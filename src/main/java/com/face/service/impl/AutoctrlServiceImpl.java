package com.face.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.face.entity.ArmStrategyInfo;
import com.face.entity.DataForOperationAdd;
import com.face.entity.DataForThresholdAdd;
import com.face.entity.EquipmentInfo;
import com.face.entity.OperationGroupInfo;
import com.face.entity.OperationInfo;
import com.face.entity.SensorInfo;
import com.face.entity.StrategyInfo;
import com.face.entity.ThresholdGroupInfo;
import com.face.entity.ThresholdInfo;
import com.face.mapper.IgcsArmThresholdMapper;
import com.face.mapper.IgcsChoperationMapper;
import com.face.mapper.IgcsChstrategyMapper;
import com.face.mapper.IgcsChthresholdMapper;
import com.face.mapper.IgcsCoperationGroupMapper;
import com.face.mapper.IgcsCoperationMapper;
import com.face.mapper.IgcsCstrategyMapper;
import com.face.mapper.IgcsCthresholdGroupMapper;
import com.face.mapper.IgcsCthresholdMapper;
import com.face.mapper.IgcsIsensorinfoMapper;
import com.face.mapper.UserMapper;
import com.face.mapper.IgcsAThresholdTypeMapper;
import com.face.mapper.IgcsArmControltypeMapper;
import com.face.model.IgcsAcontroltype;
import com.face.model.IgcsAcontroltypeExample;
import com.face.model.IgcsArmControltype;
import com.face.model.IgcsArmControltypeExample;
import com.face.model.IgcsArmThreshold;
import com.face.model.IgcsArmThresholdExample;
import com.face.model.IgcsChoperation;
import com.face.model.IgcsChstrategy;
import com.face.model.IgcsChthreshold;
import com.face.model.IgcsCoperation;
import com.face.model.IgcsCoperationExample;
import com.face.model.IgcsCoperationGroup;
import com.face.model.IgcsCoperationGroupExample;
import com.face.model.IgcsCstrategy;
import com.face.model.IgcsCstrategyExample;
import com.face.model.IgcsCthreshold;
import com.face.model.IgcsCthresholdExample;
import com.face.model.IgcsCthresholdGroup;
import com.face.model.IgcsCthresholdGroupExample;
import com.face.model.IgcsIEquipment;
import com.face.model.IgcsInodeinfo;
import com.face.model.IgcsInodeinfoKey;
import com.face.model.IgcsIsensorinfo;
import com.face.model.IgcsIsensorinfoExample;
import com.face.model.User;
import com.face.model.UserExample;
import com.face.model.IgcsACompareType;
import com.face.model.IgcsACompareTypeExample;
import com.face.model.IgcsAEquipmentType;
import com.face.model.IgcsASensorType;
import com.face.model.IgcsAThresholdType;
import com.face.model.IgcsAThresholdTypeExample;
import com.face.service.IAutoctrlService;
import com.face.utils.StringUtil;

@Service
public class AutoctrlServiceImpl extends BaseServiceImpl implements IAutoctrlService {
	@Autowired
	private IgcsCthresholdGroupMapper thresholdgroupDAO;	
	@Autowired
	private IgcsCthresholdMapper thresholdDAO;
	@Autowired
	private IgcsAThresholdTypeMapper thresholdtypeDAO;
	@Autowired
	private IgcsIsensorinfoMapper sensorinfoDAO;
	@Autowired
	private UserMapper userDAO;
	@Autowired
	private IgcsChthresholdMapper thresholdHDAO;
	@Autowired
	private IgcsCoperationGroupMapper operationgroupDAO;
	@Autowired
	private IgcsCoperationMapper operationDAO;
	@Autowired
	private IgcsChoperationMapper operationHDAO;
	@Autowired
	private IgcsCstrategyMapper strategyDAO;
	@Autowired
	private IgcsChstrategyMapper strategyHDAO;
	@Autowired
	private IgcsArmThresholdMapper armStrategyDAO;
	@Autowired
	private IgcsArmControltypeMapper armControltypeDAO;

	@Override
	public ThresholdGroupInfo findTgById(String tgId) throws Exception {
		ThresholdGroupInfo info = new ThresholdGroupInfo();
		
		IgcsCthresholdGroup tgInfo = thresholdgroupDAO.selectByPrimaryKey(tgId);
		info.setTgBaseInfo(tgInfo);
		
		List<ThresholdInfo> lstT = getThresholdOfTg(tgId);
		info.setLstThresholds(lstT);
		
		return info;
	}

	private List<ThresholdInfo> getThresholdOfTg(String tgId) {
		IgcsCthresholdExample example = new IgcsCthresholdExample();
		IgcsCthresholdExample.Criteria criteria = example.createCriteria();
		criteria.andThresholdGroupIdEqualTo(tgId);
		example.setOrderByClause("threshold_id desc");
		List<IgcsCthreshold> lstThresholds = thresholdDAO.selectByExample(example);
		List<ThresholdInfo> lstT = new ArrayList<ThresholdInfo>();
		for (IgcsCthreshold igcsCthreshold : lstThresholds) {
			ThresholdInfo tInfo = new ThresholdInfo();
			tInfo.setThresholdBaseInfo(igcsCthreshold);
			
			IgcsInodeinfoKey nodeKey = new IgcsInodeinfoKey();
			nodeKey.setNodeId(igcsCthreshold.getNodeId());
			nodeKey.setGatewayId(igcsCthreshold.getGatewayId());
			tInfo.setNodeName(nodeinfoDAO.selectByPrimaryKey(nodeKey).getNodeName());
			IgcsASensorType sType = sensortypeDAO.selectByPrimaryKey(igcsCthreshold.getSensorTypeCode());
			tInfo.setSensorTypeName(sType.getSensorTypeName());
			tInfo.setThresholdTypeName(thresholdtypeDAO.selectByPrimaryKey(igcsCthreshold.getThresholdTypeCode()).getThresholdTypeName());
			tInfo.setThresholdParameterName(comparetypeDAO.selectByPrimaryKey(igcsCthreshold.getComparaType()).getCompareTypeName());
			tInfo.setSensorUnit(sType.getSensorUnit());
			lstT.add(tInfo);
		}
		return lstT;
	}

	@Override
	public DataForThresholdAdd findDatasForThresholdAdd(String ghId) throws Exception {
		DataForThresholdAdd data = new DataForThresholdAdd();
		
		List<IgcsInodeinfo> lst = getNodesOfGh(ghId, true);
		if (lst != null) {
			for (IgcsInodeinfo nodeinfo : lst) {
				String gwId = nodeinfo.getGatewayId();
				String nodeId = nodeinfo.getNodeId();
				String nodeName = nodeinfo.getNodeName();
				
				IgcsIsensorinfoExample exSensor = new IgcsIsensorinfoExample();
				IgcsIsensorinfoExample.Criteria criSensor = exSensor.createCriteria();
				criSensor.andGatewayIdEqualTo(gwId);
				criSensor.andNodeIdEqualTo(nodeId);
				criSensor.andStatusEqualTo("0");
				exSensor.setOrderByClause("sensor_type_code asc, sensor_id asc");
				List<IgcsIsensorinfo> lstSensor = sensorinfoDAO.selectByExample(exSensor);
				for (IgcsIsensorinfo sensor : lstSensor) {
					SensorInfo sInfo = new SensorInfo();
					sInfo.setAtGwId(gwId);
					sInfo.setAtNodeId(nodeId);
					sInfo.setAtNodeName(nodeName);
					sInfo.setSensorTypeCode(sensor.getSensorTypeCode());
					IgcsASensorType sType = sensortypeDAO.selectByPrimaryKey(sensor.getSensorTypeCode());
					sInfo.setSensorTypeName(sType.getSensorTypeName());
					sInfo.setSensorId(sensor.getSensorId());
					sInfo.setUnit(sType.getSensorUnit());
					
					data.addSensor(sInfo);
				}
			}
		}
		
		IgcsAThresholdTypeExample exType = new IgcsAThresholdTypeExample();
		IgcsAThresholdTypeExample.Criteria criType = exType.createCriteria();
		criType.andThresholdTypeCodeIsNotNull();
		exType.setOrderByClause("order_id asc");
		List<IgcsAThresholdType> lstType = thresholdtypeDAO.selectByExample(exType);
		data.addType(lstType);
		
		IgcsACompareTypeExample exComp = new IgcsACompareTypeExample();
		IgcsACompareTypeExample.Criteria criComp = exComp.createCriteria();
		criComp.andCompareTypeIsNotNull();
		exComp.setOrderByClause("order_id asc");
		List<IgcsACompareType> lstComp = comparetypeDAO.selectByExample(exComp);
		data.addComp(lstComp);
		
		return data;
	}

	@Override
	public IgcsCthresholdGroup findTgBaseById(String tgId) throws Exception {
		return thresholdgroupDAO.selectByPrimaryKey(tgId);
	}

	@Override
	public void addTgInfo(IgcsCthresholdGroup tgInfo) throws Exception {
		thresholdgroupDAO.insert(tgInfo);
	}
	
	@Override
	public void modifyTgInfo(IgcsCthresholdGroup tgInfo) throws Exception {
		thresholdgroupDAO.updateByPrimaryKey(tgInfo);
	}
	
	@Override
	public List<ThresholdGroupInfo> findTgsByGhId(String ghId, boolean bGetThresholdInfo) throws Exception {
		List<ThresholdGroupInfo> lstRet = new ArrayList<ThresholdGroupInfo>();
		IgcsCthresholdGroupExample exp = new IgcsCthresholdGroupExample();
		IgcsCthresholdGroupExample.Criteria cri = exp.createCriteria();
		cri.andGreenhouseIdEqualTo(ghId);
		exp.setOrderByClause("update_time desc");
		List<IgcsCthresholdGroup> lst = thresholdgroupDAO.selectByExample(exp);
		for (IgcsCthresholdGroup igcsCthresholdGroup : lst) {
			ThresholdGroupInfo info = new ThresholdGroupInfo();
			info.setTgBaseInfo(igcsCthresholdGroup);
			
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(igcsCthresholdGroup.getUpdateUserId());
			List<User> userList = userDAO.selectByExample(example);
			if (null == userList || userList.isEmpty()) {
				throw new RuntimeException("阈值组用户不存在！");
			}
			User user = userList.get(0);
			info.setUseName(user.getTruename());
			
			if (bGetThresholdInfo) {
				List<ThresholdInfo> lstT = getThresholdOfTg(igcsCthresholdGroup.getThresholdGroupId());
				info.setLstThresholds(lstT);
			}
			
			lstRet.add(info);
		}
		
		return lstRet;
	}
	
	@Override
	public IgcsCthreshold findThresholdById(String thresholdId) throws Exception {
		return thresholdDAO.selectByPrimaryKey(thresholdId);
	}
	
	@Override
	@Transactional
	public void addThresholdInfo(IgcsCthreshold tInfo, String userId) throws Exception {
		thresholdDAO.insert(tInfo);		
		updateThresholdGroup(tInfo.getThresholdGroupId(), userId);
	}

	private void updateThresholdGroup(String tgId, String userId) {
		IgcsCthresholdGroup group = thresholdgroupDAO.selectByPrimaryKey(tgId);
		group.setUpdateUserId(userId);
		group.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		thresholdgroupDAO.updateByPrimaryKey(group);
	}
	
	@Override
	@Transactional
	public void mdyThresholdInfo(IgcsCthreshold tInfo, String userId, IgcsChthreshold hInfo) throws Exception {
		thresholdDAO.updateByPrimaryKey(tInfo);
		updateThresholdGroup(tInfo.getThresholdGroupId(), userId);
		thresholdHDAO.insert(hInfo);
	}

	@Override
	@Transactional
	public void delThresholdInfo(String thresholdId, String userId) throws Exception {
		IgcsCthreshold tInfo = thresholdDAO.selectByPrimaryKey(thresholdId);
		if (tInfo == null) {
			throw new RuntimeException("该阈值不存在，请刷新后重试！");
		}
		String tgId = tInfo.getThresholdGroupId();
		IgcsChthreshold hInfo = generateHistoryThreshold(tInfo);
		thresholdDAO.deleteByPrimaryKey(thresholdId);
		updateThresholdGroup(tgId, userId);
		thresholdHDAO.insert(hInfo);
	}
	
	@Override
	@Transactional
	public void delTgInfo(String tgId) throws Exception {
		IgcsCthresholdGroup group = thresholdgroupDAO.selectByPrimaryKey(tgId);
		if (group == null) {
			throw new RuntimeException("该阈值组不存在，请刷新后重试！");
		}
		
		IgcsCthresholdExample example = new IgcsCthresholdExample();
		IgcsCthresholdExample.Criteria criteria = example.createCriteria();
		criteria.andThresholdGroupIdEqualTo(tgId);
		List<IgcsCthreshold> lstThresholds = thresholdDAO.selectByExample(example);
		for (IgcsCthreshold tInfo : lstThresholds) {
			IgcsChthreshold hInfo = generateHistoryThreshold(tInfo);
			thresholdDAO.deleteByPrimaryKey(tInfo.getThresholdId());
			thresholdHDAO.insert(hInfo);
		}
		
		thresholdgroupDAO.deleteByPrimaryKey(group.getThresholdGroupId());
	}
	
	@Override
	public IgcsChthreshold generateHistoryThreshold(IgcsCthreshold tInfo) throws Exception {
		IgcsChthreshold hInfo = new IgcsChthreshold();
		hInfo.setThresholdId(tInfo.getThresholdId());
		hInfo.setThresholdGroupId(tInfo.getThresholdGroupId());
		hInfo.setGatewayId(tInfo.getGatewayId());
		hInfo.setNodeId(tInfo.getNodeId());
		hInfo.setSensorTypeCode(tInfo.getSensorTypeCode());
		hInfo.setSensorId(tInfo.getSensorId());
		hInfo.setThresholdTypeCode(tInfo.getThresholdTypeCode());
		hInfo.setThresholdParameter(tInfo.getThresholdParameter());
		hInfo.setComparaType(tInfo.getComparaType());
		hInfo.setThresholdValue(tInfo.getThresholdValue());
		hInfo.setInDate(tInfo.getInDate());
		hInfo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		return hInfo;
	}
	
	@Override
	public List<OperationGroupInfo> findOgsByGhId(String ghId, boolean bGetOperationInfo) throws Exception {
		List<OperationGroupInfo> lstRet = new ArrayList<OperationGroupInfo>();
		IgcsCoperationGroupExample exp = new IgcsCoperationGroupExample();
		IgcsCoperationGroupExample.Criteria cri = exp.createCriteria();
		cri.andGreenhouseIdEqualTo(ghId);
		exp.setOrderByClause("update_time desc");
		List<IgcsCoperationGroup> lst = operationgroupDAO.selectByExample(exp);
		for (IgcsCoperationGroup group : lst) {
			OperationGroupInfo info = new OperationGroupInfo();
			info.setOgBaseInfo(group);
			
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(group.getUpdateUserId());
			List<User> userList = userDAO.selectByExample(example);
			if (null == userList || userList.isEmpty()) {
				throw new RuntimeException("操作组用户不存在！");
			}
			User user = userList.get(0);
			info.setUseName(user.getTruename());
			
			if (bGetOperationInfo) {
				List<OperationInfo> lstT = getOperationOfOg(group.getOperateGroupId());
				info.setLstOperations(lstT);
			}
			
			lstRet.add(info);
		}
		
		return lstRet;
	}
	
	@Override
	public IgcsCoperationGroup findOgBaseById(String ogId) throws Exception {
		return operationgroupDAO.selectByPrimaryKey(ogId);
	}
	
	@Override
	public void addOgInfo(IgcsCoperationGroup tgInfo) throws Exception {
		operationgroupDAO.insert(tgInfo);
	}
	
	@Override
	public void modifyOgInfo(IgcsCoperationGroup ogInfo) throws Exception {
		operationgroupDAO.updateByPrimaryKey(ogInfo);
	}
	
	@Override
	public OperationGroupInfo findOgById(String ogId) throws Exception {
		OperationGroupInfo info = new OperationGroupInfo();
		
		IgcsCoperationGroup tgInfo = operationgroupDAO.selectByPrimaryKey(ogId);
		info.setOgBaseInfo(tgInfo);
		
		List<OperationInfo> lstT = getOperationOfOg(ogId);
		info.setLstOperations(lstT);
		
		return info;
	}

	private List<OperationInfo> getOperationOfOg(String ogId) throws Exception {
		IgcsCoperationExample example = new IgcsCoperationExample();
		IgcsCoperationExample.Criteria criteria = example.createCriteria();
		criteria.andOperateGroupIdEqualTo(ogId);
		example.setOrderByClause("operate_id desc");
		List<IgcsCoperation> lstThresholds = operationDAO.selectByExample(example);
		List<OperationInfo> lstT = new ArrayList<OperationInfo>();
		for (IgcsCoperation oBaseInfo : lstThresholds) {
			OperationInfo oInfo = new OperationInfo();
			oInfo.setOperationBaseInfo(oBaseInfo);
			
			IgcsInodeinfoKey nodeKey = new IgcsInodeinfoKey();
			nodeKey.setNodeId(oBaseInfo.getNodeId());
			nodeKey.setGatewayId(oBaseInfo.getGatewayId());
			oInfo.setNodeName(nodeinfoDAO.selectByPrimaryKey(nodeKey).getNodeName());
			
			oInfo.setEquipmentTypeName(getEquipNameByType(oBaseInfo.getEquipmentTypeCode()));
			oInfo.setControlTypeName(controltypeDAO.selectByPrimaryKey(oBaseInfo.getControlType()).getControlName());
			
			lstT.add(oInfo);
		}
		return lstT;
	}
	
	@Override
	public DataForOperationAdd findDatasForOperationAdd(String ghId) throws Exception {
		DataForOperationAdd data = new DataForOperationAdd();
		
		List<IgcsInodeinfo> lst = getNodesOfGh(ghId, true);
		if (lst != null) {
			for (IgcsInodeinfo nodeinfo : lst) {
				String gwId = nodeinfo.getGatewayId();
				String nodeId = nodeinfo.getNodeId();
				String nodeName = nodeinfo.getNodeName();
				
				List<IgcsIEquipment> lstEquip = getNodeEquips(gwId, nodeId, false);
				for (IgcsIEquipment equip : lstEquip) {
					EquipmentInfo sInfo = new EquipmentInfo();
					sInfo.setEquip(equip);
					sInfo.setAtGwId(gwId);
					sInfo.setAtNodeId(nodeId);
					sInfo.setAtNodeName(nodeName);
					IgcsAEquipmentType equipType = equipmenttypeDAO.selectByPrimaryKey(equip.getEquipmentType());
					sInfo.setEquipmentName(equipType.getEquipmentTypeName());
					sInfo.setType(equipType.getOrderId().shortValue());
					
					IgcsAcontroltypeExample exCtrl = new IgcsAcontroltypeExample();
					IgcsAcontroltypeExample.Criteria criCtrl = exCtrl.createCriteria();
					criCtrl.andControlTypeLike(equip.getEquipmentType() + "%");
					List<IgcsAcontroltype> lstCtrl = controltypeDAO.selectByExample(exCtrl);
					for (IgcsAcontroltype ctrl : lstCtrl) {
						sInfo.addControl(ctrl.getControlType(), ctrl.getControlName());
					}				
					
					data.addEquipment(sInfo);
				}
			}
		}
		
		return data;
	}
	
	@Override
	public IgcsCoperation findOperationById(String operationId) throws Exception {
		return operationDAO.selectByPrimaryKey(operationId);
	}
	
	@Override
	@Transactional
	public void addOperationInfo(IgcsCoperation oInfo, String userId) throws Exception {
		operationDAO.insert(oInfo);		
		updateOperationGroup(oInfo.getOperateGroupId(), userId);
	}
	
	private void updateOperationGroup(String ogId, String userId) {
		IgcsCoperationGroup group = operationgroupDAO.selectByPrimaryKey(ogId);
		group.setUpdateUserId(userId);
		group.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		operationgroupDAO.updateByPrimaryKey(group);
	}
	
	@Override
	public IgcsChoperation generateHistoryOperation(IgcsCoperation oInfo) throws Exception {
		IgcsChoperation hInfo = new IgcsChoperation();
		hInfo.setOperateId(oInfo.getOperateId());
		hInfo.setOperateGroupId(oInfo.getOperateGroupId());
		hInfo.setGatewayId(oInfo.getGatewayId());
		hInfo.setNodeId(oInfo.getNodeId());
		hInfo.setEquipmentTypeCode(oInfo.getEquipmentTypeCode());
		hInfo.setEquipmentId(oInfo.getEquipmentId());
		hInfo.setControlType(oInfo.getControlType());
		hInfo.setControlParameter1(oInfo.getControlParameter1());
		hInfo.setControlParameter2(oInfo.getControlParameter2());
		hInfo.setControlParameter3(oInfo.getControlParameter3());
		hInfo.setInDate(oInfo.getInDate());
		hInfo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		return hInfo;
	}
	
	@Override
	@Transactional
	public void mdyOperationInfo(IgcsCoperation oInfo, String userId, IgcsChoperation hInfo) throws Exception {
		operationDAO.updateByPrimaryKey(oInfo);
		updateOperationGroup(oInfo.getOperateGroupId(), userId);
		operationHDAO.insert(hInfo);
	}
	
	@Override
	@Transactional
	public void delOperationInfo(String operationId, String userId) throws Exception {
		IgcsCoperation oInfo = operationDAO.selectByPrimaryKey(operationId);
		if (oInfo == null) {
			throw new RuntimeException("该操作不存在，请刷新后重试！");
		}
		String ogId = oInfo.getOperateGroupId();
		IgcsChoperation hInfo = generateHistoryOperation(oInfo);
		operationDAO.deleteByPrimaryKey(operationId);
		updateOperationGroup(ogId, userId);
		operationHDAO.insert(hInfo);
	}
	
	@Override
	@Transactional
	public void delOgInfo(String ogId) throws Exception {
		IgcsCoperationGroup group = operationgroupDAO.selectByPrimaryKey(ogId);
		if (group == null) {
			throw new RuntimeException("该操作组不存在，请刷新后重试！");
		}
		
		IgcsCoperationExample example = new IgcsCoperationExample();
		IgcsCoperationExample.Criteria criteria = example.createCriteria();
		criteria.andOperateGroupIdEqualTo(ogId);
		List<IgcsCoperation> lstThresholds = operationDAO.selectByExample(example);
		for (IgcsCoperation tInfo : lstThresholds) {
			IgcsChoperation hInfo = generateHistoryOperation(tInfo);
			operationDAO.deleteByPrimaryKey(tInfo.getOperateId());
			operationHDAO.insert(hInfo);
		}
		
		operationgroupDAO.deleteByPrimaryKey(group.getOperateGroupId());
	}
	
	@Override
	public List<StrategyInfo> findStrategyByGhId(String ghId) throws Exception {
		List<StrategyInfo> lstRet = new ArrayList<StrategyInfo>();
		
		IgcsCstrategyExample exp = new IgcsCstrategyExample();
		IgcsCstrategyExample.Criteria cri = exp.createCriteria();
		cri.andGreenhouseIdEqualTo(ghId);
//		exp.setOrderByClause("update_time desc");
		List<IgcsCstrategy> lst = strategyDAO.selectByExample(exp);
		for (IgcsCstrategy group : lst) {
			StrategyInfo info = new StrategyInfo();
			info.setBaseInfo(group);
			
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(group.getUpdateUserId());
			List<User> userList = userDAO.selectByExample(example);
			if (null == userList || userList.isEmpty()) {
				throw new RuntimeException("策略用户不存在！");
			}
			User user = userList.get(0);
			info.setUserName(user.getTruename());
			
			String curId = group.getThresholdGroupId1();
			if (StringUtil.notEmpty(curId)) {
				info.setTgName1(thresholdgroupDAO.selectByPrimaryKey(curId).getThresholdGroupName());
			}
			curId = group.getThresholdGroupId2();
			if (StringUtil.notEmpty(curId)) {
				info.setTgName2(thresholdgroupDAO.selectByPrimaryKey(curId).getThresholdGroupName());
			}
			curId = group.getThresholdGroupId3();
			if (StringUtil.notEmpty(curId)) {
				info.setTgName3(thresholdgroupDAO.selectByPrimaryKey(curId).getThresholdGroupName());
			}
			curId = group.getOperateGroupId();
			if (StringUtil.notEmpty(curId)) {
				info.setOgName(operationgroupDAO.selectByPrimaryKey(curId).getOperateGroupName());
			}
			
			lstRet.add(info);
		}
		
		return lstRet;
	}
	
	@Override
	public IgcsCstrategy findStrategyById(String strategyId) throws Exception {
		return strategyDAO.selectByPrimaryKey(strategyId);
	}
	
	@Override
	public void addStrategyInfo(IgcsCstrategy strategyInfo) throws Exception {
		strategyDAO.insert(strategyInfo);
	}
	
	@Override
	public IgcsChstrategy generateHistoryStrategy(IgcsCstrategy strategyInfo) throws Exception {
		IgcsChstrategy hInfo = new IgcsChstrategy();
		hInfo.setStrategyId(strategyInfo.getStrategyId());
		hInfo.setGreenhouseId(strategyInfo.getGreenhouseId());
		hInfo.setThresholdGroupId1(strategyInfo.getThresholdGroupId1());
		hInfo.setThresholdGroupId2(strategyInfo.getThresholdGroupId2());
		hInfo.setThresholdGroupId3(strategyInfo.getThresholdGroupId3());
		hInfo.setOperateGroupId(strategyInfo.getOperateGroupId());
		hInfo.setExcutionStartTime(strategyInfo.getExcutionStartTime());
		hInfo.setExcutionEndTime(strategyInfo.getExcutionEndTime());
		hInfo.setUpdateUserId(strategyInfo.getUpdateUserId());
		hInfo.setInDate(strategyInfo.getInDate());
		hInfo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		return hInfo;
	}
	
	@Override
	@Transactional
	public void mdyStrategyInfo(IgcsCstrategy strategyInfo, IgcsChstrategy hInfo) throws Exception {
		strategyDAO.updateByPrimaryKey(strategyInfo);
		strategyHDAO.insert(hInfo);
	}
	
	@Override
	@Transactional
	public void delStrategyInfo(String strategyId) throws Exception {
		IgcsCstrategy strategyInfo = strategyDAO.selectByPrimaryKey(strategyId);
		if (strategyInfo == null) {
			throw new RuntimeException("该策略不存在，请刷新后重试！");
		}
		IgcsChstrategy hInfo = generateHistoryStrategy(strategyInfo);
		strategyDAO.deleteByPrimaryKey(strategyId);
		strategyHDAO.insert(hInfo);
	}

	@Override
	public boolean tgInUse(String tgId) throws Exception {
		IgcsCstrategyExample exp = new IgcsCstrategyExample();
		IgcsCstrategyExample.Criteria cri = exp.createCriteria();
		cri.andThresholdGroupId1EqualTo(tgId);
		List<IgcsCstrategy> lst = strategyDAO.selectByExample(exp);
		if (lst.size() > 0) {
			return true;
		}
		
		IgcsCstrategyExample exp2 = new IgcsCstrategyExample();
		IgcsCstrategyExample.Criteria cri2 = exp2.createCriteria();
		cri2.andThresholdGroupId2EqualTo(tgId);
		lst = strategyDAO.selectByExample(exp2);
		if (lst.size() > 0) {
			return true;
		}
		
		IgcsCstrategyExample exp3 = new IgcsCstrategyExample();
		IgcsCstrategyExample.Criteria cri3 = exp3.createCriteria();
		cri3.andThresholdGroupId3EqualTo(tgId);
		lst = strategyDAO.selectByExample(exp3);
		if (lst.size() > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean ogInUse(String ogId) throws Exception {
		IgcsCstrategyExample exp = new IgcsCstrategyExample();
		IgcsCstrategyExample.Criteria cri = exp.createCriteria();
		cri.andOperateGroupIdEqualTo(ogId);
		List<IgcsCstrategy> lst = strategyDAO.selectByExample(exp);
		if (lst.size() > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public IgcsInodeinfo getFirstNodeOfGh(String ghId) throws Exception {
		List<IgcsInodeinfo> lst = getNodesOfGh(ghId, false);
		if (lst.size() == 0) {
			return null;
		}
		
		return lst.get(0);
	}

	@Override
	public List<ArmStrategyInfo> findArmStrategyByGhId(String ghId) throws Exception {
        List<IgcsInodeinfo> lstNodes = getNodesOfGh(ghId, true); 
        
        List<ArmStrategyInfo> lstRet = new ArrayList<ArmStrategyInfo>();
        for (IgcsInodeinfo nInfo : lstNodes) {
        	ArmStrategyInfo asInfo = new ArmStrategyInfo(nInfo);
        	
        	IgcsArmThresholdExample exp = new IgcsArmThresholdExample();
    		IgcsArmThresholdExample.Criteria cri = exp.createCriteria();
    		cri.andGatewayIdEqualTo(nInfo.getGatewayId());
    		cri.andNodeIdEqualTo(nInfo.getNodeId());
    		exp.setOrderByClause("threshold_id asc, arm_strategy_id asc");
    		asInfo.setLstAts(armStrategyDAO.selectByExample(exp));
    		
    		lstRet.add(asInfo);
        }
        
		return lstRet;
	}

	@Override
	public IgcsArmThreshold findArmStrategyById(String strategyId) throws Exception {
		return armStrategyDAO.selectByPrimaryKey(strategyId);
	}

	@Override
	public void modifyArmThreshold(IgcsArmThreshold curArm) throws Exception {
		armStrategyDAO.updateByPrimaryKey(curArm);
	}

	@Override
	public Integer getArmOperateType(String equipmentType, String operateType) throws Exception {
		IgcsArmControltypeExample exp = new IgcsArmControltypeExample();
		IgcsArmControltypeExample.Criteria cri = exp.createCriteria();
		cri.andEquipmentTypeEqualTo(equipmentType);
		cri.andControlTypeEqualTo(operateType);
		List<IgcsArmControltype> lst = armControltypeDAO.selectByExample(exp);
		return lst.get(0).getOperateType();
	}
}

package com.face.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.face.entity.GatewayInfo;
import com.face.entity.GreenhouseInfo;
import com.face.entity.NodeInfo;
import com.face.entity.Parkinfo;
import com.face.entity.SensorHistoryData;
import com.face.entity.SensorInfo;
import com.face.entity.WeatherInfo;
import com.face.entity.SensorData;
import com.face.mapper.IgcsBGatherWDataCMapper;
import com.face.mapper.IgcsBgatherDataCMapper;
import com.face.mapper.IgcsIparkinfoMapper;
import com.face.mapper.IgcsIsensorinfoMapper;
import com.face.mapper.UserMapper;
import com.face.model.IgcsAEquipmentType;
import com.face.model.IgcsASensorType;
import com.face.model.IgcsBGatherWDataC;
import com.face.model.IgcsBGatherWDataCExample;
import com.face.model.IgcsBgatherDataC;
import com.face.model.IgcsBgatherDataCExample;
import com.face.model.IgcsIEquipment;
import com.face.model.IgcsIEquipmentKey;
import com.face.model.IgcsIGatewayInfo;
import com.face.model.IgcsIGatewayInfoExample;
import com.face.model.IgcsIgreenhouse;
import com.face.model.IgcsIgreenhouseExample;
import com.face.model.IgcsInodeinfo;
import com.face.model.IgcsInodeinfoExample;
import com.face.model.IgcsInodeinfoKey;
import com.face.model.IgcsIparkinfo;
import com.face.model.IgcsIparkinfoExample;
import com.face.model.IgcsIsensorinfo;
import com.face.model.IgcsIsensorinfoExample;
import com.face.model.User;
import com.face.model.UserExample;
import com.face.service.IGatewayService;
import com.face.utils.DateUtil;
import com.face.utils.StringUtil;

@Service
@Transactional
public class GatewayServiceImpl extends BaseServiceImpl implements IGatewayService {
	
	// @Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法。
	@Autowired
	private UserMapper userinfoDAO;
	@Autowired
	private IgcsBgatherDataCMapper gatherdatacDAO;
	@Autowired
	private IgcsBGatherWDataCMapper gatherwdatacDAO;
    @Autowired
 	private IgcsIparkinfoMapper parkinfoDAO;
    @Autowired
	private IgcsIsensorinfoMapper sensorinfoDAO;
	

	@Override
	public List<IgcsIGatewayInfo> queryGatewayOfParkUser(String parkId, String userId) throws Exception {
		IgcsIGatewayInfoExample example = new IgcsIGatewayInfoExample();
		IgcsIGatewayInfoExample.Criteria criteria = example.createCriteria();
        criteria.andParkIdEqualTo(parkId);
        criteria.andUserIdEqualTo(userId);
        criteria.andStatusEqualTo("0");
        criteria.andTypeEqualTo(GatewayInfo.GW_TYPE_NODE);
		return gatewayinfoDAO.selectByExample(example);
	}	
	
	@Override
	public List<IgcsIGatewayInfo> queryGatewayOfParkAdmin(String parkId) throws Exception {
		IgcsIGatewayInfoExample example = new IgcsIGatewayInfoExample();
		IgcsIGatewayInfoExample.Criteria criteria = example.createCriteria();
        criteria.andParkIdEqualTo(parkId);
        criteria.andStatusEqualTo("0");
        criteria.andTypeEqualTo(GatewayInfo.GW_TYPE_NODE);
		return gatewayinfoDAO.selectByExample(example);
	}

	@Override
	public IgcsIGatewayInfo findGatewayById(String gatewayId) throws Exception {
		return gatewayinfoDAO.selectByPrimaryKey(gatewayId);
	}

	@Override
	public String addGateway(IgcsIGatewayInfo info) throws Exception {
		gatewayinfoDAO.insert(info);
		return "success";
	}

	@Override
	public String mdyGateway(IgcsIGatewayInfo info) throws Exception {
		gatewayinfoDAO.updateByPrimaryKey(info);
		return "success";
	}

	@Override
	public IgcsIgreenhouse findGhById(String ghId) throws Exception {
		return greenhouseDAO.selectByPrimaryKey(ghId);
	}
	
	@Override
	public String addGreenhouse(IgcsIgreenhouse info) throws Exception {
		greenhouseDAO.insert(info);
		return "success";
	}
	
	private User findUserById(String userId) throws Exception {
    	UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(userId);
        List<User> userList = userinfoDAO.selectByExample(example);
        if (null == userList || userList.isEmpty()) {
        	return null;
		}
		
        return userList.get(0);
    }
	
	@Override
	public List<GreenhouseInfo> queryGhOfParkUser(String userId) throws Exception {
        return queryGhs(userId, false);
	}
	
	@Override
	public List<GreenhouseInfo> queryGhOfGw(String gwId) throws Exception {        
        return queryGh(gwId, true);
	}
	
	private List<GreenhouseInfo> queryGh(String keyId, boolean bUseGw) throws Exception {
		IgcsIgreenhouseExample example = new IgcsIgreenhouseExample();
		IgcsIgreenhouseExample.Criteria criteria = example.createCriteria();
		if (bUseGw) {
			criteria.andGatewayIdEqualTo(keyId);
		} else {
			criteria.andUserIdEqualTo(keyId);
		}
        List<IgcsIgreenhouse> lst = greenhouseDAO.selectByExample(example);
        
        List<GreenhouseInfo> lstGh = new ArrayList<GreenhouseInfo>();
        for (IgcsIgreenhouse igcsIgreenhouse : lst) {
        	IgcsIGatewayInfo gw = gatewayinfoDAO.selectByPrimaryKey(igcsIgreenhouse.getGatewayId());
			if (!StringUtil.getStringNotNull(gw.getStatus()).equals("0")) {
				continue;
			}
			User user = findUserById(igcsIgreenhouse.getUserId());
			GreenhouseInfo info = new GreenhouseInfo(igcsIgreenhouse, gw.getGatewayName(), user.getTruename());
			
			lstGh.add(info);
		}
        
        return lstGh;
	}
	
	@Override
	public String mdyGreenhouse(IgcsIgreenhouse info) throws Exception {
		greenhouseDAO.updateByPrimaryKey(info);
		return "success";
	}
	
	@Override
	public List<NodeInfo> getNodesInfoByGhId(String ghId) throws Exception {
		List<NodeInfo> lstNodes = new ArrayList<NodeInfo>();
		
		List<IgcsInodeinfo> lst = getNodesOfGh(ghId, true);
		if (lst != null) {
			for (IgcsInodeinfo igcsInodeinfo : lst) {
				NodeInfo nInfo = new NodeInfo();
				String nodeId = igcsInodeinfo.getNodeId();
				String gwId = igcsInodeinfo.getGatewayId();
				nInfo.setNodeId(nodeId);
				nInfo.setGatewayId(gwId);
				nInfo.setNodeName(StringUtil.getStringNotNull(igcsInodeinfo.getNodeName()));
				
				Date lastTime = gatherdatacDAO.getLastDataTime(gwId, nodeId);
				if (lastTime != null) {
					nInfo.setGatherTime(lastTime);
					
					IgcsBgatherDataCExample dataC = new IgcsBgatherDataCExample();
					IgcsBgatherDataCExample.Criteria dataCCri = dataC.createCriteria();
					dataCCri.andNodeIdEqualTo(nodeId);
					dataCCri.andGatewayIdEqualTo(gwId);
					dataCCri.andGatherTimeEqualTo(lastTime); 
					List<IgcsBgatherDataC> lstSensor = gatherdatacDAO.selectByExample(dataC);
					for (IgcsBgatherDataC sensor : lstSensor) {
						SensorInfo sinfo = new SensorInfo();
						sinfo.setSensorId(sensor.getSensorId());
						sinfo.setSensorTypeCode(sensor.getSensorTypeCode());
						sinfo.setSensorValue(sensor.getSensorValue());
						
						IgcsASensorType type = sensortypeDAO.selectByPrimaryKey(sensor.getSensorTypeCode());
						sinfo.setSensorTypeName(type.getSensorTypeName());
						sinfo.setUnit(type.getSensorUnit());
						
						nInfo.addSensor(sinfo, type.getOrderId().shortValue());
					}
				} else {
					nInfo.setGatherTime(null);
				}			
				
				lstNodes.add(nInfo);
			}
		}
		
		return lstNodes;
	}
	
	@Override
	public List<SensorHistoryData> findRecentByFilter(String gwId, String nodeId, String sensorId, String sensorTypeCode) throws Exception {
		Date lastTime = gatherdatacDAO.getSensorLastRec(gwId, nodeId, sensorId, sensorTypeCode);
		
		Date date = /*new Date()*/lastTime; 
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.HOUR, -24);  
        Date startTime = calendar.getTime(); 
        
        List<SensorData> lstTemp = gatherdatacDAO.selectRecentSensorData(gwId, nodeId, sensorId, sensorTypeCode, startTime); 
        
		List<SensorHistoryData> lstData = new ArrayList<SensorHistoryData>();
		if (lstTemp.size() > 0) {
			for (SensorData objTemp : lstTemp) {
				lstData.add(new SensorHistoryData(objTemp.getGatherTime(), objTemp.getSensorValue()));
			}
			
			while (lstData.size() > 3000) {
				lstData = removeEvenDatas(lstData);
			}
		}
		
		return lstData;
	}
	
	private List<SensorHistoryData> removeEvenDatas(List<SensorHistoryData> lstData) {
		List<SensorHistoryData> lstSmallData = new ArrayList<SensorHistoryData>();
		
		for (int i = 0; i < lstData.size(); i++) {
			if (i % 2 == 0) {
				lstSmallData.add(lstData.get(i));
			}
		}
		
		return lstSmallData;
	}
	
	@Override
	public List<NodeInfo> getNodesEquipByGhId(String ghId, Boolean bTimeLimit) throws Exception {
		List<NodeInfo> lstNodes = new ArrayList<NodeInfo>();
		
		List<IgcsInodeinfo> lst = getNodesOfGh(ghId, true);
		if (lst != null) {
			for (IgcsInodeinfo igcsInodeinfo : lst) {
				NodeInfo nInfo = new NodeInfo();
				String nodeId = igcsInodeinfo.getNodeId();
				String gwId = igcsInodeinfo.getGatewayId();
				nInfo.setNodeId(nodeId);
				nInfo.setGatewayId(gwId);
				nInfo.setNodeName(StringUtil.getStringNotNull(igcsInodeinfo.getNodeName()));				
				
				List<IgcsIEquipment> lstSensor = getNodeEquips(gwId, nodeId, bTimeLimit);
				for (IgcsIEquipment equipment : lstSensor) {
					IgcsAEquipmentType typeE = equipmenttypeDAO.selectByPrimaryKey(equipment.getEquipmentType());
					nInfo.addEquipmentEx(equipment, typeE.getEquipmentTypeName(), typeE.getOrderId().shortValue());
				}						
				lstNodes.add(nInfo);
			}
		}
		
		return lstNodes;
	}
	
	@Override
	public List<IgcsInodeinfo> getNodesByGhId(String ghId) throws Exception {
		return getNodesOfGh(ghId, false); 
	}
	
	@Override
	public Map<String, List<SensorHistoryData>> findHistoryByFilter(String gwId, String nodeFilter,
			String startTimeFilter, String endTimeFilter) throws Exception {
		Map<String, List<SensorHistoryData>> mpData = new TreeMap<String, List<SensorHistoryData>>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		String startTime = DateUtil.stringToString(startTimeFilter);
		String lastTime = DateUtil.stringToString(endTimeFilter);		
		
		List<IgcsBgatherDataC> caijis = gatherdatacDAO.findHistoryByFilter(gwId, nodeFilter, startTime, lastTime);
		
		String preSensorTypeCode = "";
		String nowSensorTypeCode = "";
		String preSensorId = "";
		String nowSensorId = "";
		String sensorName = "";
		String sensorUnit = "";
		short type = 0;
		String key = "";		
		
		for (IgcsBgatherDataC info : caijis) {
			nowSensorTypeCode = info.getSensorTypeCode();
			nowSensorId = info.getSensorId();
			SensorHistoryData one = new SensorHistoryData(info.getGatherTime(), info.getSensorValue());
			if (!nowSensorTypeCode.contentEquals(preSensorTypeCode)) {
				IgcsASensorType sensorType = sensortypeDAO.selectByPrimaryKey(nowSensorTypeCode);
				type = sensorType.getOrderId().shortValue();
				sensorName = sensorType.getSensorTypeName().replace("二氧化碳", "CO2");
				sensorUnit = "(" + sensorType.getSensorUnit() + ")";
				key = type + "_" + nowSensorTypeCode + "_" + sensorName + nowSensorId + sensorUnit;
				
				preSensorTypeCode = nowSensorTypeCode;
				preSensorId = nowSensorId;
				
				List<SensorHistoryData> lst = new ArrayList<SensorHistoryData>();
				lst.add(one);
				mpData.put(key, lst);
			} else {
				if (!nowSensorId.equals(preSensorId)) {
					key = type + "_" + nowSensorTypeCode + "_" + sensorName + nowSensorId + sensorUnit;
					
					preSensorId = nowSensorId;
					
					List<SensorHistoryData> lst = new ArrayList<SensorHistoryData>();
					lst.add(one);
					mpData.put(key, lst);
				} else {
					mpData.get(key).add(one);
				}
			}		
		}	
		
		return mpData;
	}
	
	@Override
	public IgcsInodeinfo findNodeById(String nodeId, String gwId) throws Exception {
		IgcsInodeinfoKey key = new IgcsInodeinfoKey();
		key.setGatewayId(gwId);
		key.setNodeId(nodeId);
		return nodeinfoDAO.selectByPrimaryKey(key);
	}	
	
	@Override
	public String mdyNodeInfo(IgcsInodeinfo info) throws Exception {
		nodeinfoDAO.updateByPrimaryKey(info);
		return "success";
	}
	
	@Override
	public List<Parkinfo> queryAllPark() throws Exception {
		List<Parkinfo> lstRet = new ArrayList<Parkinfo>();
		
		IgcsIparkinfoExample example = new IgcsIparkinfoExample();
		example.setOrderByClause("park_id asc");
		
		List<IgcsIparkinfo> lstInfo = parkinfoDAO.selectByExample(example);
		for (IgcsIparkinfo igcsIparkinfo : lstInfo) {
			Parkinfo pInfo = new Parkinfo();
			pInfo.setBaseInfo(igcsIparkinfo);
			
			User uInfo = findUserById(igcsIparkinfo.getUserId());
			if (uInfo != null) {
				pInfo.setUserName(uInfo.getTruename());
			}
			
			lstRet.add(pInfo);
		}
		
		return lstRet;
	}

	@Override
	public IgcsASensorType findSensorTyById(String sensorTypeCode) throws Exception {
		return sensortypeDAO.selectByPrimaryKey(sensorTypeCode);
	}

	@Override
	public IgcsIEquipment findEquipmentById(String gwId, String nodeId, String equipType, String equipId) throws Exception {
		IgcsIEquipmentKey eKey = new IgcsIEquipmentKey();
		eKey.setGatewayId(gwId);
		eKey.setNodeId(nodeId);
		eKey.setEquipmentType(equipType);
		eKey.setEquipmentId(equipId);
		
		return equipmentDAO.selectByPrimaryKey(eKey);
	}

	@Override
	public List<WeatherInfo> getWeatherInfoByUserId(String userId, String parkId) throws Exception {
		List<WeatherInfo> lstWeathers = new ArrayList<WeatherInfo>();
		
		List<IgcsIGatewayInfo> lstWeather = getWeatherList(userId, parkId);
		
        for (IgcsIGatewayInfo wInfo : lstWeather) {
        	WeatherInfo nInfo = new WeatherInfo();
			String gwId = wInfo.getGatewayId();
			nInfo.setGatewayId(gwId);
			nInfo.setGatewayName(StringUtil.getStringNotNull(wInfo.getGatewayName()));
			nInfo.setNodeId("1");
			
			Date lastTime = gatherwdatacDAO.getLastDataTime(gwId, nInfo.getNodeId());
			if (lastTime != null) {
				nInfo.setGatherTime(lastTime);
				
				IgcsBGatherWDataCExample dataC = new IgcsBGatherWDataCExample();
				IgcsBGatherWDataCExample.Criteria dataCCri = dataC.createCriteria();
				dataCCri.andNodeIdEqualTo(nInfo.getNodeId());
				dataCCri.andGatewayIdEqualTo(gwId);
				dataCCri.andGatherTimeEqualTo(lastTime); 
				List<IgcsBGatherWDataC> lstSensor = gatherwdatacDAO.selectByExample(dataC);
				for (IgcsBGatherWDataC sensor : lstSensor) {
					SensorInfo sinfo = new SensorInfo();
					sinfo.setSensorId(sensor.getSensorId());
					sinfo.setSensorTypeCode(sensor.getSensorTypeCode());
					sinfo.setSensorValue(sensor.getSensorValue());
					
					IgcsASensorType type = sensortypeDAO.selectByPrimaryKey(sensor.getSensorTypeCode());
					sinfo.setSensorTypeName(type.getSensorTypeName());
					sinfo.setUnit(type.getSensorUnit());
					
					nInfo.addSensor(sinfo, type.getOrderId().shortValue());
				}
			} else {
				nInfo.setGatherTime(null);
			}			
			
			lstWeathers.add(nInfo);
		}
		
		return lstWeathers;
	}

	@Override
	public List<SensorHistoryData> findWRecentByFilter(String gwId, String nodeId, String sensorId,
			String sensorTypeCode) throws Exception {
		Date lastTime = gatherwdatacDAO.getSensorLastRec(gwId, nodeId, sensorId, sensorTypeCode);
		
		Date date = /*new Date()*/lastTime; 
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.HOUR, -24);  
        Date startTime = calendar.getTime(); 
        
        List<SensorData> lstTemp = gatherwdatacDAO.selectRecentSensorData(gwId, nodeId, sensorId, sensorTypeCode, startTime); 
        
		List<SensorHistoryData> lstData = new ArrayList<SensorHistoryData>();
		if (lstTemp.size() > 0) {
			for (SensorData objTemp : lstTemp) {
				lstData.add(new SensorHistoryData(objTemp.getGatherTime(), objTemp.getSensorValue()));
			}
			
			while (lstData.size() > 3000) {
				lstData = removeEvenDatas(lstData);
			}
		}
		
		return lstData;
	}

	@Override
	public List<IgcsIGatewayInfo> getWeatherList(String userId, String parkId) throws Exception {
		IgcsIGatewayInfoExample example = new IgcsIGatewayInfoExample();
		IgcsIGatewayInfoExample.Criteria criteria = example.createCriteria();
		if (parkId != null) {
			criteria.andParkIdEqualTo(parkId);
		} else {
			User user = findUserById(userId);
			criteria.andParkIdEqualTo(user.getParkId());
		}
        criteria.andStatusEqualTo("0");
        criteria.andTypeEqualTo(GatewayInfo.GW_TYPE_WEATHER);
        return gatewayinfoDAO.selectByExample(example);
	}

	@Override
	public Map<Short, List<SensorInfo>> getSensorList(String gwId, String nodeId) throws Exception {
		IgcsIsensorinfoExample exp = new IgcsIsensorinfoExample();
		exp.createCriteria().andGatewayIdEqualTo(gwId).andNodeIdEqualTo(nodeId).andStatusEqualTo("0");
		List<IgcsIsensorinfo> lstS = sensorinfoDAO.selectByExample(exp);
		
		Map<Short, List<SensorInfo>> mpSensor = new TreeMap<Short, List<SensorInfo>>();
		for (IgcsIsensorinfo igcsIsensorinfo : lstS) {
			SensorInfo sinfo = new SensorInfo();
			sinfo.setSensorId(igcsIsensorinfo.getSensorId());
			sinfo.setSensorTypeCode(igcsIsensorinfo.getSensorTypeCode());
			
			IgcsASensorType type = sensortypeDAO.selectByPrimaryKey(igcsIsensorinfo.getSensorTypeCode());
			sinfo.setSensorTypeName(type.getSensorTypeName());
			
			Short orderId = type.getOrderId().shortValue();
			
			if (!mpSensor.containsKey(orderId)) {	
				List<SensorInfo> lst = new ArrayList<SensorInfo>();
				lst.add(sinfo);
				mpSensor.put(orderId, lst);			
			} else {
				mpSensor.get(orderId).add(sinfo);
			}
		}
		
		return mpSensor;
	}	
	
	@Override
	public Map<String, List<SensorData>> findHistoryInfoByFilter(String gwFilter, String nodeFilter,
			String sensorListFilter, String startTimeFilter, String endTimeFilter, String bWeather) throws Exception {
		Map<String, List<SensorData>> mpData = new LinkedHashMap<String, List<SensorData>>();
		
		String startTime = DateUtil.stringToString(startTimeFilter);
		String lastTime = DateUtil.stringToString(endTimeFilter);		
		
		String nowSensorTypeCode = "";
		String nowSensorId = "";
		String sensorName = "";
		String sensorUnit = "";
		short type = 0;
		String key = "";
		List<SensorData> lstOneSensorData = null;
		
		String[] aTypeAndId = sensorListFilter.split(",");
		for (String strTypeAndId : aTypeAndId) {
			String[] aS = strTypeAndId.split("-");
			nowSensorTypeCode = aS[0];
			nowSensorId = aS[1];
			IgcsASensorType sensorType = sensortypeDAO.selectByPrimaryKey(aS[0]);
			type = sensorType.getOrderId().shortValue();
			sensorName = sensorType.getSensorTypeName();
			sensorUnit = "(" + sensorType.getSensorUnit() + ")";			
			
			if (bWeather.equals("1")) {
				key = type + "_" + nowSensorTypeCode + "_" + sensorName + sensorUnit;
				lstOneSensorData = gatherwdatacDAO.findWHistoryByFilter(gwFilter, nodeFilter, 
						nowSensorTypeCode, nowSensorId, startTime, lastTime);
			} else {
				key = type + "_" + nowSensorTypeCode + "_" + sensorName + nowSensorId + sensorUnit;
				lstOneSensorData = gatherdatacDAO.findHistoryByCondition(gwFilter, nodeFilter, 
						nowSensorTypeCode, nowSensorId, startTime, lastTime);
			}
			
			mpData.put(key, lstOneSensorData);
		}
		
		return mpData;
	}

	@Override
	public List<GreenhouseInfo> queryGhOfPark(String parkId) throws Exception {
		return queryGhs(parkId, true);
	}
	
	private List<GreenhouseInfo> queryGhs(String keyId, boolean bUseParkId) throws Exception {
		IgcsIgreenhouseExample example = new IgcsIgreenhouseExample();
		IgcsIgreenhouseExample.Criteria criteria = example.createCriteria();
		if (bUseParkId) {
			criteria.andParkIdEqualTo(keyId);
			example.setOrderByClause("user_id asc, greenhouse_name asc");
		} else {
			criteria.andUserIdEqualTo(keyId);
		}
        List<IgcsIgreenhouse> lst = greenhouseDAO.selectByExample(example);
        
        List<GreenhouseInfo> lstGh = new ArrayList<GreenhouseInfo>();
        for (IgcsIgreenhouse igcsIgreenhouse : lst) {
        	List<IgcsInodeinfo> lstNs = getNodesOfGh(igcsIgreenhouse.getGreenhouseId(), true);
			User user = findUserById(igcsIgreenhouse.getUserId());
			GreenhouseInfo info = new GreenhouseInfo(igcsIgreenhouse, user.getTruename(), lstNs);			
			lstGh.add(info);
		}
        
        return lstGh;
	}

	@Override
	public List<IgcsInodeinfo> queryNodesOfPark(String parkId) throws Exception {
		List<IgcsIGatewayInfo> lstInfo = queryGatewayOfParkAdmin(parkId);	
		List<String> lstGwIds = new ArrayList<String>();
		for (IgcsIGatewayInfo info : lstInfo) {
			lstGwIds.add(info.getGatewayId());
		}	
		
		IgcsInodeinfoExample example = new IgcsInodeinfoExample();
		IgcsInodeinfoExample.Criteria criteria = example.createCriteria();
        criteria.andGatewayIdIn(lstGwIds);
        criteria.andStatusEqualTo("0");
        example.setOrderByClause("gateway_id asc, node_id asc");
		return nodeinfoDAO.selectByExample(example);
	}

	@Override
	public void addGreenhouseEx(IgcsIgreenhouse info, String gwNodes) throws Exception {
		greenhouseDAO.insert(info);		
		updateNodesGhId(info.getGreenhouseId(), gwNodes);
	}

	private void updateNodesGhId(String ghId, String gwNodes) throws Exception {
		String[] aTypeAndId = gwNodes.split(",");
		for (String strTypeAndId : aTypeAndId) {
			String[] aS = strTypeAndId.split("-");
			IgcsInodeinfoKey key = new IgcsInodeinfoKey();
			key.setGatewayId(aS[0]);
			key.setNodeId(aS[1]);
			IgcsInodeinfo nInfo = nodeinfoDAO.selectByPrimaryKey(key);
			nInfo.setGreenhouseId(ghId);	
			nodeinfoDAO.updateByPrimaryKey(nInfo);
		}
	}

	@Override
	public void mdyGreenhouseEx(IgcsIgreenhouse info, String gwNodes) throws Exception {
		greenhouseDAO.updateByPrimaryKey(info);		
		updateNodesGhId(info.getGreenhouseId(), gwNodes);
	}

	@Override
	public void delGhById(String ghId) throws Exception {
		List<IgcsInodeinfo> lstNs = getNodesOfGh(ghId, false);
		for (IgcsInodeinfo nInfo : lstNs) {
			nInfo.setGreenhouseId(null);	
			nodeinfoDAO.updateByPrimaryKey(nInfo);
		}
		
		greenhouseDAO.deleteByPrimaryKey(ghId);
	}

	@Override
	public IgcsIparkinfo findParkById(String parkId) {
		
		 return parkinfoDAO.selectByPrimaryKey(parkId);
	}
}

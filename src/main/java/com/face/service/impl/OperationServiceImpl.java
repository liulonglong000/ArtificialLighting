package com.face.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.face.mapper.IgcsBTradeMapper;
import com.face.mapper.IgcsINodeItemMapper;
import com.face.mapper.IgcsIEquipmentMapper;
import com.face.model.IgcsBTrade;
import com.face.model.IgcsINodeItem;
import com.face.model.IgcsINodeItemExample;
import com.face.model.IgcsIEquipment;
import com.face.model.IgcsIEquipmentKey;
import com.face.service.IOperationService;

@Service
public class OperationServiceImpl implements IOperationService {
	@Autowired
	private IgcsBTradeMapper tradeDAO;
	@Autowired
	private IgcsIEquipmentMapper equipmentDAO;
	@Autowired
	private IgcsINodeItemMapper nodeItemDAO;
	
	@Override
	public void addTrade(IgcsBTrade info) throws Exception {
		tradeDAO.insert(info);
	}
	
	@Override
	public IgcsBTrade findTradeById(String tradeId) throws Exception {
		return tradeDAO.selectByPrimaryKey(tradeId);
	}

	@Override
	public IgcsIEquipment findEquipById(String gatewayId, String nodeId, String equipmentTypeCode, String equipmentId)
			throws Exception {
		IgcsIEquipmentKey key = new IgcsIEquipmentKey();
		key.setGatewayId(gatewayId);
		key.setNodeId(nodeId);
		key.setEquipmentType(equipmentTypeCode);
		key.setEquipmentId(equipmentId);
		return equipmentDAO.selectByPrimaryKey(key);
	}

	@Override
	public void updateEquipById(String gatewayId, String nodeId, String equipmentTypeCode, String equipmentId,
			String status) throws Exception {
		IgcsIEquipmentKey key = new IgcsIEquipmentKey();
		key.setGatewayId(gatewayId);
		key.setNodeId(nodeId);
		key.setEquipmentType(equipmentTypeCode);
		key.setEquipmentId(equipmentId);
		IgcsIEquipment equip = equipmentDAO.selectByPrimaryKey(key);
		equip.setStatus(status);
		
		equipmentDAO.updateByPrimaryKey(equip);
	}

	@Override
	public List<IgcsINodeItem> findNodeEquipTypes(String gwId, String nodeId) throws Exception {
		IgcsINodeItemExample example = new IgcsINodeItemExample();
		IgcsINodeItemExample.Criteria cri = example.createCriteria();
		cri.andGatewayIdEqualTo(gwId);
		cri.andNodeIdEqualTo(nodeId);
		
		return nodeItemDAO.selectByExample(example);
	}

	@Override
	public void modifyEquipmentTimeLimit(IgcsBTrade info) throws Exception {
		IgcsIEquipmentKey key = new IgcsIEquipmentKey();
		key.setGatewayId(info.getGatewayId());
		key.setNodeId(info.getNodeId());
		key.setEquipmentType(info.getEquipmentTypeCode());
		key.setEquipmentId(info.getEquipmentId());
		IgcsIEquipment equipInfo = equipmentDAO.selectByPrimaryKey(key);
		
		equipInfo.setLocate(Float.valueOf(info.getControlParameter2()));
		String para = info.getControlParameter1().substring(1, info.getControlParameter1().length() - 1);
		String timeUp = para.substring(0, para.indexOf(","));
		String timeDown = para.substring(para.indexOf(",") + 1, para.length());
		equipInfo.setPara1(Integer.valueOf(timeUp));
		equipInfo.setPara2(Integer.valueOf(timeDown));
		equipInfo.setPara3(Integer.valueOf(info.getControlParameter3()));
		equipmentDAO.updateByPrimaryKey(equipInfo);
	}

	@Override
	public void modifyEquipmentEncoder(IgcsBTrade info) throws Exception {
		IgcsIEquipmentKey key = new IgcsIEquipmentKey();
		key.setGatewayId(info.getGatewayId());
		key.setNodeId(info.getNodeId());
		key.setEquipmentType(info.getEquipmentTypeCode());
		key.setEquipmentId(info.getEquipmentId());
		IgcsIEquipment equipInfo = equipmentDAO.selectByPrimaryKey(key);
		
		equipInfo.setStatusPara(Integer.valueOf(info.getControlParameter1()));
		equipInfo.setParameter(Integer.valueOf(info.getControlParameter2()));
		equipmentDAO.updateByPrimaryKey(equipInfo);
	}
}

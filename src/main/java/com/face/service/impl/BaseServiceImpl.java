package com.face.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.face.mapper.IgcsACompareTypeMapper;
import com.face.mapper.IgcsAEquipmentTypeMapper;
import com.face.mapper.IgcsASensorTypeMapper;
import com.face.mapper.IgcsAcontroltypeMapper;
import com.face.mapper.IgcsIEquipmentMapper;
import com.face.mapper.IgcsIGatewayInfoMapper;
import com.face.mapper.IgcsIgreenhouseMapper;
import com.face.mapper.IgcsInodeinfoMapper;
import com.face.model.IgcsACompareType;
import com.face.model.IgcsAEquipmentType;
import com.face.model.IgcsASensorType;
import com.face.model.IgcsAcontroltype;
import com.face.model.IgcsIEquipment;
import com.face.model.IgcsIEquipmentExample;
import com.face.model.IgcsInodeinfo;
import com.face.model.IgcsInodeinfoExample;

@Service
public class BaseServiceImpl {
	@Autowired
	protected IgcsIGatewayInfoMapper gatewayinfoDAO;
	@Autowired
	protected IgcsIgreenhouseMapper greenhouseDAO;
	@Autowired
	protected IgcsInodeinfoMapper nodeinfoDAO;
	@Autowired
	protected IgcsAEquipmentTypeMapper equipmenttypeDAO;
	@Autowired
	protected IgcsAcontroltypeMapper controltypeDAO;
	@Autowired
	protected IgcsASensorTypeMapper sensortypeDAO;
	@Autowired
	protected IgcsACompareTypeMapper comparetypeDAO;
	@Autowired
	protected IgcsIEquipmentMapper equipmentDAO;
	
	// 获取温室下所有的节点
	protected List<IgcsInodeinfo> getNodesOfGh(String ghId, boolean bOnlyGetConnected) throws Exception {		
		IgcsInodeinfoExample example = new IgcsInodeinfoExample();
		IgcsInodeinfoExample.Criteria criteria = example.createCriteria();
        criteria.andGreenhouseIdEqualTo(ghId);
        if (bOnlyGetConnected) {
        	criteria.andStatusEqualTo("0");
        }
        example.setOrderByClause("gateway_id asc, node_id asc");
		return nodeinfoDAO.selectByExample(example);
	}
	
	public String getEquipNameByType(String type) throws Exception {
		if (type == null) {
			return "";			
		}
		if (type.length() == 0) {
			return "";
		}
		IgcsAEquipmentType equi = equipmenttypeDAO.selectByPrimaryKey(type);
		if (equi == null) {
			return "";
		}
		return equi.getEquipmentTypeName();
	}
	
	public String getControlNameByType(String type) throws Exception {
		if (type == null) {
			return "";			
		}
		if (type.length() == 0) {
			return "";
		}
		IgcsAcontroltype equi = controltypeDAO.selectByPrimaryKey(type);
		if (equi == null) {
			return "";
		}
		return equi.getControlName();
	}
	
	public String getSensorNameByType(String type) throws Exception {
		if (type == null) {
			return "";			
		}
		if (type.length() == 0) {
			return "";
		}
		IgcsASensorType equi = sensortypeDAO.selectByPrimaryKey(type);
		if (equi == null) {
			return "";
		}
		return equi.getSensorTypeName();
	}
	
	public String getCompareNameByType(String type) throws Exception {
		if (type == null) {
			return "";			
		}
		if (type.length() == 0) {
			return "";
		}
		IgcsACompareType equi = comparetypeDAO.selectByPrimaryKey(type);
		if (equi == null) {
			return "";
		}
		return equi.getCompareTypeName();
	}
	
	public String getSensorUnitByType(String type) throws Exception {
		if (type == null) {
			return "";			
		}
		if (type.length() == 0) {
			return "";
		}
		IgcsASensorType equi = sensortypeDAO.selectByPrimaryKey(type);
		if (equi == null) {
			return "";
		}
		return equi.getSensorUnit();
	}
	
	public Integer getSensorArmIdByType(String type) throws Exception {
		if (type == null) {
			return 99;			
		}
		if (type.length() == 0) {
			return 99;
		}
		IgcsASensorType equi = sensortypeDAO.selectByPrimaryKey(type);
		if (equi == null) {
			return 99;
		}
		return equi.getArmSensorTypeId();
	}
	
	public Integer getCompArmIdByType(String type) throws Exception {
		if (type == null) {
			return 99;			
		}
		if (type.length() == 0) {
			return 99;
		}
		IgcsACompareType equi = comparetypeDAO.selectByPrimaryKey(type);
		if (equi == null) {
			return 99;
		}
		return equi.getArmCompareTypeId();
	}
	
	// 获取节点下的所有在线设备
	public List<IgcsIEquipment> getNodeEquips(String gwId, String nodeId, Boolean bTimeLimit) throws Exception {
		IgcsIEquipmentExample dataC = new IgcsIEquipmentExample();
		IgcsIEquipmentExample.Criteria dataCCri = dataC.createCriteria();
		dataCCri.andGatewayIdEqualTo(gwId);
		dataCCri.andNodeIdEqualTo(nodeId);
		dataCCri.andStatusNotEqualTo("-1");
		if (bTimeLimit) {
			dataCCri.andEquipmentTypeEqualTo("RBM");			
		}
		dataC.setOrderByClause("equipment_type asc, equipment_id asc");

		return equipmentDAO.selectByExample(dataC);								
	}
}

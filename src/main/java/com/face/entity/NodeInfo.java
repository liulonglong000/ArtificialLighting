package com.face.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.face.model.IgcsIEquipment;

public class NodeInfo {
	private String nodeId;
	private String gatewayId;
	private String nodeName;
	private Date gatherTime;
	
	private Map<Short, List<SensorInfo>> mpSensor = new TreeMap<Short, List<SensorInfo>>();
	
	private Map<Short, List<EquipmentInfo>> mpEquips = new TreeMap<Short, List<EquipmentInfo>>();

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getGatewayId() {
		return gatewayId;
	}

	public void setGatewayId(String gatewayId) {
		this.gatewayId = gatewayId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public Date getGatherTime() {
		return gatherTime;
	}

	public void setGatherTime(Date gatherTime) {
		this.gatherTime = gatherTime;
	}

	public Map<Short, List<SensorInfo>> getMpSensor() {
		return mpSensor;
	}

	public void setMpSensor(Map<Short, List<SensorInfo>> mpSensor) {
		this.mpSensor = mpSensor;
	}

	public Map<Short, List<EquipmentInfo>> getMpEquips() {
		return mpEquips;
	}

	public void addSensor(SensorInfo sinfo, Short type) {
		sinfo.setClassName("sensor_normal_bg");
		sinfo.setPicClass(sinfo.getClassName() + "_" + SensorType.getPicByType(sinfo.getSensorTypeCode()));
		
		if (!mpSensor.containsKey(type)) {	
			List<SensorInfo> lst = new ArrayList<SensorInfo>();
			lst.add(sinfo);
			mpSensor.put(type, lst);			
		} else {
			mpSensor.get(type).add(sinfo);
		}
	}
	
	public String getGatherTimeString() throws Exception {
		if (gatherTime == null) {
			return "";
		}
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return df2.format(gatherTime);
	}

	public void addEquipmentEx(IgcsIEquipment equip, String equipmentName, Short equipOrder) {
		EquipmentInfo info = new EquipmentInfo();
		info.setEquip(equip);
		info.setType(equipOrder);
		info.setEquipmentName(equipmentName);
		
		if (!mpEquips.containsKey(equipOrder)) {	
			List<EquipmentInfo> lst = new ArrayList<EquipmentInfo>();
			lst.add(info);
			mpEquips.put(equipOrder, lst);			
		} else {
			mpEquips.get(equipOrder).add(info);
		}
	}
}

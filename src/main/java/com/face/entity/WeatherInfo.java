package com.face.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WeatherInfo {
	private String gatewayId;
	private String gatewayName;
	private String nodeId;
	private Date gatherTime;
	
	private Map<Short, List<SensorInfo>> mpSensor = new TreeMap<Short, List<SensorInfo>>();

	public String getGatewayId() {
		return gatewayId;
	}

	public void setGatewayId(String gatewayId) {
		this.gatewayId = gatewayId;
	}

	public String getGatewayName() {
		return gatewayName;
	}

	public void setGatewayName(String gatewayName) {
		this.gatewayName = gatewayName;
	}

	public Date getGatherTime() {
		return gatherTime;
	}

	public void setGatherTime(Date gatherTime) {
		this.gatherTime = gatherTime;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public Map<Short, List<SensorInfo>> getMpSensor() {
		return mpSensor;
	}

	public void setMpSensor(Map<Short, List<SensorInfo>> mpSensor) {
		this.mpSensor = mpSensor;
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
}

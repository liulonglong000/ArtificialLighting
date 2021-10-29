package com.face.entity;

import com.face.model.IgcsCthreshold;

public class ThresholdInfo {
	private IgcsCthreshold thresholdBaseInfo;
	private String nodeName;
	private String sensorTypeName;
	private String thresholdTypeName;
	private String thresholdParameterName;
	private String sensorUnit;

	public String getSensorTypeName() {
		return sensorTypeName;
	}

	public void setSensorTypeName(String sensorTypeName) {
		this.sensorTypeName = sensorTypeName;
	}

	public IgcsCthreshold getThresholdBaseInfo() {
		return thresholdBaseInfo;
	}

	public void setThresholdBaseInfo(IgcsCthreshold thresholdBaseInfo) {
		this.thresholdBaseInfo = thresholdBaseInfo;
	}

	public String getThresholdTypeName() {
		return thresholdTypeName;
	}

	public void setThresholdTypeName(String thresholdTypeName) {
		this.thresholdTypeName = thresholdTypeName;
	}

	public String getThresholdParameterName() {
		return thresholdParameterName;
	}

	public void setThresholdParameterName(String thresholdParameterName) {
		this.thresholdParameterName = thresholdParameterName;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getSensorUnit() {
		return sensorUnit;
	}

	public void setSensorUnit(String sensorUnit) {
		this.sensorUnit = sensorUnit;
	}
	
	public String getSensorFullName() {
        return nodeName + "  " + sensorTypeName + thresholdBaseInfo.getSensorId();
    }

    public String getInfo() {
        return thresholdBaseInfo.getThresholdParameter() + "秒内" + thresholdTypeName + thresholdParameterName
        		+ thresholdBaseInfo.getThresholdValue() + sensorUnit;
    }
}

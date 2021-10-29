package com.face.entity;

public class SensorInfo {
	private String sensorId;
	private String sensorTypeCode;
	private Float sensorValue;
	private String sensorTypeName;
	private String className;
	private String picClass;
	private String unit;
	
	private String atGwId;
	private String atNodeId;
	private String atNodeName;

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public String getSensorTypeCode() {
		return sensorTypeCode;
	}

	public void setSensorTypeCode(String sensorTypeCode) {
		this.sensorTypeCode = sensorTypeCode;
	}

	public Float getSensorValue() {
		return sensorValue;
	}

	public void setSensorValue(Float sensorValue) {
		this.sensorValue = sensorValue;
	}

	public String getSensorTypeName() {
		return sensorTypeName;
	}

	public void setSensorTypeName(String sensorTypeName) {
		sensorTypeName = sensorTypeName.replace("二氧化碳", "CO2");
		this.sensorTypeName = sensorTypeName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPicClass() {
		return picClass;
	}

	public void setPicClass(String picClass) {
		this.picClass = picClass;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getAtNodeId() {
		return atNodeId;
	}

	public void setAtNodeId(String atNodeId) {
		this.atNodeId = atNodeId;
	}
	
	public String getSensorName() {
		return sensorTypeName + sensorId;
	}

	public String getAtNodeName() {
		return atNodeName;
	}

	public void setAtNodeName(String atNodeName) {
		this.atNodeName = atNodeName;
	}

	public String getAtGwId() {
		return atGwId;
	}

	public void setAtGwId(String atGwId) {
		this.atGwId = atGwId;
	}
}

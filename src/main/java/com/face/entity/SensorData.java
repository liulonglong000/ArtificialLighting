package com.face.entity;

import java.util.Date;

public class SensorData {
	private Date gatherTime;
	private Float sensorValue;

	public Float getSensorValue() {
		return sensorValue;
	}

	public void setSensorValue(Float sensorValue) {
		this.sensorValue = sensorValue;
	}

	public Date getGatherTime() {
		return gatherTime;
	}

	public void setGatherTime(Date gatherTime) {
		this.gatherTime = gatherTime;
	}
}

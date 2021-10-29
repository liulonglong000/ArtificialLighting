package com.face.entity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

public class SensorHistoryData implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date dateGet;
	private float fData;
	
	public SensorHistoryData() {
		
	}

	public SensorHistoryData(Date gatherTime, Float sensorValue) throws Exception {
		this.dateGet = gatherTime;
		this.fData = sensorValue;
	}

	public Date getDateGet() {
		return dateGet;
	}

	public void setDateGet(Date dateGet) {
		this.dateGet = dateGet;
	}

	public float getfData() {
		return fData;
	}

	public void setfData(float fData) {
		this.fData = fData;
	}

	public String getfDataString() {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(fData);
	}
}

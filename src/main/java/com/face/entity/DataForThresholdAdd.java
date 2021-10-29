package com.face.entity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.face.model.IgcsACompareType;
import com.face.model.IgcsAThresholdType;

public class DataForThresholdAdd {
	private List<SensorInfo> lstSensor = new ArrayList<SensorInfo>();
	private Map<String, String> mpType = new LinkedHashMap<String, String>();
	private Map<String, String> mpComp = new LinkedHashMap<String, String>();

	public List<SensorInfo> getLstSensor() {
		return lstSensor;
	}

	public void setLstSensor(List<SensorInfo> lstSensor) {
		this.lstSensor = lstSensor;
	}

	public Map<String, String> getMpType() {
		return mpType;
	}

	public void setMpType(Map<String, String> mpType) {
		this.mpType = mpType;
	}

	public Map<String, String> getMpComp() {
		return mpComp;
	}

	public void setMpComp(Map<String, String> mpComp) {
		this.mpComp = mpComp;
	}

	public void addType(List<IgcsAThresholdType> lstType) {
		for (IgcsAThresholdType igcsAthresholdtype : lstType) {
			mpType.put(igcsAthresholdtype.getThresholdTypeCode(), igcsAthresholdtype.getThresholdTypeName());
		}
	}

	public void addComp(List<IgcsACompareType> lstComp) {
		for (IgcsACompareType igcsAcomparetype : lstComp) {
			mpComp.put(igcsAcomparetype.getCompareType(), igcsAcomparetype.getCompareTypeName());
		}
	}

	public void addSensor(SensorInfo sInfo) {
		lstSensor.add(sInfo);
	}
}

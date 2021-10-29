package com.face.entity;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class HistoryDataEntity {
	private Long llTime;
    private Map<Integer, Float> sensorData;
    
    public HistoryDataEntity(Long time) {
        this.llTime = time;
        sensorData = new LinkedHashMap<Integer, Float>();
    }

    public Map<Integer, Float> getSensorData() {
        return sensorData;
    }

    public void setSensorData(Map<Integer, Float> sensorData) {
        this.sensorData = sensorData;
    }

    public Long getLlTime() {
		return llTime;
	}

	public void setLlTime(Long llTime) {
		this.llTime = llTime;
	}
	
	public String getTimeStr(String dateFormat) {
		SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        Date date = new Date();
        date.setTime(llTime);
		return sf.format(date);
	}

	public String getSensorDataById(int n) {
        if (sensorData.containsKey(n)) {
            DecimalFormat df = new DecimalFormat("0.00");
            return df.format(sensorData.get(n));
        } else {
            return "";
        }
    }
}

package com.face.entity;

public class SensorType {
	public static String getPicByType(String type) {
		if (type.equals("ETEMP")) {
            return "soilT";
        } else if (type.equals("EHUMI")) {
            return "soilM";
        } else if (type.equals("ECOND")) {
            return "soilD";
        } else if (type.equals("ATEMP")) {
            return "airT";
        } else if (type.equals("AHUMI")) {
            return "airH";
        } else if (type.equals("AILLU")) {
            return "light";
        } else if (type.equals("ACO2")) {
            return "co2";
        } else if (type.equals("RAINS")) {
            return "rains";
        } else {
            return "";
        }
	}
	
	public static int getYAxisByType(String type) {
		if (type.equals("ETEMP") || type.equals("ATEMP")) {				// 温度轴
            return 0;
        } else if (type.equals("EHUMI") || type.equals("AHUMI")) {		// 湿度轴
            return 1;
        } else if (type.equals("AILLU")) {								// 光照度轴
            return 2;
        } else if (type.equals("ACO2")) {								// 二氧化碳浓度轴
            return 3;
        } else if (type.equals("ECOND")) {								// 土壤电导率轴
            return 4;
        }
		return 0;
	}
}

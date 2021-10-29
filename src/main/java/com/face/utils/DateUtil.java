package com.face.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String timestampToString(Timestamp time) {
		if (time == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return df.format(time);
	}
	
	public static String dateToString(Date time) {
		if (time == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return df.format(time);
	}
	
	public static String stringToString(String src) {
		if (src == null) {
			return "";
		}
		if (src.equals("")) {
			return "";
		}
		
		String dest = src.substring(0, 4);
		dest += src.substring(5, 7);
		dest += src.substring(8, 10);
		dest += src.substring(11, 13);
		dest += src.substring(14, 16);
		dest += "00";
		
    	return dest;
	}

	public static Date stringToTime(String time) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.parse(time);
	}

	public static String timeToString(Date time) {
		if (time == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
    	return df.format(time);
	}
}

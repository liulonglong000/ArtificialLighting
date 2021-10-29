package com.face.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataConversionUtil {
	private static final Log log = LogFactory.getLog(DataConversionUtil.class);
	
	public static Integer stringToInteger(String strVal) {
		try {
			if (strVal == null || strVal.length() == 0) {
				return null;
			}
			return Integer.valueOf(strVal);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Convert " + strVal + "to integer failed!(" + e.getLocalizedMessage() + ")");
			return null;
		}
	}
	
	public static String integerToString(Integer nVal) {
		try {
			if (nVal == null) {
				return "";
			}
			return nVal.toString();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Convert " + nVal + "to string failed!(" + e.getLocalizedMessage() + ")");
			return "";
		}
	}
}

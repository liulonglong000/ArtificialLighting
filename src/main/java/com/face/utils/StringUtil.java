package com.face.utils;

import java.net.URLEncoder;

public class StringUtil {
	public static String getStringNotNull(String src) {
		if (src == null) {
			return "";
		}
		return src;
	}
	
	public static String getStringForDL(String src) throws Exception {
		if (src == null) {
			return "";
		}
		return URLEncoder.encode(src, "UTF-8");
	}

	public static boolean notEmpty(String src) {
		if (src == null) {
			return false;
		} 
		if (src.length() == 0) {
			return false;
		}
		return true;
	}
	
	public static String getStringNotNull(Integer src) {
		if (src == null) {
			return "";
		}
		return src.toString();
	}
	
	public static String getStringNotNull(Float src) {
		if (src == null) {
			return "";
		}
		return src.toString();
	}
}

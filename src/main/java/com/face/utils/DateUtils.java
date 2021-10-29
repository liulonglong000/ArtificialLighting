package com.face.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;


public class DateUtils {

	private final static String DATE_FORMAT = "yyyy-MM-dd";
	private final static String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private final static long TIME_8 = 8 * 60 * 60 * 1000; // 八小时时差，单位毫秒

	/**
	 * 获取字符串格式的日期
	 * @param date
	 * @return
	 */
	public static String getDateStr(Date date) {
		if (null == date) {
			return "";
		}
		DateFormat dateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
		return dateFormat.format(date);
	}

	public static String getDateStr(Date date, String format) {
		if (null == date) {
			return "";
		}
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	/**
	 * 处理VUE传进来的日期格式，并+8小时时间差
	 * @param dateStr
	 * @return
	 */
	public static Date getVueDate(String dateStr) {
		if (StringUtils.isBlank(dateStr)) {
			return null;
		}
		dateStr = dateStr.substring(0, dateStr.indexOf("."));
		dateStr = dateStr.replace("T", " ");
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
		try {
			Date date = sdf.parse(dateStr);
			return new Date(date.getTime() + TIME_8);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	 public static Date string2Date(String time) {  
	       
	        SimpleDateFormat sf = new SimpleDateFormat(DEFAULT_FORMAT);  
	        Date date=null;
	        try {  
	         
	             date = sf.parse(time);  
	             
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }
			return date;  
	  
	    }  
	
	
	 /** 
	  * 将长整型数字转换为日期格式的字符串 
	  *  
	  * @param time 
	  * @param format 
	  * @return 
	  */  
	 public static String convert2String1(long time) {  
	  if (time > 0l) {  
	   SimpleDateFormat sf = new SimpleDateFormat(DATE_FORMAT);  
	   Date date = new Date(time);  
	   return sf.format(date);  
	  }  
	  return "";  
	 }  
	 
	 public static String convert2String(long time) {  
		  if (time > 0l) {  
		   SimpleDateFormat sf = new SimpleDateFormat(DEFAULT_FORMAT);  
		   Date date = new Date(time);  
		   return sf.format(date);  
		  }  
		  return "";  
		 } 
	 
	 /** 
	  * 将日期格式的字符串转换为长整型 
	  *  
	  * @param date 
	  * @param format 
	  * @return 
	  */  
	 public static long convert2long(String date) {  
	  try {  
	   if (StringUtils.isNotBlank(date)) {  
	    SimpleDateFormat sf = new SimpleDateFormat(DEFAULT_FORMAT);  
	    return sf.parse(date).getTime();  
	   }  
	  } catch (ParseException e) {  
	   e.printStackTrace();  
	  }  
	  return 0l;  
	 }  
	 
	 public static String subMonth(int date, String time) {  
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	        Calendar rightNow = Calendar.getInstance();  
	        Date dt=null;
	        try {
				 dt = sdf.parse(time);
			} catch (ParseException e) {
				e.printStackTrace();
			}  
	        rightNow.setTime(dt);  
	        rightNow.add(Calendar.MONTH, date);  
	        Date dt1 = rightNow.getTime();  
	        String reStr = sdf.format(dt1);  
	  
	        return reStr;  
	    }  
	 
	    public static String getStringToDate(String lo){
	        long time = Long.parseLong(lo);
	        Date date = new Date(time);
	        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
	        return sd.format(date);
	    }
	    public static String getYesTaday(){
	    Calendar cal=Calendar.getInstance();
	  cal.add(Calendar.DATE,-1);
	  Date time=cal.getTime();
	  return  new SimpleDateFormat("yyyy-MM-dd").format(time);
	    }
	    
	    public static String getSpecifiedDayAfter(String specifiedDay){ 
	    	Calendar c = Calendar.getInstance(); 
	    	Date date=null; 
	    	try { 
	    	date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay); 
	    	} catch (ParseException e) { 
	    	e.printStackTrace(); 
	    	} 
	    	c.setTime(date); 
	    	int day=c.get(Calendar.DATE); 
	    	c.set(Calendar.DATE,day+1); 

	    	String dayAfter=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()); 
	    	return dayAfter; 
	    	}
	    
	    public static String getYesTadayTime(){
		    Calendar cal=Calendar.getInstance();
		  cal.add(Calendar.DATE,-1);
		  Date time=cal.getTime();
		  return  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
		    }
	 public static void main(String[] args) {
		
		System.out.println(subMonth(3,"2018-03-22 03:11:11"));
	}
	
}

package com.face.utils;

import java.awt.Color;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class ReportZong {

	protected XSSFCellStyle styleheader;
	protected XSSFCellStyle stylebody;
	protected XSSFCellStyle styletitle;
	protected XSSFCellStyle styletotal;

	// public abstract void createReport(XSSFWorkbook wb,List<String>
	// header,List<List<String>> data);

	


	public XSSFCellStyle getStyle(XSSFWorkbook wb) {
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 水平居中
		// style.setAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN); // 下边框
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);// 左边框
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);// 上边框
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);// 右边框
		style.setWrapText(true);
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		style.setFont(font);
		return style;
	}

	public static XSSFCellStyle styletotal(XSSFWorkbook wb) {
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 水平居中
		// style.setAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN); // 下边框
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);// 左边框
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);// 上边框
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);// 右边框
		style.setWrapText(true);
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		XSSFColor myColor = new XSSFColor(Color.red);
		font.setColor(myColor); // 字体设置为红色
		style.setFont(font);
		return style;
	}

	public static XSSFCellStyle getStyleheader(XSSFWorkbook wb) {
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 水平居中
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		style.setBorderBottom(XSSFCellStyle.BORDER_THIN); // 下边框
		style.setBorderLeft(XSSFCellStyle.BORDER_THIN);// 左边框
		style.setBorderTop(XSSFCellStyle.BORDER_THIN);// 上边框
		style.setBorderRight(XSSFCellStyle.BORDER_THIN);// 右边框
		style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		XSSFColor myColor = new XSSFColor(Color.GREEN);
		style.setFillForegroundColor(myColor); // 填暗绿色
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		style.setFont(font);
		return style;
	}

	public static  XSSFCellStyle getStyletitle(XSSFWorkbook wb) {
		XSSFCellStyle style = wb.createCellStyle();
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		XSSFFont font = wb.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short) 28);// 设置字体大小
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		style.setFont(font);
		return style;
	}

	protected String getDate(String dateStr) {
		if (dateStr.length() == 4) {
			return dateStr;
		}
		return dateStr.substring(5);
	}

}

package com.face.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WriteException;

public class HandleExcel {
	private static final Log log = LogFactory.getLog(HandleExcel.class);
	
	public static final short HORIZONTAL_PRINT_TOTAL_WIDTH = 132;	// 横向打印时能打印到一张纸上的最大总列宽
	public static final int FONT_SIZE_DEFAULT = 10;
	
	// 表头单元格样式的设定 
	  public static WritableCellFormat getHeaderCellStyleWithPara(int ps,Colour c ) throws Exception {          
	        /* 
	         * WritableFont.createFont("宋体")：设置字体为宋体 
	         * 10：设置字体大小 
	         * WritableFont.BOLD:设置字体加粗（BOLD：加粗     NO_BOLD：不加粗） 
	         * false：设置非斜体 
	         * UnderlineStyle.NO_UNDERLINE：没有下划线 
	         */  
	        WritableFont font = new WritableFont(WritableFont.createFont("宋体"),  
	        									 ps,   
	                                             WritableFont.BOLD,   
	                                             false,  
	                                             UnderlineStyle.NO_UNDERLINE);  
	          
	        WritableCellFormat headerFormat = new WritableCellFormat(NumberFormats.TEXT);  
	        try {  
	            // 添加字体设置  
	            headerFormat.setFont(font);  
	            // 设置单元格背景色：表头为黄色  
	            headerFormat.setBackground(c);  
	   
	            // 设置表头表格边框样式  
	            // 整个表格线为粗线、黑色  
	            headerFormat.setBorder(Border.ALL, BorderLineStyle.THICK, Colour.BLACK);  
	            // 表头内容水平居中显示  
	            headerFormat.setAlignment(Alignment.CENTRE);    
	            headerFormat.setVerticalAlignment(VerticalAlignment.CENTRE); 
	            return headerFormat;
	        } catch (WriteException e) {  
	        	log.error("表头单元格样式设置失败！");
	        	e.printStackTrace();
	        	throw new RuntimeException(e);
	        }   
	    } 
	    
	  
    public static WritableCellFormat getHeaderCellStyleWithPara(int ps) throws Exception {          
        /* 
         * WritableFont.createFont("宋体")：设置字体为宋体 
         * 10：设置字体大小 
         * WritableFont.BOLD:设置字体加粗（BOLD：加粗     NO_BOLD：不加粗） 
         * false：设置非斜体 
         * UnderlineStyle.NO_UNDERLINE：没有下划线 
         */  
        WritableFont font = new WritableFont(WritableFont.createFont("宋体"),  
        									 ps,   
                                             WritableFont.BOLD,   
                                             false,  
                                             UnderlineStyle.NO_UNDERLINE);  
          
        WritableCellFormat headerFormat = new WritableCellFormat(NumberFormats.TEXT);  
        try {  
            // 添加字体设置  
            headerFormat.setFont(font);  
            // 设置单元格背景色：表头为黄色  
       /*     headerFormat.setBackground(Colour.YELLOW); */ 
            headerFormat.setBackground(Colour.WHITE);  
            // 设置表头表格边框样式  
            // 整个表格线为粗线、黑色  
           /* headerFormat.setBorder(Border.ALL, BorderLineStyle.THICK, Colour.BLACK);  */
            headerFormat.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK); 
            // 表头内容水平居中显示  
            headerFormat.setAlignment(Alignment.CENTRE);    
            headerFormat.setVerticalAlignment(VerticalAlignment.CENTRE); 
            return headerFormat;
        } catch (WriteException e) {  
        	log.error("表头单元格样式设置失败！");
        	e.printStackTrace();
        	throw new RuntimeException(e);
        }   
    } 
    
    public static WritableCellFormat getHeaderCellStyle() throws Exception {          
    	return getHeaderCellStyleWithPara(FONT_SIZE_DEFAULT);
    } 
    public static WritableCellFormat getHeaderCellStyle(int ps,Colour c) throws Exception {          
    	return getHeaderCellStyleWithPara(ps,c);
    } 
    // 表体单元格样式的设定 
    public static WritableCellFormat getBodyCellStyleWithPara(Alignment align, int ps, boolean bSwap) throws Exception {           
        /* 
         * WritableFont.createFont("宋体")：设置字体为宋体 
         * 10：设置字体大小 
         * WritableFont.NO_BOLD:设置字体非加粗（BOLD：加粗     NO_BOLD：不加粗） 
         * false：设置非斜体 
         * UnderlineStyle.NO_UNDERLINE：没有下划线 
         */  
        WritableFont font = new WritableFont(WritableFont.createFont("宋体"),  
                                             ps,   
                                             WritableFont.NO_BOLD,   
                                             false,  
                                             UnderlineStyle.NO_UNDERLINE);            
        WritableCellFormat bodyFormat = new WritableCellFormat(font);  
        try {  
            // 设置单元格背景色：表体为白色  
            bodyFormat.setBackground(Colour.WHITE);  
            // 设置表头表格边框样式  
            // 整个表格线为细线、黑色  
            bodyFormat.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK); 
            bodyFormat.setAlignment(align);
            bodyFormat.setVerticalAlignment(VerticalAlignment.CENTRE); 
            bodyFormat.setWrap(bSwap);
//            bodyFormat.setShrinkToFit(true);
            return bodyFormat;
        } catch (WriteException e) {  
        	log.error("表体单元格样式设置失败！");
        	e.printStackTrace();
        	throw new RuntimeException(e);
        }   
    }
    
    public static WritableCellFormat getBodyCellStyleWithAsignBorder(Alignment align, boolean bSetBottom) throws Exception {           
        /* 
         * WritableFont.createFont("宋体")：设置字体为宋体 
         * 10：设置字体大小 
         * WritableFont.NO_BOLD:设置字体非加粗（BOLD：加粗     NO_BOLD：不加粗） 
         * false：设置非斜体 
         * UnderlineStyle.NO_UNDERLINE：没有下划线 
         */  
        WritableFont font = new WritableFont(WritableFont.createFont("宋体"),  
        									 FONT_SIZE_DEFAULT,   
                                             WritableFont.NO_BOLD,   
                                             false,  
                                             UnderlineStyle.NO_UNDERLINE);            
        WritableCellFormat bodyFormat = new WritableCellFormat(font);  
        try {  
            // 设置单元格背景色：表体为白色  
            bodyFormat.setBackground(Colour.WHITE);  
            // 设置表头表格边框样式  
            // 整个表格线为细线、黑色  
            bodyFormat.setBorder(Border.RIGHT, BorderLineStyle.THIN, Colour.BLACK); 
            if (bSetBottom) {
            	bodyFormat.setBorder(Border.BOTTOM, BorderLineStyle.THIN, Colour.BLACK);
			}
            bodyFormat.setAlignment(align);
            bodyFormat.setVerticalAlignment(VerticalAlignment.CENTRE); 
            bodyFormat.setWrap(false);
//            bodyFormat.setShrinkToFit(true);
            return bodyFormat;
        } catch (WriteException e) {  
        	log.error("表体单元格样式设置失败！");
        	e.printStackTrace();
        	throw new RuntimeException(e);
        }   
    }    
    
    public static WritableCellFormat getMergerCellStyle() throws Exception {           
        /* 
         * WritableFont.createFont("宋体")：设置字体为宋体 
         * 10：设置字体大小 
         * WritableFont.NO_BOLD:设置字体非加粗（BOLD：加粗     NO_BOLD：不加粗） 
         * false：设置非斜体 
         * UnderlineStyle.NO_UNDERLINE：没有下划线 
         */  
        WritableFont font = new WritableFont(WritableFont.createFont("宋体"),  
                                             10,   
                                             WritableFont.BOLD,   
                                             false,  
                                             UnderlineStyle.NO_UNDERLINE);            
        WritableCellFormat bodyFormat = new WritableCellFormat(font);  
        try {  
            // 设置单元格背景色：表体为白色  
            bodyFormat.setBackground(Colour.WHITE);  
            // 设置表头表格边框样式  
            // 整个表格线为细线、黑色  
            bodyFormat.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK); 
            bodyFormat.setAlignment(Alignment.CENTRE);
            bodyFormat.setVerticalAlignment(VerticalAlignment.CENTRE); 
            bodyFormat.setWrap(false);
//            bodyFormat.setShrinkToFit(true);
            return bodyFormat;
        } catch (WriteException e) {  
        	log.error("表体单元格样式设置失败！");
        	e.printStackTrace();
        	throw new RuntimeException(e);
        }   
    }
    
    public static WritableCellFormat getBodyCellStyleWithPara(Alignment align, boolean bSwap) throws Exception {           
        return getBodyCellStyleWithPara(align, FONT_SIZE_DEFAULT, bSwap);
    }
    
    public static WritableCellFormat getBodyCellStyle(Alignment align) throws Exception {           
        return getBodyCellStyleWithPara(align, FONT_SIZE_DEFAULT, false);
    }
    
    public static WritableCellFormat getBodyCellStyle(int ps ,Alignment align) throws Exception {           
        return getBodyCellStyleWithPara(align, 11, false);
    }
    
	public static CellFormat getTitleCellStyleWithPara(VerticalAlignment vAlign, int ps) {
		WritableFont font = new WritableFont(WritableFont.createFont("黑体"), ps,
				WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE);
		WritableCellFormat headerFormat = new WritableCellFormat(NumberFormats.TEXT);
		try {
			headerFormat.setFont(font);
			headerFormat.setBackground(Colour.WHITE);
			headerFormat.setBorder(Border.ALL, BorderLineStyle.THICK, Colour.WHITE);
			headerFormat.setAlignment(Alignment.LEFT);
			headerFormat.setVerticalAlignment(vAlign);
			headerFormat.setWrap(true);
			return headerFormat;
		} catch (WriteException e) {
			log.error("页眉单元格样式设置失败！");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static CellFormat getTitleCellStyle(VerticalAlignment vAlign) {
		return getTitleCellStyleWithPara(vAlign, FONT_SIZE_DEFAULT);
	}
	
	public static WritableCellFormat getFooterCellStyleWithPara(int ps) throws Exception {          
        /* 
         * WritableFont.createFont("宋体")：设置字体为宋体 
         * 10：设置字体大小 
         * WritableFont.BOLD:设置字体加粗（BOLD：加粗     NO_BOLD：不加粗） 
         * false：设置非斜体 
         * UnderlineStyle.NO_UNDERLINE：没有下划线 
         */  
        WritableFont font = new WritableFont(WritableFont.createFont("宋体"),  
        									 ps,   
                                             WritableFont.BOLD,   
                                             false,  
                                             UnderlineStyle.NO_UNDERLINE);  
          
        WritableCellFormat headerFormat = new WritableCellFormat(NumberFormats.TEXT);  
        try {  
            // 添加字体设置  
            headerFormat.setFont(font);  
            // 设置单元格背景色：表头为黄色  
            headerFormat.setBackground(Colour.WHITE);  
            // 设置表头表格边框样式  
            // 整个表格线为粗线、黑色  
            headerFormat.setBorder(Border.TOP, BorderLineStyle.THIN, Colour.BLACK);  
            // 表头内容水平居中显示  
            headerFormat.setAlignment(Alignment.RIGHT);    
            headerFormat.setVerticalAlignment(VerticalAlignment.CENTRE); 
            return headerFormat;
        } catch (WriteException e) {  
        	log.error("表尾单元格样式设置失败！");
        	e.printStackTrace();
        	throw new RuntimeException(e);
        }   
    } 
}

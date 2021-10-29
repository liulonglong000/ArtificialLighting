package com.face.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

import javax.management.RuntimeErrorException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.face.entity.HistoryDataEntity;
import com.face.entity.SensorHistoryData;

import jxl.format.Alignment;
import jxl.write.Label;

/**
 * 在线时长统计报表
 * 
 * @author zhenzq
 * 
 */
public class ZongExcelReport extends ReportZong {

	public ZongExcelReport() {

	}


	

	public void writeToFile(String filepath, XSSFWorkbook wb) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filepath);
			wb.write(fos);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			throw new RuntimeErrorException(null, "写入文件不存在");
		} catch (IOException e) {

			e.printStackTrace();
			throw new RuntimeErrorException(null, "写入数据失败");
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
		}

	}

	public byte[] writeToStream(XSSFWorkbook wb) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			wb.write(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeErrorException(null, "写入流失败" + e.getMessage());
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return out.toByteArray();

	}


	public void createReport(XSSFWorkbook workbook, String strTitle, Map<String, List<SensorHistoryData>> mpData,
			String dateFormat) {
		// TODO Auto-generated method stub
		styleheader = super.getStyleheader(workbook);
		stylebody = super.getStyle(workbook);
		styletitle = super.getStyletitle(workbook);
		styletotal = super.styletotal(workbook);
		 XSSFSheet sheet = workbook.createSheet("历史数据");

			CellRangeAddress cra = new CellRangeAddress(0, 0, 0,
					mpData.size() + 2);
			sheet.addMergedRegion(cra);
			XSSFRow row = sheet.createRow(0);
			row.setHeightInPoints(3 * sheet.getDefaultRowHeightInPoints());
			XSSFCell cell_0 = row.createCell(0);
			cell_0.setCellValue(strTitle);
			cell_0.setCellStyle(styletitle);
	        
			XSSFRow row1 = sheet.createRow(1);
			row1.setHeightInPoints(3 * sheet.getDefaultRowHeightInPoints());
			
			XSSFCell cell_1 = row1.createCell(0);
			cell_1.setCellValue("序号");
			cell_1.setCellStyle(styleheader);
			XSSFCell cell_2 = row1.createCell(1);
			cell_2.setCellValue("时间");
			cell_2.setCellStyle(styleheader);
			int nCol=2;
			for (Entry<String, List<SensorHistoryData>> entry : mpData.entrySet()) {
				String key = entry.getKey();
				String[] strVals= key.split("_");
				XSSFCell temp = row1.createCell(nCol++);
				temp.setCellStyle(styletitle);
				cell_2.setCellValue(strVals[2]);
				
			}		
			
			
			Set<Long> setTime = new TreeSet<>();
	        Long lVal;
			for (Entry<String, List<SensorHistoryData>> entry : mpData.entrySet()) {
				for (SensorHistoryData hisInfo : entry.getValue()) {
					lVal = hisInfo.getDateGet().getTime();
	                if (setTime.contains(lVal)) {
	                    continue;
	                }
	                setTime.add(lVal);
				}
			}
	        
	        ArrayList<HistoryDataEntity> lstEntity = new ArrayList<>();
	        for (Long time : setTime) {
	            HistoryDataEntity entity = new HistoryDataEntity(time);
	            lstEntity.add(entity);
	        }
	        
	        float fVal = 0;
	        int i = 1;
	        Map<Long, Float> mpLine = new LinkedHashMap<>();
	        for (Entry<String, List<SensorHistoryData>> entry : mpData.entrySet()) {
				mpLine.clear();
				for (SensorHistoryData hisInfo : entry.getValue()) {
					mpLine.put(hisInfo.getDateGet().getTime(), hisInfo.getfData());
				}
				
				for (HistoryDataEntity entity : lstEntity) {
	                if (mpLine.containsKey(entity.getLlTime())) {
	                    fVal = mpLine.get(entity.getLlTime());
	                    entity.getSensorData().put(i, fVal);
	                }
	            }
				
				i++;
			}
	        int nRow=1;
	    
	        int maxDataColum = mpData.size();
	        for (HistoryDataEntity entity : lstEntity) {
	        	nCol = 0;
				XSSFCell temp = row1.createCell(nCol++);
				temp.setCellStyle(stylebody);
				temp.setCellValue(String.valueOf(nRow - 1));
				XSSFCell temp2 = row1.createCell(nCol++);
				temp2.setCellStyle(stylebody);
				temp2.setCellValue(String.valueOf(nRow - 1));
				int n;
				for (n = 1; n <= maxDataColum; n++) {
					XSSFCell temphou = row1.createCell(nCol++);
					temphou.setCellStyle(stylebody);
					temphou.setCellValue(entity.getSensorDataById(n));
		        }
				
				nRow++;
			}
	     
		
		
		
		
		
	}




}

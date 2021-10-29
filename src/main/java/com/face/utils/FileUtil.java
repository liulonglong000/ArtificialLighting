package com.face.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	public static final String WORK_PATH = "D:\\IGCS\\PicPath\\";
	
	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception { 
        File targetFile = new File(filePath);  
        if (!targetFile.exists()) {    
            targetFile.mkdirs();    
        }       
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
	
	public static String getUplodFilePath(String fileName) {
		Timestamp st = new Timestamp(System.currentTimeMillis());
		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(st);
		String abPath = timeStamp + "\\" + fileName;
		int loop = 1;
		while (true) {
			File f = new File(WORK_PATH + abPath);
			if (f.exists()) {
				abPath = timeStamp + "_" + loop + "\\" + fileName;
				loop++;
				continue;
			}
			String strDestPath = WORK_PATH + abPath;
			strDestPath = strDestPath.substring(0, strDestPath.lastIndexOf("\\"));
			File folder = new File(strDestPath);
			if (!folder.exists()) {
				folder.mkdirs();
			}
			break;
		}
		return abPath;
	}
	
	public static void updateFileContent(String destFilePath, MultipartFile picSel) throws Exception {
		FileOutputStream fos = new FileOutputStream(destFilePath);
		byte[] buffer = new byte[64 * 1024]; 
		int count = 0;
		InputStream is = picSel.getInputStream();
		while ((count = is.read(buffer)) > 0) {
			fos.write(buffer, 0, count);
		}
		fos.close();
		is.close();
	}	

	public static void deleteFile(String fileRPath) throws Exception {
		if (fileRPath == null) {
			return;
		}
		File f = new File(WORK_PATH, fileRPath);
		if (f.exists()) {
			f.delete();			
		}
		File dir = f.getParentFile();
		if (dir != null) {
			if (dir.exists()) {
				if (dir.list().length == 0) {
					dir.delete();
				}
			}
		}
	}
}

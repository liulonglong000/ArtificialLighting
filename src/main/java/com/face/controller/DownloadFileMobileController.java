package com.face.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.Base64;
import com.face.dto.Result;
import com.face.utils.FileUtil;



/**
 * 下载相关接口
 */
@RestController
@RequestMapping("/downloadFile")
public class DownloadFileMobileController extends BaseController {
	private static final Log log = LogFactory.getLog(DownloadFileMobileController.class);	
	
	@GetMapping("/downloadFile")
	@PostMapping("/downloadFile")
//	public Result downloadFile(HttpServletRequest request,String inputPath)
//	{
//		try
//		{
//			File file = new File(FileUtil.WORK_PATH, inputPath);
//			if (file.exists())
//			{
//				log.info("downloadFileAction end");
//				return new Result("success",null);
//			}
//			else
//			{				
//				log.info("downloadFileAction error");
//				request.setAttribute("info", "下载文件不存在！" );
//				return new Result("error",null);
//			}
//		}
//		catch (Exception e)
//		{
//			log.error("downloadFileAction error:", e);
//			e.printStackTrace();
//			request.setAttribute("info", "下载文件失败！（" + e + "）" );
//			return new Result("error",null);
//		}
//	}
	
	
	public void downloadFile(HttpServletRequest request, HttpServletResponse response, String inputPath) throws Exception {
		InputStream bis = null;
		BufferedOutputStream out = null;
		
		try {
	        String path = FileUtil.WORK_PATH + inputPath;  
	        // 获取输入流  
	        bis = new BufferedInputStream(new FileInputStream(new File(path)));
	        // 转码，免得文件名中文乱码  
	        inputPath = URLEncoder.encode(inputPath, "UTF-8");  
	        // 设置文件下载头  
	        response.addHeader("Content-Disposition", "attachment;filename=" + inputPath);    
	        // 设置文件ContentType类型，这样设置，会自动判断下载文件类型    
	        response.setContentType("multipart/form-data");   	        
		
			out = new BufferedOutputStream(response.getOutputStream());
			int len = 0;  
			byte[] arrBuffer = new byte[1024 * 64];
	        while ((len = bis.read(arrBuffer)) != -1) {  
	            out.write(arrBuffer, 0, len);  
	            out.flush();  
	        } 
		} catch (Exception e) {
			log.error("downloadFileAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "下载文件失败！（" + e + "）");
		} finally {
			if (bis != null) {
				bis.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
	
	public Result downloadAPKFile(HttpServletRequest request,String inputPath)	
	{
		try
		{
			log.info("downloadAPKFileAction start");

			File file = new File(FileUtil.WORK_PATH, inputPath);
			if (file.exists())
			{
				log.info("downloadAPKFileAction end");
				return new Result("success",null);
			}
			else
			{				
				log.info("downloadAPKFileAction error");
				request.setAttribute("info", "下载文件不存在！" );
				return new Result("error",null);
			}
		}
		catch (Exception e)
		{
			log.error("downloadAPKFileAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "下载文件失败！（" + e + "）" );
			return new Result("error",null);
		}
	}
	
	public void convertFileName(HttpServletRequest request,String fileName,String inputPath) throws Exception
	{		
		
		String agent = request.getHeader("USER-AGENT");
		
		//if(-1 != agent.indexOf("QQBrowser"))
		//{
		//}

		fileName = inputPath.substring(inputPath.lastIndexOf("\\") + 1, inputPath.length());
		
		if (null != agent)
		{				
			//移动端
			if(-1 != agent.indexOf("Mobile"))
			{	
				fileName = URLEncoder.encode(fileName, "UTF-8");
				fileName = StringUtils.replace(fileName, "+", "%20");  //替换空格
			}
			//PC端
			else
			{
				if (-1 != agent.indexOf("Firefox"))
				{ // Firefox
					fileName = "=?UTF-8?B?" + (new String(Base64.byteArrayToBase64(fileName.getBytes("UTF-8")))) + "?=";
				}				
				else if (-1 != agent.indexOf("Chrome"))
				{	// Chrome
					fileName = new String(fileName.getBytes(), "ISO8859-1");
				}				
				else
				{	// IE7+
					fileName = URLEncoder.encode(fileName, "UTF-8");
					fileName = StringUtils.replace(fileName, "+", "%20");	// 替换空格
				}
			}
		}
	}
	
	// 获取所下载文件的输入流
	public InputStream getTargetInputStream(HttpServletRequest request,String fileName,String inputPath) throws Exception
	{		
		try
		{
			convertFileName( request,fileName, inputPath);			
			return new FileInputStream(FileUtil.WORK_PATH + inputPath);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	
}
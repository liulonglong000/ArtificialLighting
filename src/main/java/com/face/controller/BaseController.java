package com.face.controller;

import com.alibaba.fastjson.JSONArray;
import com.face.model.Session;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;

public class BaseController {
	protected static final String SUCCESS = "success";

    public Session getSession() {
        return (Session) RequestContextHolder.getRequestAttributes().getAttribute("face_session", 0);
    }

    protected void returnJsonWithMsg(HttpServletResponse response, String msg) throws Exception {
		String jsonC = new String();
		jsonC +="[";
		jsonC += "{\"message\":\"" + msg +  "\"}";
		jsonC += "]";
		response.setContentType("text/json; charset=utf-8"); 
		response.getWriter().print(jsonC);
		response.getWriter().flush();
		response.getWriter().close();
	}
    
    protected void returnJsonArray(HttpServletResponse response, JSONArray jArray) throws Exception {
    	response.setContentType("text/json; charset=utf-8"); 
		response.getWriter().print(jArray.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}
    
    protected Timestamp getCurTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}
}

package com.face.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.face.model.Session;
import com.face.service.IUserService;
  
@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {
	private static final Log log = LogFactory.getLog(LoginController.class);

	@Autowired
	protected IUserService userService;

	@PostMapping("/doLogin")
	public void doLogin(HttpServletRequest request, HttpServletResponse response, String userId, String userPwd) throws Exception {
		try {
			Session session = userService.checkLogin(userId, userPwd);
			
			request.getSession().setAttribute("sessionInfo", session);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject(); 
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			JSONObject jObj1 = new JSONObject();
			jObj1.put("token", session.getToken());
			jObj1.put("userRole", session.getRoleName());
			jArray.add(jObj1);
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("doLoginAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "登录失败（" + e.getLocalizedMessage() + "）！");
		}
	}
	
	@PostMapping("/doLogout")
	public void doLogout(HttpServletRequest request, HttpServletResponse response, String token) throws Exception {		
		try {
			userService.logout(token);
			request.getSession().invalidate();	
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("doLogoutAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "退出登录失败（" + e.getLocalizedMessage() + "）！");
		}
	}
}

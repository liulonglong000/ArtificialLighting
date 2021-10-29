package com.face.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.face.entity.ParkWebInfo;
import com.face.entity.UserInfo;
import com.face.model.IgcsIparkinfo;
import com.face.model.User;
import com.face.service.IUserService;

@Controller
@RequestMapping("/userJsp")
public class UserControllerRetJSP extends BaseController {
	private static final Log log = LogFactory.getLog(UserControllerRetJSP.class);
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/webQueryUserInfo")
	public String webQueryUserInfo(HttpServletRequest request) {
		try {
			String parentUserId = request.getParameter("parentUserId");
			List<User> lstInfo = userService.queryChildUserById(parentUserId);
			List<UserInfo> uLst = new ArrayList<UserInfo>();
			for (User user : lstInfo) {
				UserInfo uInfo = new UserInfo(user);
				uLst.add(uInfo);
			}
			request.setAttribute("uList", uLst);
			
			return "userInfo/queryUserInfo";
		} catch (Exception e) {
			log.error("webQueryUserInfoAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "查询用户失败（" + e + "）！");				
			return "error";
		}
	}
	
	@RequestMapping("/webGetParkInfo")
	public String webGetParkInfo(HttpServletRequest request) throws Exception {
		try {
			String userId = request.getParameter("userId");
			IgcsIparkinfo info = userService.getParkInfoByUserId(userId);
			if (info == null) {
				request.setAttribute("info", "add");
				return "error";
			}
			
			ParkWebInfo pWeb = new ParkWebInfo(info);
			request.setAttribute("parkInfo", pWeb);
			
			return "parkInfo/viewParkInfo";
		} catch (Exception e) {
			log.error("webGetParkInfoAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "获取园区信息失败（" + e + "）！");
			return "error";
		}
	}
}

package com.face.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.face.model.IgcsIGatewayInfo;
import com.face.model.IgcsIgreenhouse;
import com.face.model.IgcsIparkinfo;
import com.face.service.IGatewayService;
import com.face.service.IUserService;
import com.face.utils.StringUtil;

public class NavControllerRetGSP extends BaseController {
	@Autowired
	protected IGatewayService gatewayService;	
	@Autowired
	protected IUserService userService;
	
	protected boolean setNavInfoToRaquest(HttpServletRequest request, String ghId) throws Exception {
		IgcsIgreenhouse ghInfo = setGreenhouseToRequest(request, ghId);
		if (ghInfo == null) {
			return false;
		}
		
		IgcsIGatewayInfo info = setGatewayToRequest(request, ghInfo.getGatewayId());
		if (info == null) {
			return false;
		}
		
		IgcsIparkinfo infoP = setParkToRequest(request, info.getParkId());
		if (infoP == null) {
			return false;
		}
		
		return true;
	}
	
	protected IgcsIparkinfo setParkToRequest(HttpServletRequest request, String parkId) throws Exception {
		IgcsIparkinfo infoP = userService.findParkInfoById(parkId);
		if (infoP == null) {
			request.setAttribute("info", "园区ID不存在，请重新登录后重试！");
		} else {
			request.setAttribute("parkId", infoP.getParkId());
			request.setAttribute("parkName", StringUtil.getStringNotNull(infoP.getParkName()));
		}
		
		return infoP;
	}
	
	protected IgcsIGatewayInfo setGatewayToRequest(HttpServletRequest request, String gwId) throws Exception {
		IgcsIGatewayInfo info = gatewayService.findGatewayById(gwId);
		if (info == null) {
			request.setAttribute("info", "网关ID不存在，请重新登录后重试！");
		} else {
			request.setAttribute("gwId", info.getGatewayId());
			request.setAttribute("gwName", StringUtil.getStringNotNull(info.getGatewayName()));
		}
		
		return info;
	}
	
	protected IgcsIgreenhouse setGreenhouseToRequest(HttpServletRequest request, String ghId) throws Exception {
		IgcsIgreenhouse ghInfo = gatewayService.findGhById(ghId);
		if (ghInfo == null) {
			request.setAttribute("info", "温室ID" + ghId + "不存在，请重新登录后重试！");
		} else {
			request.setAttribute("ghId", ghInfo.getGreenhouseId());
			request.setAttribute("ghName", StringUtil.getStringNotNull(ghInfo.getGreenhouseName()));
		}
		
		return ghInfo;
	}
}

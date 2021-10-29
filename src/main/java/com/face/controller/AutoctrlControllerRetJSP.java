package com.face.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.face.entity.OperationGroupInfo;
import com.face.entity.StrategyInfo;
import com.face.entity.ThresholdGroupInfo;
import com.face.service.IAutoctrlService;

@Controller
@RequestMapping("/autoctrlJsp")
public class AutoctrlControllerRetJSP extends NavControllerRetGSP {
	private static final Log log = LogFactory.getLog(AutoctrlControllerRetJSP.class);
	
	@Autowired
	private IAutoctrlService autoctrlService;
	
	@RequestMapping("/webQueryThresholdGroup")
	public String webQueryThresholdGroup(HttpServletRequest request) throws Exception {
		try {
			String ghId = request.getParameter("ghId");
			if (!setNavInfoToRaquest(request, ghId)) {
				
			}
			
			List<ThresholdGroupInfo> lstTgs = autoctrlService.findTgsByGhId(ghId, true);
			request.setAttribute("tgList", lstTgs);
			
			return "actrlInfo/queryThresholdGroup";			
		} catch (Exception e) {
			log.error("webQueryThresholdGroupAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "查询阈值组失败（" + e + "）！");
			return "error";
		}
	}
	
	@RequestMapping("/webQueryOperationGroup")
	public String webQueryOperationGroup(HttpServletRequest request) throws Exception {
		try {
			String ghId = request.getParameter("ghId");
			if (!setNavInfoToRaquest(request, ghId)) {
			
			}
			
			List<OperationGroupInfo> lstOgs = autoctrlService.findOgsByGhId(ghId, true);
			request.setAttribute("ogList", lstOgs);
			
			return "actrlInfo/queryOperationGroup";	
		} catch (Exception e) {
			log.error("webQueryOperationGroupAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "查询操作组失败（" + e + "）！");
			return "error";
		}
	}	
	
	@RequestMapping("/webQueryStrategy")
	public String webQueryStrategy(HttpServletRequest request) throws Exception {
		try {
			String ghId = request.getParameter("ghId");
			if (!setNavInfoToRaquest(request, ghId)) {
				
			}
			
			List<StrategyInfo> lstOgs = autoctrlService.findStrategyByGhId(ghId);
			request.setAttribute("strategyList", lstOgs);
			
			return "actrlInfo/queryStrategy";
		} catch (Exception e) {
			log.error("webQueryStrategyAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "查询策略失败（" + e + "）！");
			return "error";
		}
	}	
}

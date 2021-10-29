package com.face.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.face.dto.UserRole;
import com.face.entity.GatewayInfo;
import com.face.entity.GreenhouseInfo;
import com.face.entity.NodeInfo;
import com.face.entity.NodeWebInfo;
import com.face.entity.ParkWebInfo;
import com.face.entity.Parkinfo;
import com.face.model.IgcsIGatewayInfo;
import com.face.model.IgcsIgreenhouse;
import com.face.model.IgcsInodeinfo;
import com.face.model.IgcsIparkinfo;
import com.face.model.User;
import com.face.utils.StringUtil;

@Controller
@RequestMapping("/gatewayJsp")
public class GatewayControllerRetJSP extends NavControllerRetGSP {
	private static final Log log = LogFactory.getLog(GatewayControllerRetJSP.class);
	
	@RequestMapping("/webQueryPark")
	public String webQueryPark(HttpServletRequest request) {
		try {			
			List<Parkinfo> lstInfo = gatewayService.queryAllPark();
			List<ParkWebInfo> uLst = new ArrayList<ParkWebInfo>();
			for (Parkinfo user : lstInfo) {
				ParkWebInfo uInfo = new ParkWebInfo(user);
				uLst.add(uInfo);
			}
			request.setAttribute("pList", uLst);
			return "parkInfo/queryParkInfo";
		} catch (Exception e) {
			log.error("webQueryParkAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "查询园区失败（" + e + "）！");
			return "error";
		}
	}
	
	@RequestMapping("/webQueryGatewayOfPark")
	public String webQueryGatewayOfPark(HttpServletRequest request) {
		try {			
			String parkId = request.getParameter("parkId");
			IgcsIparkinfo infoP = setParkToRequest(request, parkId);
			if (infoP == null) {
				return "error";
			}
			
			List<IgcsIGatewayInfo> lstInfo = gatewayService.queryGatewayOfParkAdmin(parkId);
			List<GatewayInfo> uLst = new ArrayList<GatewayInfo>();
			for (IgcsIGatewayInfo user : lstInfo) {
				GatewayInfo uInfo = new GatewayInfo(user);
				uLst.add(uInfo);
			}
			request.setAttribute("gwList", uLst);
			
			return "parkInfo/queryGatewayInfo";
		} catch (Exception e) {
			log.error("webQueryGatewayOfParkAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "查询园区网关失败（" + e + "）！");
			return "error";
		}
	}
	
	public String doQueryGateway(HttpServletRequest request, String retPath) throws Exception {
		String userId = request.getParameter("userId");
		User userInfo = userService.findUserById(userId);
		if (userInfo == null) {
			request.setAttribute("info", "用户ID不存在，请重新登录后重试！");
			return "error";
		}
		if (!StringUtil.notEmpty(userInfo.getParkId())) {
			request.setAttribute("info", "请先设置园区信息！");
			return retPath;
		} 

		IgcsIparkinfo infoP = setParkToRequest(request, userInfo.getParkId());
		if (infoP == null) {
			return "error";
		}
		
		List<IgcsIGatewayInfo> lstInfo = null;
		String roleName = userService.getRoleNameById(userInfo.getRole());
		if (roleName.equals(UserRole.ROLE_PARK_USER)) { 
			lstInfo = gatewayService.queryGatewayOfParkUser(userInfo.getParkId(), userId);
		} else if (roleName.equals(UserRole.ROLE_PARK_ADMIN)) { 
			lstInfo = gatewayService.queryGatewayOfParkAdmin(userInfo.getParkId());
		}			
		
		List<GatewayInfo> uLst = new ArrayList<GatewayInfo>();
		for (IgcsIGatewayInfo user : lstInfo) {
			GatewayInfo uInfo = new GatewayInfo(user);
			uLst.add(uInfo);
		}
		request.setAttribute("gwList", uLst);
		
		return retPath;
	}
	
	@RequestMapping("/webQueryGateway")
	public String webQueryGateway(HttpServletRequest request) throws Exception {
		try {
			return doQueryGateway(request, "parkInfo/queryGatewayInfo");
		} catch (Exception e) {
			log.error("webQueryGatewayAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "查询园区网关失败（" + e + "）！");
			return "error";
		}
	}
	
	@RequestMapping("/webQueryGwTable")
	public String webQueryGwTable(HttpServletRequest request) throws Exception {
		try {
			return doQueryGateway(request, "parkInfo/queryGwTableInfo");
		} catch (Exception e) {
			log.error("webQueryGwTableAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "查询园区网关失败（" + e + "）！");
			return "error";
		}
	}
	
	@RequestMapping("/webQueryGreenhouseOfGw")
	public String webQueryGreenhouseOfGw(HttpServletRequest request) throws Exception {
		try {
			String gwId = request.getParameter("gwId");
			IgcsIGatewayInfo info = setGatewayToRequest(request, gwId);
			if (info == null) {
				return "error";
			}
			
			IgcsIparkinfo infoP = setParkToRequest(request, info.getParkId());
			if (infoP == null) {
				return "error";
			}
			
			List<GreenhouseInfo> lstInfo = gatewayService.queryGhOfGw(gwId);
			request.setAttribute("ghList", lstInfo);
			
			return "parkInfo/queryGreenhouseInfo";
		} catch (Exception e) {
			log.error("webQueryGreenhouseOfGwAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "查询网关下温室失败（" + e + "）！");
			return "error";
		}
	}
	
	@RequestMapping("/webQueryGreenhouse")
	public String webQueryGreenhouse(HttpServletRequest request) throws Exception {
	try {
			doQueryGhInfo(request);			
			return "parkInfo/queryGhTableInfo";
		} catch (Exception e) {
			log.error("webQueryGreenhouseAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "查询温室失败（" + e + "）！");
			return "error";
		}
		
		
		
	}
	
	@RequestMapping("/webQueryGhInfo")
	public String webQueryGhInfo(HttpServletRequest request) throws Exception {
		/*try {
			doQueryGhInfo(request);		
			return "parkInfo/queryGreenhouseInfo";
		} catch (Exception e) {
			log.error("webQueryGhInfoAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "查询温室失败（" + e + "）！");
			return "error";
		}*/
		String userId = request.getParameter("userId");
		User userInfo = userService.findUserById(userId);
		if (userInfo == null) {
			request.setAttribute("info", "用户ID不存在，请重新登录后重试！");
			return "error";
		}
		if (!StringUtil.notEmpty(userInfo.getParkId())) {
			request.setAttribute("info",  "请先设置园区信息！");
			return "error";
		} 
		try {
			doQueryGhInfo(request);	
			return "parkInfo/queryGreenhouseInfo";
		} catch (Exception e) {
			log.error("queryGreenhouseByUserIdAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "查询温室失败（" + e + "）！");
			return "error";
		}
		
	}

	private void doQueryGhInfo(HttpServletRequest request) throws Exception {
		String userId = request.getParameter("userId");
		User userInfo = userService.findUserById(userId);
		
		List<GreenhouseInfo> lstInfo = null;
		String roleName = userService.getRoleNameById(userInfo.getRole());
		if (roleName.equals(UserRole.ROLE_PARK_USER)) { 
			lstInfo = gatewayService.queryGhOfParkUser(userId);
		} else if (roleName.equals(UserRole.ROLE_PARK_ADMIN)) { 
			lstInfo = gatewayService.queryGhOfPark(userInfo.getParkId());
		}	
		request.setAttribute("ghList", lstInfo);
		
	}
	
	@RequestMapping("/webGetGhNodesData")
	public String webGetGhNodesData(HttpServletRequest request) throws Exception {
		try {
			String ghId = request.getParameter("ghId");
			if (!setNavInfoToRaquest(request, ghId)) {
			
			}
			
			List<NodeInfo> lst = gatewayService.getNodesInfoByGhId(ghId);
			request.setAttribute("nodeList", lst);
			
			return "parkInfo/queryNodeInfo";
		} catch (Exception e) {
			log.error("webGetGhNodesDataAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "获取该大棚信息失败（" + e + "）！");
			return "error";
		}		
	}
	
	@RequestMapping("/webGetDataForHistory")
	public String webGetDataForHistory(HttpServletRequest request) throws Exception {
		try {
			String ghId = request.getParameter("ghId");
			request.setAttribute("ghId", ghId);
			if (!setNavInfoToRaquest(request, ghId)) {
				
			}
			
			List<IgcsInodeinfo> lst = gatewayService.getNodesByGhId(ghId);
			Map<String, String> mpNodes = new LinkedHashMap<String, String>();
			int i=0;
			for (IgcsInodeinfo node : lst) {
	    		mpNodes.put(i+++"-"+node.getNodeId(), StringUtil.getStringNotNull(node.getNodeName()));
			}
			request.setAttribute("nodeList", mpNodes);
			SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String nowDate = sdf.format(date);
			request.setAttribute("endtime", nowDate);
			Calendar c = Calendar.getInstance();
	        c.add(Calendar.DATE, -1);
	        SimpleDateFormat startSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        request.setAttribute("starttime", startSdf.format(c.getTime())); 

			return "parkInfo/ViewHistoryInfo";
		} catch (Exception e) {
			log.error("webGetDataForHistoryAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "获取该大棚信息失败（" + e + "）！");
			return "error";
		}		
	}  
	
	@RequestMapping("/webGetGatewayInfo")
	public String webGetGatewayInfo(HttpServletRequest request) throws Exception {
		try {
			String gatewayId = request.getParameter("gatewayId");
			IgcsIGatewayInfo info = gatewayService.findGatewayById(gatewayId);
			if (info == null) {
				request.setAttribute("info", "该网关不存在，请刷新后重试！");	
				return "error";	
			}
			
			GatewayInfo uInfo = new GatewayInfo(info);
			request.setAttribute("gwInfo", uInfo);
			
			return "parkInfo/mdyGatewayInfo";
		} catch (Exception e) {
			log.error("webGetGatewayInfoAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "获取网关信息失败（" + e + "）！");
			return "error";	
		}
	}	
	
	@RequestMapping("/webGetGhInfo")
	public String webGetGhInfo(HttpServletRequest request) throws Exception {
		try {
			String ghId = request.getParameter("ghId");
			IgcsIgreenhouse info = gatewayService.findGhById(ghId);
			if (info == null) {
				request.setAttribute("info", "该温室不存在，请刷新后重试！");	
				return "error";		
			}
			IgcsIGatewayInfo gwInfo = gatewayService.findGatewayById(info.getGatewayId());			
			GreenhouseInfo gh = new GreenhouseInfo(info, gwInfo.getGatewayName());
			request.setAttribute("ghInfo", gh);
			
			List<IgcsIGatewayInfo> lstInfo = gatewayService.queryGatewayOfParkAdmin(info.getParkId());			
			Map<String,String> mpGws = new LinkedHashMap<String, String>();			
			for (IgcsIGatewayInfo infoGw : lstInfo) {
				mpGws.put(infoGw.getGatewayId(), StringUtil.getStringNotNull(infoGw.getGatewayName()));
			}	
			request.setAttribute("gws", mpGws);
			
			return "parkInfo/mdyGreenhouseInfo";
		} catch (Exception e) {
			log.error("webGetGhInfoAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "获取温室信息失败（" + e + "）！");
			return "error";	
		}
	}
	
	@RequestMapping("/webQueryNode")
	public String webQueryNode(HttpServletRequest request) throws Exception {
		try {
			String ghId = request.getParameter("ghId");
			IgcsIgreenhouse info = gatewayService.findGhById(ghId);
			if (info == null) {
				request.setAttribute("info", "该温室不存在，请刷新后重试！");	
				return "error";		
			}		
			request.setAttribute("ghName", StringUtil.getStringNotNull(info.getGreenhouseName()));
			
			List<IgcsInodeinfo> lstInfo = gatewayService.getNodesByGhId(ghId);			
			List<NodeWebInfo> uLst = new ArrayList<NodeWebInfo>();
			for (IgcsInodeinfo user : lstInfo) {
				NodeWebInfo uInfo = new NodeWebInfo(user);
				uLst.add(uInfo);
			}
			request.setAttribute("nodeList", uLst);
			
			return "parkInfo/queryNodeTableInfo";
		} catch (Exception e) {
			log.error("webQueryNodeAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "查询节点失败（" + e + "）！");
			return "error";	
		}
	}
	
	@RequestMapping("/webGetNodeInfo")
	public String webGetNodeInfo(HttpServletRequest request) throws Exception {
		try {
			String nodeId = request.getParameter("nodeId");
			String gwId = request.getParameter("gwId");
			IgcsInodeinfo info = gatewayService.findNodeById(nodeId, gwId);
			if (info == null) {
				request.setAttribute("info", "该节点不存在，请刷新后重试！");	
				return "error";		
			}		
			NodeWebInfo gh = new NodeWebInfo(info);
			request.setAttribute("nodeInfo", gh);
			
			return "parkInfo/mdyNodeInfo";
		} catch (Exception e) {
			log.error("webGetNodeInfoAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "获取节点信息失败（" + e + "）！");
			return "error";	
		}
	}
	
	@RequestMapping("/webGetGhNodesEquipment")
	public String webGetGhNodesEquipment(HttpServletRequest request) throws Exception {
		try {
			String ghId = request.getParameter("ghId");
			if (!setNavInfoToRaquest(request, ghId)) {
				
			}
			
			List<NodeInfo> lst = gatewayService.getNodesEquipByGhId(ghId, false);
			request.setAttribute("nodeList", lst);
			
			return "parkInfo/controlManualInfo";
		} catch (Exception e) {
			log.error("webGetGhNodesEquipmentAction error:", e);
			e.printStackTrace();
			request.setAttribute("info", "获取该大棚设备信息失败（" + e + "）！");
			return "error";	
		}		
	}
}

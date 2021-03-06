package com.face.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.face.controller.LoginController;
import com.face.dto.UserRole;
import com.face.entity.EquipmentInfo;
import com.face.entity.GreenhouseInfo;
import com.face.entity.HistoryDataEntity;
import com.face.entity.NodeInfo;
import com.face.entity.Parkinfo;
import com.face.entity.SensorData;
import com.face.entity.SensorHistoryData;
import com.face.entity.SensorInfo;
import com.face.entity.SensorType;
import com.face.entity.WeatherInfo;
import com.face.model.IgcsASensorType;
import com.face.model.IgcsIEquipment;
import com.face.model.IgcsIGatewayInfo;
import com.face.model.IgcsIgreenhouse;
import com.face.model.IgcsInodeinfo;
import com.face.model.IgcsIparkinfo;
import com.face.model.Session;
import com.face.model.User;
import com.face.service.IGatewayService;
import com.face.service.IUserService;
import com.face.utils.DateUtil;
import com.face.utils.DateUtils;
import com.face.utils.FileUtil;
import com.face.utils.HandleExcel;
import com.face.utils.StringUtil;
import com.face.utils.ZongExcelReport;


/**
 * ??????????????????
 */
@Api(tags = "01 ???????????????????????????????????????", value = "???????????????????????????????????????")
@RestController
@RequestMapping("/gateway")
public class GatewayController extends LoginController{

	private static final Log log = LogFactory.getLog(GatewayController.class);
	
	@Autowired
	private IGatewayService gatewayService;	
	@Autowired
	private IUserService userService; 
	
	@ApiOperation(value = "????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userId", value = "?????????????????????????????????", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/queryGateway")
	public void queryGateway(HttpServletResponse response, String userId) throws Exception {
		try {
			User userInfo = userService.findUserById(userId);
			if (userInfo == null) {
				returnJsonWithMsg(response, "??????ID???????????????????????????????????????");
				return;
			}
			if (!StringUtil.notEmpty(userInfo.getParkId())) {
				returnJsonWithMsg(response, "???????????????????????????");
				return;
			} 
			
			List<IgcsIGatewayInfo> lstInfo = null;
			String roleName = userService.getRoleNameById(userInfo.getRole());
			if (roleName.equals(UserRole.ROLE_PARK_USER)) { 
				lstInfo = gatewayService.queryGatewayOfParkUser(userInfo.getParkId(), userId);
			} else if (roleName.equals(UserRole.ROLE_PARK_ADMIN)) { 
				lstInfo = gatewayService.queryGatewayOfParkAdmin(userInfo.getParkId());
			}			
			
			returnJsonArray(response, gwToJarray(lstInfo));
		} catch (Exception e) {
			log.error("queryGatewayAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response,"?????????????????????" + e + "??????");
		}
	}
	
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "parkId", value = "??????ID", required = true, paramType = "query", dataType = "String")
    })
	@PostMapping("/queryGatewayOfPark")
	public void queryGatewayOfPark(HttpServletResponse response, String parkId) throws Exception {
		try {			
			List<IgcsIGatewayInfo> lstInfo = gatewayService.queryGatewayOfParkAdmin(parkId);
			returnJsonArray(response, gwToJarray(lstInfo));
		} catch (Exception e) {
			log.error("queryGatewayOfParkAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response,"???????????????????????????" + e + "??????");
		}
	}
	
	private JSONArray gwToJarray(List<IgcsIGatewayInfo> lstInfo) throws Exception {
		JSONObject jObj0 = new JSONObject();
		jObj0.put("message", "success");
		JSONArray jArray = new JSONArray();
		jArray.add(jObj0);
		
		for (IgcsIGatewayInfo info : lstInfo) {
			JSONObject jObj1 = new JSONObject();
			jObj1.put("gwId", info.getGatewayId());
			jObj1.put("gwName", StringUtil.getStringNotNull(info.getGatewayName()));
			jObj1.put("gwAddr", StringUtil.getStringNotNull(info.getGatewayAddr()));
			jObj1.put("addTime", DateUtils.getDateStr(info.getInDate()));
			if (StringUtil.getStringNotNull(info.getStatus()).equals("0")) {
				jObj1.put("status", "??????");
			} else {
				jObj1.put("status", "?????????");
			}	
			jObj1.put("connectTime", DateUtils.getDateStr(info.getLastConnectTime()));
			jObj1.put("gwRemark", StringUtil.getStringNotNull(info.getRemark()));
			jObj1.put("picPath", StringUtil.getStringForDL(info.getGatewayPic()));
			jArray.add(jObj1);
		}			
		
		return jArray;
	}
	  
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gatewayId", value = "??????ID??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userId", value = "?????????????????????????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gatewayName", value = "??????????????????????????????????????????????????????????????????????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gatewayAddress", value = "????????????????????????????????????????????????????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gatewayRemark", value = "?????????????????????????????????????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "picSel", value = "????????????", required = false, paramType = "query", dataType = "MultipartFile") })
	@PostMapping("/addGatewayInfo")
	public void addGatewayInfo(HttpServletResponse response, String gatewayId, String userId, String gatewayName, String gatewayAddress, 
			String gatewayRemark, MultipartFile picSel) throws Exception {
		try {
			IgcsIGatewayInfo infoPre = gatewayService.findGatewayById(gatewayId);
			if (infoPre != null) {
				returnJsonWithMsg(response, "??????ID??????????????????????????????");
				return;
			}
			
			User userInfo = userService.findUserById(userId);
			if (userInfo == null) {
				returnJsonWithMsg(response, "??????ID???????????????????????????????????????");
				return;
			}
			if (!StringUtil.notEmpty(userInfo.getParkId())) {
				returnJsonWithMsg(response, "???????????????????????????");
				return;
			}
			
			IgcsIGatewayInfo info = new IgcsIGatewayInfo();
			
			info.setGatewayId(gatewayId);
			info.setGatewayName(gatewayName);
			info.setGatewayAddr(gatewayAddress);
			info.setRemark(gatewayRemark);
			info.setStatus("0");
			info.setUserId(userId);
			info.setParkId(userInfo.getParkId());
			
			if (picSel != null && picSel.getOriginalFilename().length() > 0) {
				String abPath = FileUtil.getUplodFilePath(picSel.getOriginalFilename());
				info.setGatewayPic(abPath);
				FileUtil.updateFileContent(FileUtil.WORK_PATH + abPath, picSel);
			} 
			
			info.setInDate(getCurTimestamp());
			
			String ret = gatewayService.addGateway(info);
			
			returnJsonWithMsg(response,ret);
		} catch (Exception e) {
			log.error("addGatewayInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response,"???????????????????????????" + e + "??????");
		}
	}
	  
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gatewayId", value = "??????ID", required = false, paramType = "query", dataType = "String")

	})	  
    @PostMapping("/getGatewayInfo")
	public void getGatewayInfo(HttpServletResponse response, String gatewayId) throws Exception {
		try {
			IgcsIGatewayInfo info = gatewayService.findGatewayById(gatewayId);
			if (info == null) {
				returnJsonWithMsg(response,"??????????????????????????????????????????");	
				return;		
			}
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			JSONObject jObj1 = new JSONObject();
			jObj1.put("id", info.getGatewayId());
			jObj1.put("name", StringUtil.getStringNotNull(info.getGatewayName()));
			jObj1.put("addr", StringUtil.getStringNotNull(info.getGatewayAddr()));
			jObj1.put("remark", StringUtil.getStringNotNull(info.getRemark()));
			jObj1.put("pic", StringUtil.getStringForDL(info.getGatewayPic()));
			jArray.add(jObj1);
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getGatewayInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response,"???????????????????????????" + e + "??????");
		}
	}	
	  
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gatewayId", value = "??????ID??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gatewayName", value = "??????????????????????????????????????????????????????????????????????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gatewayAddress", value = "????????????????????????????????????????????????????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gatewayRemark", value = "?????????????????????????????????????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "picSel", value = "????????????", required = false, paramType = "query", dataType = "MultipartFile"),
			@ApiImplicitParam(name = "picSrcFile", value = "????????????????????????", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/mdyGatewayInfo")
	public void mdyGatewayInfo(HttpServletResponse response, String gatewayId, String gatewayName, String gatewayAddress, 
			String gatewayRemark, MultipartFile picSel, String picSrcFile) throws Exception {
		try {			
			IgcsIGatewayInfo info = gatewayService.findGatewayById(gatewayId);
			if (info == null) {
				returnJsonWithMsg(response,"??????????????????????????????????????????");	
				return;		
			}
			
			info.setGatewayName(gatewayName);
			info.setGatewayAddr(gatewayAddress);
			info.setRemark(gatewayRemark);
			
			boolean bDel = false;
			String sourcePic = StringUtil.getStringNotNull(info.getGatewayPic());
			String sourceDLPic = StringUtil.getStringForDL(info.getGatewayPic());
			if (picSel != null && picSel.getOriginalFilename().length() > 0) {
				String abPath = FileUtil.getUplodFilePath(picSel.getOriginalFilename());
				info.setGatewayPic(abPath);
				FileUtil.updateFileContent(FileUtil.WORK_PATH + abPath, picSel);
				
				if (sourcePic.length() > 0) {
					bDel = true;
				}
			} else {
				if (!sourceDLPic.equals(picSrcFile)) {
					info.setGatewayPic(null);
					bDel = true;
				}
			}
			
			String strRet = gatewayService.mdyGateway(info);
			
			if (strRet.equals("success") && bDel) {
				FileUtil.deleteFile(sourcePic);
			}
			
			returnJsonWithMsg(response,strRet);
			
		} catch (Exception e) {
			log.error("mdyGatewayInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response,"???????????????????????????" + e + "??????");
		}		
	}	
	
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gatewayId", value = "??????ID??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gatewayName", value = "??????????????????????????????????????????????????????????????????????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gatewayAddress", value = "????????????????????????????????????????????????????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gatewayRemark", value = "?????????????????????????????????????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "picSel", value = "????????????", required = false, paramType = "query", dataType = "MultipartFile"),
			@ApiImplicitParam(name = "picSrcFile", value = "????????????????????????", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/getGatewaysOfPark")
	public void getGatewaysOfPark(HttpServletResponse response, String userId) throws Exception {
		try {	
			User userInfo = userService.findUserById(userId);
			if (userInfo == null) {
				returnJsonWithMsg(response, "??????ID???????????????????????????????????????");
				return;
			}
			if (!StringUtil.notEmpty(userInfo.getParkId())) {
				returnJsonWithMsg(response, "???????????????????????????");
				return;
			} 
			
			List<IgcsIGatewayInfo> lstInfo = gatewayService.queryGatewayOfParkAdmin(userInfo.getParkId());
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");
			JSONArray jArray = new JSONArray();
			jArray.add(jObj0);
			
			for (IgcsIGatewayInfo info : lstInfo) {
				JSONObject jObj1 = new JSONObject();
				jObj1.put("gwId", info.getGatewayId());
				jObj1.put("gwName", StringUtil.getStringNotNull(info.getGatewayName()));
				jArray.add(jObj1);
			}	
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getGatewaysOfParkAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "????????????????????????????????????" + e + "??????");
		}
	}
	
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ghId", value = "??????id", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userId", value = "??????????????????????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ghName", value = "????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ghAddress", value = "????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ghRemark", value = "?????????????????????????????????????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gwId", value = "?????????????????????ID", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/addGhInfo")
	public void addGhInfo(HttpServletResponse response, String ghId, String userId, String ghName, String ghAddress, 
			String ghRemark, String gwId, MultipartFile picSel) throws Exception {
		try {
			IgcsIgreenhouse infoPre = gatewayService.findGhById(ghId);
			if (infoPre != null) {
				returnJsonWithMsg(response, "??????ID??????????????????????????????");
				return;
			}
			
			User userInfo = userService.findUserById(userId);
			if (userInfo == null) {
				returnJsonWithMsg(response, "??????ID???????????????????????????????????????");
				return;
			}
			
			IgcsIgreenhouse info = new IgcsIgreenhouse();
			
			info.setGreenhouseId(ghId);
			info.setGreenhouseName(ghName);
			info.setGreenhouseAddr(ghAddress);
			info.setRemark(ghRemark);
			info.setUserId(userId);
			info.setParkId(userInfo.getParkId());
			info.setGatewayId(gwId);	
			
			if (picSel != null && picSel.getOriginalFilename().length() > 0) {
				String abPath = FileUtil.getUplodFilePath(picSel.getOriginalFilename());
				info.setGreenhousePic(abPath);
				FileUtil.updateFileContent(FileUtil.WORK_PATH + abPath, picSel);
			} 
			
			info.setInDate(getCurTimestamp());
			
			String ret = gatewayService.addGreenhouse(info);
			
			returnJsonWithMsg(response,ret);
		} catch (Exception e) {
			log.error("addGhInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "???????????????????????????" + e + "??????");
		}
	}
	
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ghId", value = "??????id", required = false, paramType = "query", dataType = "String") }) 
	@PostMapping("/getGhInfo")
	public void getGhInfo(HttpServletResponse response, String ghId) throws Exception {
		try {

			IgcsIgreenhouse info = gatewayService.findGhById(ghId);
			if (info == null) {
				returnJsonWithMsg(response, "??????????????????????????????????????????");	
				return;		
			}
			User userInfo = userService.findUserById(info.getUserId());
			if (userInfo == null) {
				returnJsonWithMsg(response, "??????ID???????????????????????????????????????");
				return;
			}
			List<IgcsInodeinfo> lst = gatewayService.getNodesByGhId(ghId);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			JSONObject jObj1 = new JSONObject();
			jObj1.put("id", info.getGreenhouseId());
			jObj1.put("name", StringUtil.getStringNotNull(info.getGreenhouseName()));
			jObj1.put("addr", StringUtil.getStringNotNull(info.getGreenhouseAddr()));
			jObj1.put("remark", StringUtil.getStringNotNull(info.getRemark()));
			jObj1.put("pic", StringUtil.getStringForDL(info.getGreenhousePic()));
			jObj1.put("userId", info.getUserId());
			jObj1.put("userName", StringUtil.getStringNotNull(userInfo.getTruename()));

			JSONArray copyType = new JSONArray(); //???????????????
			copyType.add("??????");
			copyType.add("??????");
			copyType.add("??????");
			jObj1.put("copyType",copyType);
			
			JSONArray jArrayN = new JSONArray();
			for (IgcsInodeinfo infoN : lst) {
	    		JSONObject jObjNode = new JSONObject();
	    		jObjNode.put("gwId", infoN.getGatewayId());
	    		jObjNode.put("nodeId", infoN.getNodeId());
	    		jObjNode.put("nodeName", StringUtil.getStringNotNull(infoN.getNodeName()));
				if (StringUtil.getStringNotNull(infoN.getStatus()).equals("0")) {
					jObjNode.put("status", "??????");
				} else {
					jObjNode.put("status", "?????????");
				}				
	    		jArrayN.add(jObjNode);
	    	}	
			jObj1.put("nodes", jArrayN);
			
			jArray.add(jObj1);
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getGhInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response,"???????????????????????????" + e + "??????");
		}
	}
	  
	@ApiOperation(value = "????????????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userId", value = "??????id", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/queryGreenhouse")
	public void queryGreenhouse(HttpServletResponse response, String userId) throws Exception {
		try {
			List<GreenhouseInfo> lstInfo = gatewayService.queryGhOfParkUser(userId);
			returnJsonArray(response, ghToJson(lstInfo));
		} catch (Exception e) {
			log.error("queryGreenhouseAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "?????????????????????" + e + "??????");
		}
	}
	
	@ApiOperation(value = "?????????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gwId", value = "??????id", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/queryGreenhouseOfGw")
	public void queryGreenhouseOfGw(HttpServletResponse response, String gwId) throws Exception {
		try {
			List<GreenhouseInfo> lstInfo = gatewayService.queryGhOfGw(gwId);
			returnJsonArray(response, ghToJson(lstInfo));
		} catch (Exception e) {
			log.error("queryGreenhouseOfGwAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "??????????????????????????????" + e + "??????");
		}
	}
	
	@PostMapping("/queryGreenhouseByParkId")
	public void queryGreenhouseByParkId(HttpServletResponse response, String parkId) throws Exception {
		try {
			List<GreenhouseInfo> lstInfo = gatewayService.queryGhOfPark(parkId);
			returnJsonArray(response, ghToJson(lstInfo));
		} catch (Exception e) {
			log.error("queryGreenhouseByParkIdAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "?????????????????????????????????????????????" + e + "??????");
		}
	}
	
	@PostMapping("/queryGreenhouseByUserId")
	public void queryGreenhouseByUserId(HttpServletResponse response, String userId) throws Exception {
		try {
			User userInfo = userService.findUserById(userId);
			if (userInfo == null) {
				returnJsonWithMsg(response, "??????ID???????????????????????????????????????");
				return;
			}
			if (!StringUtil.notEmpty(userInfo.getParkId())) {
				returnJsonWithMsg(response, "???????????????????????????");
				return;
			} 
			
			List<GreenhouseInfo> lstInfo = null;
			String roleName = userService.getRoleNameById(userInfo.getRole());
			if (roleName.equals(UserRole.ROLE_PARK_USER)) { 
				lstInfo = gatewayService.queryGhOfParkUser(userId);
			} else if (roleName.equals(UserRole.ROLE_PARK_ADMIN)) { 
				lstInfo = gatewayService.queryGhOfPark(userInfo.getParkId());
			}	
			
			returnJsonArray(response, ghToJson(lstInfo));
		} catch (Exception e) {
			log.error("queryGreenhouseByUserIdAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "?????????????????????????????????????????????" + e + "??????");
		}
	}
	
	@RequestMapping("/queryWebGreenhouseByUserId")
	public String queryWebGreenhouseByUserId(HttpServletRequest request, String userId) throws Exception {
		try {
			User userInfo = userService.findUserById(userId);
			if (userInfo == null) {
				request.setAttribute("info", "??????ID???????????????????????????????????????");
				return "error";
			}
			if (!StringUtil.notEmpty(userInfo.getParkId())) {
				request.setAttribute("info",  "???????????????????????????");
				return "error";
			} 
			
			List<GreenhouseInfo> lstInfo = null;
			String roleName = userService.getRoleNameById(userInfo.getRole());
			if (roleName.equals(UserRole.ROLE_PARK_USER)) { 
				lstInfo = gatewayService.queryGhOfParkUser(userId);
			} else if (roleName.equals(UserRole.ROLE_PARK_ADMIN)) { 
				lstInfo = gatewayService.queryGhOfPark(userInfo.getParkId());
			}	
			request.setAttribute("ghList", lstInfo);
			return "parkInfo/queryGreenhouseInfo";
		} catch (Exception e) {
			log.error("queryGreenhouseByUserIdAction error:", e);
			e.printStackTrace();
			return "error";
		}
	}
	
	
	private JSONArray ghToJson(List<GreenhouseInfo> lstInfo) throws Exception {
		JSONObject jObj0 = new JSONObject();
		jObj0.put("message", "success");
		JSONArray jArray = new JSONArray();
		jArray.add(jObj0);
		
		for (GreenhouseInfo info : lstInfo) {
			JSONObject jObj1 = new JSONObject();
			jObj1.put("ghId", info.getGreenhouseId());
			jObj1.put("ghName", info.getGreenhouseName());
			jObj1.put("ghAddr", info.getGreenhouseAddr());
			jObj1.put("addTime", info.getInDate());
			jObj1.put("ghRemark", info.getRemark());
			jObj1.put("userName", info.getUserName());
			jObj1.put("picPath", info.getPicPath());
			
			JSONArray jAOne = new JSONArray();			
			for (IgcsInodeinfo nInfo : info.getLstNodesUnder()) {
				JSONObject jObj = new JSONObject();
				jObj.put("gwId", nInfo.getGatewayId());  
				jObj.put("nodeId", nInfo.getNodeId()); 
				jObj.put("nodeName", StringUtil.getStringNotNull(nInfo.getNodeName()));
		   		jAOne.add(jObj);
			}	
			jObj1.put("nodes", jAOne);
			
			jArray.add(jObj1);
		}			
		
		return jArray;
	}
	
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ghId", value = "??????id", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userId", value = "??????????????????????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ghName", value = "????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ghAddress", value = "????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ghRemark", value = "?????????????????????????????????????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gwId", value = "?????????????????????ID", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/mdyGhInfo")
	public void mdyGhInfo(HttpServletResponse response, String ghId, String userId, String ghName, String ghAddress, 
			String ghRemark, String gwId, MultipartFile picSel, String picSrcFile) throws Exception {
		try {			
			IgcsIgreenhouse info = gatewayService.findGhById(ghId);
			if (info == null) {
				returnJsonWithMsg(response,"??????????????????????????????????????????");	
				return;		
			}
			
			info.setGreenhouseId(ghId);
			info.setGreenhouseName(ghName);
			info.setGreenhouseAddr(ghAddress);
			info.setRemark(ghRemark);
			info.setUserId(userId);
			info.setGatewayId(gwId);
			
			boolean bDel = false;
			String sourcePic = StringUtil.getStringNotNull(info.getGreenhousePic());
			String sourceDLPic = StringUtil.getStringForDL(info.getGreenhousePic());
			if (picSel != null && picSel.getOriginalFilename().length() > 0) {
				String abPath = FileUtil.getUplodFilePath(picSel.getOriginalFilename());
				info.setGreenhousePic(abPath);
				FileUtil.updateFileContent(FileUtil.WORK_PATH + abPath, picSel);
				
				if (sourcePic.length() > 0) {
					bDel = true;
				}
			} else {
				if (!sourceDLPic.equals(picSrcFile)) {
					info.setGreenhousePic(null);
					bDel = true;
				}
			}
			
			String strRet = gatewayService.mdyGreenhouse(info);		
			
			if (strRet.equals("success") && bDel) {
				FileUtil.deleteFile(sourcePic);
			}
			
			returnJsonWithMsg(response, strRet);			
		} catch (Exception e) {
			log.error("mdyGhInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response,"???????????????????????????" + e + "??????");
		}		
	}
	
	@ApiOperation(value = "???????????????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ghId", value = "??????id", required = false, paramType = "query", dataType = "String") }) 
	@PostMapping("/getGhNodesData")
	public void getGhNodesData(HttpServletResponse response, String ghId) throws Exception {
		try {
			List<NodeInfo> lst = gatewayService.getNodesInfoByGhId(ghId);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");		
			jArray.add(jObj0);
			
			for (NodeInfo info : lst) {
	    		JSONObject jObjNode = new JSONObject();
	    		jObjNode.put("gwId", info.getGatewayId());
	    		jObjNode.put("NodeId", info.getNodeId());
	    		jObjNode.put("NodeName", info.getNodeName());
	    		jObjNode.put("NodeTime", info.getGatherTimeString()); 
	    		jArray.add(jObjNode);
	    		
	    		JSONArray jAOne = new JSONArray();
	    		
	    		Map<Short, List<SensorInfo>> lstSensor = info.getMpSensor();
				for (List<SensorInfo> lstS : lstSensor.values()) {
					for (SensorInfo sensor : lstS) {
						JSONObject jObj = new JSONObject();
						jObj.put("SensorId", sensor.getSensorId());  
						jObj.put("SensorTypeCode", sensor.getSensorTypeCode()); 
						jObj.put("SensorValue", sensor.getSensorValue());
						jObj.put("SensorUnit", sensor.getUnit());
						jObj.put("SensorName", sensor.getSensorName());
						jObj.put("SensorClass", sensor.getClassName());
						jObj.put("SensorPicClass", sensor.getPicClass());
				   		jAOne.add(jObj);
					}
				}
				
				jArray.add(jAOne);
	    	}	
			
		    returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getGhNodesDataAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "??????????????????????????????" + e + "??????");
		}		
	}
	
	
/*	@ApiOperation(value = "???????????????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ghId", value = "??????id", required = false, paramType = "query", dataType = "String") }) 
	@PostMapping("/getGhNodesDataPC")
	public void getGhNodesDataPC(HttpServletRequest request, String ghId) throws Exception {
		try {
			List<NodeInfo> lst = gatewayService.getNodesInfoByGhId(ghId);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");		
			jArray.add(jObj0);
			
			for (NodeInfo info : lst) {
	    		JSONObject jObjNode = new JSONObject();
	    		jObjNode.put("gwId", info.getGatewayId());
	    		jObjNode.put("NodeId", info.getNodeId());
	    		jObjNode.put("NodeName", info.getNodeName());
	    		jObjNode.put("NodeTime", info.getGatherTimeString()); 
	    		jArray.add(jObjNode);
	    		
	    		JSONArray jAOne = new JSONArray();
	    		
	    		Map<Short, List<SensorInfo>> lstSensor = info.getMpSensor();
				for (List<SensorInfo> lstS : lstSensor.values()) {
					for (SensorInfo sensor : lstS) {
						JSONObject jObj = new JSONObject();
						jObj.put("SensorId", sensor.getSensorId());  
						jObj.put("SensorTypeCode", sensor.getSensorTypeCode()); 
						jObj.put("SensorValue", sensor.getSensorValue());
						jObj.put("SensorUnit", sensor.getUnit());
						jObj.put("SensorName", sensor.getSensorName());
						jObj.put("SensorClass", sensor.getClassName());
						jObj.put("SensorPicClass", sensor.getPicClass());
				   		jAOne.add(jObj);
					}
				}
				
				jArray.add(jAOne);
	    	}	
			return "parkInfo/queryNodeInfo";
		    returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getGhNodesDataAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "??????????????????????????????" + e + "??????");
		}		
	}
	*/
	
	
	
	
	
	
	
	@ApiOperation(value = "????????????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "gwId", value = "?????????????????????ID", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "nodeId", value = "??????id", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sensorId", value = "???????????????id", required = false, paramType = "query", dataType = "String")

	})
	@PostMapping("/getRecentInfo")
	public void getRecentInfo(HttpServletResponse response, String gwId, String nodeId, String sensorId, String sensorTypeCode) throws Exception {
		try {
			List<SensorHistoryData> lstData = gatewayService.findRecentByFilter(gwId, nodeId, sensorId, sensorTypeCode);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			JSONObject jObj1 = new JSONObject();
			StringBuilder str = new StringBuilder();
			str.append("[");
			for (SensorHistoryData hisInfo : lstData) {
				str.append("[");
				str.append(hisInfo.getDateGet().getTime());
				str.append(",");
				str.append(hisInfo.getfDataString());
				str.append("],");
			}
			str.deleteCharAt(str.length() - 1);
			str.append("]");
			jObj1.put("data", str + "");			
			jArray.add(jObj1);			
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getRecentInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "????????????????????????????????????" + e + "???" );
		}
	}	
	
	@PostMapping("/webGetRecentInfo")
	public void webGetRecentInfo(HttpServletResponse response, String gwId, String nodeId, String sensorId, String sensorTypeCode) throws Exception {
		try {
			List<SensorHistoryData> lstData = gatewayService.findRecentByFilter(gwId, nodeId, sensorId, sensorTypeCode);
			IgcsASensorType sensorTypeInfo = gatewayService.findSensorTyById(sensorTypeCode);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");		
			jObj0.put("name", sensorTypeInfo.getSensorTypeName());
			jObj0.put("yTitle", sensorTypeInfo.getSensorTypeName() + "("+ sensorTypeInfo.getSensorUnit() + ")");
			jArray.add(jObj0);
			
			JSONObject jObj1 = new JSONObject();
			
			JSONArray aData = new JSONArray();
			for (SensorHistoryData hisInfo : lstData) {
				JSONArray aTmp = new JSONArray();
				aTmp.add(hisInfo.getDateGet().getTime());
				aTmp.add(hisInfo.getfData());
				aData.add(aTmp);
			}
			jObj1.put("data", aData);
			
			jArray.add(jObj1);			
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("webGetRecentInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "????????????????????????????????????" + e + "???" );
		}
	}	
	
	@ApiOperation(value = "???????????????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ghId", value = "??????id", required = false, paramType = "query", dataType = "String")
	})
	@PostMapping("/getGhNodesEquipment")
	public void getGhNodesEquipment(HttpServletResponse response, String ghId) throws Exception {
		try {
			List<NodeInfo> lst = gatewayService.getNodesEquipByGhId(ghId, false);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");		
			jArray.add(jObj0);
			
			for (NodeInfo info : lst) {
	    		JSONObject jObjNode = new JSONObject();
	    		jObjNode.put("gwId", info.getGatewayId());
	    		jObjNode.put("NodeId", info.getNodeId());
	    		jObjNode.put("NodeName", info.getNodeName());
	    		jArray.add(jObjNode);
	    		
	    		JSONArray jAOne = new JSONArray();
	    		
	    		Map<Short, List<EquipmentInfo>> lstSensor = info.getMpEquips();
				for (List<EquipmentInfo> lstVal : lstSensor.values()) {
					for (EquipmentInfo sensor : lstVal) {
						JSONObject jObj = new JSONObject();
						jObj.put("equiId", sensor.getEquip().getEquipmentId()); 
						jObj.put("equiType", sensor.getType()); 
						jObj.put("equiTypeString", sensor.getEquip().getEquipmentType()); 
						jObj.put("equiName", sensor.getEquipmentName());
						jObj.put("equiStatus", StringUtil.getStringNotNull(sensor.getEquip().getStatus()));
						jObj.put("equiStatusString", sensor.getStatusString());
						jObj.put("equiStatusPara", sensor.getStatusPara());
						jObj.put("equiPara", sensor.getParameter());
						jObj.put("equipLocate", sensor.getLocate());
						jObj.put("equipPara3", StringUtil.getStringNotNull(sensor.getEquip().getPara3()));
				   		jAOne.add(jObj);
					}
				}
				
				jArray.add(jAOne);
	    	}	
			
		    returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getGhNodesEquipmentAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "????????????????????????????????????" + e + "??????");
		}		
	}
	
	@PostMapping("/getEquipmentInfo")
	public void getEquipmentInfo(HttpServletResponse response, String gwId, String nodeId, String equipType, String equipId) throws Exception {
		try {
			IgcsIEquipment eInfo = gatewayService.findEquipmentById(gwId, nodeId, equipType, equipId);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");		
			jArray.add(jObj0);
			
			JSONObject jObj = new JSONObject();
			jObj.put("equiStatus", StringUtil.getStringNotNull(eInfo.getStatus()));
			jObj.put("equiStatusString", EquipmentInfo.getStatusString(eInfo.getStatus(), equipType));
			jObj.put("equiStatusPara", eInfo.getStatusPara());
			jObj.put("equiPara", eInfo.getParameter());
			if (eInfo.getLocate() != null) {
				jObj.put("equipLocate", eInfo.getLocate());
			} else {
				jObj.put("equipLocate", -1);
			}
			jObj.put("connectTime", DateUtil.dateToString(eInfo.getLastConnectTime()));
			jObj.put("equipPara3", StringUtil.getStringNotNull(eInfo.getPara3()));
			jArray.add(jObj);
			
		    returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getGhNodesEquipmentAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "????????????????????????????????????" + e + "??????");
		}		
	}
	
	@ApiOperation(value = "???????????????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ghId", value = "??????id", required = false, paramType = "query", dataType = "String")
	})
	@PostMapping("/getGhNodes")
	public void getGhNodes(HttpServletResponse response, String ghId) throws Exception {
		try {
			List<IgcsInodeinfo> lst = gatewayService.getNodesByGhId(ghId);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");		
			jArray.add(jObj0);
			
			for (IgcsInodeinfo info : lst) {
	    		JSONObject jObjNode = new JSONObject();
	    		jObjNode.put("gwId", info.getGatewayId());
	    		jObjNode.put("nodeId", info.getNodeId());
	    		jObjNode.put("nodeName", StringUtil.getStringNotNull(info.getNodeName()));
				if (StringUtil.getStringNotNull(info.getStatus()).equals("0")) {
					jObjNode.put("status", "??????");
				} else {
					jObjNode.put("status", "?????????");
				}	
	    		jArray.add(jObjNode);
	    	}	
			
		    returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getGhNodesAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "?????????????????????????????????" + e + "??????");
		}		
	}
	
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gwId", value = "?????????????????????ID", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "nodeFilter", value = "", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "startTimeFilter", value = "????????????", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "endTimeFilter", value = "????????????", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/getHistoryInfo")
	public void getHistoryInfo(HttpServletResponse response, String gwFilter, String nodeFilter, String sensorListFilter, String startTimeFilter, String endTimeFilter) throws Exception {
		try {
			Map<String, List<SensorHistoryData>> mpData = gatewayService.findHistoryByFilter(gwFilter, nodeFilter, startTimeFilter, endTimeFilter);			
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", SUCCESS);
			JSONArray jArray = new JSONArray();
			jArray.add(jObj0);
			for (Entry<String, List<SensorHistoryData>> entry : mpData.entrySet()) {
				JSONObject jObj1 = new JSONObject();
				String key = entry.getKey();
				String[] strVals= key.split("_");
				jObj1.put("type", strVals[2]);
				StringBuilder str = new StringBuilder();
				str.append("[");
				for (SensorHistoryData hisInfo : entry.getValue()) {
					str.append("[");
//					str.append(hisInfo.getDateGet().getTime() + 8 * 3600 * 1000);
					str.append(hisInfo.getDateGet().getTime());
					str.append(",");
					str.append(hisInfo.getfDataString());
					str.append("],");
				}
				str.deleteCharAt(str.length() - 1);
				if (str.length() > 0) {
					str.append("]");
				}
				jObj1.put("data", str + "");
				jObj1.put("yAxis", SensorType.getYAxisByType(strVals[1]));
				jArray.add(jObj1);
			}
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getHistoryInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "??????????????????????????????" + e + "???" );
		}
	}
	
	private void exportToExcel(HttpServletResponse response, String strTitle, Map<String, List<SensorHistoryData>> mpData, String dateFormat) throws Exception {
		OutputStream os;
//		os = new FileOutputStream("D:\\project.xls");
		os = response.getOutputStream();
		
		response.setHeader("Content-Disposition", "attachment;filename=envdata.xls");//???????????????
		// ????????????ContentType?????????????????????????????????????????????????????????    
//        response.setContentType("multipart/form-data");
        
		int nRow = 0;
        int nCol = 0;
		// ???????????????
        WritableWorkbook workbook = Workbook.createWorkbook(os);
        // ??????????????????
        WritableSheet sheet = workbook.createSheet("????????????", 0);	  
        
        sheet.setRowView(nRow, 500, false);
        sheet.mergeCells(0, nRow, mpData.size() + 1, nRow);			
		Label cell = new Label(0, nRow, strTitle, HandleExcel.getBodyCellStyle(Alignment.CENTRE));
		sheet.addCell(cell);
		nRow++;		

        // ????????????????????????,????????????????????????????????????????????????????????????????????????????????????????????????????????????
		sheet.setRowView(nRow, 500, false); //????????????
        sheet.setColumnView(nCol, 5);
		cell = new Label(nCol++, nRow, "??????", HandleExcel.getHeaderCellStyle());
		sheet.addCell(cell);
		sheet.setColumnView(nCol, 20);
		cell = new Label(nCol++, nRow, "??????", HandleExcel.getHeaderCellStyle());
		sheet.addCell(cell);
		
		for (Entry<String, List<SensorHistoryData>> entry : mpData.entrySet()) {
			String key = entry.getKey();
			String[] strVals= key.split("_");
			
			sheet.setColumnView(nCol, 20);
			cell = new Label(nCol++, nRow, strVals[2], HandleExcel.getHeaderCellStyle());
			sheet.addCell(cell);
		}		
		nRow++;
		
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
        
        int maxDataColum = mpData.size();
        for (HistoryDataEntity entity : lstEntity) {
			sheet.setRowView(nRow, 400, false); //????????????
			nCol = 0;
			
			cell = new Label(nCol++, nRow, String.valueOf(nRow - 1), HandleExcel.getBodyCellStyle(Alignment.CENTRE));
			sheet.addCell(cell);
			cell = new Label(nCol++, nRow, entity.getTimeStr(dateFormat), HandleExcel.getBodyCellStyle(Alignment.CENTRE));
			sheet.addCell(cell);
			
			int n;
			for (n = 1; n <= maxDataColum; n++) {
				cell = new Label(nCol++, nRow, entity.getSensorDataById(n), HandleExcel.getBodyCellStyle(Alignment.CENTRE));
				sheet.addCell(cell);
	        }
			
			nRow++;
		}
		
//		response.addHeader("Content-Length", "" + file.length());
        
        // ????????????????????????????????????????????????????????????
        workbook.write();
        workbook.close();
        os.close();
	}
	
	@PostMapping("/webGetHistoryInfo")
	public void webGetHistoryInfo(HttpServletRequest request,HttpServletResponse response, String gwId, String nodeFilter, String startTimeFilter, String endTimeFilter, boolean isExport,String ghId) throws Exception {
		try {
			nodeFilter=	nodeFilter.split("-")[1];
			Map<String, List<SensorHistoryData>> mpData = gatewayService.findHistoryByFilter(gwId, nodeFilter, startTimeFilter, endTimeFilter);			
			
			if (!isExport) {
				JSONObject jObj0 = new JSONObject();
				jObj0.put("message", SUCCESS);
				JSONArray jArray = new JSONArray();
				jArray.add(jObj0);
				for (Entry<String, List<SensorHistoryData>> entry : mpData.entrySet()) {
					JSONObject jObj1 = new JSONObject();
					String key = entry.getKey();
					String[] strVals= key.split("_");
					jObj1.put("type", strVals[2]);
					JSONArray aData = new JSONArray();
					for (SensorHistoryData hisInfo : entry.getValue()) {
						JSONArray aTmp = new JSONArray();
						aTmp.add(hisInfo.getDateGet().getTime());
						aTmp.add(hisInfo.getfData());
						aData.add(aTmp);
					}
					jObj1.put("data", aData);
					jObj1.put("yAxis", SensorType.getYAxisByType(strVals[1]));
					jArray.add(jObj1);
				}
			
				returnJsonArray(response, jArray);
			} else {
				IgcsIgreenhouse gh = gatewayService.findGhById(ghId);
				String greenhouseName = gh.getGreenhouseName();
				 IgcsIparkinfo park = gatewayService.findParkById(gh.getParkId());
				 String parkhouseName= park.getParkName();
				String strTitle = new String("");
				Session session = (Session) request.getSession().getAttribute("sessionInfo");
				String userName = session.getUserIdString();
		        strTitle += "??????????????????????????????" +parkhouseName+"????????????"+greenhouseName+"?????????ID???"+ gwId + "?????????ID???" + nodeFilter + "???" + "\r\n"+"??????????????????" + startTimeFilter
		        		+ "-" + endTimeFilter+"???????????????"+userName;
		        String dateFormat = getDatwFormat(startTimeFilter, endTimeFilter);
		        exportToExcel(response, strTitle, mpData, dateFormat);
			}
		} catch (Exception e) {
			log.error("webGetHistoryInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "??????????????????????????????" + e + "???" );
		}
	}
	
	private String getDatwFormat(String startTime, String endTime) {
        String startPrefix = startTime.substring(0, 10);
        String endPrefix = endTime.substring(0, 10);
        if (startPrefix.equals(endPrefix)) {
            return "HH:mm";
        } else {
            return "MM-dd HH:mm";
        }
    }

	@ApiOperation(value = "????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ghId", value = "??????ID", required = true, paramType = "query", dataType = "String")
    })
	@PostMapping("/queryNode")
	public void queryNode(HttpServletResponse response, String ghId) throws Exception {
		try {
			List<IgcsInodeinfo> lstInfo = gatewayService.getNodesByGhId(ghId);
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");
			JSONArray jArray = new JSONArray();
			jArray.add(jObj0);

			for (IgcsInodeinfo info : lstInfo) {
				JSONObject jObj1 = new JSONObject();
				jObj1.put("nodeId", info.getNodeId());
				jObj1.put("gwId", info.getGatewayId());
				jObj1.put("nodeName", StringUtil.getStringNotNull(info.getNodeName()));
				jObj1.put("nodeAddr", StringUtil.getStringNotNull(info.getNodeAddr()));
				jObj1.put("addTime", DateUtils.getDateStr(info.getInDate()));
				jObj1.put("connectTime", DateUtils.getDateStr(info.getLastConnectTime()));
				jObj1.put("remark", StringUtil.getStringNotNull(info.getRemark()));
				jObj1.put("frequency", info.getFrequency());
				if (StringUtil.getStringNotNull(info.getStatus()).equals("0")) {
					jObj1.put("status", "??????");
				} else {
					jObj1.put("status", "?????????");
				}				
				jObj1.put("picPath", StringUtil.getStringForDL(info.getNodePic()));
				jArray.add(jObj1);
			}
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("queryNodeAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "?????????????????????" + e + "??????");
		}
	}
	
	@ApiOperation(value = "??????????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "nodeId", value = "??????id", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gwId", value = "??????ID", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "nodeName", value = "????????????", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "nodeAddr", value = "????????????", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "nodeRemark", value = "????????????", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "frquency", value = "??????????????????????????????", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "picSel", value = "???????????????", required = true, paramType = "query", dataType = "MultipartFile"),
			@ApiImplicitParam(name = "picSrcFile", value = "????????????", required = true, paramType = "query", dataType = "String")
    })
	@PostMapping("/mdyNodeInfo")
	public void mdyNodeInfo(HttpServletResponse response, String nodeId, String gwId, String nodeName, String nodeAddr, 
			String nodeRemark, String frquency, MultipartFile picSel, String picSrcFile) throws Exception {
		try {			
			IgcsInodeinfo info = gatewayService.findNodeById(nodeId, gwId);
			if (info == null) {
				returnJsonWithMsg(response, "??????????????????????????????????????????");	
				return;		
			}
			
			Integer nPreFrq = info.getFrequency();
			boolean bFeqMdy = true;
			
			info.setNodeName(nodeName);
			info.setNodeAddr(nodeAddr);
			info.setRemark(nodeRemark);
			
			Integer nowFrq = Integer.valueOf(frquency);
			if (nPreFrq.equals(nowFrq)) {
				bFeqMdy = false;
			}
			
			boolean bDel = false;
			String sourcePic = StringUtil.getStringNotNull(info.getNodePic());
			String sourceDLPic = StringUtil.getStringForDL(info.getNodePic());
			if (picSel != null && picSel.getOriginalFilename().length() > 0) {
				String abPath = FileUtil.getUplodFilePath(picSel.getOriginalFilename());
				info.setNodePic(abPath);
				FileUtil.updateFileContent(FileUtil.WORK_PATH + abPath, picSel);
				
				if (sourcePic.length() > 0) {
					bDel = true;
				}
			} else {
				if (!sourceDLPic.equals(picSrcFile)) {
					info.setNodePic(null);
					bDel = true;
				}
			}
			
			String strRet = gatewayService.mdyNodeInfo(info);
			
			if (strRet.equals("success") && bDel) {
				FileUtil.deleteFile(sourcePic);
			}
			
//			returnJsonWithMsg(response, strRet);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");		
			jArray.add(jObj0);
			
			JSONObject jObj = new JSONObject();
			jObj.put("frqMdy", bFeqMdy);
			jArray.add(jObj);
			
		    returnJsonArray(response, jArray);
			
		} catch (Exception e) {
			log.error("mdyNodeInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response,"???????????????????????????" + e + "??????");
		}		
	}
	
	@ApiOperation(value = "????????????")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String")
    })
	@PostMapping("/queryPark")
	public void queryPark(HttpServletResponse response) throws Exception {
		try {			
			List<Parkinfo> lstInfo = gatewayService.queryAllPark();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");
			JSONArray jArray = new JSONArray();
			jArray.add(jObj0);
			
			for (Parkinfo info : lstInfo) {
				JSONObject jObj1 = new JSONObject();
				jObj1.put("parkId", info.getBaseInfo().getParkId());
				jObj1.put("parkName", StringUtil.getStringNotNull(info.getBaseInfo().getParkName()));
				jObj1.put("parkAddr", StringUtil.getStringNotNull(info.getBaseInfo().getParkAddr()));
				jObj1.put("parkRemark", StringUtil.getStringNotNull(info.getBaseInfo().getRemark()));
				jObj1.put("addTime", DateUtils.getDateStr(info.getBaseInfo().getInDate()));
				jObj1.put("area", info.getBaseInfo().getParkArea());
				jObj1.put("picPath", StringUtil.getStringForDL(info.getBaseInfo().getParkPic()));
				jObj1.put("userName", StringUtil.getStringNotNull(info.getUserName()));
				jArray.add(jObj1);
			}			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("queryParkAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "?????????????????????" + e + "??????");
		}
	}
	
	@PostMapping("/getWeatherData")
	public void getWeatherData(HttpServletResponse response, String userId, String parkId) throws Exception {
		try {
			List<WeatherInfo> lst = gatewayService.getWeatherInfoByUserId(userId, parkId);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");		
			jArray.add(jObj0);
			
			for (WeatherInfo info : lst) {
	    		JSONObject jObjNode = new JSONObject();
	    		jObjNode.put("gwId", info.getGatewayId());
	    		jObjNode.put("NodeId", info.getNodeId());
	    		jObjNode.put("gwName", info.getGatewayName());
	    		jObjNode.put("gwTime", info.getGatherTimeString()); 
	    		jArray.add(jObjNode);
	    		
	    		JSONArray jAOne = new JSONArray();
	    		
	    		Map<Short, List<SensorInfo>> lstSensor = info.getMpSensor();
				for (List<SensorInfo> lstS : lstSensor.values()) {
					for (SensorInfo sensor : lstS) {
						JSONObject jObj = new JSONObject();
						jObj.put("SensorId", sensor.getSensorId());  
						jObj.put("SensorTypeCode", sensor.getSensorTypeCode()); 
						jObj.put("SensorValue", sensor.getSensorValue());
						jObj.put("SensorUnit", sensor.getUnit());
						jObj.put("SensorName", sensor.getSensorTypeName());
						jObj.put("SensorClass", sensor.getClassName());
						jObj.put("SensorPicClass", sensor.getPicClass());
				   		jAOne.add(jObj);
					}
				}
				
				jArray.add(jAOne);
	    	}	
			
		    returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getWeatherDataAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "??????????????????????????????" + e + "??????");
		}		
	}
	
	@PostMapping("/getWeatherRecentInfo")
	public void getWeatherRecentInfo(HttpServletResponse response, String gwId, String nodeId, String sensorId, String sensorTypeCode) throws Exception {
		try {
			List<SensorHistoryData> lstData = gatewayService.findWRecentByFilter(gwId, nodeId, sensorId, sensorTypeCode);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			JSONObject jObj1 = new JSONObject();
			StringBuilder str = new StringBuilder();
			str.append("[");
			for (SensorHistoryData hisInfo : lstData) {
				str.append("[");
				str.append(hisInfo.getDateGet().getTime());
				str.append(",");
				str.append(hisInfo.getfDataString());
				str.append("],");
			}
			str.deleteCharAt(str.length() - 1);
			if (str.length() > 0) {
				str.append("]");
			}
			jObj1.put("data", str + "");			
			jArray.add(jObj1);			
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getWeatherRecentInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "?????????????????????????????????????????????" + e + "???" );
		}
	}	
	
	@PostMapping("/getWeathers")
	public void getWeathers(HttpServletResponse response, String userId, String parkId) throws Exception {
		try {
			List<IgcsIGatewayInfo> lst = gatewayService.getWeatherList(userId, parkId);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");		
			jArray.add(jObj0);
			
			for (IgcsIGatewayInfo info : lst) {
	    		JSONObject jObjNode = new JSONObject();
	    		jObjNode.put("weatherId", info.getGatewayId());
	    		jObjNode.put("weatherName", StringUtil.getStringNotNull(info.getGatewayName()));
	    		jArray.add(jObjNode);
	    	}	
			
		    returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getWeathersAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "??????????????????????????????" + e + "??????");
		}		
	}	
	
	@PostMapping("/getWeatherSensors")
	public void getWeatherSensors(HttpServletResponse response, String weatherId) throws Exception {
		try {
			Map<Short, List<SensorInfo>> mpSensor = gatewayService.getSensorList(weatherId, "1");
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");		
			jArray.add(jObj0);
			
			for (List<SensorInfo> lstSi : mpSensor.values()) {
				for (SensorInfo info : lstSi) {
					JSONObject jObjNode = new JSONObject();
		    		jObjNode.put("sensorId", info.getSensorTypeCode() + "-" + info.getSensorId());
		    		jObjNode.put("sensorName", info.getSensorTypeName());
		    		jArray.add(jObjNode);
				}
			}
			
		    returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getWeatherSensorsAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "???????????????????????????????????????" + e + "??????");
		}		
	}
	
	@PostMapping("/getNodeSensors")
	public void getNodeSensors(HttpServletResponse response, String gwId, String nodeId) throws Exception {
		try {
			Map<Short, List<SensorInfo>> mpSensor = gatewayService.getSensorList(gwId, nodeId);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");		
			jArray.add(jObj0);
			
			for (List<SensorInfo> lstSi : mpSensor.values()) {
				for (SensorInfo info : lstSi) {
					JSONObject jObjNode = new JSONObject();
		    		jObjNode.put("sensorId", info.getSensorTypeCode() + "-" + info.getSensorId());
		    		jObjNode.put("sensorName", info.getSensorTypeName() + info.getSensorId());
		    		jArray.add(jObjNode);
				}
			}
			
		    returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getNodeSensorsAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "????????????????????????????????????" + e + "??????");
		}		
	}
	
	@PostMapping("/getHistoryExInfo")
	public void getHistoryExInfo(HttpServletResponse response, String gwFilter, String nodeFilter, String sensorListFilter, 
			String startTimeFilter, String endTimeFilter, String bWeather) throws Exception {
		try {
			Map<String, List<SensorData>> mpData = gatewayService.findHistoryInfoByFilter(gwFilter, nodeFilter, sensorListFilter, 
					startTimeFilter, endTimeFilter, bWeather);			
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", SUCCESS);
			JSONArray jArray = new JSONArray();
			jArray.add(jObj0);
			for (Entry<String, List<SensorData>> entry : mpData.entrySet()) {
				JSONObject jObj1 = new JSONObject();
				String key = entry.getKey();
				String[] strVals= key.split("_");
				jObj1.put("type", strVals[2]);
				StringBuilder str = new StringBuilder();
				str.append("[");
				for (SensorData hisInfo : entry.getValue()) {
					str.append("[");
//					str.append(hisInfo.getDateGet().getTime() + 8 * 3600 * 1000);
					str.append(hisInfo.getGatherTime().getTime());
					str.append(",");
					str.append(hisInfo.getSensorValue());
					str.append("],");
				}
				str.deleteCharAt(str.length() - 1);
				if (str.length() > 0) {
					str.append("]");
				}
				jObj1.put("data", str + "");
				jObj1.put("yAxis", SensorType.getYAxisByType(strVals[1]));
				jObj1.put("sensorTypeCode", strVals[1]);
				jArray.add(jObj1);
			}
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getHistoryExInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "??????????????????????????????" + e + "???" );
		}
	}
	
	@PostMapping("/getGhNodesTimeLimit")
	public void getGhNodesTimeLimit(HttpServletResponse response, String ghId) throws Exception {
		try {
			List<NodeInfo> lst = gatewayService.getNodesEquipByGhId(ghId, true);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");		
			jArray.add(jObj0);
			
			for (NodeInfo info : lst) {
	    		JSONObject jObjNode = new JSONObject();
	    		jObjNode.put("gwId", info.getGatewayId());
	    		jObjNode.put("NodeId", info.getNodeId());
	    		jObjNode.put("NodeName", info.getNodeName());
	    		jArray.add(jObjNode);
	    		
	    		JSONArray jAOne = new JSONArray();
	    		
	    		Map<Short, List<EquipmentInfo>> lstSensor = info.getMpEquips();
				for (List<EquipmentInfo> lstVal : lstSensor.values()) {
					for (EquipmentInfo sensor : lstVal) {
						JSONObject jObj = new JSONObject();
						jObj.put("equiId", sensor.getEquip().getEquipmentId()); 
						jObj.put("equiType", sensor.getType()); 
						jObj.put("equiTypeString", sensor.getEquip().getEquipmentType()); 
						jObj.put("equiName", sensor.getEquipmentName());
						jObj.put("locate", StringUtil.getStringNotNull(sensor.getEquip().getLocate()));
						jObj.put("timeUp", StringUtil.getStringNotNull(sensor.getEquip().getPara1()));
						jObj.put("timeDown", StringUtil.getStringNotNull(sensor.getEquip().getPara2()));
						jObj.put("timeError", StringUtil.getStringNotNull(sensor.getEquip().getPara3()));
				   		jAOne.add(jObj);
					}
				}
				
				jArray.add(jAOne);
	    	}	
			
		    returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getGhNodesTimeLimitAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "??????????????????????????????????????????" + e + "??????");
		}		
	}
	
	@PostMapping("/getNodesOfParkPd")
	public void getNodesOfParkPd(HttpServletResponse response, String userId,String gwId,String nodeId) throws Exception {
		try {	
			User userInfo = userService.findUserById(userId);
			
			List<IgcsInodeinfo> lstInfo = gatewayService.queryNodesOfPark(userInfo.getParkId());
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");
			JSONArray jArray = new JSONArray();
			jArray.add(jObj0);
			
			for (IgcsInodeinfo info : lstInfo) {
				if(info.getNodeId().equals(nodeId)&&info.getGatewayId().equals(gwId)) {
					JSONObject jObj1 = new JSONObject();
					jObj1.put("xiaoxi", "success");
					if(null!=info.getGreenhouseId()) {
						jObj1.put("xiaoxi", "??????????????????????????????");
						jArray.add(jObj1);
					}
					break;
				}

			}	
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getNodesOfParkAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "????????????????????????????????????" + e + "??????");
		}
	}

	
	@PostMapping("/getNodesOfPark")
	public void getNodesOfPark(HttpServletResponse response, String userId) throws Exception {
		try {	
			User userInfo = userService.findUserById(userId);
			if (userInfo == null) {
				returnJsonWithMsg(response, "??????ID???????????????????????????????????????");
				return;
			}
			if (!StringUtil.notEmpty(userInfo.getParkId())) {
				returnJsonWithMsg(response, "???????????????????????????");
				return;
			} 
			
			List<IgcsInodeinfo> lstInfo = gatewayService.queryNodesOfPark(userInfo.getParkId());
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");
			JSONArray jArray = new JSONArray();
			jArray.add(jObj0);
			
			for (IgcsInodeinfo info : lstInfo) {
				JSONObject jObj1 = new JSONObject();
				jObj1.put("gwId", info.getGatewayId());
				jObj1.put("nodeId", info.getNodeId());
				jObj1.put("nodeName", StringUtil.getStringNotNull(info.getNodeName()));
				jObj1.put("ghId", StringUtil.getStringNotNull(info.getGreenhouseId()));
				if (StringUtil.getStringNotNull(info.getStatus()).equals("0")) {
					jObj1.put("status", "??????");
				} else {
					jObj1.put("status", "?????????");
				}	
				jArray.add(jObj1);
			}	
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getNodesOfParkAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "????????????????????????????????????" + e + "??????");
		}
	}
	
	@PostMapping("/addGhInfoEx")
	public void addGhInfoEx(HttpServletResponse response, String ghId, String userId, String ghName, String ghAddress, 
			String ghRemark, String gwNodes, MultipartFile picSel) throws Exception {
		try {
			IgcsIgreenhouse infoPre = gatewayService.findGhById(ghId);
			if (infoPre != null) {
				returnJsonWithMsg(response, "??????ID??????????????????????????????");
				return;
			}
			
			User userInfo = userService.findUserById(userId);
			if (userInfo == null) {
				returnJsonWithMsg(response, "??????ID???????????????????????????????????????");
				return;
			}
			
			IgcsIgreenhouse info = new IgcsIgreenhouse();
			
			info.setGreenhouseId(ghId);
			info.setGreenhouseName(ghName);
			info.setGreenhouseAddr(ghAddress);
			info.setRemark(ghRemark);
			info.setUserId(userId);
			info.setParkId(userInfo.getParkId());
			
			if (picSel != null && picSel.getOriginalFilename().length() > 0) {
				String abPath = FileUtil.getUplodFilePath(picSel.getOriginalFilename());
				info.setGreenhousePic(abPath);
				FileUtil.updateFileContent(FileUtil.WORK_PATH + abPath, picSel);
			} 
			
			info.setInDate(getCurTimestamp());
			
			gatewayService.addGreenhouseEx(info, gwNodes);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("addGhInfoExAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "???????????????????????????" + e + "??????");
		}
	}
	
	@PostMapping("/mdyGhInfoEx")
	public void mdyGhInfoEx(HttpServletResponse response, String ghId, String userId, String ghName, String ghAddress, 
			String ghRemark, String gwNodes, MultipartFile picSel, String picSrcFile, String ghPlant, String plantDirection,String count) throws Exception {
		try {			
			IgcsIgreenhouse info = gatewayService.findGhById(ghId);
			if (info == null) {
				returnJsonWithMsg(response,"??????????????????????????????????????????");	
				return;		
			}

			System.out.println(ghPlant);
			System.out.println(plantDirection);
			System.out.println(count);
			
			info.setGreenhouseId(ghId);
			info.setGreenhouseName(ghName);
			info.setGreenhouseAddr(ghAddress);
			info.setRemark(ghRemark);
			info.setUserId(userId);
			
			boolean bDel = false;
			String sourcePic = StringUtil.getStringNotNull(info.getGreenhousePic());
			String sourceDLPic = StringUtil.getStringForDL(info.getGreenhousePic());
			if (picSel != null && picSel.getOriginalFilename().length() > 0) {
				String abPath = FileUtil.getUplodFilePath(picSel.getOriginalFilename());
				info.setGreenhousePic(abPath);
				FileUtil.updateFileContent(FileUtil.WORK_PATH + abPath, picSel);
				
				if (sourcePic.length() > 0) {
					bDel = true;
				}
			} else {
				if (!sourceDLPic.equals(picSrcFile)) {
					info.setGreenhousePic(null);
					bDel = true;
				}
			}
			
			gatewayService.mdyGreenhouseEx(info, gwNodes);		
			
			if (bDel) {
				FileUtil.deleteFile(sourcePic);
			}
			
			returnJsonWithMsg(response, SUCCESS);			
		} catch (Exception e) {
			log.error("mdyGhInfoExAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "???????????????????????????" + e + "??????");
		}		
	}
	
	@PostMapping("/delGhInfo")
	public void delGhInfo(HttpServletResponse response, String ghId) throws Exception {
		try {
			IgcsIgreenhouse info = gatewayService.findGhById(ghId);
			if (info == null) {
				returnJsonWithMsg(response, "??????????????????????????????????????????");	
				return;		
			}			
			
			gatewayService.delGhById(ghId);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("delGhInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "???????????????????????????" + e + "??????");
		}
	}
	
	
	
	private void exportToExcel1(HttpServletResponse response, String strTitle, Map<String, List<SensorHistoryData>> mpData, String dateFormat) throws Exception {
		ZongExcelReport zongExcelReport = new ZongExcelReport();
		XSSFWorkbook workbook = new XSSFWorkbook();
		zongExcelReport.createReport(workbook, strTitle, mpData, dateFormat);
        byte[] content = zongExcelReport.writeToStream(workbook);
//		response.addHeader("Content-Length", "" + file.length());
       
        
        try {
		    String filename =new String("????????????".getBytes("UTF-8"),"ISO-8859-1");
	        response.setContentType("application/octet-stream;charset=utf-8");
	        response.setHeader("Content-Disposition", "attachment;filename=" +filename);
	        response.setContentLength(content.length);
			response.getOutputStream().write(content);
	        response.getOutputStream().flush();
	        response.getOutputStream().close();
		 } catch (IOException e) {
				e.printStackTrace();
		}
		
	}
	
	@PostMapping("/getGhNodesEncode")
	public void getGhNodesEncode(HttpServletResponse response, String ghId) throws Exception {
		try {
			List<NodeInfo> lst = gatewayService.getNodesEquipByGhId(ghId, true);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");		
			jArray.add(jObj0);
			
			for (NodeInfo info : lst) {
	    		JSONObject jObjNode = new JSONObject();
	    		jObjNode.put("gwId", info.getGatewayId());
	    		jObjNode.put("NodeId", info.getNodeId());
	    		jObjNode.put("NodeName", info.getNodeName());
	    		jArray.add(jObjNode);
	    		
	    		JSONArray jAOne = new JSONArray();
	    		
	    		Map<Short, List<EquipmentInfo>> lstSensor = info.getMpEquips();
				for (List<EquipmentInfo> lstVal : lstSensor.values()) {
					for (EquipmentInfo sensor : lstVal) {
						JSONObject jObj = new JSONObject();
						jObj.put("equiId", sensor.getEquip().getEquipmentId()); 
						jObj.put("equiType", sensor.getType()); 
						jObj.put("equiTypeString", sensor.getEquip().getEquipmentType()); 
						jObj.put("equiName", sensor.getEquipmentName());
						jObj.put("curQs", StringUtil.getStringNotNull(sensor.getEquip().getStatusPara()));
						jObj.put("totalQs", StringUtil.getStringNotNull(sensor.getEquip().getParameter()));
						jAOne.add(jObj);
					}
				}
				
				jArray.add(jAOne);
	    	}	
			
		    returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getGhNodesEncodeAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "?????????????????????????????????????????????" + e + "??????");
		}		
	}
}

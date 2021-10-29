package com.face.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.face.controller.LoginController;
import com.face.model.IgcsBTrade;
import com.face.model.IgcsINodeItem;
import com.face.model.IgcsInodeinfo;
import com.face.model.User;
import com.face.service.IGatewayService;
import com.face.service.IOperationService;


@Api(tags = "02 大棚控制相关接口", value = "大棚控制相关接口展示")
@RestController
@RequestMapping("/operation")
public class OperationController extends LoginController {
	private static final Log log = LogFactory.getLog(OperationController.class);
	
	@Autowired
	private IOperationService operationService;
	@Autowired
	private IGatewayService gatewayService;	
	
	@ApiOperation(value = "添加操作信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "tradeId", value = "流水号", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gwId", value = "网关ID", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "nodeId", value = "节点ID", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "equiType", value = "控制设备类型", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "equiId", value = "控制设备ID", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "controlType", value = "操作类型编码", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "insertWay", value = "插入方式，0手工控制，1策略自动控制，手工控制优先级更高", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userId", value = "指令发出人，策略触发时，插入的是策略对应的用户", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "para1", value = "操作参数，用于生成message，为后续精准控制预留，如补光时长、滴灌时长/量等参数", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "para2", value = "操作参数，用于生成message，为后续精准控制预留，如补光时长、滴灌时长/量等参数", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "para3", value = "操作参数，用于生成message，为后续精准控制预留，如补光时长、滴灌时长/量等参数", required = false, paramType = "query", dataType = "String"), })
	@PostMapping("/addTradeInfo")
	public void addTradeInfo(HttpServletResponse response, String tradeId, String gwId, String nodeId, String equiType, 
			String equiId, String controlType, String insertWay, String userId, String para1, String para2, String para3) throws Exception {
		try {
			User userInfo = userService.findUserById(userId);
			if (userInfo == null) {
				returnJsonWithMsg(response, "用户ID不存在，请重新登录后重试！");
				return;
			}
			
			IgcsBTrade info = new IgcsBTrade();
			
			info.setTradeId(tradeId);
			info.setGatewayId(gwId);
			info.setNodeId(nodeId);
			info.setEquipmentTypeCode(equiType);
			info.setEquipmentId(equiId);
			info.setControlType(controlType);
			info.setControlParameter1(para1);	
			info.setControlParameter2(para2);	
			info.setControlParameter3(para3);
			info.setInsertWay(insertWay);
			info.setUserId(userId);
			info.setInsertTime(getCurTimestamp());
			info.setPreDealTime(getCurTimestamp());
			info.setDealCount(0);
			info.setIsDeal("0");
			
			operationService.addTrade(info);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("addTradeInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "添加操作信息失败（" + e + "）！");
		}
	}

	@ApiOperation(value = "检查相关信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "tradeId", value = "流水号", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/checkTradeResult")
	public void checkTradeResult(HttpServletResponse response, String tradeId) throws Exception {
		try {			
			IgcsBTrade info = operationService.findTradeById(tradeId);

			String result = info.getIsDeal();
			
			// 成功，修改设备状态
			if (result.equals("1")) {
				String ctrlType = info.getControlType();
				String status = "0";
				if (ctrlType.endsWith("DEON")) {
					status = "3";
				} else if (ctrlType.endsWith("ON")) {
					status = "1";
				} else if (ctrlType.endsWith("FWD")) {
					status = "1";
				} else if (ctrlType.endsWith("REV")) {
					status = "2";
				}
				operationService.updateEquipById(info.getGatewayId(), info.getNodeId(), info.getEquipmentTypeCode(), info.getEquipmentId(), 
						status);
			}
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			JSONObject jObj1 = new JSONObject();
			jObj1.put("result", result);
			jObj1.put("remark", info.getRemark());
			jArray.add(jObj1);
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("checkTradeResultAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "获取操作信息结果失败（" + e + "）！");
		}
	}
	
	@PostMapping("/refreshNodeEquips")
	public void refreshNodeEquips(HttpServletResponse response, String gwId, String nodeId, String userId) throws Exception {
		try {
			User userInfo = userService.findUserById(userId);
			if (userInfo == null) {
				returnJsonWithMsg(response, "用户ID不存在，请重新登录后重试！");
				return;
			}
			
			List<IgcsINodeItem> lstItem = operationService.findNodeEquipTypes(gwId, nodeId);
			List<String> lstTrades = new ArrayList<String>();
			
			for (IgcsINodeItem igcsINodeItem : lstItem) {
				IgcsBTrade info = new IgcsBTrade();
				
				String equiType = igcsINodeItem.getItemType();
				equiType = equiType.substring(0, equiType.lastIndexOf("_"));
				
				info.setTradeId("0#" + System.currentTimeMillis());
				info.setGatewayId(gwId);
				info.setNodeId(nodeId);
				info.setEquipmentTypeCode(equiType);
				info.setControlType("GetEquipTypeStatus");
				info.setInsertWay("0");
				info.setUserId(userId);
				info.setInsertTime(getCurTimestamp());
				info.setPreDealTime(getCurTimestamp());
				info.setDealCount(0);
				info.setIsDeal("0");
				
				operationService.addTrade(info);
				
				lstTrades.add(info.getTradeId());
			}
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			for (String tId : lstTrades) {
				JSONObject jObj1 = new JSONObject();
				jObj1.put("tradeId", tId);
				
				jArray.add(jObj1);				
			}
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("refreshNodeEquipsAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "刷新节点设备信息失败（" + e + "）！");
		}
	}
	
	@PostMapping("/checkRefreshResult")
	public void checkRefreshResult(HttpServletResponse response, String tradesId) throws Exception {
		try {
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			String[] strA = tradesId.split("\\+");
			for (String tradeId : strA) {
				IgcsBTrade info = operationService.findTradeById(tradeId);
				
				JSONObject jObj1 = new JSONObject();
				
				jObj1.put("tradeId", tradeId);
				jObj1.put("result", info.getIsDeal());
				jObj1.put("remark", info.getRemark());
				jArray.add(jObj1);
			}
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("checkRefreshResultAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "获取刷新节点设备结果失败（" + e + "）！");
		}
	}
	
	@PostMapping("/addMdyNodeFrq")
	public void addMdyNodeFrq(HttpServletResponse response, String tradeId, String gwId, String nodeId, 
			String userId, String frqPara) throws Exception {
		try {
			User userInfo = userService.findUserById(userId);
			if (userInfo == null) {
				returnJsonWithMsg(response, "用户ID不存在，请重新登录后重试！");
				return;
			}
			
			IgcsBTrade info = new IgcsBTrade();
			
			info.setTradeId(tradeId);
			info.setGatewayId(gwId);
			info.setNodeId(nodeId);
			info.setControlType("SetNodeFreq");
			info.setControlParameter1(frqPara);	
			info.setUserId(userId);
			info.setInsertTime(getCurTimestamp());
			info.setPreDealTime(getCurTimestamp());
			info.setDealCount(0);
			info.setIsDeal("0");
			
			operationService.addTrade(info);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("addMdyNodeFrqAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "添加修改节点采集频率失败（" + e + "）！");
		}
	}
	
	@PostMapping("/checkMdyNodeFrqResult")
	public void checkMdyNodeFrqResult(HttpServletResponse response, String tradeId) throws Exception {
		try {			
			IgcsBTrade info = operationService.findTradeById(tradeId);

			String result = info.getIsDeal();
			
			// 成功，修改节点采集频率
			if (result.equals("1")) {
				IgcsInodeinfo infoNode = gatewayService.findNodeById(info.getNodeId(), info.getGatewayId());
				infoNode.setFrequency(Integer.valueOf(info.getControlParameter1()));
				gatewayService.mdyNodeInfo(infoNode);
			}
						
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			JSONObject jObj1 = new JSONObject();
			jObj1.put("result", result);
			jObj1.put("remark", info.getRemark());
			jArray.add(jObj1);
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("checkMdyNodeFrqResultAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "获取修改节点采集频率结果失败（" + e + "）！");
		}
	}
	
	@PostMapping("/syncNodeTime")
	public void syncNodeTime(HttpServletResponse response, String tradeId, String gwId, String nodeId, 
			String userId) throws Exception {
		try {
			User userInfo = userService.findUserById(userId);
			if (userInfo == null) {
				returnJsonWithMsg(response, "用户ID不存在，请重新登录后重试！");
				return;
			}
			
			IgcsBTrade info = new IgcsBTrade();
			
			info.setTradeId(tradeId);
			info.setGatewayId(gwId);
			info.setNodeId(nodeId);
			info.setControlType("GetNodeTime");
			info.setUserId(userId);
			info.setInsertTime(getCurTimestamp());
			info.setPreDealTime(getCurTimestamp());
			info.setDealCount(0);
			info.setIsDeal("0");
			
			operationService.addTrade(info);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("syncNodeTimeAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "同步节点时间失败（" + e + "）！");
		}
	}
	
	@PostMapping("/checkSyncNodeTimeResult")
	public void checkSyncNodeTimeResult(HttpServletResponse response, String tradeId) throws Exception {
		try {			
			IgcsBTrade info = operationService.findTradeById(tradeId);

			String result = info.getIsDeal();
						
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			JSONObject jObj1 = new JSONObject();
			jObj1.put("result", result);
			jObj1.put("remark", info.getRemark());
			jArray.add(jObj1);
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("checkSyncNodeTimeResultAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "获取同步节点时间结果失败（" + e + "）！");
		}
	}
}

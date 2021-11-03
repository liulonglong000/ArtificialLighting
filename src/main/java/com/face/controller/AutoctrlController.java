package com.face.controller;

import com.face.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import com.face.model.IgcsArmThreshold;
import com.face.model.IgcsBTrade;
import com.face.model.IgcsChoperation;
import com.face.model.IgcsChstrategy;
import com.face.model.IgcsChthreshold;
import com.face.model.IgcsCoperation;
import com.face.model.IgcsCoperationGroup;
import com.face.model.IgcsCstrategy;
import com.face.model.IgcsCthreshold;
import com.face.model.IgcsCthresholdGroup;
import com.face.model.IgcsInodeinfo;
import com.face.model.User;
import com.face.service.IAutoctrlService;
import com.face.service.IOperationService;
import com.face.utils.DateUtil;
import com.face.utils.StringUtil;

@Api(tags = "03 联动控制接口", value = "联动控制接口")
@RestController
@RequestMapping("/autoctrl")
public class AutoctrlController extends LoginController {
	private static final Log log = LogFactory.getLog(AutoctrlController.class);
	
	@Autowired
	private IAutoctrlService autoctrlService;
	@Autowired
	private IOperationService operationService;

	  @ApiOperation(value = "获取阈值组信息")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "tgId", value = "条件组ID", required = false, paramType = "query", dataType = "String")
	    })
	@PostMapping("/getThresholdGroupInfo")
	public void getThresholdGroupInfo(HttpServletResponse response, String tgId) throws Exception {
		try {
			ThresholdGroupInfo info = autoctrlService.findTgById(tgId);
			
			IgcsCthresholdGroup tgInfo = info.getTgBaseInfo();
			if (tgInfo == null) {
				returnJsonWithMsg(response, "该阈值组不存在，请刷新后重试！");	
				return;		
			}
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			JSONObject jObj1 = new JSONObject();
			jObj1.put("id", tgInfo.getThresholdGroupId());
			jObj1.put("name", StringUtil.getStringNotNull(tgInfo.getThresholdGroupName()));
			jObj1.put("remark", StringUtil.getStringNotNull(tgInfo.getRemark()));
			jArray.add(jObj1);
			
			List<ThresholdInfo> lstThresholds = info.getLstThresholds();
			for (ThresholdInfo threshold : lstThresholds) {
				JSONObject jObj2 = new JSONObject();
				jObj2.put("id", threshold.getThresholdBaseInfo().getThresholdId());
				jObj2.put("gwId", threshold.getThresholdBaseInfo().getGatewayId());	
				jObj2.put("nodeId", threshold.getThresholdBaseInfo().getNodeId());	
				jObj2.put("nodeName", threshold.getNodeName());
				jObj2.put("sensorType", threshold.getThresholdBaseInfo().getSensorTypeCode());
				jObj2.put("sensorTypeName", threshold.getSensorTypeName());
				jObj2.put("sensorId", threshold.getThresholdBaseInfo().getSensorId());				
				jObj2.put("typeCode", threshold.getThresholdBaseInfo().getThresholdTypeCode());
				jObj2.put("typeName", threshold.getThresholdTypeName());				
				jObj2.put("typePara", threshold.getThresholdBaseInfo().getThresholdParameter());				
				jObj2.put("compCode", threshold.getThresholdBaseInfo().getComparaType());
				jObj2.put("compName", threshold.getThresholdParameterName());				
				jObj2.put("compPara", threshold.getThresholdBaseInfo().getThresholdValue());
				jObj2.put("addDate", DateUtil.dateToString(threshold.getThresholdBaseInfo().getInDate()));
				jObj2.put("unit", threshold.getSensorUnit());				
				jArray.add(jObj2);
			}
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getThresholdGroupInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "获取阈值组信息失败（" + e + "）！");
		}
	}
	  @ApiOperation(value = "获取阈值组信息")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "tgId", value = "条件组ID", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "tgName", value = "阈值组名称", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "ghId", value = "温室ID", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "remark", value = "备注", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "userId", value = "用户ID", required = false, paramType = "query", dataType = "String")
	            
	    })
	@PostMapping("/addThresholdGroupInfo")
	public void addThresholdGroupInfo(HttpServletResponse response, String tgId, String tgName, String ghId, String remark, String userId) throws Exception {
		try {
			IgcsCthresholdGroup tgInfo = autoctrlService.findTgBaseById(tgId);
			if (tgInfo != null) {
				returnJsonWithMsg(response, "该阈值组ID已存在，请刷新后重试！");
				return;
			}
			
			tgInfo = new IgcsCthresholdGroup();
			tgInfo.setThresholdGroupId(tgId);
			tgInfo.setThresholdGroupName(tgName);
			tgInfo.setRemark(remark);
			tgInfo.setGreenhouseId(ghId);
			tgInfo.setUpdateUserId(userId);
			tgInfo.setInDate(getCurTimestamp());
			tgInfo.setUpdateTime(getCurTimestamp());
			
			autoctrlService.addTgInfo(tgInfo);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("addThresholdGroupInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "添加阈值组失败（" + e + "）！");
		}
	}	
	  @ApiOperation(value = "修改阈值组")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "tgId", value = "条件组ID", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "tgName", value = "阈值组名称", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "remark", value = "备注", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "userId", value = "用户ID", required = false, paramType = "query", dataType = "String")
	            
	    })
	@PostMapping("/mdyThresholdGroupInfo")
	public void mdyThresholdGroupInfo(HttpServletResponse response, String tgId, String tgName, String remark, String userId) throws Exception {
		try {
			IgcsCthresholdGroup tgInfo = autoctrlService.findTgBaseById(tgId);
			if (tgInfo == null) {
				returnJsonWithMsg(response, "该阈值组不存在，请刷新后重试！");
				return;
			}
			
			tgInfo.setThresholdGroupName(tgName);
			tgInfo.setRemark(remark);
			tgInfo.setUpdateUserId(userId);
			tgInfo.setUpdateTime(getCurTimestamp());
			
			autoctrlService.modifyTgInfo(tgInfo);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("mdyThresholdGroupInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "修改阈值组失败（" + e + "）！");
		}
	}	
	  
	@ApiOperation(value = "删除阈值组")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "tgId", value = "条件组ID", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/delThresholdGroupInfo")
	public void delThresholdGroupInfo(HttpServletResponse response, String tgId) throws Exception {
		try {
			if (autoctrlService.tgInUse(tgId)) {
				returnJsonWithMsg(response, "该阈值组被策略引用，无法删除！");
				return;
			}
			
			autoctrlService.delTgInfo(tgId);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("delThresholdGroupInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "删除阈值组失败（" + e + "）！");
		}
	}
	  
	@ApiOperation(value = "查询阈值组")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ghId", value = "温室ID", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/queryThresholdGroup")
	public void queryThresholdGroup(HttpServletResponse response, String ghId) throws Exception {
		try {
			List<ThresholdGroupInfo> lstTgs = autoctrlService.findTgsByGhId(ghId, false);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			for (ThresholdGroupInfo thresholdGroup : lstTgs) {
				JSONObject jObj2 = new JSONObject();
				jObj2.put("id", thresholdGroup.getTgBaseInfo().getThresholdGroupId());
				jObj2.put("name", thresholdGroup.getTgBaseInfo().getThresholdGroupName());
				jObj2.put("remark", StringUtil.getStringNotNull(thresholdGroup.getTgBaseInfo().getRemark()));
				jObj2.put("userName", StringUtil.getStringNotNull(thresholdGroup.getUseName()));
				jObj2.put("mdyTime", DateUtil.dateToString(thresholdGroup.getTgBaseInfo().getUpdateTime()));
				jArray.add(jObj2);
			}
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("queryThresholdGroupAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "查询阈值组失败（" + e + "）！");
		}
	}
	
	@ApiOperation(value = "获取添加阈值需要的信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ghId", value = "温室ID", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/getDatasForThresholdAdd")
	public void getDatasForThresholdAdd(HttpServletResponse response, String ghId) throws Exception {
		try {
			DataForThresholdAdd info = autoctrlService.findDatasForThresholdAdd(ghId);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			List<SensorInfo> lstSensor = info.getLstSensor();
			JSONArray aSubSensor = new JSONArray();
			for (SensorInfo sensorInfo : lstSensor) {
				JSONObject jObj1 = new JSONObject();
				jObj1.put("gwId", sensorInfo.getAtGwId());
				jObj1.put("nodeId", sensorInfo.getAtNodeId());
				jObj1.put("nodeName", StringUtil.getStringNotNull(sensorInfo.getAtNodeName()));
				jObj1.put("sensorType", sensorInfo.getSensorTypeCode());
				jObj1.put("sensorTypeName", sensorInfo.getSensorTypeName());
				jObj1.put("sensorId", sensorInfo.getSensorId());
				jObj1.put("sensorUnit", sensorInfo.getUnit());
				aSubSensor.add(jObj1);
			}
			jArray.add(aSubSensor);
			
			Map<String, String> mpType = info.getMpType();
			JSONArray aSubType = new JSONArray();
			for (Map.Entry<String, String> entryType : mpType.entrySet()) {
				JSONObject jObj1 = new JSONObject();
				jObj1.put("typeId", entryType.getKey());
				jObj1.put("typeName", entryType.getValue());	
				aSubType.add(jObj1);
			}
			jArray.add(aSubType);
			
			Map<String, String> mpComp = info.getMpComp();
			JSONArray aSubComp = new JSONArray();
			for (Map.Entry<String, String> entryComp : mpComp.entrySet()) {
				JSONObject jObj1 = new JSONObject();
				jObj1.put("compId", entryComp.getKey());
				jObj1.put("compName", entryComp.getValue());	
				aSubComp.add(jObj1);
			}
			jArray.add(aSubComp);
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getDatasForThresholdAddAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "获取添加阈值需要的信息失败（" + e + "）！");
		}
	}	
	  @ApiOperation(value = "添加阈值信息")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "thresholdId", value = "阈值条件ID", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "tgId", value = "阈值组ID", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "gwId", value = "网关ID", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "nodeId", value = "节点id", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "sensorTypeCode", value = "传感器类型", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "sensorId", value = "传感器ID", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "typeCode", value = "阈值条件类型", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "typePara", value = "阈值条件参数", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "compCode", value = "对比类型，例如大于小于", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "compPara", value = "对比参数值", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "userId", value = "用户ID", required = false, paramType = "query", dataType = "String")
	    })
	@PostMapping("/addThresholdInfo")
	public void addThresholdInfo(HttpServletResponse response, String thresholdId, String tgId, String gwId, String nodeId, 
			String sensorTypeCode, String sensorId, String typeCode, String typePara, String compCode, String compPara, String userId) throws Exception {
		try {
			IgcsCthreshold tInfo = autoctrlService.findThresholdById(thresholdId);
			if (tInfo != null) {
				returnJsonWithMsg(response, "该阈值ID已存在，请刷新后重试！");
				return;
			}
			
			tInfo = new IgcsCthreshold();
			tInfo.setThresholdId(thresholdId);
			tInfo.setThresholdGroupId(tgId);
			tInfo.setGatewayId(gwId);
			tInfo.setNodeId(nodeId);
			tInfo.setSensorTypeCode(sensorTypeCode);
			tInfo.setSensorId(sensorId);
			tInfo.setThresholdTypeCode(typeCode);
			tInfo.setThresholdParameter(typePara);
			tInfo.setComparaType(compCode);
			tInfo.setThresholdValue(Integer.valueOf(compPara));
			tInfo.setInDate(getCurTimestamp());
			
			autoctrlService.addThresholdInfo(tInfo, userId);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("addThresholdInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "添加阈值失败（" + e + "）！");
		}
	}	
	  
	@ApiOperation(value = "修改阈值信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "thresholdId", value = "阈值条件ID", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gwId", value = "网关ID", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "nodeId", value = "节点id", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sensorTypeCode", value = "传感器类型", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sensorId", value = "传感器ID", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "typeCode", value = "阈值条件类型", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "typePara", value = "阈值条件参数", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "compCode", value = "对比类型，例如大于小于", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "compPara", value = "对比参数值", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userId", value = "用户ID", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/mdyThresholdInfo")
	public void mdyThresholdInfo(HttpServletResponse response, String thresholdId, String gwId, String nodeId, 
			String sensorTypeCode, String sensorId, String typeCode, String typePara, String compCode, String compPara, String userId) throws Exception {
		try {
			IgcsCthreshold tInfo = autoctrlService.findThresholdById(thresholdId);
			if (tInfo == null) {
				returnJsonWithMsg(response, "该阈值不存在，请刷新后重试！");
				return;
			}
			
			IgcsChthreshold hInfo = autoctrlService.generateHistoryThreshold(tInfo);
			
			tInfo.setGatewayId(gwId);
			tInfo.setNodeId(nodeId);
			tInfo.setSensorTypeCode(sensorTypeCode);
			tInfo.setSensorId(sensorId);
			tInfo.setThresholdTypeCode(typeCode);
			tInfo.setThresholdParameter(typePara);
			tInfo.setComparaType(compCode);
			tInfo.setThresholdValue(Integer.valueOf(compPara));
			
			autoctrlService.mdyThresholdInfo(tInfo, userId, hInfo);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("mdyThresholdInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "修改阈值失败（" + e + "）！");
		}
	}	
	  @ApiOperation(value = "删除阈值信息")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "thresholdId", value = "阈值条件ID", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "userId", value = "用户ID", required = false, paramType = "query", dataType = "String")
	    })
	@PostMapping("/delThresholdInfo")
	public void delThresholdInfo(HttpServletResponse response, String thresholdId, String userId) throws Exception {
		try {
			autoctrlService.delThresholdInfo(thresholdId, userId);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("delThresholdInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "删除阈值失败（" + e + "）！");
		}
	}
	  
	@ApiOperation(value = "查询操作组")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ghId", value = "温室ID", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/queryOperationGroup")
	public void queryOperationGroup(HttpServletResponse response, String ghId) throws Exception {
		try {
			List<OperationGroupInfo> lstOgs = autoctrlService.findOgsByGhId(ghId, false);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			for (OperationGroupInfo thresholdGroup : lstOgs) {
				JSONObject jObj2 = new JSONObject();
				jObj2.put("id", thresholdGroup.getOgBaseInfo().getOperateGroupId());
				jObj2.put("name", thresholdGroup.getOgBaseInfo().getOperateGroupName());
				jObj2.put("remark", StringUtil.getStringNotNull(thresholdGroup.getOgBaseInfo().getRemark()));
				jObj2.put("userName", StringUtil.getStringNotNull(thresholdGroup.getUseName()));
				jObj2.put("mdyTime", DateUtil.dateToString(thresholdGroup.getOgBaseInfo().getUpdateTime()));
				jArray.add(jObj2);
			}
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("queryOperationGroupAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "查询操作组失败（" + e + "）！");
		}
	}	
	  @ApiOperation(value = "添加操作组")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "ogId", value = "操作组ID", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "ogName", value ="操作组名称", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "ghId", value = "大棚id", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "remark", value = "备注", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "userId", value = "用户ID", required = false, paramType = "query", dataType = "String")
	    })
	@PostMapping("/addOperationGroupInfo")
	public void addOperationGroupInfo(HttpServletResponse response, String ogId, String ogName, String ghId, String remark, String userId) throws Exception {
		try {
			IgcsCoperationGroup ogInfo = autoctrlService.findOgBaseById(ogId);
			if (ogInfo != null) {
				returnJsonWithMsg(response, "该操作组ID已存在，请刷新后重试！");
				return;
			}
			
			ogInfo = new IgcsCoperationGroup();
			ogInfo.setOperateGroupId(ogId);
			ogInfo.setOperateGroupName(ogName);
			ogInfo.setRemark(remark);
			ogInfo.setGreenhouseId(ghId);
			ogInfo.setUpdateUserId(userId);
			ogInfo.setInDate(getCurTimestamp());
			ogInfo.setUpdateTime(getCurTimestamp());
			
			autoctrlService.addOgInfo(ogInfo);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("addOperationGroupInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "添加操作组失败（" + e + "）！");
		}
	}	
	  @ApiOperation(value = "修改操作组")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "ogId", value = "操作组ID", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "ogName", value ="操作组名称", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "remark", value = "备注", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "userId", value = "用户ID", required = false, paramType = "query", dataType = "String")
	    })
	@PostMapping("/mdyOperationGroupInfo")
	public void mdyOperationGroupInfo(HttpServletResponse response, String ogId, String ogName, String remark, String userId) throws Exception {
		try {
			IgcsCoperationGroup ogInfo = autoctrlService.findOgBaseById(ogId);
			if (ogInfo == null) {
				returnJsonWithMsg(response, "该操作组不存在，请刷新后重试！");
				return;
			}
			
			ogInfo.setOperateGroupName(ogName);
			ogInfo.setRemark(remark);
			ogInfo.setUpdateUserId(userId);
			ogInfo.setUpdateTime(getCurTimestamp());
			
			autoctrlService.modifyOgInfo(ogInfo);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("mdyOperationGroupInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "修改操作组失败（" + e + "）！");
		}
	}
	  @ApiOperation(value = "获取操作组信息")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "ogId", value = "操作组ID", required = false, paramType = "query", dataType = "String"),
	    })
	@PostMapping("/getOperationGroupInfo")
	public void getOperationGroupInfo(HttpServletResponse response, String ogId) throws Exception {
		try {
			OperationGroupInfo info = autoctrlService.findOgById(ogId);
			
			IgcsCoperationGroup ogInfo = info.getOgBaseInfo();
			if (ogInfo == null) {
				returnJsonWithMsg(response, "该操作组不存在，请刷新后重试！");	
				return;		
			}
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			JSONObject jObj1 = new JSONObject();
			jObj1.put("id", ogInfo.getOperateGroupId());
			jObj1.put("name", StringUtil.getStringNotNull(ogInfo.getOperateGroupName()));
			jObj1.put("remark", StringUtil.getStringNotNull(ogInfo.getRemark()));
			jArray.add(jObj1);
			
			List<OperationInfo> lstThresholds = info.getLstOperations();
			for (OperationInfo threshold : lstThresholds) {
				JSONObject jObj2 = new JSONObject();
				jObj2.put("id", threshold.getOperationBaseInfo().getOperateId());
				jObj2.put("gwId", threshold.getOperationBaseInfo().getGatewayId());
				jObj2.put("nodeId", threshold.getOperationBaseInfo().getNodeId());	
				jObj2.put("nodeName", threshold.getNodeName());
				jObj2.put("equipType", threshold.getOperationBaseInfo().getEquipmentTypeCode());
				jObj2.put("equipTypeName", threshold.getEquipmentTypeName());
				jObj2.put("equipId", threshold.getOperationBaseInfo().getEquipmentId());				
				jObj2.put("controlType", threshold.getOperationBaseInfo().getControlType());
				jObj2.put("controlTypeName", threshold.getControlTypeName());				
				jObj2.put("para1", StringUtil.getStringNotNull(threshold.getOperationBaseInfo().getControlParameter1()));			
				jObj2.put("para2", StringUtil.getStringNotNull(threshold.getOperationBaseInfo().getControlParameter2()));			
				jObj2.put("para3", StringUtil.getStringNotNull(threshold.getOperationBaseInfo().getControlParameter3()));
				jObj2.put("addDate", DateUtil.dateToString(threshold.getOperationBaseInfo().getInDate()));
				jArray.add(jObj2);
			}
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getOperationGroupInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "获取操作组信息失败（" + e + "）！");
		}
	}
	  @ApiOperation(value = "获取添加操作需要的信息")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "ghId", value = "温室ID", required = false, paramType = "query", dataType = "String"),
	    })
	@PostMapping("/getDatasForOperationAdd")
	public void getDatasForOperationAdd(HttpServletResponse response, String ghId) throws Exception {
		try {
			DataForOperationAdd info = autoctrlService.findDatasForOperationAdd(ghId);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			List<EquipmentInfo> lstEquip = info.getLstEquip();			
			for (EquipmentInfo equipInfo : lstEquip) {
				JSONArray aSubSensor = new JSONArray();
				
				JSONObject jObj1 = new JSONObject();
				jObj1.put("gwId", equipInfo.getAtGwId());
				jObj1.put("nodeId", equipInfo.getAtNodeId());
				jObj1.put("nodeName", StringUtil.getStringNotNull(equipInfo.getAtNodeName()));
				jObj1.put("equipType", equipInfo.getEquip().getEquipmentType());
				jObj1.put("type", equipInfo.getType());
				jObj1.put("equipTypeName", equipInfo.getEquipmentName());
				jObj1.put("equipId", equipInfo.getEquip().getEquipmentId());
				jObj1.put("equipPara", equipInfo.getEquip().getParameter());
				aSubSensor.add(jObj1);
				
				Map<String, String> mpControl = equipInfo.getMpControl();
				for (Map.Entry<String, String> ctrl : mpControl.entrySet()) {
					JSONObject jObj2 = new JSONObject();
					jObj2.put("ctrlId", ctrl.getKey());
					jObj2.put("ctrlName", ctrl.getValue());
					aSubSensor.add(jObj2);
				}
				
				jArray.add(aSubSensor);
			}			
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getDatasForOperationAddAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "获取添加操作需要的信息失败（" + e + "）！");
		}
	}	

	@ApiOperation(value = "添加操作")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "operationId", value = "操作ID", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ogId", value = "操作组ID", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gwId", value = "网关ID", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "nodeId", value = "节点ID", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "equipTypeCode", value = "控制设备类型", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "equipId", value = "控制设备ID", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "controlType", value = "操作类型编码", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "para1", value = "操作参数", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "para2", value = "操作参数", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "para3", value = "操作参数", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userId", value = "用户ID", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/addOperationInfo")
	public void addOperationInfo(HttpServletResponse response, String operationId, String ogId, String gwId, String nodeId, 
			String equipTypeCode, String equipId, String controlType, String para1, String para2, String para3, String userId) throws Exception {
		try {
			IgcsCoperation oInfo = autoctrlService.findOperationById(operationId);
			if (oInfo != null) {
				returnJsonWithMsg(response, "该操作ID已存在，请刷新后重试！");
				return;
			}
			
			if (controlType.startsWith("ALARM")) {
				IgcsInodeinfo nInfo = autoctrlService.getFirstNodeOfGh(nodeId);								
				if (nInfo == null) {
					returnJsonWithMsg(response, "该温室下没有节点，无法告警！");
					return;
				}
				gwId = nInfo.getGatewayId();
				nodeId = nInfo.getNodeId();
			}
			
			oInfo = new IgcsCoperation();
			oInfo.setOperateId(operationId);
			oInfo.setOperateGroupId(ogId);
			oInfo.setGatewayId(gwId);
			oInfo.setNodeId(nodeId);
			oInfo.setEquipmentTypeCode(equipTypeCode);
			oInfo.setEquipmentId(equipId);
			oInfo.setControlType(controlType);
			oInfo.setControlParameter1(para1);
			oInfo.setControlParameter2(para2);
			oInfo.setControlParameter3(para3);
			oInfo.setInDate(getCurTimestamp());
			
			autoctrlService.addOperationInfo(oInfo, userId);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("addOperationInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "添加操作失败（" + e + "）！");
		}
	}		
	
	@ApiOperation(value = "修改操作")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "operationId", value = "操作ID", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "nodeId", value = "节点ID", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "equipTypeCode", value = "控制设备类型", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "equipId", value = "控制设备ID", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "controlType", value = "操作类型编码", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "para1", value = "操作参数", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "para2", value = "操作参数", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "para3", value = "操作参数", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userId", value = "用户ID", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/mdyOperationInfo")
	public void mdyOperationInfo(HttpServletResponse response, String operationId, String gwId, String nodeId, 
			String equipTypeCode, String equipId, String controlType, String para1, String para2, String para3, String userId) throws Exception {
		try {
			IgcsCoperation oInfo = autoctrlService.findOperationById(operationId);
			if (oInfo == null) {
				returnJsonWithMsg(response, "该操作不存在，请刷新后重试！");
				return;
			}
			
			IgcsChoperation hInfo = autoctrlService.generateHistoryOperation(oInfo);
			
			if (controlType.startsWith("ALARM")) {
				//nodeId = getNodeIdByGwAndGh(gwId, nodeId);
				
				if (nodeId == null) {
					returnJsonWithMsg(response, "该温室下没有节点，无法告警！");
					return;
				}
			}
			
			oInfo.setGatewayId(gwId);
			oInfo.setNodeId(nodeId);
			oInfo.setEquipmentTypeCode(equipTypeCode);
			oInfo.setEquipmentId(equipId);
			oInfo.setControlType(controlType);
			oInfo.setControlParameter1(para1);
			oInfo.setControlParameter2(para2);
			oInfo.setControlParameter3(para3);
			
			autoctrlService.mdyOperationInfo(oInfo, userId, hInfo);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("mdyOperationInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "修改操作失败（" + e + "）！");
		}
	}	
	  @ApiOperation(value = "修改操作")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "operationId", value = "操作ID", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "userId", value = "用户ID", required = false, paramType = "query", dataType = "String")
	    })
	@PostMapping("/delOperationInfo")
	public void delOperationInfo(HttpServletResponse response, String operationId, String userId) throws Exception {
		try {
			autoctrlService.delOperationInfo(operationId, userId);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("delOperationInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "删除操作失败（" + e + "）！");
		}
	}
	  
	@ApiOperation(value = "删除操作组")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ogId", value = "操作组ID", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/delOperationGroupInfo")
	public void delOperationGroupInfo(HttpServletResponse response, String ogId) throws Exception {
		try {
			if (autoctrlService.ogInUse(ogId)) {
				returnJsonWithMsg(response, "该操作组被策略引用，无法删除！");
				return;
			}
			
			autoctrlService.delOgInfo(ogId);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("delOperationGroupInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "删除操作组失败（" + e + "）！");
		}
	}	
	
	  @ApiOperation(value = "获取添加策略需要的信息")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "ogId", value = "温室ID", required = false, paramType = "query", dataType = "String")
	    })
	@PostMapping("/getDatasForStrategyAdd")
	public void getDatasForStrategyAdd(HttpServletResponse response, String ghId) throws Exception {
		try {
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			List<ThresholdGroupInfo> lstTgs = autoctrlService.findTgsByGhId(ghId, false);
			JSONArray aTg = new JSONArray();
			for (ThresholdGroupInfo thresholdGroup : lstTgs) {
				JSONObject jObj1 = new JSONObject();
				jObj1.put("tgId", thresholdGroup.getTgBaseInfo().getThresholdGroupId());
				jObj1.put("tgName", thresholdGroup.getTgBaseInfo().getThresholdGroupName());
				aTg.add(jObj1);
			}
			jArray.add(aTg);
			
			List<OperationGroupInfo> lstOgs = autoctrlService.findOgsByGhId(ghId, false);
			JSONArray aOg = new JSONArray();
			for (OperationGroupInfo thresholdGroup : lstOgs) {
				JSONObject jObj1 = new JSONObject();
				jObj1.put("ogId", thresholdGroup.getOgBaseInfo().getOperateGroupId());
				jObj1.put("ogName", thresholdGroup.getOgBaseInfo().getOperateGroupName());	
				aOg.add(jObj1);
			}
			jArray.add(aOg);
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getDatasForStrategyAddAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "获取添加策略需要的信息失败（" + e + "）！");
		}
	}	
	  
	@ApiOperation(value = "查询策略")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ogId", value = "温室ID", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/queryStrategy")
	public void queryStrategy(HttpServletResponse response, String ghId) throws Exception {
		try {
			List<StrategyInfo> lstOgs = autoctrlService.findStrategyByGhId(ghId);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			for (StrategyInfo strategy : lstOgs) {
				JSONObject jObj2 = new JSONObject();
				jObj2.put("id", strategy.getBaseInfo().getStrategyId());
				jObj2.put("tgId1", strategy.getBaseInfo().getThresholdGroupId1());
				jObj2.put("tgName1", strategy.getTgName1());
				jObj2.put("tgId2", strategy.getBaseInfo().getThresholdGroupId2());
				jObj2.put("tgName2", strategy.getTgName2());
				jObj2.put("tgId3", strategy.getBaseInfo().getThresholdGroupId3());
				jObj2.put("tgName3", strategy.getTgName3());
				jObj2.put("ogId", strategy.getBaseInfo().getOperateGroupId());
				jObj2.put("ogName", strategy.getOgName());
				jObj2.put("start", DateUtil.timeToString(strategy.getBaseInfo().getExcutionStartTime()));
				jObj2.put("end", DateUtil.timeToString(strategy.getBaseInfo().getExcutionEndTime()));
				jObj2.put("userName", StringUtil.getStringNotNull(strategy.getUserName()));
				jObj2.put("mdyTime", DateUtil.dateToString(strategy.getBaseInfo().getInDate()));
				jArray.add(jObj2);
			}
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("queryStrategyAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "查询策略失败（" + e + "）！");
		}
	}	
	
	  @ApiOperation(value = "添加策略")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "strategyId", value = "操作ID", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "ghId", value = "温室ID", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "tgId1", value = "阈值条件组ID1", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "tgId2", value = "阈值条件组ID1", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "tgId3", value = "阈值条件组ID1", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "ogId", value = "操作组ID", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "start", value = "每日执行开始时间", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "end", value = "每日执行结束时间", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "userId", value = "用户ID", required = false, paramType = "query", dataType = "String")
	    })
	@PostMapping("/addStrategyInfo")
	public void addStrategyInfo(HttpServletResponse response, String strategyId, String ghId, String tgId1, String tgId2, String tgId3,
			String ogId, String start, String end, String userId) throws Exception {
		try {
			IgcsCstrategy strategyInfo = autoctrlService.findStrategyById(strategyId);
			if (strategyInfo != null) {
				returnJsonWithMsg(response, "该策略ID已存在，请刷新后重试！");
				return;
			}
			
			strategyInfo = new IgcsCstrategy();
			strategyInfo.setStrategyId(strategyId);
			strategyInfo.setGreenhouseId(ghId);
			strategyInfo.setThresholdGroupId1(tgId1);
			strategyInfo.setThresholdGroupId2(tgId2);
			strategyInfo.setThresholdGroupId3(tgId3);
			strategyInfo.setOperateGroupId(ogId);
			strategyInfo.setExcutionStartTime(DateUtil.stringToTime(start));
			strategyInfo.setExcutionEndTime(DateUtil.stringToTime(end));
			strategyInfo.setUpdateUserId(userId);
			strategyInfo.setInDate(getCurTimestamp());
//			strategyInfo.setUpdateTime(getCurTimestamp());
			
			autoctrlService.addStrategyInfo(strategyInfo);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("addStrategyInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "添加策略失败（" + e + "）！");
		}
	}	
	  @ApiOperation(value = "修改策略")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "strategyId", value = "操作ID", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "tgId1", value = "阈值条件组ID1", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "tgId2", value = "阈值条件组ID1", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "tgId3", value = "阈值条件组ID1", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "ogId", value = "操作组ID", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "start", value = "每日执行开始时间", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "end", value = "每日执行结束时间", required = false, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "userId", value = "用户ID", required = false, paramType = "query", dataType = "String")
	    })
	@PostMapping("/mdyStrategyInfo")
	public void mdyStrategyInfo(HttpServletResponse response, String strategyId, String tgId1, String tgId2, String tgId3,
			String ogId, String start, String end, String userId) throws Exception {
		try {
			IgcsCstrategy strategyInfo = autoctrlService.findStrategyById(strategyId);
			if (strategyInfo == null) {
				returnJsonWithMsg(response, "该策略不存在，请刷新后重试！");
				return;
			}
			
			IgcsChstrategy hInfo = autoctrlService.generateHistoryStrategy(strategyInfo);
			
			strategyInfo.setThresholdGroupId1(tgId1);
			strategyInfo.setThresholdGroupId2(tgId2);
			strategyInfo.setThresholdGroupId3(tgId3);
			strategyInfo.setOperateGroupId(ogId);
			strategyInfo.setExcutionStartTime(DateUtil.stringToTime(start));
			strategyInfo.setExcutionEndTime(DateUtil.stringToTime(end));
			strategyInfo.setUpdateUserId(userId);
			
			autoctrlService.mdyStrategyInfo(strategyInfo, hInfo);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("mdyStrategyInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "修改策略失败（" + e + "）！");
		}
	}	
	  @ApiOperation(value = "删除策略")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
	            @ApiImplicitParam(name = "strategyId", value = "操作ID", required = false, paramType = "query", dataType = "String")
	    })
	@PostMapping("/delStrategyInfo")
	public void delStrategyInfo(HttpServletResponse response, String strategyId) throws Exception {
		try {
			autoctrlService.delStrategyInfo(strategyId);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("delStrategyInfoAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "删除策略失败（" + e + "）！");
		}
	}	  
	  
	@PostMapping("/queryArmStrategy")
	public void queryArmStrategy(HttpServletResponse response, String ghId) throws Exception {
		try {
			List<ArmStrategyInfo> lstOgs = autoctrlService.findArmStrategyByGhId(ghId);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");		
			jArray.add(jObj0);
			
			for (ArmStrategyInfo as : lstOgs) {
	    		JSONObject jObjNode = new JSONObject();
	    		jObjNode.put("gwId", as.getGatewayId());
	    		jObjNode.put("NodeId", as.getNodeId());
	    		jObjNode.put("NodeName", as.getNodeName());
	    		jArray.add(jObjNode);
	    		
	    		JSONArray jAOne = new JSONArray();
	    		
	    		for (IgcsArmThreshold strategy : as.getLstAts()) {
					JSONObject jObj2 = new JSONObject();
					jObj2.put("id", strategy.getArmStrategyId());
					jObj2.put("armId", strategy.getThresholdId());
					jObj2.put("type", strategy.getThresholdType());
					jObj2.put("isUse", strategy.getIsUse());
					jObj2.put("startH", StringUtil.getStringNotNull(strategy.getStartHour()));
					jObj2.put("startM", StringUtil.getStringNotNull(strategy.getStartMin()));
					jObj2.put("endH", StringUtil.getStringNotNull(strategy.getEndHour()));
					jObj2.put("endM", StringUtil.getStringNotNull(strategy.getEndMin()));
					jObj2.put("sensorType", autoctrlService.getSensorNameByType(strategy.getSensorTypeCode()));
					jObj2.put("sensorId", StringUtil.getStringNotNull(strategy.getSensorId()));
					jObj2.put("sensorUnit", autoctrlService.getSensorUnitByType(strategy.getSensorTypeCode()));
					jObj2.put("compType", autoctrlService.getCompareNameByType(strategy.getCompareType()));
					jObj2.put("compPara", StringUtil.getStringNotNull(strategy.getComparePara()));
					jObj2.put("equipType", autoctrlService.getEquipNameByType(strategy.getEquipmentType()));
					jObj2.put("equipId", StringUtil.getStringNotNull(strategy.getEquipmentId()));
					jObj2.put("opertType", autoctrlService.getControlNameByType(strategy.getOperateType()));
					jObj2.put("opertPara", StringUtil.getStringNotNull(strategy.getOperatePara()));
					jAOne.add(jObj2);
				}
				
				jArray.add(jAOne);
	    	}

			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("queryArmStrategyAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "查询下位机策略失败（" + e + "）！");
		}
	}	
	
	@PostMapping("/setTimeThreshold")
	public void setTimeThreshold(HttpServletResponse response, String tradeId, String strategyId, 
			String isUse, String startHour, String startMin, String operPara, String userId) throws Exception {
		try {
			User userInfo = userService.findUserById(userId);
			if (userInfo == null) {
				returnJsonWithMsg(response, "用户ID不存在，请重新登录后重试！");
				return;
			}
			
			IgcsArmThreshold curArm = autoctrlService.findArmStrategyById(strategyId);
			if (curArm == null) {
				returnJsonWithMsg(response, "下位机策略不存在，请重试！");
				return;
			}
			
			IgcsBTrade info = new IgcsBTrade();
			
			info.setTradeId(tradeId);
			info.setGatewayId(curArm.getGatewayId());
			info.setNodeId(curArm.getNodeId());
			info.setEquipmentTypeCode(curArm.getEquipmentType());
			info.setEquipmentId(curArm.getEquipmentId());
			info.setControlType("SetTimeThreshold");
			info.setControlParameter1("{" + curArm.getThresholdId() + "," + isUse + "}");	
			info.setControlParameter2("{" + startHour + "," + startMin + "}");	
			Integer opeType = autoctrlService.getArmOperateType(curArm.getEquipmentType(), curArm.getOperateType());
			info.setControlParameter3("{" + opeType + "," + operPara + "}");	
			info.setInsertWay("0");
			info.setUserId(userId);
			info.setInsertTime(getCurTimestamp());
			info.setPreDealTime(getCurTimestamp());
			info.setDealCount(0);
			info.setIsDeal("0");
			
			operationService.addTrade(info);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("setTimeThresholdAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "添加设置下位机时间控制策略失败（" + e + "）！");
		}
	}
	
	@PostMapping("/checkSetTimeThreshold")
	public void checkSetTimeThreshold(HttpServletResponse response, String tradeId, String strategyId,
			String isUse, String startHour, String startMin, String operPara) throws Exception {
		try {			
			IgcsBTrade info = operationService.findTradeById(tradeId);

			String result = info.getIsDeal();
			
			// 成功，修改下位机策略
			if (result.equals("1")) {
				IgcsArmThreshold curArm = autoctrlService.findArmStrategyById(strategyId);
				curArm.setIsUse(Integer.valueOf(isUse));
				curArm.setStartHour(Integer.valueOf(startHour));
				curArm.setStartMin(Integer.valueOf(startMin));
				curArm.setOperatePara(Integer.valueOf(operPara));
				autoctrlService.modifyArmThreshold(curArm);
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
			log.error("checkSetTimeThresholdAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "获取修改下位机策略结果失败（" + e + "）！");
		}
	}
	
	@PostMapping("/setValueThreshold")
	public void setValueThreshold(HttpServletResponse response, String tradeId, String strategyId, 
			String isUse, String startHour, String startMin, String endHour, String endMin, 
			String compPara, String operPara, String userId) throws Exception {
		try {
			User userInfo = userService.findUserById(userId);
			if (userInfo == null) {
				returnJsonWithMsg(response, "用户ID不存在，请重新登录后重试！");
				return;
			}
			
			IgcsArmThreshold curArm = autoctrlService.findArmStrategyById(strategyId);
			if (curArm == null) {
				returnJsonWithMsg(response, "下位机策略不存在，请重试！");
				return;
			}
			
			IgcsBTrade info = new IgcsBTrade();
			
			info.setTradeId(tradeId);
			info.setGatewayId(curArm.getGatewayId());
			info.setNodeId(curArm.getNodeId());
			info.setEquipmentTypeCode(curArm.getEquipmentType());
			info.setEquipmentId(curArm.getEquipmentId());
			info.setControlType("SetValueThreshold");
			info.setControlParameter1("{" + curArm.getThresholdId() + "," + isUse + "}");
			info.setControlParameter2("{[" + startHour + "," + startMin + "],[" + endHour + "," + endMin + "]}");	
			Integer opeType = autoctrlService.getArmOperateType(curArm.getEquipmentType(), curArm.getOperateType());
			info.setControlParameter3("{[" + autoctrlService.getSensorArmIdByType(curArm.getSensorTypeCode()) + "," + curArm.getSensorId() + "],[" 
					+ autoctrlService.getCompArmIdByType(curArm.getCompareType()) + "," + compPara + "],["
					+ opeType + "," + operPara +"]}");	
			
			info.setInsertWay("0");
			info.setUserId(userId);
			info.setInsertTime(getCurTimestamp());
			info.setPreDealTime(getCurTimestamp());
			info.setDealCount(0);
			info.setIsDeal("0");
			
			operationService.addTrade(info);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("setValueThresholdAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "添加设置下位机阈值控制策略失败（" + e + "）！");
		}
	}
	
	@PostMapping("/checkSetValueThreshold")
	public void checkSetValueThreshold(HttpServletResponse response, String tradeId, String strategyId,
			String isUse, String startHour, String startMin, String endHour, String endMin, 
			String compPara, String operPara) throws Exception {
		try {			
			IgcsBTrade info = operationService.findTradeById(tradeId);

			String result = info.getIsDeal();
			
			// 成功，修改下位机策略
			if (result.equals("1")) {
				IgcsArmThreshold curArm = autoctrlService.findArmStrategyById(strategyId);
				curArm.setIsUse(Integer.valueOf(isUse));
				curArm.setStartHour(Integer.valueOf(startHour));
				curArm.setStartMin(Integer.valueOf(startMin));
				curArm.setEndHour(Integer.valueOf(endHour));
				curArm.setEndMin(Integer.valueOf(endMin));
				curArm.setComparePara(Integer.valueOf(compPara));
				curArm.setOperatePara(Integer.valueOf(operPara));
				autoctrlService.modifyArmThreshold(curArm);
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
			log.error("checkSetValueThresholdAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "获取修改下位机阈值策略结果失败（" + e + "）！");
		}
	}
	
	@PostMapping("/getTimeThreshold")
	public void getTimeThreshold(HttpServletResponse response, String tradeId, String strategyId, String userId) throws Exception {
		try {
			User userInfo = userService.findUserById(userId);
			if (userInfo == null) {
				returnJsonWithMsg(response, "用户ID不存在，请重新登录后重试！");
				return;
			}
			
			IgcsArmThreshold curArm = autoctrlService.findArmStrategyById(strategyId);
			if (curArm == null) {
				returnJsonWithMsg(response, "下位机策略不存在，请重试！");
				return;
			}
			
			IgcsBTrade info = new IgcsBTrade();
			
			info.setTradeId(tradeId);
			info.setGatewayId(curArm.getGatewayId());
			info.setNodeId(curArm.getNodeId());
			info.setEquipmentTypeCode(curArm.getEquipmentType());
			info.setEquipmentId(curArm.getEquipmentId());
			info.setControlType("GetTimeThreshold");
			info.setControlParameter1(curArm.getThresholdId().toString());
			info.setInsertWay("0");
			info.setUserId(userId);
			info.setInsertTime(getCurTimestamp());
			info.setPreDealTime(getCurTimestamp());
			info.setDealCount(0);
			info.setIsDeal("0");
			
			operationService.addTrade(info);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("getTimeThresholdAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "获取下位机时间控制策略失败（" + e + "）！");
		}
	}
	
	@PostMapping("/checkGetTimeThreshold")
	public void checkGetTimeThreshold(HttpServletResponse response, String tradeId) throws Exception {
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
			log.error("checkGetTimeThresholdAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "获取下位机时间策略结果失败（" + e + "）！");
		}
	}
	
	@PostMapping("/getValueThreshold")
	public void getValueThreshold(HttpServletResponse response, String tradeId, String strategyId, String userId) throws Exception {
		try {
			User userInfo = userService.findUserById(userId);
			if (userInfo == null) {
				returnJsonWithMsg(response, "用户ID不存在，请重新登录后重试！");
				return;
			}
			
			IgcsArmThreshold curArm = autoctrlService.findArmStrategyById(strategyId);
			if (curArm == null) {
				returnJsonWithMsg(response, "下位机策略不存在，请重试！");
				return;
			}
			
			IgcsBTrade info = new IgcsBTrade();
			
			info.setTradeId(tradeId);
			info.setGatewayId(curArm.getGatewayId());
			info.setNodeId(curArm.getNodeId());
			info.setEquipmentTypeCode(curArm.getEquipmentType());
			info.setEquipmentId(curArm.getEquipmentId());
			info.setControlType("GetValueThreshold");
			info.setControlParameter1(curArm.getThresholdId().toString());
			info.setInsertWay("0");
			info.setUserId(userId);
			info.setInsertTime(getCurTimestamp());
			info.setPreDealTime(getCurTimestamp());
			info.setDealCount(0);
			info.setIsDeal("0");
			
			operationService.addTrade(info);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("getValueThresholdAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "获取下位机阈值控制策略失败（" + e + "）！");
		}
	}
	
	@PostMapping("/checkGetValueThreshold")
	public void checkGetValueThreshold(HttpServletResponse response, String tradeId) throws Exception {
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
			log.error("checkGetValueThresholdAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "获取下位机阈值策略结果失败（" + e + "）！");
		}
	}
	
	@PostMapping("/addTrade")
	public void addTrade(HttpServletResponse response, String tradeId, String gwId, 
			String nodeId, String equiType, String equiId, String userId, String controlType) throws Exception {
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
			info.setInsertWay("0");
			info.setUserId(userId);
			info.setInsertTime(getCurTimestamp());
			info.setPreDealTime(getCurTimestamp());
			info.setDealCount(0);
			info.setIsDeal("0");
			
			operationService.addTrade(info);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("addTradeAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "添加trade失败（" + e + "）！");
		}
	}
	
	@PostMapping("/addTradeEx")
	public void addTradeEx(HttpServletResponse response, String tradeId, String gwId, 
			String nodeId, String equiType, String equiId, String userId, String controlType,
			String para1, String para2, String para3) throws Exception {
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
			info.setInsertWay("0");
			info.setUserId(userId);
			info.setInsertTime(getCurTimestamp());
			info.setPreDealTime(getCurTimestamp());
			info.setDealCount(0);
			info.setIsDeal("0");
			
			operationService.addTrade(info);
			
			returnJsonWithMsg(response, SUCCESS);
		} catch (Exception e) {
			log.error("addTradeExAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "添加带参数trade失败（" + e + "）！");
		}
	}
	
	@PostMapping("/checkTradeResult")
	public void checkTradeResult(HttpServletResponse response, String tradeId) throws Exception {
		try {			
			IgcsBTrade info = operationService.findTradeById(tradeId);

			String result = info.getIsDeal();
			
			// 成功
			if (result.equals("1")) {
				if (tradeId.startsWith("a_")) { // SetTimeLimit需要修改igcs_i_equipment
					operationService.modifyEquipmentTimeLimit(info);
				} else if (tradeId.startsWith("d_")) { // SetEncoder需要修改igcs_i_equipment
					operationService.modifyEquipmentEncoder(info);
				}
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
			returnJsonWithMsg(response, "获取trade结果失败（" + e + "）！");
		}
	}
	@ApiOperation(value = "查询病毒诊断列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ghId", value = "温室ID", required = false, paramType = "query", dataType = "String") })
	@PostMapping("/queryDiagnosisGroup")
	public void queryDiagnosisGroup(HttpServletResponse response, String ghId, String status) throws Exception {
		try {
			//测试程序
			List<DiagnosisInfo> lstTgs = new ArrayList<>();

			System.out.println(status);
			if(status.equals("未采集或采集中")){
				lstTgs.add(new DiagnosisInfo("11111","011","2009-01-01","2009-01-05",0,"实验采集",5,0,""));
				lstTgs.add(new DiagnosisInfo("11112","011","2009-01-02","2009-01-06",0,"预防xx病发病的概率>90%",6,0,""));
				lstTgs.add(new DiagnosisInfo("11113","011","2009-01-03","2009-01-07",1,"实验采集",7,3,""));
			}else{
				lstTgs.add(new DiagnosisInfo("11114","011","2009-01-04","2009-01-09",2,"实验采集",8,8,"2009-01-09"));
				lstTgs.add(new DiagnosisInfo("11115","011","2009-01-05","2009-01-10",3,"实验采集",9,9,"2009-01-09"));
			}

			JSONArray jArray = new JSONArray();

			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");
			jArray.add(jObj0);

			for (DiagnosisInfo diagnosisInfo : lstTgs) {
				JSONObject jObj2 = new JSONObject();
				jObj2.put("dgId", diagnosisInfo.getDgId());
				jObj2.put("dgHouseId", diagnosisInfo.getDgHouseId());
				jObj2.put("dgInDate", diagnosisInfo.getDgInDate());
				jObj2.put("dgPreFinDate", diagnosisInfo.getDgPreFinDate());
				jObj2.put("dgStatus", diagnosisInfo.getDgStatus());
				jObj2.put("dgReason", diagnosisInfo.getDgReason());
				jObj2.put("dgPlanNum", diagnosisInfo.getDgPlanNum());
				jObj2.put("dgRealNum", diagnosisInfo.getDgRealNum());
				jObj2.put("dgFinDate", diagnosisInfo.getDgFinDate());
				System.out.println(diagnosisInfo.getDgFinDate());
				jArray.add(jObj2);
			}

			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("queryThresholdGroupAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "查询阈值组失败（" + e + "）！");
		}
	}

}

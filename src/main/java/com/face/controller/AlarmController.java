package com.face.controller;

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
import com.face.model.IgcsBAlarm;
import com.face.service.IAlarmService;
import com.face.utils.DateUtil;
import com.face.utils.StringUtil;

@RestController
@RequestMapping("/alarm")
public class AlarmController extends LoginController {
	private static final Log log = LogFactory.getLog(AlarmController.class);
	
	@Autowired
	private IAlarmService alarmService;
	
	@PostMapping("/getNewAlarmByUserId")
	public void getNewAlarmByUserId(HttpServletResponse response, String userId) throws Exception {
		try {
			List<IgcsBAlarm> LstAlarm = alarmService.findNewByUserId(userId);
			
			JSONArray jArray = new JSONArray();
			
			JSONObject jObj0 = new JSONObject();
			jObj0.put("message", "success");			
			jArray.add(jObj0);
			
			for (IgcsBAlarm aInfo : LstAlarm) {
				JSONObject jObj2 = new JSONObject();
				jObj2.put("aId", aInfo.getAlarmLogId());
				jObj2.put("aMessage", StringUtil.getStringNotNull(aInfo.getAlarmMessage()));	
				jObj2.put("aTime", DateUtil.dateToString(aInfo.getInsertTime()));
				jArray.add(jObj2);
			}
			
			returnJsonArray(response, jArray);
		} catch (Exception e) {
			log.error("getNewAlarmByUserIdAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "获取最新告警信息失败（" + e + "）！");
		}
	}
	
	@PostMapping("/reportAlarmRead")
	public void reportAlarmRead(HttpServletResponse response, String alarmIds) throws Exception {
		try {
			String[] aIdArray = alarmIds.split(",");
			
			alarmService.updateByAlarmIds(aIdArray);
			
			returnJsonWithMsg(response, "success");
		} catch (Exception e) {
			log.error("reportAlarmReadAction error:", e);
			e.printStackTrace();
			returnJsonWithMsg(response, "更新告警已读失败（" + e + "）！");
		}
	}
}

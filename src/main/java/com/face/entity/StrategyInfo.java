package com.face.entity;

import com.face.model.IgcsCstrategy;
import com.face.utils.DateUtil;
import com.face.utils.StringUtil;

public class StrategyInfo {
	private IgcsCstrategy baseInfo;
	
	private String userName;
	private String tgName1;
	private String tgName2;
	private String tgName3;
	private String ogName;

	public IgcsCstrategy getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(IgcsCstrategy baseInfo) {
		this.baseInfo = baseInfo;
	}

	public String getUserName() {
		return StringUtil.getStringNotNull(userName);
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTgName1() {
		return tgName1;
	}

	public void setTgName1(String tgName1) {
		this.tgName1 = tgName1;
	}

	public String getTgName2() {
		return tgName2;
	}

	public void setTgName2(String tgName2) {
		this.tgName2 = tgName2;
	}

	public String getTgName3() {
		return tgName3;
	}

	public void setTgName3(String tgName3) {
		this.tgName3 = tgName3;
	}

	public String getOgName() {
		return ogName;
	}

	public void setOgName(String ogName) {
		this.ogName = ogName;
	}
	
	public String getStartString() {
		return DateUtil.timeToString(getBaseInfo().getExcutionStartTime());
	}
	
	public String getEndString() {
		return DateUtil.timeToString(getBaseInfo().getExcutionEndTime());
	}
	
	public String getMdyTimeString() {
		return DateUtil.dateToString(getBaseInfo().getInDate());
	}
	
	public String getRemarkString() {
		String str = "从 " + getStartString() + " 到 " + getEndString() + " ，当满足阈值组条件 '" + getTgName1() + "' ";
		if (tgName2 != null) {
			str += "或 '" + getTgName2() + "' ";
		}
		if (tgName3 != null) {
			str += "或 '" + getTgName3() + "' ";
		}
		str += "时，执行操作组 '" + getOgName() + "'";
		return str;
	}

}

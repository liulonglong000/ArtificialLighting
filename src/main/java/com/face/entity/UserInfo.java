package com.face.entity;

import com.face.model.User;
import com.face.utils.DateUtils;
import com.face.utils.StringUtil;

public class UserInfo {
	private String userId; 		// 用户ID，登录网站ID
	private String userName; 	// 用户姓名
	private String parkInfo;
	private String phoneNo; 	// 电话号码
	private String logoAddr; 	// 存储用户头像图片存储位置
	private String addTime; 	// 创建时间

	public UserInfo(User info) throws Exception {
		this.userId = info.getUsername();
        this.logoAddr = StringUtil.getStringForDL(info.getLogoAddr());
        this.userName = StringUtil.getStringNotNull(info.getTruename());
        this.phoneNo = StringUtil.getStringNotNull(info.getPhone());
        this.addTime = DateUtils.getDateStr(info.getCreateTime());
        this.parkInfo = StringUtil.getStringNotNull(info.getParkDesp());
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getParkInfo() {
		return parkInfo;
	}

	public void setParkInfo(String parkInfo) {
		this.parkInfo = parkInfo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getLogoAddr() {
		return logoAddr;
	}

	public void setLogoAddr(String logoAddr) {
		this.logoAddr = logoAddr;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
}

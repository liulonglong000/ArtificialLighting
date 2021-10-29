package com.face.entity;

import com.face.model.IgcsIparkinfo;

public class Parkinfo {
	private IgcsIparkinfo baseInfo;
	private String userName;

	public IgcsIparkinfo getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(IgcsIparkinfo baseInfo) {
		this.baseInfo = baseInfo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}

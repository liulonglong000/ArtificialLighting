package com.face.entity;

import com.face.model.IgcsIparkinfo;
import com.face.utils.DateUtils;
import com.face.utils.StringUtil;

public class ParkWebInfo {
	private String parkId;
	private String parkName;
	private String parkAddr;
	private String parkRemark;
	private String addTime;
	private String userName;
	private String picPath;
	private Integer area;
	
	public ParkWebInfo(Parkinfo info) throws Exception {
		this.parkId = info.getBaseInfo().getParkId();
        this.parkName = StringUtil.getStringNotNull(info.getBaseInfo().getParkName());
        this.parkAddr = StringUtil.getStringNotNull(info.getBaseInfo().getParkAddr());
        this.parkRemark = StringUtil.getStringNotNull(info.getBaseInfo().getRemark());
        this.addTime = DateUtils.getDateStr(info.getBaseInfo().getInDate());
        this.picPath = StringUtil.getStringForDL(info.getBaseInfo().getParkPic());
        this.userName = StringUtil.getStringNotNull(info.getUserName());
        this.area = info.getBaseInfo().getParkArea();
	}

	public ParkWebInfo(IgcsIparkinfo info) {
		this.parkId = info.getParkId();
        this.parkName = StringUtil.getStringNotNull(info.getParkName());
        this.parkAddr = StringUtil.getStringNotNull(info.getParkAddr());
        this.parkRemark = StringUtil.getStringNotNull(info.getRemark());
        this.addTime = DateUtils.getDateStr(info.getInDate());
        this.area = info.getParkArea();
	}

	public String getParkId() {
		return parkId;
	}

	public void setParkId(String parkId) {
		this.parkId = parkId;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getParkAddr() {
		return parkAddr;
	}

	public void setParkAddr(String parkAddr) {
		this.parkAddr = parkAddr;
	}

	public String getParkRemark() {
		return parkRemark;
	}

	public void setParkRemark(String parkRemark) {
		this.parkRemark = parkRemark;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}
	
	public String getInfo() {
        if (parkAddr.length() == 0 && parkRemark.length() == 0) {
            return "暂无描述信息";
        }
        if (parkAddr.length() == 0) {
            return parkRemark;
        }
        if (parkRemark.length() == 0) {
            return parkAddr;
        }
        return parkAddr + "，" + parkRemark;
    }

    public String getAreaString() {
        if (area == null) {
            return "未知";
        }
        return area + "亩";
    }
}

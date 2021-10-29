package com.face.model;

import java.sql.Timestamp;

public class IgcsIparkinfo {
	
	private String parkId;			// 园区ID
	private String parkName;		// 园区名称
	private Timestamp inDate;		// 园区加入时间
	private String parkAddr;		// 园区地址
	private String parkPic;			// 园区图片存储位置
	private Integer parkArea;		// 占地面积
	private String userId;			// 园区管理员
	private String remark;			// 备注

	// Constructors

	/** default constructor */
	public IgcsIparkinfo() {
	}

	/** full constructor */
	public IgcsIparkinfo(String parkName, Timestamp inDate, String parkAddr, String parkPic, Integer parkArea,
			String userId, String remark) {
		this.parkName = parkName;
		this.inDate = inDate;
		this.parkAddr = parkAddr;
		this.parkPic = parkPic;
		this.parkArea = parkArea;
		this.userId = userId;
		this.remark = remark;
	}

	// Property accessors

	public String getParkId() {
		return this.parkId;
	}

	public void setParkId(String parkId) {
		this.parkId = parkId;
	}

	public String getParkName() {
		return this.parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public Timestamp getInDate() {
		return this.inDate;
	}

	public void setInDate(Timestamp inDate) {    	
		this.inDate = inDate;
	}

	public String getParkAddr() {
		return this.parkAddr;
	}

	public void setParkAddr(String parkAddr) {
		this.parkAddr = parkAddr;
	}

	public String getParkPic() {
		return this.parkPic;
	}

	public void setParkPic(String parkPic) {
		this.parkPic = parkPic;
	}

	public Integer getParkArea() {
		return this.parkArea;
	}

	public void setParkArea(Integer parkArea) {
		this.parkArea = parkArea;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
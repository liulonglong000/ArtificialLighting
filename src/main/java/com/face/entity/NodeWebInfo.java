package com.face.entity;

import com.face.model.IgcsInodeinfo;
import com.face.utils.DateUtils;
import com.face.utils.StringUtil;

public class NodeWebInfo {
	private String nodeId;
	private String gwId;
	private String ghId;
	private String nodeName;
	private String nodeAddr;
	private String addTime;
	private String connectTime;
	private String remark;
	private String status;
	private String picPath;
	private Integer frequency;
	
	public NodeWebInfo(IgcsInodeinfo info) throws Exception {
		this.nodeId = info.getNodeId();
        this.gwId = info.getGatewayId();
        this.ghId = info.getGreenhouseId();
        this.nodeName = StringUtil.getStringNotNull(info.getNodeName());
        this.nodeAddr = StringUtil.getStringNotNull(info.getNodeAddr());
        this.addTime = DateUtils.getDateStr(info.getInDate());
        this.connectTime = DateUtils.getDateStr(info.getLastConnectTime());
        this.remark = StringUtil.getStringNotNull(info.getRemark());
        this.picPath = StringUtil.getStringForDL(info.getNodePic());
        this.frequency = info.getFrequency();
		if (StringUtil.getStringNotNull(info.getStatus()).equals("0")) {
			this.status = "在线";
		} else {
			this.status = "不在线";
		}		
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getGwId() {
		return gwId;
	}

	public void setGwId(String gwId) {
		this.gwId = gwId;
	}

	public String getGhId() {
		return ghId;
	}

	public void setGhId(String ghId) {
		this.ghId = ghId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getNodeAddr() {
		return nodeAddr;
	}

	public void setNodeAddr(String nodeAddr) {
		this.nodeAddr = nodeAddr;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getConnectTime() {
		return connectTime;
	}

	public void setConnectTime(String connectTime) {
		this.connectTime = connectTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	
	public String getFrequencyString() {
        if (frequency == null) {
            return "未知";
        }
        return frequency + "分钟";
    }
	
	public String getFrequencyData() {
		if (frequency == null) {
			return "";
		}
		return frequency + "";
	}
}

package com.face.entity;

import java.util.List;

import com.face.model.IgcsArmThreshold;
import com.face.model.IgcsInodeinfo;
import com.face.utils.StringUtil;

public class ArmStrategyInfo {
	private String gatewayId;
	private String nodeId;
	private String nodeName;
	private List<IgcsArmThreshold> lstAts;

	public ArmStrategyInfo(IgcsInodeinfo nInfo) {
		this.setGatewayId(nInfo.getGatewayId());
		this.setNodeId(nInfo.getNodeId());
		this.setNodeName(nInfo.getNodeName());
	}

	public String getGatewayId() {
		return gatewayId;
	}

	public void setGatewayId(String gatewayId) {
		this.gatewayId = gatewayId;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeName() {
		return StringUtil.getStringNotNull(nodeName);
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public List<IgcsArmThreshold> getLstAts() {
		return lstAts;
	}

	public void setLstAts(List<IgcsArmThreshold> lstAts) {
		this.lstAts = lstAts;
	}
}

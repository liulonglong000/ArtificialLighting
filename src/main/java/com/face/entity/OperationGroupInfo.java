package com.face.entity;

import java.util.List;

import com.face.model.IgcsCoperationGroup;
import com.face.utils.DateUtil;
import com.face.utils.StringUtil;

public class OperationGroupInfo {
	private IgcsCoperationGroup ogBaseInfo;
	private String useName;
	private List<OperationInfo> LstOperations;

	public IgcsCoperationGroup getOgBaseInfo() {
		return ogBaseInfo;
	}

	public void setOgBaseInfo(IgcsCoperationGroup ogBaseInfo) {
		this.ogBaseInfo = ogBaseInfo;
	}

	public String getUseName() {
		return useName;
	}

	public void setUseName(String useName) {
		this.useName = useName;
	}

	public List<OperationInfo> getLstOperations() {
		return LstOperations;
	}

	public void setLstOperations(List<OperationInfo> lstOperations) {
		LstOperations = lstOperations;
	}
	
	public String getIdString() {
		return getOgBaseInfo().getOperateGroupId();
	}
	
	public String getNameString() {
		return StringUtil.getStringNotNull(getOgBaseInfo().getOperateGroupName());
	}
	
	public String getRemarkString() {
		return StringUtil.getStringNotNull(getOgBaseInfo().getRemark());
	}
	
	public String getUserNameString() {
		return StringUtil.getStringNotNull(useName);
	}
	
	public String getMdyTimeString() {
		return DateUtil.dateToString(getOgBaseInfo().getUpdateTime());
	}
}

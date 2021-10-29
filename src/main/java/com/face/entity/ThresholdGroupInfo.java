package com.face.entity;

import java.util.List;

import com.face.model.IgcsCthresholdGroup;
import com.face.utils.DateUtil;
import com.face.utils.StringUtil;

public class ThresholdGroupInfo {
	private IgcsCthresholdGroup tgBaseInfo;
	private String useName;
	private List<ThresholdInfo> lstThresholds;

	public IgcsCthresholdGroup getTgBaseInfo() {
		return tgBaseInfo;
	}

	public void setTgBaseInfo(IgcsCthresholdGroup tgBaseInfo) {
		this.tgBaseInfo = tgBaseInfo;
	}

	public List<ThresholdInfo> getLstThresholds() {
		return lstThresholds;
	}

	public void setLstThresholds(List<ThresholdInfo> lstThresholds) {
		this.lstThresholds = lstThresholds;
	}

	public String getUseName() {
		return useName;
	}

	public void setUseName(String useName) {
		this.useName = useName;
	}
	
	public String getIdString() {
		return getTgBaseInfo().getThresholdGroupId();
	}
	
	public String getNameString() {
		return StringUtil.getStringNotNull(getTgBaseInfo().getThresholdGroupName());
	}
	
	public String getRemarkString() {
		return StringUtil.getStringNotNull(getTgBaseInfo().getRemark());
	}
	
	public String getUserNameString() {
		return StringUtil.getStringNotNull(useName);
	}
	
	public String getMdyTimeString() {
		return DateUtil.dateToString(getTgBaseInfo().getUpdateTime());
	}
 }

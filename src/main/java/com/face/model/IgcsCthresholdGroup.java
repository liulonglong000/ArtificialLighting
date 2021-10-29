package com.face.model;

import java.util.Date;

public class IgcsCthresholdGroup {
    private String thresholdGroupId;

    private String thresholdGroupName;

    private String greenhouseId;

    private String updateUserId;

    private Date inDate;

    private Date updateTime;

    private String remark;

    public String getThresholdGroupId() {
        return thresholdGroupId;
    }

    public void setThresholdGroupId(String thresholdGroupId) {
        this.thresholdGroupId = thresholdGroupId == null ? null : thresholdGroupId.trim();
    }

    public String getThresholdGroupName() {
        return thresholdGroupName;
    }

    public void setThresholdGroupName(String thresholdGroupName) {
        this.thresholdGroupName = thresholdGroupName == null ? null : thresholdGroupName.trim();
    }

    public String getGreenhouseId() {
        return greenhouseId;
    }

    public void setGreenhouseId(String greenhouseId) {
        this.greenhouseId = greenhouseId == null ? null : greenhouseId.trim();
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
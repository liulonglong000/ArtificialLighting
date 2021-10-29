package com.face.model;

import java.util.Date;

public class IgcsCoperationGroup {
    private String operateGroupId;

    private String operateGroupName;

    private String greenhouseId;

    private String updateUserId;

    private Date inDate;

    private Date updateTime;

    private String remark;

    public String getOperateGroupId() {
        return operateGroupId;
    }

    public void setOperateGroupId(String operateGroupId) {
        this.operateGroupId = operateGroupId == null ? null : operateGroupId.trim();
    }

    public String getOperateGroupName() {
        return operateGroupName;
    }

    public void setOperateGroupName(String operateGroupName) {
        this.operateGroupName = operateGroupName == null ? null : operateGroupName.trim();
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
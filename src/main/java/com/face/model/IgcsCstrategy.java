package com.face.model;

import java.util.Date;

public class IgcsCstrategy {
    private String strategyId;

    private String greenhouseId;

    private String thresholdGroupId1;

    private String thresholdGroupId2;

    private String thresholdGroupId3;

    private String operateGroupId;

    private Date inDate;

    private String updateUserId;

    private Date excutionStartTime;

    private Date excutionEndTime;

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId == null ? null : strategyId.trim();
    }

    public String getGreenhouseId() {
        return greenhouseId;
    }

    public void setGreenhouseId(String greenhouseId) {
        this.greenhouseId = greenhouseId == null ? null : greenhouseId.trim();
    }

    public String getThresholdGroupId1() {
        return thresholdGroupId1;
    }

    public void setThresholdGroupId1(String thresholdGroupId1) {
        this.thresholdGroupId1 = thresholdGroupId1 == null ? null : thresholdGroupId1.trim();
    }

    public String getThresholdGroupId2() {
        return thresholdGroupId2;
    }

    public void setThresholdGroupId2(String thresholdGroupId2) {
        this.thresholdGroupId2 = thresholdGroupId2 == null ? null : thresholdGroupId2.trim();
    }

    public String getThresholdGroupId3() {
        return thresholdGroupId3;
    }

    public void setThresholdGroupId3(String thresholdGroupId3) {
        this.thresholdGroupId3 = thresholdGroupId3 == null ? null : thresholdGroupId3.trim();
    }

    public String getOperateGroupId() {
        return operateGroupId;
    }

    public void setOperateGroupId(String operateGroupId) {
        this.operateGroupId = operateGroupId == null ? null : operateGroupId.trim();
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    public Date getExcutionStartTime() {
        return excutionStartTime;
    }

    public void setExcutionStartTime(Date excutionStartTime) {
        this.excutionStartTime = excutionStartTime;
    }

    public Date getExcutionEndTime() {
        return excutionEndTime;
    }

    public void setExcutionEndTime(Date excutionEndTime) {
        this.excutionEndTime = excutionEndTime;
    }
}
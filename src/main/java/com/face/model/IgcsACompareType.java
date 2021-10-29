package com.face.model;

import java.util.Date;

public class IgcsACompareType {
    private String compareType;

    private String compareTypeName;

    private Date inDate;

    private String remark;

    private Integer orderId;

    private Integer armCompareTypeId;

    public String getCompareType() {
        return compareType;
    }

    public void setCompareType(String compareType) {
        this.compareType = compareType == null ? null : compareType.trim();
    }

    public String getCompareTypeName() {
        return compareTypeName;
    }

    public void setCompareTypeName(String compareTypeName) {
        this.compareTypeName = compareTypeName == null ? null : compareTypeName.trim();
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getArmCompareTypeId() {
        return armCompareTypeId;
    }

    public void setArmCompareTypeId(Integer armCompareTypeId) {
        this.armCompareTypeId = armCompareTypeId;
    }
}
package com.face.model;

import java.util.Date;

public class IgcsAThresholdType {
    private String thresholdTypeCode;

    private String thresholdTypeName;

    private Date inDate;

    private String remark;

    private Integer orderId;

    public String getThresholdTypeCode() {
        return thresholdTypeCode;
    }

    public void setThresholdTypeCode(String thresholdTypeCode) {
        this.thresholdTypeCode = thresholdTypeCode == null ? null : thresholdTypeCode.trim();
    }

    public String getThresholdTypeName() {
        return thresholdTypeName;
    }

    public void setThresholdTypeName(String thresholdTypeName) {
        this.thresholdTypeName = thresholdTypeName == null ? null : thresholdTypeName.trim();
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
}
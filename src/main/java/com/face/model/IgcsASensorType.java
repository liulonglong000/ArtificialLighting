package com.face.model;

import java.util.Date;

public class IgcsASensorType {
    private String sensorTypeCode;

    private String sensorTypeName;

    private Date inDate;

    private String remark;

    private Integer orderId;

    private String sensorUnit;

    private Integer armSensorTypeId;

    public String getSensorTypeCode() {
        return sensorTypeCode;
    }

    public void setSensorTypeCode(String sensorTypeCode) {
        this.sensorTypeCode = sensorTypeCode == null ? null : sensorTypeCode.trim();
    }

    public String getSensorTypeName() {
        return sensorTypeName;
    }

    public void setSensorTypeName(String sensorTypeName) {
        this.sensorTypeName = sensorTypeName == null ? null : sensorTypeName.trim();
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

    public String getSensorUnit() {
        return sensorUnit;
    }

    public void setSensorUnit(String sensorUnit) {
        this.sensorUnit = sensorUnit == null ? null : sensorUnit.trim();
    }

    public Integer getArmSensorTypeId() {
        return armSensorTypeId;
    }

    public void setArmSensorTypeId(Integer armSensorTypeId) {
        this.armSensorTypeId = armSensorTypeId;
    }
}
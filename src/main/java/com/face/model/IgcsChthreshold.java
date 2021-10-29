package com.face.model;

import java.util.Date;

public class IgcsChthreshold {
    private String thresholdId;

    private String thresholdGroupId;

    private String gatewayId;

    private String nodeId;

    private String sensorTypeCode;

    private String sensorId;

    private String thresholdTypeCode;

    private String thresholdParameter;

    private String comparaType;

    private Integer thresholdValue;

    private Date inDate;

    private Date updateTime;

    public String getThresholdId() {
        return thresholdId;
    }

    public void setThresholdId(String thresholdId) {
        this.thresholdId = thresholdId == null ? null : thresholdId.trim();
    }

    public String getThresholdGroupId() {
        return thresholdGroupId;
    }

    public void setThresholdGroupId(String thresholdGroupId) {
        this.thresholdGroupId = thresholdGroupId == null ? null : thresholdGroupId.trim();
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId == null ? null : gatewayId.trim();
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId == null ? null : nodeId.trim();
    }

    public String getSensorTypeCode() {
        return sensorTypeCode;
    }

    public void setSensorTypeCode(String sensorTypeCode) {
        this.sensorTypeCode = sensorTypeCode == null ? null : sensorTypeCode.trim();
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId == null ? null : sensorId.trim();
    }

    public String getThresholdTypeCode() {
        return thresholdTypeCode;
    }

    public void setThresholdTypeCode(String thresholdTypeCode) {
        this.thresholdTypeCode = thresholdTypeCode == null ? null : thresholdTypeCode.trim();
    }

    public String getThresholdParameter() {
        return thresholdParameter;
    }

    public void setThresholdParameter(String thresholdParameter) {
        this.thresholdParameter = thresholdParameter == null ? null : thresholdParameter.trim();
    }

    public String getComparaType() {
        return comparaType;
    }

    public void setComparaType(String comparaType) {
        this.comparaType = comparaType == null ? null : comparaType.trim();
    }

    public Integer getThresholdValue() {
        return thresholdValue;
    }

    public void setThresholdValue(Integer thresholdValue) {
        this.thresholdValue = thresholdValue;
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
}
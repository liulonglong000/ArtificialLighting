package com.face.model;

import java.util.Date;

public class IgcsBgatherDataC {
    private String gatherId;

    private Date gatherTime;

    private String gatewayId;

    private String nodeId;

    private String sensorTypeCode;

    private String sensorId;

    private Float sensorValue;

    public String getGatherId() {
        return gatherId;
    }

    public void setGatherId(String gatherId) {
        this.gatherId = gatherId == null ? null : gatherId.trim();
    }

    public Date getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(Date gatherTime) {
        this.gatherTime = gatherTime;
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

    public Float getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(Float sensorValue) {
        this.sensorValue = sensorValue;
    }
}
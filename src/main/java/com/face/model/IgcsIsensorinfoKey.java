package com.face.model;

public class IgcsIsensorinfoKey {
    private String gatewayId;

    private String nodeId;

    private String sensorTypeCode;

    private String sensorId;

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
}
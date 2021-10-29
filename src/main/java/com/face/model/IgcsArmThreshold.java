package com.face.model;

public class IgcsArmThreshold {
    private String armStrategyId;

    private String gatewayId;

    private String nodeId;

    private Integer thresholdId;

    private String thresholdType;

    private Integer isUse;

    private Integer startHour;

    private Integer startMin;

    private Integer endHour;

    private Integer endMin;

    private String sensorTypeCode;

    private String sensorId;

    private String compareType;

    private Integer comparePara;

    private String equipmentType;

    private String equipmentId;

    private String operateType;

    private Integer operatePara;

    public String getArmStrategyId() {
        return armStrategyId;
    }

    public void setArmStrategyId(String armStrategyId) {
        this.armStrategyId = armStrategyId == null ? null : armStrategyId.trim();
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

    public Integer getThresholdId() {
        return thresholdId;
    }

    public void setThresholdId(Integer thresholdId) {
        this.thresholdId = thresholdId;
    }

    public String getThresholdType() {
        return thresholdType;
    }

    public void setThresholdType(String thresholdType) {
        this.thresholdType = thresholdType == null ? null : thresholdType.trim();
    }

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    public Integer getStartHour() {
        return startHour;
    }

    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    public Integer getStartMin() {
        return startMin;
    }

    public void setStartMin(Integer startMin) {
        this.startMin = startMin;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }

    public Integer getEndMin() {
        return endMin;
    }

    public void setEndMin(Integer endMin) {
        this.endMin = endMin;
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

    public String getCompareType() {
        return compareType;
    }

    public void setCompareType(String compareType) {
        this.compareType = compareType == null ? null : compareType.trim();
    }

    public Integer getComparePara() {
        return comparePara;
    }

    public void setComparePara(Integer comparePara) {
        this.comparePara = comparePara;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType == null ? null : equipmentType.trim();
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
    }

    public Integer getOperatePara() {
        return operatePara;
    }

    public void setOperatePara(Integer operatePara) {
        this.operatePara = operatePara;
    }
}
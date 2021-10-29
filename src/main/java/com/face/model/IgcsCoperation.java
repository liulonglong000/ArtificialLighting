package com.face.model;

import java.util.Date;

public class IgcsCoperation {
    private String operateId;

    private String operateGroupId;

    private String gatewayId;

    private String nodeId;

    private String equipmentTypeCode;

    private String equipmentId;

    private String controlType;

    private String controlParameter1;

    private String controlParameter2;

    private String controlParameter3;

    private Date inDate;

    public String getOperateId() {
        return operateId;
    }

    public void setOperateId(String operateId) {
        this.operateId = operateId == null ? null : operateId.trim();
    }

    public String getOperateGroupId() {
        return operateGroupId;
    }

    public void setOperateGroupId(String operateGroupId) {
        this.operateGroupId = operateGroupId == null ? null : operateGroupId.trim();
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

    public String getEquipmentTypeCode() {
        return equipmentTypeCode;
    }

    public void setEquipmentTypeCode(String equipmentTypeCode) {
        this.equipmentTypeCode = equipmentTypeCode == null ? null : equipmentTypeCode.trim();
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public String getControlType() {
        return controlType;
    }

    public void setControlType(String controlType) {
        this.controlType = controlType == null ? null : controlType.trim();
    }

    public String getControlParameter1() {
        return controlParameter1;
    }

    public void setControlParameter1(String controlParameter1) {
        this.controlParameter1 = controlParameter1 == null ? null : controlParameter1.trim();
    }

    public String getControlParameter2() {
        return controlParameter2;
    }

    public void setControlParameter2(String controlParameter2) {
        this.controlParameter2 = controlParameter2 == null ? null : controlParameter2.trim();
    }

    public String getControlParameter3() {
        return controlParameter3;
    }

    public void setControlParameter3(String controlParameter3) {
        this.controlParameter3 = controlParameter3 == null ? null : controlParameter3.trim();
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }
}
package com.face.model;

import java.util.Date;

public class IgcsBTrade {
    private String tradeId;

    private String gatewayId;

    private String nodeId;

    private String equipmentTypeCode;

    private String equipmentId;

    private String controlType;

    private String controlParameter1;

    private String controlParameter2;

    private String controlParameter3;

    private String message;

    private String insertWay;

    private String userId;

    private String strategyId;

    private Date insertTime;

    private Date preDealTime;

    private Date dealTime;

    private Integer dealCount;

    private Date finishTime;

    private String isDeal;

    private String remark;

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId == null ? null : tradeId.trim();
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getInsertWay() {
        return insertWay;
    }

    public void setInsertWay(String insertWay) {
        this.insertWay = insertWay == null ? null : insertWay.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId == null ? null : strategyId.trim();
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getPreDealTime() {
        return preDealTime;
    }

    public void setPreDealTime(Date preDealTime) {
        this.preDealTime = preDealTime;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public Integer getDealCount() {
        return dealCount;
    }

    public void setDealCount(Integer dealCount) {
        this.dealCount = dealCount;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getIsDeal() {
        return isDeal;
    }

    public void setIsDeal(String isDeal) {
        this.isDeal = isDeal == null ? null : isDeal.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
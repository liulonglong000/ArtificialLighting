package com.face.entity;

import java.util.Date;

public class DiagnosisInfo {
    private String dgId;
    private String dgHouseId;
    private String dgInDate;
    private String dgPreFinDate;
    private int dgStatus;
    private String dgReason;
    private int dgPlanNum;
    private int dgRealNum;
    private String dgFinDate;

    public DiagnosisInfo(String dgId, String dgHouseId, String dgInDate, String dgPreFinDate, int dgStatus, String dgReason, int dgPlanNum, int dgRealNum, String dgFinDate) {
        this.dgId = dgId;
        this.dgHouseId = dgHouseId;
        this.dgInDate = dgInDate;
        this.dgPreFinDate = dgPreFinDate;
        this.dgStatus = dgStatus;
        this.dgReason = dgReason;
        this.dgPlanNum = dgPlanNum;
        this.dgRealNum = dgRealNum;
        this.dgFinDate = dgFinDate;
    }

    public void setDgId(String dgId) {
        this.dgId = dgId;
    }

    public void setDgHouseId(String dgHouseId) {
        this.dgHouseId = dgHouseId;
    }

    public void setDgInDate(String dgInDate) {
        this.dgInDate = dgInDate;
    }

    public void setDgPreFinDate(String dgPreFinDate) {
        this.dgPreFinDate = dgPreFinDate;
    }

    public void setDgStatus(int dgStatus) {
        this.dgStatus = dgStatus;
    }

    public void setDgReason(String dgReason) {
        this.dgReason = dgReason;
    }

    public void setDgPlanNum(int dgPlanNum) {
        this.dgPlanNum = dgPlanNum;
    }

    public void setDgRealNum(int dgRealNum) {
        this.dgRealNum = dgRealNum;
    }

    public void setDgFinDate(String dgFinDate) {
        this.dgFinDate = dgFinDate;
    }

    public String getDgId() {
        return dgId;
    }

    public String getDgHouseId() {
        return dgHouseId;
    }

    public String getDgInDate() {
        return dgInDate;
    }

    public String getDgPreFinDate() {
        return dgPreFinDate;
    }

    public int getDgStatus() {
        return dgStatus;
    }

    public String getDgReason() {
        return dgReason;
    }

    public int getDgPlanNum() {
        return dgPlanNum;
    }

    public int getDgRealNum() {
        return dgRealNum;
    }

    public String getDgFinDate() {
        return dgFinDate;
    }
}

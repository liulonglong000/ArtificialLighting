package com.face.model;

import java.util.Date;

public class IgcsIEquipment extends IgcsIEquipmentKey {
    private Date inDate;

    private String status;

    private Integer statusPara;

    private Integer parameter;

    private Float locate;

    private Integer para1;

    private Integer para2;

    private Integer para3;

    private Date lastConnectTime;

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getStatusPara() {
        return statusPara;
    }

    public void setStatusPara(Integer statusPara) {
        this.statusPara = statusPara;
    }

    public Integer getParameter() {
        return parameter;
    }

    public void setParameter(Integer parameter) {
        this.parameter = parameter;
    }

    public Float getLocate() {
        return locate;
    }

    public void setLocate(Float locate) {
        this.locate = locate;
    }

    public Integer getPara1() {
        return para1;
    }

    public void setPara1(Integer para1) {
        this.para1 = para1;
    }

    public Integer getPara2() {
        return para2;
    }

    public void setPara2(Integer para2) {
        this.para2 = para2;
    }

    public Integer getPara3() {
        return para3;
    }

    public void setPara3(Integer para3) {
        this.para3 = para3;
    }

    public Date getLastConnectTime() {
        return lastConnectTime;
    }

    public void setLastConnectTime(Date lastConnectTime) {
        this.lastConnectTime = lastConnectTime;
    }
}
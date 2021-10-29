package com.face.model;

import java.util.Date;

public class IgcsIsensorinfo extends IgcsIsensorinfoKey {
    private Date inDate;

    private String status;			// 状态，0：连接，其他：未连接

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

    public Date getLastConnectTime() {
        return lastConnectTime;
    }

    public void setLastConnectTime(Date lastConnectTime) {
        this.lastConnectTime = lastConnectTime;
    }
}
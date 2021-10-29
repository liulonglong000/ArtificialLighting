package com.face.model;

import java.util.Date;

public class IgcsIgreenhouse {
    private String greenhouseId;

    private String greenhouseName;

    private String parkId;

    private String greenhouseAddr;

    private String greenhousePic;

    private String gatewayId;

    private Date inDate;

    private String userId;

    private String remark;    

    public String getGreenhouseId() {
        return greenhouseId;
    }

    public void setGreenhouseId(String greenhouseId) {
        this.greenhouseId = greenhouseId == null ? null : greenhouseId.trim();
    }

    public String getGreenhouseName() {
        return greenhouseName;
    }

    public void setGreenhouseName(String greenhouseName) {
        this.greenhouseName = greenhouseName == null ? null : greenhouseName.trim();
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId == null ? null : parkId.trim();
    }

    public String getGreenhouseAddr() {
        return greenhouseAddr;
    }

    public void setGreenhouseAddr(String greenhouseAddr) {
        this.greenhouseAddr = greenhouseAddr == null ? null : greenhouseAddr.trim();
    }

    public String getGreenhousePic() {
        return greenhousePic;
    }

    public void setGreenhousePic(String greenhousePic) {
        this.greenhousePic = greenhousePic == null ? null : greenhousePic.trim();
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId == null ? null : gatewayId.trim();
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
package com.face.model;

import java.util.Date;

public class IgcsInodeinfo extends IgcsInodeinfoKey {
    private String nodeName;

    private String greenhouseId;

    private Date inDate;

    private Integer frequency;

    private String status;				// 状态，0：连接，其他：未连接

    private Date lastConnectTime;

    private String nodeAddr;

    private String nodePic;

    private String remark;

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    public String getGreenhouseId() {
        return greenhouseId;
    }

    public void setGreenhouseId(String greenhouseId) {
        this.greenhouseId = greenhouseId == null ? null : greenhouseId.trim();
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
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

    public String getNodeAddr() {
        return nodeAddr;
    }

    public void setNodeAddr(String nodeAddr) {
        this.nodeAddr = nodeAddr == null ? null : nodeAddr.trim();
    }

    public String getNodePic() {
        return nodePic;
    }

    public void setNodePic(String nodePic) {
        this.nodePic = nodePic == null ? null : nodePic.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
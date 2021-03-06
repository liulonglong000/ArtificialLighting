package com.face.entity;

import com.face.model.IgcsIGatewayInfo;
import com.face.utils.DateUtils;
import com.face.utils.StringUtil;

public class GatewayInfo {
	public static final short GW_TYPE_NODE = 0;
	public static final short GW_TYPE_WEATHER = 1;
	
	private String gatewayId;			// 网关ID，通过客户端手工录入，是网关的唯一编码
    private String gatewayName;			// 网关名称，通过客户端手工录入，便于使用人记录网关信息
    private String inDate;			    // 录入时间，在客户端录入网关时，后台取系统时间，作为录入时间
    private String status;
    private String lastConnectTime;	    // 最后一次连接时间，记录该网关最后一次连接服务器时间
    private String gatewayAddr;			// 用于记录网关布放位置，通过客户端手工录入
    private String userId;				// 用于记录网关管理人账号，账号取自igcs_i_userinfo
    private String parkId;				// 用于记录园区
    private String gatewayPic;
    private String remark;
    private Short type;

    public GatewayInfo(IgcsIGatewayInfo info) throws Exception {
        this.gatewayId = info.getGatewayId();
        this.gatewayName = StringUtil.getStringNotNull(info.getGatewayName());
        this.inDate = DateUtils.getDateStr(info.getInDate());
        if (StringUtil.getStringNotNull(info.getStatus()).equals("0")) {
        	this.status = "连接";
		} else {
			this.status = "未连接";
		}
        this.lastConnectTime = DateUtils.getDateStr(info.getLastConnectTime());
        this.gatewayAddr = StringUtil.getStringNotNull(info.getGatewayAddr());
        this.gatewayPic = StringUtil.getStringForDL(info.getGatewayPic());
        this.remark = StringUtil.getStringNotNull(info.getRemark());
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public String getInDate() {
        return inDate;
    }

    public String getLastConnectTime() {
        return lastConnectTime;
    }

    public String getStatus() {
        return status;
    }

    public String getGatewayAddr() {
        return gatewayAddr;
    }

    public String getUserId() {
        return userId;
    }

    public String getParkId() {
        return parkId;
    }

    public String getGatewayPic() {
        return gatewayPic;
    }

    public String getRemark() {
        return remark;
    }

    public String getGatewayInfo() {
        if (gatewayAddr.length() == 0 && remark.length() == 0) {
            return "暂无描述信息";
        }
        if (gatewayAddr.length() == 0) {
            return remark;
        }
        if (remark.length() == 0) {
            return gatewayAddr;
        }
        return gatewayAddr + "，" + remark;
    }

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}
}

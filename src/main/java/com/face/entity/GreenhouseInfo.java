package com.face.entity;

import java.util.List;

import com.face.model.IgcsIgreenhouse;
import com.face.model.IgcsInodeinfo;
import com.face.utils.DateUtils;
import com.face.utils.StringUtil;

public class GreenhouseInfo {
	private String greenhouseId;            // 温室ID
    private String greenhouseName;          // 温室名称
    private String greenhouseAddr;          // 温室所处位置
    private String remark;                  // 备注
    private String inDate;                  // 温室加入时间
    private String parkName;
    private String gatewayId;				// 没用了
    private String gatewayName;				// 没用了
    private String userName;
    private String picPath;
    private List<IgcsInodeinfo> lstNodesUnder;

    public GreenhouseInfo(IgcsIgreenhouse info) throws Exception {
        this.greenhouseId = info.getGreenhouseId();
        this.greenhouseName = StringUtil.getStringNotNull(info.getGreenhouseName());
        this.greenhouseAddr = StringUtil.getStringNotNull(info.getGreenhouseAddr());
        this.remark = StringUtil.getStringNotNull(info.getRemark());
        this.inDate = DateUtils.getDateStr(info.getInDate());
        this.gatewayId = info.getGatewayId();
        this.picPath = StringUtil.getStringForDL(info.getGreenhousePic());
    }
    
    public GreenhouseInfo(IgcsIgreenhouse info, String gwName) throws Exception {
    	this(info);
        this.gatewayName = StringUtil.getStringNotNull(gwName);
	}
    
    public GreenhouseInfo(IgcsIgreenhouse info, String gwName, String userName) throws Exception {
    	this(info);
        this.gatewayName = StringUtil.getStringNotNull(gwName);
        this.userName = StringUtil.getStringNotNull(userName);
	}
    
    public GreenhouseInfo(IgcsIgreenhouse info, String userName, List<IgcsInodeinfo> lstNs) throws Exception {
    	this(info);
        this.userName = StringUtil.getStringNotNull(userName);
        this.lstNodesUnder = lstNs;
	}

	public String getGreenhouseId() {
        return greenhouseId;
    }

    public String getGreenhouseName() {
        return greenhouseName;
    }

    public String getGreenhouseAddr() {
        return greenhouseAddr;
    }

    public String getRemark() {
        return remark;
    }

    public String getInDate() {
        return inDate;
    }

    public String getParkName() {
        return parkName;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPicPath() {
        return picPath;
    }

    public String getRemarkString() {
        if (remark.length() == 0) {
            return "暂无说明信息";
        }
        return remark;
    }

	public List<IgcsInodeinfo> getLstNodesUnder() {
		return lstNodesUnder;
	}

	public void setLstNodesUnder(List<IgcsInodeinfo> lstNodesUnder) {
		this.lstNodesUnder = lstNodesUnder;
	}
}

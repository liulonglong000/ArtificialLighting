package com.face.entity;

import com.face.model.IgcsCoperation;
import com.face.utils.StringUtil;

public class OperationInfo {
	private IgcsCoperation operationBaseInfo;
	private String nodeName;
	private String equipmentTypeName;
	private String controlTypeName;

	public IgcsCoperation getOperationBaseInfo() {
		return operationBaseInfo;
	}

	public void setOperationBaseInfo(IgcsCoperation operationBaseInfo) {
		this.operationBaseInfo = operationBaseInfo;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getEquipmentTypeName() {
		return equipmentTypeName;
	}

	public void setEquipmentTypeName(String equipmentTypeName) {
		this.equipmentTypeName = equipmentTypeName;
	}

	public String getControlTypeName() {
		return controlTypeName;
	}

	public void setControlTypeName(String controlTypeName) {
		this.controlTypeName = controlTypeName;
	}
	
	public String getEquipFullName() {
        return nodeName + "  " + equipmentTypeName + operationBaseInfo.getEquipmentId();
    }

    public String getInfo() {
        String info = controlTypeName;
        String paras = "";
        String para1 = StringUtil.getStringNotNull(getOperationBaseInfo().getControlParameter1());			
        String para2 = StringUtil.getStringNotNull(getOperationBaseInfo().getControlParameter2());			
        String para3 = StringUtil.getStringNotNull(getOperationBaseInfo().getControlParameter3());
		
        if (para1.length() > 0) {
            paras += para1;
        }
        if (para2.length() > 0) {
            if (paras.length() > 0) {
                paras += ", ";
            }
            paras += para2;
        }
        if (para3.length() > 0) {
            if (paras.length() > 0) {
                paras += ", ";
            }
            paras += para3;
        }
        if (paras.length() > 0) {
            info += "（" + paras + "）";
        }
        return info;
    }
}

package com.face.entity;

import java.util.LinkedHashMap;
import java.util.Map;

import com.face.model.IgcsIEquipment;
import com.face.utils.DateUtil;
import com.face.utils.StringUtil;

public class EquipmentInfo {
	private IgcsIEquipment equip;

	private String equipmentName;
	private Short type;
	
	private String atGwId;
	private String atNodeId;
	private String atNodeName;
	
	private Map<String, String> mpControl = new LinkedHashMap<String, String>();

	public IgcsIEquipment getEquip() {
		return equip;
	}

	public void setEquip(IgcsIEquipment equip) {
		this.equip = equip;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public Integer getParameter() {
		if (equip.getParameter() != null) {
			return equip.getParameter();
		}
		return 0;
	}

	public Integer getStatusPara() {
		if (equip.getStatusPara() != null) {
			return equip.getStatusPara();
		}
		return 0;
	}

	public String getAtNodeId() {
		return atNodeId;
	}

	public void setAtNodeId(String atNodeId) {
		this.atNodeId = atNodeId;
	}

	public String getAtNodeName() {
		return atNodeName;
	}

	public void setAtNodeName(String atNodeName) {
		this.atNodeName = atNodeName;
	}

	public Map<String, String> getMpControl() {
		return mpControl;
	}

	public void setMpControl(Map<String, String> mpControl) {
		this.mpControl = mpControl;
	}

	public void addControl(String controlType, String controlName) {
		mpControl.put(controlType, controlName);
	}

	public String getEquipmentFullName() {
		if (equip.getEquipmentType().equals("RBM")) {
//			Integer para = equip.getParameter();
//			if (para != null) {
//				return equipmentName + equip.getEquipmentId() + "（共" + para + "圈）";
//			} else {		
				return equipmentName + equip.getEquipmentId();
//			}
		} else {
			return equipmentName + equip.getEquipmentId();
		}
	}

	public String getLastConnectTime() {
		return DateUtil.dateToString(equip.getLastConnectTime());
	}
	
	public boolean IsShow() {
		if (equip.getEquipmentType().equals("RBM") || equip.getEquipmentType().equals("FRM")) {
			return false;
		}
		
		return true;
		
		/*if (equip.getEquipmentType().equals("LED")) {
			return true;
		}
		
		return false;*/
	}
	
	public String getTimeUnit() {
		if (equip.getEquipmentType().equals("LED")) {
			return "分钟";
		}
		
		return "秒";
	}
	
	public boolean IsClose() {
		if (equip.getStatus().equals("关") || equip.getStatus().equals("0")) {
			return true;
		} else {
			return false;	 
		} 
	}
	
	public boolean IsMultiPara() {
		if (equip.getEquipmentType().equals("DRIP")) {
			return true;
		} else {
			return false;	 
		} 
	}

	public String getStatusString() {
		return getStatusString(StringUtil.getStringNotNull(equip.getStatus()), equip.getEquipmentType());
	}
	
	public static String getStatusString(String eStatus, String eType) {
		if (eType.equals("RBM") || eType.equals("FRM") || eType.equals("PUSH")) {
			if (eStatus.equals("0")) {
				return "关闭";
			} else if (eStatus.equals("1")) {
				return "正转";
			} else if (eStatus.equals("2")) {
				return "反转";
			} else if (eStatus.equals("3")) {
				return "外设开关启用";
			}
		} else {
			if (eStatus.equals("0")) {
				return "关";
			} else if (eStatus.equals("1")) {
				return "开";
			}
		}
		
		return "未连接";
	}

	public float getLocate() {
		if (equip.getLocate() != null) {
			return equip.getLocate();
		}
		return -1;
	}

	public String getAtGwId() {
		return atGwId;
	}

	public void setAtGwId(String atGwId) {
		this.atGwId = atGwId;
	}

	public String getPara3() {
		// TODO Auto-generated method stub
		return null;
	}
}

package com.face.entity;

import java.util.ArrayList;
import java.util.List;

public class DataForOperationAdd {
	private List<EquipmentInfo> lstEquip = new ArrayList<EquipmentInfo>();

	public List<EquipmentInfo> getLstEquip() {
		return lstEquip;
	}

	public void setLstEquip(List<EquipmentInfo> lstEquip) {
		this.lstEquip = lstEquip;
	}

	public void addEquipment(EquipmentInfo sInfo) {
		lstEquip.add(sInfo);
	}
}

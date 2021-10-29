package com.face.service;

import java.util.List;

import com.face.model.IgcsBTrade;
import com.face.model.IgcsINodeItem;
import com.face.model.IgcsIEquipment;

public interface IOperationService {

	void addTrade(IgcsBTrade info) throws Exception;

	IgcsBTrade findTradeById(String tradeId) throws Exception;

	IgcsIEquipment findEquipById(String gatewayId, String nodeId, String equipmentTypeCode, 
			String equipmentId) throws Exception;

	void updateEquipById(String gatewayId, String nodeId, String equipmentTypeCode, String equipmentId, String status) throws Exception;

	List<IgcsINodeItem> findNodeEquipTypes(String gwId, String nodeId) throws Exception;

	void modifyEquipmentTimeLimit(IgcsBTrade info) throws Exception;

	void modifyEquipmentEncoder(IgcsBTrade info) throws Exception;

}

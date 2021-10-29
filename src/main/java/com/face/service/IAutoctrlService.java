package com.face.service;

import java.util.List;

import com.face.entity.ArmStrategyInfo;
import com.face.entity.DataForOperationAdd;
import com.face.entity.DataForThresholdAdd;
import com.face.entity.OperationGroupInfo;
import com.face.entity.StrategyInfo;
import com.face.entity.ThresholdGroupInfo;
import com.face.model.IgcsArmThreshold;
import com.face.model.IgcsChoperation;
import com.face.model.IgcsChstrategy;
import com.face.model.IgcsChthreshold;
import com.face.model.IgcsCoperation;
import com.face.model.IgcsCoperationGroup;
import com.face.model.IgcsCstrategy;
import com.face.model.IgcsCthreshold;
import com.face.model.IgcsCthresholdGroup;
import com.face.model.IgcsInodeinfo;

public interface IAutoctrlService {

	ThresholdGroupInfo findTgById(String tgId) throws Exception;

	DataForThresholdAdd findDatasForThresholdAdd(String ghId) throws Exception;

	IgcsCthresholdGroup findTgBaseById(String tgId) throws Exception;

	void addTgInfo(IgcsCthresholdGroup tgInfo) throws Exception;

	void modifyTgInfo(IgcsCthresholdGroup tgInfo) throws Exception;

	List<ThresholdGroupInfo> findTgsByGhId(String ghId, boolean bGetThresholdInfo) throws Exception;

	IgcsCthreshold findThresholdById(String thresholdId) throws Exception;

	void addThresholdInfo(IgcsCthreshold tInfo, String userId) throws Exception;

	void mdyThresholdInfo(IgcsCthreshold tInfo, String userId, IgcsChthreshold hInfo) throws Exception;

	void delThresholdInfo(String thresholdId, String userId) throws Exception;

	void delTgInfo(String tgId) throws Exception;

	IgcsChthreshold generateHistoryThreshold(IgcsCthreshold tInfo) throws Exception;

	List<OperationGroupInfo> findOgsByGhId(String ghId, boolean bGetOperationInfo) throws Exception;

	IgcsCoperationGroup findOgBaseById(String ogId) throws Exception;

	void addOgInfo(IgcsCoperationGroup tgInfo) throws Exception;

	void modifyOgInfo(IgcsCoperationGroup ogInfo) throws Exception;

	OperationGroupInfo findOgById(String ogId) throws Exception;

	DataForOperationAdd findDatasForOperationAdd(String ghId) throws Exception;

	IgcsCoperation findOperationById(String operationId) throws Exception;

	void addOperationInfo(IgcsCoperation oInfo, String userId) throws Exception;

	IgcsChoperation generateHistoryOperation(IgcsCoperation oInfo) throws Exception;

	void mdyOperationInfo(IgcsCoperation oInfo, String userId, IgcsChoperation hInfo) throws Exception;

	void delOperationInfo(String operationId, String userId) throws Exception;

	void delOgInfo(String ogId) throws Exception;

	List<StrategyInfo> findStrategyByGhId(String ghId) throws Exception;

	IgcsCstrategy findStrategyById(String strategyId) throws Exception;

	void addStrategyInfo(IgcsCstrategy strategyInfo) throws Exception;

	IgcsChstrategy generateHistoryStrategy(IgcsCstrategy strategyInfo) throws Exception;

	void mdyStrategyInfo(IgcsCstrategy strategyInfo, IgcsChstrategy hInfo) throws Exception;

	void delStrategyInfo(String strategyId) throws Exception;

	boolean tgInUse(String tgId) throws Exception;

	boolean ogInUse(String ogId) throws Exception;

	IgcsInodeinfo getFirstNodeOfGh(String ghId) throws Exception;

	List<ArmStrategyInfo> findArmStrategyByGhId(String ghId) throws Exception;

	String getEquipNameByType(String type) throws Exception;

	String getControlNameByType(String operateType) throws Exception;

	String getSensorNameByType(String sensorTypeCode) throws Exception;
	
	String getSensorUnitByType(String type) throws Exception;

	String getCompareNameByType(String compareType) throws Exception;

	IgcsArmThreshold findArmStrategyById(String strategyId) throws Exception;

	void modifyArmThreshold(IgcsArmThreshold curArm) throws Exception;

	Integer getArmOperateType(String equipmentType, String operateType) throws Exception;

	Integer getSensorArmIdByType(String sensorTypeCode) throws Exception;

	Integer getCompArmIdByType(String compareType) throws Exception;

}

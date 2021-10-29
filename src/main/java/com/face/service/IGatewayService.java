package com.face.service;

import java.util.List;
import java.util.Map;

import com.face.entity.GreenhouseInfo;
import com.face.entity.NodeInfo;
import com.face.entity.Parkinfo;
import com.face.entity.SensorData;
import com.face.entity.SensorHistoryData;
import com.face.entity.SensorInfo;
import com.face.entity.WeatherInfo;
import com.face.model.IgcsASensorType;
import com.face.model.IgcsIEquipment;
import com.face.model.IgcsIGatewayInfo;
import com.face.model.IgcsIgreenhouse;
import com.face.model.IgcsInodeinfo;
import com.face.model.IgcsIparkinfo;

public interface IGatewayService {

	List<IgcsIGatewayInfo> queryGatewayOfParkUser(String parkId, String userId) throws Exception;

	IgcsIGatewayInfo findGatewayById(String gatewayId) throws Exception;

	String addGateway(IgcsIGatewayInfo info) throws Exception;

	String mdyGateway(IgcsIGatewayInfo info) throws Exception;

	List<IgcsIGatewayInfo> queryGatewayOfParkAdmin(String parkId) throws Exception;

	IgcsIgreenhouse findGhById(String ghId) throws Exception;

	String addGreenhouse(IgcsIgreenhouse info) throws Exception;

	List<GreenhouseInfo> queryGhOfParkUser(String userId) throws Exception;

	String mdyGreenhouse(IgcsIgreenhouse info) throws Exception;

	List<NodeInfo> getNodesInfoByGhId(String ghId) throws Exception;

	List<SensorHistoryData> findRecentByFilter(String gwId, String nodeId, String sensorId, String sensorTypeCode) throws Exception;

	List<NodeInfo> getNodesEquipByGhId(String ghId, Boolean bTimeLimit) throws Exception;

	List<IgcsInodeinfo> getNodesByGhId(String ghId) throws Exception;

	Map<String, List<SensorHistoryData>> findHistoryByFilter(String gwId, String nodeFilter, String startTimeFilter, String endTimeFilter) throws Exception;

	IgcsInodeinfo findNodeById(String nodeId, String gwId) throws Exception;

	String mdyNodeInfo(IgcsInodeinfo info) throws Exception;

	List<GreenhouseInfo> queryGhOfGw(String gwId) throws Exception;

	List<Parkinfo> queryAllPark() throws Exception;

	IgcsASensorType findSensorTyById(String sensorTypeCode) throws Exception;

	IgcsIEquipment findEquipmentById(String gwId, String nodeId, String equipType, String equipId) throws Exception;

	List<WeatherInfo> getWeatherInfoByUserId(String userId, String parkId) throws Exception;

	List<SensorHistoryData> findWRecentByFilter(String gwId, String nodeId, String sensorId, String sensorTypeCode) throws Exception;

	List<IgcsIGatewayInfo> getWeatherList(String userId, String parkId) throws Exception;

	Map<Short, List<SensorInfo>> getSensorList(String gwId, String nodeId) throws Exception;

	Map<String, List<SensorData>> findHistoryInfoByFilter(String gwFilter, String nodeFilter,
			String sensorListFilter, String startTimeFilter, String endTimeFilter, String bWeather) throws Exception;

	List<GreenhouseInfo> queryGhOfPark(String parkId) throws Exception;

	List<IgcsInodeinfo> queryNodesOfPark(String parkId) throws Exception;

	void addGreenhouseEx(IgcsIgreenhouse info, String gwNodes) throws Exception;

	void mdyGreenhouseEx(IgcsIgreenhouse info, String gwNodes) throws Exception;

	void delGhById(String ghId) throws Exception;

	IgcsIparkinfo findParkById(String parkId);
}

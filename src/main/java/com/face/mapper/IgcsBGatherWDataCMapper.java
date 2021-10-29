package com.face.mapper;

import com.face.entity.SensorData;
import com.face.entity.SensorHistoryData;
import com.face.model.IgcsBGatherWDataC;
import com.face.model.IgcsBGatherWDataCExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsBGatherWDataCMapper {
    int countByExample(IgcsBGatherWDataCExample example);

    int deleteByExample(IgcsBGatherWDataCExample example);

    int insert(IgcsBGatherWDataC record);

    int insertSelective(IgcsBGatherWDataC record);

    List<IgcsBGatherWDataC> selectByExample(IgcsBGatherWDataCExample example);

    int updateByExampleSelective(@Param("record") IgcsBGatherWDataC record, @Param("example") IgcsBGatherWDataCExample example);

    int updateByExample(@Param("record") IgcsBGatherWDataC record, @Param("example") IgcsBGatherWDataCExample example);
    
    
    Date getLastDataTime(@Param("gwId")String gwId, @Param("nodeId")String nodeId);

	Date getSensorLastRec(@Param("gwId")String gwId, @Param("nodeId")String nodeId, @Param("sensorId")String sensorId, @Param("sensorTypeCode")String sensorTypeCode);

	List<SensorData> selectRecentSensorData(@Param("gwId")String gwId, @Param("nodeId")String nodeId, 
			@Param("sensorId")String sensorId, @Param("sensorTypeCode")String sensorTypeCode, @Param("startTime")Date startTime);
	
	List<SensorData> findWHistoryByFilter(@Param("gwId")String gwId, @Param("nodeId")String nodeId, @Param("sensorType")String sensorType, 
			@Param("sensorId")String sensorId, @Param("startTime")String startTime, @Param("endTime")String endTime);
}
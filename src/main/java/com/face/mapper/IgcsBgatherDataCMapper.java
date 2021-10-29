package com.face.mapper;

import com.face.entity.SensorData;
import com.face.model.IgcsBgatherDataC;
import com.face.model.IgcsBgatherDataCExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsBgatherDataCMapper {
    int countByExample(IgcsBgatherDataCExample example);

    int deleteByExample(IgcsBgatherDataCExample example);

    int insert(IgcsBgatherDataC record);

    int insertSelective(IgcsBgatherDataC record);

    List<IgcsBgatherDataC> selectByExample(IgcsBgatherDataCExample example);

    int updateByExampleSelective(@Param("record") IgcsBgatherDataC record, @Param("example") IgcsBgatherDataCExample example);

    int updateByExample(@Param("record") IgcsBgatherDataC record, @Param("example") IgcsBgatherDataCExample example);

 // @Param是MyBatis所提供的(org.apache.ibatis.annotations.Param)，作为Dao层的注解，作用是用于传递参数，从而可以与SQL中的的字段名相对应，一般在2=<参数数<=5时使用最佳。
    Date getLastDataTime(@Param("gwId")String gwId, @Param("nodeId")String nodeId);
    
    Date getSensorLastRec(@Param("gwId")String gwId, @Param("nodeId")String nodeId, @Param("sensorId")String sensorId, @Param("sensorTypeCode")String sensorTypeCode);

	List<SensorData> selectRecentSensorData(@Param("gwId")String gwId, @Param("nodeId")String nodeId, 
			@Param("sensorId")String sensorId, @Param("sensorTypeCode")String sensorTypeCode, @Param("startTime")Date startTime);
	
	List<IgcsBgatherDataC> findHistoryByFilter(@Param("gwId")String gwId, @Param("nodeId")String nodeId, 
			@Param("startTime")String startTime, @Param("endTime")String endTime);
	
	List<SensorData> findHistoryByCondition(@Param("gwId")String gwId, @Param("nodeId")String nodeId, @Param("sensorType")String sensorType, 
			@Param("sensorId")String sensorId, @Param("startTime")String startTime, @Param("endTime")String endTime);
}
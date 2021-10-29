package com.face.mapper;

import com.face.model.IgcsArmThreshold;
import com.face.model.IgcsArmThresholdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsArmThresholdMapper {
    int countByExample(IgcsArmThresholdExample example);

    int deleteByExample(IgcsArmThresholdExample example);

    int deleteByPrimaryKey(String armStrategyId);

    int insert(IgcsArmThreshold record);

    int insertSelective(IgcsArmThreshold record);

    List<IgcsArmThreshold> selectByExample(IgcsArmThresholdExample example);

    IgcsArmThreshold selectByPrimaryKey(String armStrategyId);

    int updateByExampleSelective(@Param("record") IgcsArmThreshold record, @Param("example") IgcsArmThresholdExample example);

    int updateByExample(@Param("record") IgcsArmThreshold record, @Param("example") IgcsArmThresholdExample example);

    int updateByPrimaryKeySelective(IgcsArmThreshold record);

    int updateByPrimaryKey(IgcsArmThreshold record);
}
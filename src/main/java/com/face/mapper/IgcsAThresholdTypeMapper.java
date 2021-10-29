package com.face.mapper;

import com.face.model.IgcsAThresholdType;
import com.face.model.IgcsAThresholdTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsAThresholdTypeMapper {
    int countByExample(IgcsAThresholdTypeExample example);

    int deleteByExample(IgcsAThresholdTypeExample example);

    int deleteByPrimaryKey(String thresholdTypeCode);

    int insert(IgcsAThresholdType record);

    int insertSelective(IgcsAThresholdType record);

    List<IgcsAThresholdType> selectByExample(IgcsAThresholdTypeExample example);

    IgcsAThresholdType selectByPrimaryKey(String thresholdTypeCode);

    int updateByExampleSelective(@Param("record") IgcsAThresholdType record, @Param("example") IgcsAThresholdTypeExample example);

    int updateByExample(@Param("record") IgcsAThresholdType record, @Param("example") IgcsAThresholdTypeExample example);

    int updateByPrimaryKeySelective(IgcsAThresholdType record);

    int updateByPrimaryKey(IgcsAThresholdType record);
}
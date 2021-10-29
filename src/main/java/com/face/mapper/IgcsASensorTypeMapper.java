package com.face.mapper;

import com.face.model.IgcsASensorType;
import com.face.model.IgcsASensorTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsASensorTypeMapper {
    int countByExample(IgcsASensorTypeExample example);

    int deleteByExample(IgcsASensorTypeExample example);

    int deleteByPrimaryKey(String sensorTypeCode);

    int insert(IgcsASensorType record);

    int insertSelective(IgcsASensorType record);

    List<IgcsASensorType> selectByExample(IgcsASensorTypeExample example);

    IgcsASensorType selectByPrimaryKey(String sensorTypeCode);

    int updateByExampleSelective(@Param("record") IgcsASensorType record, @Param("example") IgcsASensorTypeExample example);

    int updateByExample(@Param("record") IgcsASensorType record, @Param("example") IgcsASensorTypeExample example);

    int updateByPrimaryKeySelective(IgcsASensorType record);

    int updateByPrimaryKey(IgcsASensorType record);
}
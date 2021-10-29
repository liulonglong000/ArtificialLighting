package com.face.mapper;

import com.face.model.IgcsIgreenhouse;
import com.face.model.IgcsIgreenhouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsIgreenhouseMapper {
    int countByExample(IgcsIgreenhouseExample example);

    int deleteByExample(IgcsIgreenhouseExample example);

    int deleteByPrimaryKey(String greenhouseId);

    int insert(IgcsIgreenhouse record);

    int insertSelective(IgcsIgreenhouse record);

    List<IgcsIgreenhouse> selectByExample(IgcsIgreenhouseExample example);

    IgcsIgreenhouse selectByPrimaryKey(String greenhouseId);

    int updateByExampleSelective(@Param("record") IgcsIgreenhouse record, @Param("example") IgcsIgreenhouseExample example);

    int updateByExample(@Param("record") IgcsIgreenhouse record, @Param("example") IgcsIgreenhouseExample example);

    int updateByPrimaryKeySelective(IgcsIgreenhouse record);

    int updateByPrimaryKey(IgcsIgreenhouse record);
}
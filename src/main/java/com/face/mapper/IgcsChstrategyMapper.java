package com.face.mapper;

import com.face.model.IgcsChstrategy;
import com.face.model.IgcsChstrategyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsChstrategyMapper {
    int countByExample(IgcsChstrategyExample example);

    int deleteByExample(IgcsChstrategyExample example);

    int deleteByPrimaryKey(String strategyId);

    int insert(IgcsChstrategy record);

    int insertSelective(IgcsChstrategy record);

    List<IgcsChstrategy> selectByExample(IgcsChstrategyExample example);

    IgcsChstrategy selectByPrimaryKey(String strategyId);

    int updateByExampleSelective(@Param("record") IgcsChstrategy record, @Param("example") IgcsChstrategyExample example);

    int updateByExample(@Param("record") IgcsChstrategy record, @Param("example") IgcsChstrategyExample example);

    int updateByPrimaryKeySelective(IgcsChstrategy record);

    int updateByPrimaryKey(IgcsChstrategy record);
}
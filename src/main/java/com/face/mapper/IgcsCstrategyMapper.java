package com.face.mapper;

import com.face.model.IgcsCstrategy;
import com.face.model.IgcsCstrategyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsCstrategyMapper {
    int countByExample(IgcsCstrategyExample example);

    int deleteByExample(IgcsCstrategyExample example);

    int deleteByPrimaryKey(String strategyId);

    int insert(IgcsCstrategy record);

    int insertSelective(IgcsCstrategy record);

    List<IgcsCstrategy> selectByExample(IgcsCstrategyExample example);

    IgcsCstrategy selectByPrimaryKey(String strategyId);

    int updateByExampleSelective(@Param("record") IgcsCstrategy record, @Param("example") IgcsCstrategyExample example);

    int updateByExample(@Param("record") IgcsCstrategy record, @Param("example") IgcsCstrategyExample example);

    int updateByPrimaryKeySelective(IgcsCstrategy record);

    int updateByPrimaryKey(IgcsCstrategy record);
}
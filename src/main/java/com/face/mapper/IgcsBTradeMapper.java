package com.face.mapper;

import com.face.model.IgcsBTrade;
import com.face.model.IgcsBTradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsBTradeMapper {
    int countByExample(IgcsBTradeExample example);

    int deleteByExample(IgcsBTradeExample example);

    int deleteByPrimaryKey(String tradeId);

    int insert(IgcsBTrade record);

    int insertSelective(IgcsBTrade record);

    List<IgcsBTrade> selectByExample(IgcsBTradeExample example);

    IgcsBTrade selectByPrimaryKey(String tradeId);

    int updateByExampleSelective(@Param("record") IgcsBTrade record, @Param("example") IgcsBTradeExample example);

    int updateByExample(@Param("record") IgcsBTrade record, @Param("example") IgcsBTradeExample example);

    int updateByPrimaryKeySelective(IgcsBTrade record);

    int updateByPrimaryKey(IgcsBTrade record);
}
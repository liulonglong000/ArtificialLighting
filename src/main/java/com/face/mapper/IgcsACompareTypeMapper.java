package com.face.mapper;

import com.face.model.IgcsACompareType;
import com.face.model.IgcsACompareTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsACompareTypeMapper {
    int countByExample(IgcsACompareTypeExample example);

    int deleteByExample(IgcsACompareTypeExample example);

    int deleteByPrimaryKey(String compareType);

    int insert(IgcsACompareType record);

    int insertSelective(IgcsACompareType record);

    List<IgcsACompareType> selectByExample(IgcsACompareTypeExample example);

    IgcsACompareType selectByPrimaryKey(String compareType);

    int updateByExampleSelective(@Param("record") IgcsACompareType record, @Param("example") IgcsACompareTypeExample example);

    int updateByExample(@Param("record") IgcsACompareType record, @Param("example") IgcsACompareTypeExample example);

    int updateByPrimaryKeySelective(IgcsACompareType record);

    int updateByPrimaryKey(IgcsACompareType record);
}
package com.face.mapper;

import com.face.model.IgcsIsensorinfo;
import com.face.model.IgcsIsensorinfoExample;
import com.face.model.IgcsIsensorinfoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsIsensorinfoMapper {
    int countByExample(IgcsIsensorinfoExample example);

    int deleteByExample(IgcsIsensorinfoExample example);

    int deleteByPrimaryKey(IgcsIsensorinfoKey key);

    int insert(IgcsIsensorinfo record);

    int insertSelective(IgcsIsensorinfo record);

    List<IgcsIsensorinfo> selectByExample(IgcsIsensorinfoExample example);

    IgcsIsensorinfo selectByPrimaryKey(IgcsIsensorinfoKey key);

    int updateByExampleSelective(@Param("record") IgcsIsensorinfo record, @Param("example") IgcsIsensorinfoExample example);

    int updateByExample(@Param("record") IgcsIsensorinfo record, @Param("example") IgcsIsensorinfoExample example);

    int updateByPrimaryKeySelective(IgcsIsensorinfo record);

    int updateByPrimaryKey(IgcsIsensorinfo record);
}
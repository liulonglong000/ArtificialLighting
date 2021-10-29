package com.face.mapper;

import com.face.model.IgcsIparkinfo;
import com.face.model.IgcsIparkinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsIparkinfoMapper {
    int countByExample(IgcsIparkinfoExample example);

    int deleteByExample(IgcsIparkinfoExample example);

    int deleteByPrimaryKey(String parkId);

    int insert(IgcsIparkinfo record);

    int insertSelective(IgcsIparkinfo record);

    List<IgcsIparkinfo> selectByExample(IgcsIparkinfoExample example);

    IgcsIparkinfo selectByPrimaryKey(String parkId);

    int updateByExampleSelective(@Param("record") IgcsIparkinfo record, @Param("example") IgcsIparkinfoExample example);

    int updateByExample(@Param("record") IgcsIparkinfo record, @Param("example") IgcsIparkinfoExample example);

    int updateByPrimaryKeySelective(IgcsIparkinfo record);

    int updateByPrimaryKey(IgcsIparkinfo record);
}
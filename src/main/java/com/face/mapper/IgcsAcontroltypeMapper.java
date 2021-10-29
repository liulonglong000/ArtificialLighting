package com.face.mapper;

import com.face.model.IgcsAcontroltype;
import com.face.model.IgcsAcontroltypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsAcontroltypeMapper {
    int countByExample(IgcsAcontroltypeExample example);

    int deleteByExample(IgcsAcontroltypeExample example);

    int deleteByPrimaryKey(String controlType);

    int insert(IgcsAcontroltype record);

    int insertSelective(IgcsAcontroltype record);

    List<IgcsAcontroltype> selectByExample(IgcsAcontroltypeExample example);

    IgcsAcontroltype selectByPrimaryKey(String controlType);

    int updateByExampleSelective(@Param("record") IgcsAcontroltype record, @Param("example") IgcsAcontroltypeExample example);

    int updateByExample(@Param("record") IgcsAcontroltype record, @Param("example") IgcsAcontroltypeExample example);

    int updateByPrimaryKeySelective(IgcsAcontroltype record);

    int updateByPrimaryKey(IgcsAcontroltype record);
}
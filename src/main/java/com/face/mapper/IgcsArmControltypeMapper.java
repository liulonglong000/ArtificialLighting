package com.face.mapper;

import com.face.model.IgcsArmControltype;
import com.face.model.IgcsArmControltypeExample;
import com.face.model.IgcsArmControltypeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsArmControltypeMapper {
    int countByExample(IgcsArmControltypeExample example);

    int deleteByExample(IgcsArmControltypeExample example);

    int deleteByPrimaryKey(IgcsArmControltypeKey key);

    int insert(IgcsArmControltype record);

    int insertSelective(IgcsArmControltype record);

    List<IgcsArmControltype> selectByExample(IgcsArmControltypeExample example);

    IgcsArmControltype selectByPrimaryKey(IgcsArmControltypeKey key);

    int updateByExampleSelective(@Param("record") IgcsArmControltype record, @Param("example") IgcsArmControltypeExample example);

    int updateByExample(@Param("record") IgcsArmControltype record, @Param("example") IgcsArmControltypeExample example);

    int updateByPrimaryKeySelective(IgcsArmControltype record);

    int updateByPrimaryKey(IgcsArmControltype record);
}
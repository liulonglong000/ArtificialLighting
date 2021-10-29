package com.face.mapper;

import com.face.model.IgcsInodeinfo;
import com.face.model.IgcsInodeinfoExample;
import com.face.model.IgcsInodeinfoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsInodeinfoMapper {
    int countByExample(IgcsInodeinfoExample example);

    int deleteByExample(IgcsInodeinfoExample example);

    int deleteByPrimaryKey(IgcsInodeinfoKey key);

    int insert(IgcsInodeinfo record);

    int insertSelective(IgcsInodeinfo record);

    List<IgcsInodeinfo> selectByExample(IgcsInodeinfoExample example);

    IgcsInodeinfo selectByPrimaryKey(IgcsInodeinfoKey key);

    int updateByExampleSelective(@Param("record") IgcsInodeinfo record, @Param("example") IgcsInodeinfoExample example);

    int updateByExample(@Param("record") IgcsInodeinfo record, @Param("example") IgcsInodeinfoExample example);

    int updateByPrimaryKeySelective(IgcsInodeinfo record);

    int updateByPrimaryKey(IgcsInodeinfo record);
}
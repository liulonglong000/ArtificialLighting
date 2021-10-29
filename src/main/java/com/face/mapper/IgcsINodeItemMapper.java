package com.face.mapper;

import com.face.model.IgcsINodeItem;
import com.face.model.IgcsINodeItemExample;
import com.face.model.IgcsINodeItemKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsINodeItemMapper {
    int countByExample(IgcsINodeItemExample example);

    int deleteByExample(IgcsINodeItemExample example);

    int deleteByPrimaryKey(IgcsINodeItemKey key);

    int insert(IgcsINodeItem record);

    int insertSelective(IgcsINodeItem record);

    List<IgcsINodeItem> selectByExample(IgcsINodeItemExample example);

    IgcsINodeItem selectByPrimaryKey(IgcsINodeItemKey key);

    int updateByExampleSelective(@Param("record") IgcsINodeItem record, @Param("example") IgcsINodeItemExample example);

    int updateByExample(@Param("record") IgcsINodeItem record, @Param("example") IgcsINodeItemExample example);

    int updateByPrimaryKeySelective(IgcsINodeItem record);

    int updateByPrimaryKey(IgcsINodeItem record);
}
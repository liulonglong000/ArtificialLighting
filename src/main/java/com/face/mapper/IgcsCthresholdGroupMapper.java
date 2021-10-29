package com.face.mapper;

import com.face.model.IgcsCthresholdGroup;
import com.face.model.IgcsCthresholdGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsCthresholdGroupMapper {
    int countByExample(IgcsCthresholdGroupExample example);

    int deleteByExample(IgcsCthresholdGroupExample example);

    int deleteByPrimaryKey(String thresholdGroupId);

    int insert(IgcsCthresholdGroup record);

    int insertSelective(IgcsCthresholdGroup record);

    List<IgcsCthresholdGroup> selectByExample(IgcsCthresholdGroupExample example);

    IgcsCthresholdGroup selectByPrimaryKey(String thresholdGroupId);

    int updateByExampleSelective(@Param("record") IgcsCthresholdGroup record, @Param("example") IgcsCthresholdGroupExample example);

    int updateByExample(@Param("record") IgcsCthresholdGroup record, @Param("example") IgcsCthresholdGroupExample example);

    int updateByPrimaryKeySelective(IgcsCthresholdGroup record);

    int updateByPrimaryKey(IgcsCthresholdGroup record);
}
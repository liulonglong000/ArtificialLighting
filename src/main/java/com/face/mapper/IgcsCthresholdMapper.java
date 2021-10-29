package com.face.mapper;

import com.face.model.IgcsCthreshold;
import com.face.model.IgcsCthresholdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsCthresholdMapper {
    int countByExample(IgcsCthresholdExample example);

    int deleteByExample(IgcsCthresholdExample example);

    int deleteByPrimaryKey(String thresholdId);

    int insert(IgcsCthreshold record);

    int insertSelective(IgcsCthreshold record);

    List<IgcsCthreshold> selectByExample(IgcsCthresholdExample example);

    IgcsCthreshold selectByPrimaryKey(String thresholdId);

    int updateByExampleSelective(@Param("record") IgcsCthreshold record, @Param("example") IgcsCthresholdExample example);

    int updateByExample(@Param("record") IgcsCthreshold record, @Param("example") IgcsCthresholdExample example);

    int updateByPrimaryKeySelective(IgcsCthreshold record);

    int updateByPrimaryKey(IgcsCthreshold record);
}
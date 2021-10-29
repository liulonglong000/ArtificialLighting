package com.face.mapper;

import com.face.model.IgcsChthreshold;
import com.face.model.IgcsChthresholdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsChthresholdMapper {
    int countByExample(IgcsChthresholdExample example);

    int deleteByExample(IgcsChthresholdExample example);

    int insert(IgcsChthreshold record);

    int insertSelective(IgcsChthreshold record);

    List<IgcsChthreshold> selectByExample(IgcsChthresholdExample example);

    int updateByExampleSelective(@Param("record") IgcsChthreshold record, @Param("example") IgcsChthresholdExample example);

    int updateByExample(@Param("record") IgcsChthreshold record, @Param("example") IgcsChthresholdExample example);
}
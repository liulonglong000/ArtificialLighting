package com.face.mapper;

import com.face.model.IgcsChoperation;
import com.face.model.IgcsChoperationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsChoperationMapper {
    int countByExample(IgcsChoperationExample example);

    int deleteByExample(IgcsChoperationExample example);

    int insert(IgcsChoperation record);

    int insertSelective(IgcsChoperation record);

    List<IgcsChoperation> selectByExample(IgcsChoperationExample example);

    int updateByExampleSelective(@Param("record") IgcsChoperation record, @Param("example") IgcsChoperationExample example);

    int updateByExample(@Param("record") IgcsChoperation record, @Param("example") IgcsChoperationExample example);
}
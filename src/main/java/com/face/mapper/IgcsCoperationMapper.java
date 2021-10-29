package com.face.mapper;

import com.face.model.IgcsCoperation;
import com.face.model.IgcsCoperationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsCoperationMapper {
    int countByExample(IgcsCoperationExample example);

    int deleteByExample(IgcsCoperationExample example);

    int deleteByPrimaryKey(String operateId);

    int insert(IgcsCoperation record);

    int insertSelective(IgcsCoperation record);

    List<IgcsCoperation> selectByExample(IgcsCoperationExample example);

    IgcsCoperation selectByPrimaryKey(String operateId);

    int updateByExampleSelective(@Param("record") IgcsCoperation record, @Param("example") IgcsCoperationExample example);

    int updateByExample(@Param("record") IgcsCoperation record, @Param("example") IgcsCoperationExample example);

    int updateByPrimaryKeySelective(IgcsCoperation record);

    int updateByPrimaryKey(IgcsCoperation record);
}
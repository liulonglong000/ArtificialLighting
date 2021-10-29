package com.face.mapper;

import com.face.model.IgcsCoperationGroup;
import com.face.model.IgcsCoperationGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsCoperationGroupMapper {
    int countByExample(IgcsCoperationGroupExample example);

    int deleteByExample(IgcsCoperationGroupExample example);

    int deleteByPrimaryKey(String operateGroupId);

    int insert(IgcsCoperationGroup record);

    int insertSelective(IgcsCoperationGroup record);

    List<IgcsCoperationGroup> selectByExample(IgcsCoperationGroupExample example);

    IgcsCoperationGroup selectByPrimaryKey(String operateGroupId);

    int updateByExampleSelective(@Param("record") IgcsCoperationGroup record, @Param("example") IgcsCoperationGroupExample example);

    int updateByExample(@Param("record") IgcsCoperationGroup record, @Param("example") IgcsCoperationGroupExample example);

    int updateByPrimaryKeySelective(IgcsCoperationGroup record);

    int updateByPrimaryKey(IgcsCoperationGroup record);
}
package com.face.mapper;

import com.face.model.IgcsBAlarm;
import com.face.model.IgcsBAlarmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsBAlarmMapper {
    int countByExample(IgcsBAlarmExample example);

    int deleteByExample(IgcsBAlarmExample example);

    int deleteByPrimaryKey(String alarmLogId);

    int insert(IgcsBAlarm record);

    int insertSelective(IgcsBAlarm record);

    List<IgcsBAlarm> selectByExample(IgcsBAlarmExample example);

    IgcsBAlarm selectByPrimaryKey(String alarmLogId);

    int updateByExampleSelective(@Param("record") IgcsBAlarm record, @Param("example") IgcsBAlarmExample example);

    int updateByExample(@Param("record") IgcsBAlarm record, @Param("example") IgcsBAlarmExample example);

    int updateByPrimaryKeySelective(IgcsBAlarm record);

    int updateByPrimaryKey(IgcsBAlarm record);
}
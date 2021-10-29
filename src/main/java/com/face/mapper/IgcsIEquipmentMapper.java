package com.face.mapper;

import com.face.model.IgcsIEquipment;
import com.face.model.IgcsIEquipmentExample;
import com.face.model.IgcsIEquipmentKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsIEquipmentMapper {
    int countByExample(IgcsIEquipmentExample example);

    int deleteByExample(IgcsIEquipmentExample example);

    int deleteByPrimaryKey(IgcsIEquipmentKey key);

    int insert(IgcsIEquipment record);

    int insertSelective(IgcsIEquipment record);

    List<IgcsIEquipment> selectByExample(IgcsIEquipmentExample example);

    IgcsIEquipment selectByPrimaryKey(IgcsIEquipmentKey key);

    int updateByExampleSelective(@Param("record") IgcsIEquipment record, @Param("example") IgcsIEquipmentExample example);

    int updateByExample(@Param("record") IgcsIEquipment record, @Param("example") IgcsIEquipmentExample example);

    int updateByPrimaryKeySelective(IgcsIEquipment record);

    int updateByPrimaryKey(IgcsIEquipment record);
}
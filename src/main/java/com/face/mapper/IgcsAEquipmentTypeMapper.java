package com.face.mapper;

import com.face.model.IgcsAEquipmentType;
import com.face.model.IgcsAEquipmentTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsAEquipmentTypeMapper {
    int countByExample(IgcsAEquipmentTypeExample example);

    int deleteByExample(IgcsAEquipmentTypeExample example);

    int deleteByPrimaryKey(String equipmentTypeCode);

    int insert(IgcsAEquipmentType record);

    int insertSelective(IgcsAEquipmentType record);

    List<IgcsAEquipmentType> selectByExample(IgcsAEquipmentTypeExample example);

    IgcsAEquipmentType selectByPrimaryKey(String equipmentTypeCode);

    int updateByExampleSelective(@Param("record") IgcsAEquipmentType record, @Param("example") IgcsAEquipmentTypeExample example);

    int updateByExample(@Param("record") IgcsAEquipmentType record, @Param("example") IgcsAEquipmentTypeExample example);

    int updateByPrimaryKeySelective(IgcsAEquipmentType record);

    int updateByPrimaryKey(IgcsAEquipmentType record);
}
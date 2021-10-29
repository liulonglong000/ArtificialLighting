package com.face.mapper;

import com.face.model.IgcsIGatewayInfo;
import com.face.model.IgcsIGatewayInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IgcsIGatewayInfoMapper {
    int countByExample(IgcsIGatewayInfoExample example);

    int deleteByExample(IgcsIGatewayInfoExample example);

    int deleteByPrimaryKey(String gatewayId);

    int insert(IgcsIGatewayInfo record);

    int insertSelective(IgcsIGatewayInfo record);

    List<IgcsIGatewayInfo> selectByExample(IgcsIGatewayInfoExample example);

    IgcsIGatewayInfo selectByPrimaryKey(String gatewayId);

    int updateByExampleSelective(@Param("record") IgcsIGatewayInfo record, @Param("example") IgcsIGatewayInfoExample example);

    int updateByExample(@Param("record") IgcsIGatewayInfo record, @Param("example") IgcsIGatewayInfoExample example);

    int updateByPrimaryKeySelective(IgcsIGatewayInfo record);

    int updateByPrimaryKey(IgcsIGatewayInfo record);
}
package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingDeliveryLog;
import com.xdj.www.entity.ShoppingDeliveryLogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingDeliveryLogMapper {
    long countByExample(ShoppingDeliveryLogExample example);

    int deleteByExample(ShoppingDeliveryLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingDeliveryLog record);

    int insertSelective(ShoppingDeliveryLog record);

    List<ShoppingDeliveryLog> selectByExample(ShoppingDeliveryLogExample example);

    ShoppingDeliveryLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingDeliveryLog record, @Param("example") ShoppingDeliveryLogExample example);

    int updateByExample(@Param("record") ShoppingDeliveryLog record, @Param("example") ShoppingDeliveryLogExample example);

    int updateByPrimaryKeySelective(ShoppingDeliveryLog record);

    int updateByPrimaryKey(ShoppingDeliveryLog record);
}

package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingShipping;
import com.xdj.www.entity.ShoppingShippingExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingShippingMapper {
    long countByExample(ShoppingShippingExample example);

    int deleteByExample(ShoppingShippingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingShipping record);

    int insertSelective(ShoppingShipping record);

    List<ShoppingShipping> selectByExampleWithBLOBs(ShoppingShippingExample example);

    List<ShoppingShipping> selectByExample(ShoppingShippingExample example);

    ShoppingShipping selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingShipping record, @Param("example") ShoppingShippingExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingShipping record, @Param("example") ShoppingShippingExample example);

    int updateByExample(@Param("record") ShoppingShipping record, @Param("example") ShoppingShippingExample example);

    int updateByPrimaryKeySelective(ShoppingShipping record);

    int updateByPrimaryKeyWithBLOBs(ShoppingShipping record);

    int updateByPrimaryKey(ShoppingShipping record);
}

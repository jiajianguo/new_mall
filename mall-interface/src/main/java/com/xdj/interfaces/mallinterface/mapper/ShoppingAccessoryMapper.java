package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingAccessory;
import com.xdj.www.entity.ShoppingAccessoryExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingAccessoryMapper {
    long countByExample(ShoppingAccessoryExample example);

    int deleteByExample(ShoppingAccessoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingAccessory record);

    int insertSelective(ShoppingAccessory record);

    List<ShoppingAccessory> selectByExample(ShoppingAccessoryExample example);

    ShoppingAccessory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingAccessory record, @Param("example") ShoppingAccessoryExample example);

    int updateByExample(@Param("record") ShoppingAccessory record, @Param("example") ShoppingAccessoryExample example);

    int updateByPrimaryKeySelective(ShoppingAccessory record);

    int updateByPrimaryKey(ShoppingAccessory record);

    List<ShoppingAccessory> queryByCondition(Map<String, Object> params);

    List<ShoppingAccessory> queryByGoodsId(@Param("goods_id") Long goods_id);
}

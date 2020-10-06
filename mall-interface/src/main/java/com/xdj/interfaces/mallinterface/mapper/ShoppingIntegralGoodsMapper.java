package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingIntegralGoods;
import com.xdj.www.entity.ShoppingIntegralGoodsExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingIntegralGoodsMapper {
    long countByExample(ShoppingIntegralGoodsExample example);

    int deleteByExample(ShoppingIntegralGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingIntegralGoods record);

    int insertSelective(ShoppingIntegralGoods record);

    List<ShoppingIntegralGoods> selectByExample(ShoppingIntegralGoodsExample example);

    ShoppingIntegralGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingIntegralGoods record, @Param("example") ShoppingIntegralGoodsExample example);

    int updateByExample(@Param("record") ShoppingIntegralGoods record, @Param("example") ShoppingIntegralGoodsExample example);

    int updateByPrimaryKeySelective(ShoppingIntegralGoods record);

    int updateByPrimaryKey(ShoppingIntegralGoods record);

    List<ShoppingIntegralGoods> queryByCondition(Map params);
}

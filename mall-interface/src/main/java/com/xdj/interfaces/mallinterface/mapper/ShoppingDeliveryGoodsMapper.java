package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingDeliveryGoods;
import com.xdj.www.entity.ShoppingDeliveryGoodsExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingDeliveryGoodsMapper {
    long countByExample(ShoppingDeliveryGoodsExample example);

    int deleteByExample(ShoppingDeliveryGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingDeliveryGoods record);

    int insertSelective(ShoppingDeliveryGoods record);

    List<ShoppingDeliveryGoods> selectByExample(ShoppingDeliveryGoodsExample example);

    ShoppingDeliveryGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingDeliveryGoods record, @Param("example") ShoppingDeliveryGoodsExample example);

    int updateByExample(@Param("record") ShoppingDeliveryGoods record, @Param("example") ShoppingDeliveryGoodsExample example);

    int updateByPrimaryKeySelective(ShoppingDeliveryGoods record);

    int updateByPrimaryKey(ShoppingDeliveryGoods record);

    List<ShoppingDeliveryGoods> queryByCondition(Map params);

    ShoppingDeliveryGoods queryByGoodsId( @Param("goodsId") Long goodsId);

    List<ShoppingDeliveryGoods> pageList(Map<String, Object> params);

    int count(Map<String, Object> params);
}

package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingBargainGoods;
import com.xdj.www.entity.ShoppingBargainGoodsExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingBargainGoodsMapper {
    long countByExample(ShoppingBargainGoodsExample example);

    int deleteByExample(ShoppingBargainGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingBargainGoods record);

    int insertSelective(ShoppingBargainGoods record);

    List<ShoppingBargainGoods> selectByExample(ShoppingBargainGoodsExample example);

    ShoppingBargainGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingBargainGoods record, @Param("example") ShoppingBargainGoodsExample example);

    int updateByExample(@Param("record") ShoppingBargainGoods record, @Param("example") ShoppingBargainGoodsExample example);

    int updateByPrimaryKeySelective(ShoppingBargainGoods record);

    int updateByPrimaryKey(ShoppingBargainGoods record);

    List<ShoppingBargainGoods> pageList(Map<String, Object> para);

    int count(Map<String, Object> para);

    List<ShoppingBargainGoods> queryByCondition(Map<String, Object> para);
}

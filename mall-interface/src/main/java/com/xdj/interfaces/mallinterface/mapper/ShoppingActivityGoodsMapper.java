package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingActivityGoods;
import com.xdj.www.entity.ShoppingActivityGoodsExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
@Mapper
public interface ShoppingActivityGoodsMapper {

    long countByExample(ShoppingActivityGoodsExample example);

    int deleteByExample(ShoppingActivityGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingActivityGoods record);

    int insertSelective(ShoppingActivityGoods record);

    List<ShoppingActivityGoods> selectByExample(ShoppingActivityGoodsExample example);

    ShoppingActivityGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingActivityGoods record, @Param("example") ShoppingActivityGoodsExample example);

    int updateByExample(@Param("record") ShoppingActivityGoods record, @Param("example") ShoppingActivityGoodsExample example);

    int updateByPrimaryKeySelective(ShoppingActivityGoods record);

    int updateByPrimaryKey(ShoppingActivityGoods record);

    List<ShoppingActivityGoods> pageList(Map<String, Object> para);

    int count(Map<String, Object> para);
}

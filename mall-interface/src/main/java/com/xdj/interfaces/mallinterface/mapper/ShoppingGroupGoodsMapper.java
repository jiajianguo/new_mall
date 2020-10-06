package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGroupGoods;
import com.xdj.www.entity.ShoppingGroupGoodsExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGroupGoodsMapper {
    long countByExample(ShoppingGroupGoodsExample example);

    int deleteByExample(ShoppingGroupGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGroupGoods record);

    int insertSelective(ShoppingGroupGoods record);

    List<ShoppingGroupGoods> selectByExampleWithBLOBs(ShoppingGroupGoodsExample example);

    List<ShoppingGroupGoods> selectByExample(ShoppingGroupGoodsExample example);

    ShoppingGroupGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGroupGoods record, @Param("example") ShoppingGroupGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingGroupGoods record, @Param("example") ShoppingGroupGoodsExample example);

    int updateByExample(@Param("record") ShoppingGroupGoods record, @Param("example") ShoppingGroupGoodsExample example);

    int updateByPrimaryKeySelective(ShoppingGroupGoods record);

    int updateByPrimaryKeyWithBLOBs(ShoppingGroupGoods record);

    int updateByPrimaryKey(ShoppingGroupGoods record);

    List<ShoppingGroupGoods> queryByCondition(Map params);

    int count(Map params);
}

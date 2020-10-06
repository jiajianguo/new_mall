package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodsUgc;
import com.xdj.www.entity.ShoppingGoodsUgcExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoodsUgcMapper {
    long countByExample(ShoppingGoodsUgcExample example);

    int deleteByExample(ShoppingGoodsUgcExample example);

    int insert(ShoppingGoodsUgc record);

    int insertSelective(ShoppingGoodsUgc record);

    List<ShoppingGoodsUgc> selectByExample(ShoppingGoodsUgcExample example);

    int updateByExampleSelective(@Param("record") ShoppingGoodsUgc record, @Param("example") ShoppingGoodsUgcExample example);

    int updateByExample(@Param("record") ShoppingGoodsUgc record, @Param("example") ShoppingGoodsUgcExample example);
}

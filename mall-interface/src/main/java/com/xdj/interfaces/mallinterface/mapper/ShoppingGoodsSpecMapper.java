package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodsSpec;
import com.xdj.www.entity.ShoppingGoodsSpecExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoodsSpecMapper {
    long countByExample(ShoppingGoodsSpecExample example);

    int deleteByExample(ShoppingGoodsSpecExample example);

    int insert(ShoppingGoodsSpec record);

    int insertSelective(ShoppingGoodsSpec record);

    List<ShoppingGoodsSpec> selectByExample(ShoppingGoodsSpecExample example);

    int updateByExampleSelective(@Param("record") ShoppingGoodsSpec record, @Param("example") ShoppingGoodsSpecExample example);

    int updateByExample(@Param("record") ShoppingGoodsSpec record, @Param("example") ShoppingGoodsSpecExample example);
}

package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodsCombin;
import com.xdj.www.entity.ShoppingGoodsCombinExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoodsCombinMapper {
    long countByExample(ShoppingGoodsCombinExample example);

    int deleteByExample(ShoppingGoodsCombinExample example);

    int insert(ShoppingGoodsCombin record);

    int insertSelective(ShoppingGoodsCombin record);

    List<ShoppingGoodsCombin> selectByExample(ShoppingGoodsCombinExample example);

    int updateByExampleSelective(@Param("record") ShoppingGoodsCombin record, @Param("example") ShoppingGoodsCombinExample example);

    int updateByExample(@Param("record") ShoppingGoodsCombin record, @Param("example") ShoppingGoodsCombinExample example);
}

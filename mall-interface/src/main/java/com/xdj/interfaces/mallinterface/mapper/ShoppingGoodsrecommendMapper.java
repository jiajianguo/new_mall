package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodsrecommend;
import com.xdj.www.entity.ShoppingGoodsrecommendExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoodsrecommendMapper {
    long countByExample(ShoppingGoodsrecommendExample example);

    int deleteByExample(ShoppingGoodsrecommendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGoodsrecommend record);

    int insertSelective(ShoppingGoodsrecommend record);

    List<ShoppingGoodsrecommend> selectByExampleWithBLOBs(ShoppingGoodsrecommendExample example);

    List<ShoppingGoodsrecommend> selectByExample(ShoppingGoodsrecommendExample example);

    ShoppingGoodsrecommend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGoodsrecommend record, @Param("example") ShoppingGoodsrecommendExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingGoodsrecommend record, @Param("example") ShoppingGoodsrecommendExample example);

    int updateByExample(@Param("record") ShoppingGoodsrecommend record, @Param("example") ShoppingGoodsrecommendExample example);

    int updateByPrimaryKeySelective(ShoppingGoodsrecommend record);

    int updateByPrimaryKeyWithBLOBs(ShoppingGoodsrecommend record);

    int updateByPrimaryKey(ShoppingGoodsrecommend record);
}

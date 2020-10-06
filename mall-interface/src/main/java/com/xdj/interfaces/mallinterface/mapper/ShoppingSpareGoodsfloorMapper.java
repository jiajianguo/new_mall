package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingSpareGoodsfloor;
import com.xdj.www.entity.ShoppingSpareGoodsfloorExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingSpareGoodsfloorMapper {
    long countByExample(ShoppingSpareGoodsfloorExample example);

    int deleteByExample(ShoppingSpareGoodsfloorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingSpareGoodsfloor record);

    int insertSelective(ShoppingSpareGoodsfloor record);

    List<ShoppingSpareGoodsfloor> selectByExample(ShoppingSpareGoodsfloorExample example);

    ShoppingSpareGoodsfloor selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingSpareGoodsfloor record, @Param("example") ShoppingSpareGoodsfloorExample example);

    int updateByExample(@Param("record") ShoppingSpareGoodsfloor record, @Param("example") ShoppingSpareGoodsfloorExample example);

    int updateByPrimaryKeySelective(ShoppingSpareGoodsfloor record);

    int updateByPrimaryKey(ShoppingSpareGoodsfloor record);

    List<ShoppingSpareGoodsfloor> queryByCondition(Map params);
}

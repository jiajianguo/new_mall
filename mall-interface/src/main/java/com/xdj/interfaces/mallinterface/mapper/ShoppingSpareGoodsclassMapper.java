package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingSpareGoodsclass;
import com.xdj.www.entity.ShoppingSpareGoodsclassExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingSpareGoodsclassMapper {
    long countByExample(ShoppingSpareGoodsclassExample example);

    int deleteByExample(ShoppingSpareGoodsclassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingSpareGoodsclass record);

    int insertSelective(ShoppingSpareGoodsclass record);

    List<ShoppingSpareGoodsclass> selectByExample(ShoppingSpareGoodsclassExample example);

    ShoppingSpareGoodsclass selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingSpareGoodsclass record, @Param("example") ShoppingSpareGoodsclassExample example);

    int updateByExample(@Param("record") ShoppingSpareGoodsclass record, @Param("example") ShoppingSpareGoodsclassExample example);

    int updateByPrimaryKeySelective(ShoppingSpareGoodsclass record);

    int updateByPrimaryKey(ShoppingSpareGoodsclass record);

    List<ShoppingSpareGoodsclass> queryByCondition(Map params);
}

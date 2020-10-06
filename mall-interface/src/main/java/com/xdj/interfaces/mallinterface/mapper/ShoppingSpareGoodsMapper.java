package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingSpareGoods;
import com.xdj.www.entity.ShoppingSpareGoodsExample;
import com.xdj.www.entity.ShoppingSpareGoodsWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingSpareGoodsMapper {
    long countByExample(ShoppingSpareGoodsExample example);

    int deleteByExample(ShoppingSpareGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingSpareGoodsWithBLOBs record);

    int insertSelective(ShoppingSpareGoodsWithBLOBs record);

    List<ShoppingSpareGoodsWithBLOBs> selectByExampleWithBLOBs(ShoppingSpareGoodsExample example);

    List<ShoppingSpareGoods> selectByExample(ShoppingSpareGoodsExample example);

    ShoppingSpareGoodsWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingSpareGoodsWithBLOBs record, @Param("example") ShoppingSpareGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingSpareGoodsWithBLOBs record, @Param("example") ShoppingSpareGoodsExample example);

    int updateByExample(@Param("record") ShoppingSpareGoods record, @Param("example") ShoppingSpareGoodsExample example);

    int updateByPrimaryKeySelective(ShoppingSpareGoodsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingSpareGoodsWithBLOBs record);

    int updateByPrimaryKey(ShoppingSpareGoods record);

    List<ShoppingSpareGoodsWithBLOBs> queryByCondition(Map params);

    ShoppingSpareGoodsWithBLOBs getObjById(Long id);

    int count(Map params);

    List<ShoppingSpareGoodsWithBLOBs> pageList(Map params);
}

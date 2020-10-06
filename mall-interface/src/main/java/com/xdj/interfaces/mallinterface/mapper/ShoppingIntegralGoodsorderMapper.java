package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingIntegralGoodsorder;
import com.xdj.www.entity.ShoppingIntegralGoodsorderExample;
import com.xdj.www.entity.ShoppingIntegralGoodsorderWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingIntegralGoodsorderMapper {
    long countByExample(ShoppingIntegralGoodsorderExample example);

    int deleteByExample(ShoppingIntegralGoodsorderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingIntegralGoodsorderWithBLOBs record);

    int insertSelective(ShoppingIntegralGoodsorderWithBLOBs record);

    List<ShoppingIntegralGoodsorderWithBLOBs> selectByExampleWithBLOBs(ShoppingIntegralGoodsorderExample example);

    List<ShoppingIntegralGoodsorder> selectByExample(ShoppingIntegralGoodsorderExample example);

    ShoppingIntegralGoodsorderWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingIntegralGoodsorderWithBLOBs record, @Param("example") ShoppingIntegralGoodsorderExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingIntegralGoodsorderWithBLOBs record, @Param("example") ShoppingIntegralGoodsorderExample example);

    int updateByExample(@Param("record") ShoppingIntegralGoodsorder record, @Param("example") ShoppingIntegralGoodsorderExample example);

    int updateByPrimaryKeySelective(ShoppingIntegralGoodsorderWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingIntegralGoodsorderWithBLOBs record);

    int updateByPrimaryKey(ShoppingIntegralGoodsorder record);

    List<ShoppingIntegralGoodsorderWithBLOBs> queryByCondition(Map<String, Object> params);

    int pageCount(Map<String, Object> params);
}

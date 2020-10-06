package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingIntegralGoodscart;
import com.xdj.www.entity.ShoppingIntegralGoodscartExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingIntegralGoodscartMapper {
    long countByExample(ShoppingIntegralGoodscartExample example);

    int deleteByExample(ShoppingIntegralGoodscartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingIntegralGoodscart record);

    int insertSelective(ShoppingIntegralGoodscart record);

    List<ShoppingIntegralGoodscart> selectByExample(ShoppingIntegralGoodscartExample example);

    ShoppingIntegralGoodscart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingIntegralGoodscart record, @Param("example") ShoppingIntegralGoodscartExample example);

    int updateByExample(@Param("record") ShoppingIntegralGoodscart record, @Param("example") ShoppingIntegralGoodscartExample example);

    int updateByPrimaryKeySelective(ShoppingIntegralGoodscart record);

    int updateByPrimaryKey(ShoppingIntegralGoodscart record);

    List<ShoppingIntegralGoodscart> queryByCondition(Map<String, Object> params);
}

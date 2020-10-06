package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGroupPriceRange;
import com.xdj.www.entity.ShoppingGroupPriceRangeExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGroupPriceRangeMapper {
    long countByExample(ShoppingGroupPriceRangeExample example);

    int deleteByExample(ShoppingGroupPriceRangeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGroupPriceRange record);

    int insertSelective(ShoppingGroupPriceRange record);

    List<ShoppingGroupPriceRange> selectByExample(ShoppingGroupPriceRangeExample example);

    ShoppingGroupPriceRange selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGroupPriceRange record, @Param("example") ShoppingGroupPriceRangeExample example);

    int updateByExample(@Param("record") ShoppingGroupPriceRange record, @Param("example") ShoppingGroupPriceRangeExample example);

    int updateByPrimaryKeySelective(ShoppingGroupPriceRange record);

    int updateByPrimaryKey(ShoppingGroupPriceRange record);

    List<ShoppingGroupPriceRange> queryByCondition(Map params);
}

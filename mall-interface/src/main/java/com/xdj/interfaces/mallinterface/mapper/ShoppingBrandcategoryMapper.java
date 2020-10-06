package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingBrandcategory;
import com.xdj.www.entity.ShoppingBrandcategoryExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingBrandcategoryMapper {
    long countByExample(ShoppingBrandcategoryExample example);

    int deleteByExample(ShoppingBrandcategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingBrandcategory record);

    int insertSelective(ShoppingBrandcategory record);

    List<ShoppingBrandcategory> selectByExample(ShoppingBrandcategoryExample example);

    ShoppingBrandcategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingBrandcategory record, @Param("example") ShoppingBrandcategoryExample example);

    int updateByExample(@Param("record") ShoppingBrandcategory record, @Param("example") ShoppingBrandcategoryExample example);

    int updateByPrimaryKeySelective(ShoppingBrandcategory record);

    int updateByPrimaryKey(ShoppingBrandcategory record);

    List<ShoppingBrandcategory> queryByCondition(Map<String, Object> params);
}

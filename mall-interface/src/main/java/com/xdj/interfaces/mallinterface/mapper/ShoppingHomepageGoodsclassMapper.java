package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingHomepageGoodsclass;
import com.xdj.www.entity.ShoppingHomepageGoodsclassExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingHomepageGoodsclassMapper {
    long countByExample(ShoppingHomepageGoodsclassExample example);

    int deleteByExample(ShoppingHomepageGoodsclassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingHomepageGoodsclass record);

    int insertSelective(ShoppingHomepageGoodsclass record);

    List<ShoppingHomepageGoodsclass> selectByExample(ShoppingHomepageGoodsclassExample example);

    ShoppingHomepageGoodsclass selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingHomepageGoodsclass record, @Param("example") ShoppingHomepageGoodsclassExample example);

    int updateByExample(@Param("record") ShoppingHomepageGoodsclass record, @Param("example") ShoppingHomepageGoodsclassExample example);

    int updateByPrimaryKeySelective(ShoppingHomepageGoodsclass record);

    int updateByPrimaryKey(ShoppingHomepageGoodsclass record);

    List<ShoppingHomepageGoodsclass> queryByCondition(Map<String, Object> params);
}

package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingHomepageGoodsclassLog;
import com.xdj.www.entity.ShoppingHomepageGoodsclassLogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingHomepageGoodsclassLogMapper {
    long countByExample(ShoppingHomepageGoodsclassLogExample example);

    int deleteByExample(ShoppingHomepageGoodsclassLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingHomepageGoodsclassLog record);

    int insertSelective(ShoppingHomepageGoodsclassLog record);

    List<ShoppingHomepageGoodsclassLog> selectByExample(ShoppingHomepageGoodsclassLogExample example);

    ShoppingHomepageGoodsclassLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingHomepageGoodsclassLog record, @Param("example") ShoppingHomepageGoodsclassLogExample example);

    int updateByExample(@Param("record") ShoppingHomepageGoodsclassLog record, @Param("example") ShoppingHomepageGoodsclassLogExample example);

    int updateByPrimaryKeySelective(ShoppingHomepageGoodsclassLog record);

    int updateByPrimaryKey(ShoppingHomepageGoodsclassLog record);
}

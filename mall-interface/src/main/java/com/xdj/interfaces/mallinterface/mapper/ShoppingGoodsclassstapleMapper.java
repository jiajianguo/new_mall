package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodsclassstaple;
import com.xdj.www.entity.ShoppingGoodsclassstapleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoodsclassstapleMapper {
    long countByExample(ShoppingGoodsclassstapleExample example);

    int deleteByExample(ShoppingGoodsclassstapleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGoodsclassstaple record);

    int insertSelective(ShoppingGoodsclassstaple record);

    List<ShoppingGoodsclassstaple> selectByExample(ShoppingGoodsclassstapleExample example);

    ShoppingGoodsclassstaple selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGoodsclassstaple record, @Param("example") ShoppingGoodsclassstapleExample example);

    int updateByExample(@Param("record") ShoppingGoodsclassstaple record, @Param("example") ShoppingGoodsclassstapleExample example);

    int updateByPrimaryKeySelective(ShoppingGoodsclassstaple record);

    int updateByPrimaryKey(ShoppingGoodsclassstaple record);

    List<ShoppingGoodsclassstaple> queryByStoreId(@Param("storeId") Long storeId);
}

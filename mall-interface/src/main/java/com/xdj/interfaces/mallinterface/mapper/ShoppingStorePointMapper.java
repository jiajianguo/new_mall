package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingStorePoint;
import com.xdj.www.entity.ShoppingStorePointExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingStorePointMapper {
    long countByExample(ShoppingStorePointExample example);

    int deleteByExample(ShoppingStorePointExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingStorePoint record);

    int insertSelective(ShoppingStorePoint record);

    List<ShoppingStorePoint> selectByExample(ShoppingStorePointExample example);

    ShoppingStorePoint selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingStorePoint record, @Param("example") ShoppingStorePointExample example);

    int updateByExample(@Param("record") ShoppingStorePoint record, @Param("example") ShoppingStorePointExample example);

    int updateByPrimaryKeySelective(ShoppingStorePoint record);

    int updateByPrimaryKey(ShoppingStorePoint record);

    ShoppingStorePoint queryOne(@Param("storeId") Long storeId);
}

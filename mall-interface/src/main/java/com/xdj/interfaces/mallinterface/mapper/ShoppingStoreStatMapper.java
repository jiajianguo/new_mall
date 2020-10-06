package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingStoreStat;
import com.xdj.www.entity.ShoppingStoreStatExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingStoreStatMapper {
    long countByExample(ShoppingStoreStatExample example);

    int deleteByExample(ShoppingStoreStatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingStoreStat record);

    int insertSelective(ShoppingStoreStat record);

    List<ShoppingStoreStat> selectByExample(ShoppingStoreStatExample example);

    ShoppingStoreStat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingStoreStat record, @Param("example") ShoppingStoreStatExample example);

    int updateByExample(@Param("record") ShoppingStoreStat record, @Param("example") ShoppingStoreStatExample example);

    int updateByPrimaryKeySelective(ShoppingStoreStat record);

    int updateByPrimaryKey(ShoppingStoreStat record);
}

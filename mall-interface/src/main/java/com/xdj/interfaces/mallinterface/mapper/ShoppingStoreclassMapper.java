package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingStoreclass;
import com.xdj.www.entity.ShoppingStoreclassExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingStoreclassMapper {
    long countByExample(ShoppingStoreclassExample example);

    int deleteByExample(ShoppingStoreclassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingStoreclass record);

    int insertSelective(ShoppingStoreclass record);

    List<ShoppingStoreclass> selectByExample(ShoppingStoreclassExample example);

    ShoppingStoreclass selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingStoreclass record, @Param("example") ShoppingStoreclassExample example);

    int updateByExample(@Param("record") ShoppingStoreclass record, @Param("example") ShoppingStoreclassExample example);

    int updateByPrimaryKeySelective(ShoppingStoreclass record);

    int updateByPrimaryKey(ShoppingStoreclass record);

    List<ShoppingStoreclass> queryByCondition(Map<String, Object> params);
}

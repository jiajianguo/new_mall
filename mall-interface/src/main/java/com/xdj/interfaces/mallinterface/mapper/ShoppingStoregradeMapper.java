package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingStoregrade;
import com.xdj.www.entity.ShoppingStoregradeExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingStoregradeMapper {
    long countByExample(ShoppingStoregradeExample example);

    int deleteByExample(ShoppingStoregradeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingStoregrade record);

    int insertSelective(ShoppingStoregrade record);

    List<ShoppingStoregrade> selectByExampleWithBLOBs(ShoppingStoregradeExample example);

    List<ShoppingStoregrade> selectByExample(ShoppingStoregradeExample example);

    ShoppingStoregrade selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingStoregrade record, @Param("example") ShoppingStoregradeExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingStoregrade record, @Param("example") ShoppingStoregradeExample example);

    int updateByExample(@Param("record") ShoppingStoregrade record, @Param("example") ShoppingStoregradeExample example);

    int updateByPrimaryKeySelective(ShoppingStoregrade record);

    int updateByPrimaryKeyWithBLOBs(ShoppingStoregrade record);

    int updateByPrimaryKey(ShoppingStoregrade record);

    List<ShoppingStoregrade> queryByCondition(Map<String, Object> params);
}

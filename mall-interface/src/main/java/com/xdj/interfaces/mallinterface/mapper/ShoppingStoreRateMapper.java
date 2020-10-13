package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingStoreRate;
import com.xdj.www.entity.ShoppingStoreRateExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ShoppingStoreRateMapper {
    long countByExample(ShoppingStoreRateExample example);

    int deleteByExample(ShoppingStoreRateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingStoreRate record);

    int insertSelective(ShoppingStoreRate record);

    List<ShoppingStoreRate> selectByExample(ShoppingStoreRateExample example);

    ShoppingStoreRate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingStoreRate record, @Param("example") ShoppingStoreRateExample example);

    int updateByExample(@Param("record") ShoppingStoreRate record, @Param("example") ShoppingStoreRateExample example);

    int updateByPrimaryKeySelective(ShoppingStoreRate record);

    int updateByPrimaryKey(ShoppingStoreRate record);
}
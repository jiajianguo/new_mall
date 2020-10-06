package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingAddress;
import com.xdj.www.entity.ShoppingAddressExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingAddressMapper {
    long countByExample(ShoppingAddressExample example);

    int deleteByExample(ShoppingAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingAddress record);

    int insertSelective(ShoppingAddress record);

    List<ShoppingAddress> selectByExample(ShoppingAddressExample example);

    ShoppingAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingAddress record, @Param("example") ShoppingAddressExample example);

    int updateByExample(@Param("record") ShoppingAddress record, @Param("example") ShoppingAddressExample example);

    int updateByPrimaryKeySelective(ShoppingAddress record);

    int updateByPrimaryKey(ShoppingAddress record);

    List<ShoppingAddress> queryByCondition(Map params);

    int count(Map params);
}

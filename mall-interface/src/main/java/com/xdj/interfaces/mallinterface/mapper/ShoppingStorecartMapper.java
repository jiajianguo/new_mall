package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingStorecart;
import com.xdj.www.entity.ShoppingStorecartExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingStorecartMapper {
    long countByExample(ShoppingStorecartExample example);

    int deleteByExample(ShoppingStorecartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingStorecart record);

    int insertSelective(ShoppingStorecart record);

    List<ShoppingStorecart> selectByExample(ShoppingStorecartExample example);

    ShoppingStorecart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingStorecart record, @Param("example") ShoppingStorecartExample example);

    int updateByExample(@Param("record") ShoppingStorecart record, @Param("example") ShoppingStorecartExample example);

    int updateByPrimaryKeySelective(ShoppingStorecart record);

    int updateByPrimaryKey(ShoppingStorecart record);

    List<ShoppingStorecart> queryByCondition(Map params);

    List<ShoppingStorecart> queryCookiecart(Map params);
}

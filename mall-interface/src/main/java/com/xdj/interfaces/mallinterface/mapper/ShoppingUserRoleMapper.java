package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingUserRoleExample;
import com.xdj.www.entity.ShoppingUserRoleKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingUserRoleMapper {
    long countByExample(ShoppingUserRoleExample example);

    int deleteByExample(ShoppingUserRoleExample example);

    int deleteByPrimaryKey(ShoppingUserRoleKey key);

    int insert(ShoppingUserRoleKey record);

    int insertSelective(ShoppingUserRoleKey record);

    List<ShoppingUserRoleKey> selectByExample(ShoppingUserRoleExample example);

    int updateByExampleSelective(@Param("record") ShoppingUserRoleKey record, @Param("example") ShoppingUserRoleExample example);

    int updateByExample(@Param("record") ShoppingUserRoleKey record, @Param("example") ShoppingUserRoleExample example);
}

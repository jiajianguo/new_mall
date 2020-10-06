package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingRoleRes;
import com.xdj.www.entity.ShoppingRoleResExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingRoleResMapper {
    long countByExample(ShoppingRoleResExample example);

    int deleteByExample(ShoppingRoleResExample example);

    int insert(ShoppingRoleRes record);

    int insertSelective(ShoppingRoleRes record);

    List<ShoppingRoleRes> selectByExample(ShoppingRoleResExample example);

    int updateByExampleSelective(@Param("record") ShoppingRoleRes record, @Param("example") ShoppingRoleResExample example);

    int updateByExample(@Param("record") ShoppingRoleRes record, @Param("example") ShoppingRoleResExample example);
}

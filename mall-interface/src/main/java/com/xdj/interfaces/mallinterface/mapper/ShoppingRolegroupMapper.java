package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingRolegroup;
import com.xdj.www.entity.ShoppingRolegroupExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingRolegroupMapper {
    long countByExample(ShoppingRolegroupExample example);

    int deleteByExample(ShoppingRolegroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingRolegroup record);

    int insertSelective(ShoppingRolegroup record);

    List<ShoppingRolegroup> selectByExample(ShoppingRolegroupExample example);

    ShoppingRolegroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingRolegroup record, @Param("example") ShoppingRolegroupExample example);

    int updateByExample(@Param("record") ShoppingRolegroup record, @Param("example") ShoppingRolegroupExample example);

    int updateByPrimaryKeySelective(ShoppingRolegroup record);

    int updateByPrimaryKey(ShoppingRolegroup record);
}

package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingRole;
import com.xdj.www.entity.ShoppingRoleExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingRoleMapper {
    long countByExample(ShoppingRoleExample example);

    int deleteByExample(ShoppingRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingRole record);

    int insertSelective(ShoppingRole record);

    List<ShoppingRole> selectByExample(ShoppingRoleExample example);

    ShoppingRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingRole record, @Param("example") ShoppingRoleExample example);

    int updateByExample(@Param("record") ShoppingRole record, @Param("example") ShoppingRoleExample example);

    int updateByPrimaryKeySelective(ShoppingRole record);

    int updateByPrimaryKey(ShoppingRole record);

    List<ShoppingRole> queryByCondition(Map params);

    List<ShoppingRole> queryRoleByUserId(@Param("user_id") Long user_id);
}

package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.UserRoles;
import com.xdj.www.entity.UserRolesExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRolesMapper {
    long countByExample(UserRolesExample example);

    int deleteByExample(UserRolesExample example);

    int insert(UserRoles record);

    int insertSelective(UserRoles record);

    List<UserRoles> selectByExample(UserRolesExample example);

    int updateByExampleSelective(@Param("record") UserRoles record, @Param("example") UserRolesExample example);

    int updateByExample(@Param("record") UserRoles record, @Param("example") UserRolesExample example);
}

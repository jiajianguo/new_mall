package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingUserFriend;
import com.xdj.www.entity.ShoppingUserFriendExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingUserFriendMapper {
    long countByExample(ShoppingUserFriendExample example);

    int deleteByExample(ShoppingUserFriendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingUserFriend record);

    int insertSelective(ShoppingUserFriend record);

    List<ShoppingUserFriend> selectByExample(ShoppingUserFriendExample example);

    ShoppingUserFriend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingUserFriend record, @Param("example") ShoppingUserFriendExample example);

    int updateByExample(@Param("record") ShoppingUserFriend record, @Param("example") ShoppingUserFriendExample example);

    int updateByPrimaryKeySelective(ShoppingUserFriend record);

    int updateByPrimaryKey(ShoppingUserFriend record);

    List<ShoppingUserFriend> queryByCondition(Map<String, Object> map);
}

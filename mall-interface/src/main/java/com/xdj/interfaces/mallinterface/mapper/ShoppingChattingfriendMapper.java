package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingChattingfriend;
import com.xdj.www.entity.ShoppingChattingfriendExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface ShoppingChattingfriendMapper {
    long countByExample(ShoppingChattingfriendExample example);

    int deleteByExample(ShoppingChattingfriendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingChattingfriend record);

    int insertSelective(ShoppingChattingfriend record);

    List<ShoppingChattingfriend> selectByExample(ShoppingChattingfriendExample example);

    ShoppingChattingfriend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingChattingfriend record, @Param("example") ShoppingChattingfriendExample example);

    int updateByExample(@Param("record") ShoppingChattingfriend record, @Param("example") ShoppingChattingfriendExample example);

    int updateByPrimaryKeySelective(ShoppingChattingfriend record);

    int updateByPrimaryKey(ShoppingChattingfriend record);
}

package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingChatting;
import com.xdj.www.entity.ShoppingChattingExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingChattingMapper {
    long countByExample(ShoppingChattingExample example);

    int deleteByExample(ShoppingChattingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingChatting record);

    int insertSelective(ShoppingChatting record);

    List<ShoppingChatting> selectByExample(ShoppingChattingExample example);

    ShoppingChatting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingChatting record, @Param("example") ShoppingChattingExample example);

    int updateByExample(@Param("record") ShoppingChatting record, @Param("example") ShoppingChattingExample example);

    int updateByPrimaryKeySelective(ShoppingChatting record);

    int updateByPrimaryKey(ShoppingChatting record);
}

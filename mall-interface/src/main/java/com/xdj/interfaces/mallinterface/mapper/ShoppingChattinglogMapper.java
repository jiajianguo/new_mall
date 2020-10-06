package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingChattinglog;
import com.xdj.www.entity.ShoppingChattinglogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingChattinglogMapper {
    long countByExample(ShoppingChattinglogExample example);

    int deleteByExample(ShoppingChattinglogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingChattinglog record);

    int insertSelective(ShoppingChattinglog record);

    List<ShoppingChattinglog> selectByExampleWithBLOBs(ShoppingChattinglogExample example);

    List<ShoppingChattinglog> selectByExample(ShoppingChattinglogExample example);

    ShoppingChattinglog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingChattinglog record, @Param("example") ShoppingChattinglogExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingChattinglog record, @Param("example") ShoppingChattinglogExample example);

    int updateByExample(@Param("record") ShoppingChattinglog record, @Param("example") ShoppingChattinglogExample example);

    int updateByPrimaryKeySelective(ShoppingChattinglog record);

    int updateByPrimaryKeyWithBLOBs(ShoppingChattinglog record);

    int updateByPrimaryKey(ShoppingChattinglog record);
}

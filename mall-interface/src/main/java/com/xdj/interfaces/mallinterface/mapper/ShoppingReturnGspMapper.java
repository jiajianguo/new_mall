package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingReturnGsp;
import com.xdj.www.entity.ShoppingReturnGspExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingReturnGspMapper {
    long countByExample(ShoppingReturnGspExample example);

    int deleteByExample(ShoppingReturnGspExample example);

    int insert(ShoppingReturnGsp record);

    int insertSelective(ShoppingReturnGsp record);

    List<ShoppingReturnGsp> selectByExample(ShoppingReturnGspExample example);

    int updateByExampleSelective(@Param("record") ShoppingReturnGsp record, @Param("example") ShoppingReturnGspExample example);

    int updateByExample(@Param("record") ShoppingReturnGsp record, @Param("example") ShoppingReturnGspExample example);
}

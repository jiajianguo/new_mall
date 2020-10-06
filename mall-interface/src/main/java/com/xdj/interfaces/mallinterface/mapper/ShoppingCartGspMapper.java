package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingCartGsp;
import com.xdj.www.entity.ShoppingCartGspExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface ShoppingCartGspMapper {
    long countByExample(ShoppingCartGspExample example);

    int deleteByExample(ShoppingCartGspExample example);

    int insert(ShoppingCartGsp record);

    int insertSelective(ShoppingCartGsp record);

    List<ShoppingCartGsp> selectByExample(ShoppingCartGspExample example);

    int updateByExampleSelective(@Param("record") ShoppingCartGsp record, @Param("example") ShoppingCartGspExample example);

    int updateByExample(@Param("record") ShoppingCartGsp record, @Param("example") ShoppingCartGspExample example);
}

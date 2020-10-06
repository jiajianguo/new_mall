package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingRes;
import com.xdj.www.entity.ShoppingResExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingResMapper {
    long countByExample(ShoppingResExample example);

    int deleteByExample(ShoppingResExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingRes record);

    int insertSelective(ShoppingRes record);

    List<ShoppingRes> selectByExample(ShoppingResExample example);

    ShoppingRes selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingRes record, @Param("example") ShoppingResExample example);

    int updateByExample(@Param("record") ShoppingRes record, @Param("example") ShoppingResExample example);

    int updateByPrimaryKeySelective(ShoppingRes record);

    int updateByPrimaryKey(ShoppingRes record);
}

package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingVlog;
import com.xdj.www.entity.ShoppingVlogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingVlogMapper {
    long countByExample(ShoppingVlogExample example);

    int deleteByExample(ShoppingVlogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingVlog record);

    int insertSelective(ShoppingVlog record);

    List<ShoppingVlog> selectByExample(ShoppingVlogExample example);

    ShoppingVlog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingVlog record, @Param("example") ShoppingVlogExample example);

    int updateByExample(@Param("record") ShoppingVlog record, @Param("example") ShoppingVlogExample example);

    int updateByPrimaryKeySelective(ShoppingVlog record);

    int updateByPrimaryKey(ShoppingVlog record);
}

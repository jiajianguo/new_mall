package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingIntegrallog;
import com.xdj.www.entity.ShoppingIntegrallogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingIntegrallogMapper {
    long countByExample(ShoppingIntegrallogExample example);

    int deleteByExample(ShoppingIntegrallogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingIntegrallog record);

    int insertSelective(ShoppingIntegrallog record);

    List<ShoppingIntegrallog> selectByExampleWithBLOBs(ShoppingIntegrallogExample example);

    List<ShoppingIntegrallog> selectByExample(ShoppingIntegrallogExample example);

    ShoppingIntegrallog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingIntegrallog record, @Param("example") ShoppingIntegrallogExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingIntegrallog record, @Param("example") ShoppingIntegrallogExample example);

    int updateByExample(@Param("record") ShoppingIntegrallog record, @Param("example") ShoppingIntegrallogExample example);

    int updateByPrimaryKeySelective(ShoppingIntegrallog record);

    int updateByPrimaryKeyWithBLOBs(ShoppingIntegrallog record);

    int updateByPrimaryKey(ShoppingIntegrallog record);
}

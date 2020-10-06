package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingOrderLog;
import com.xdj.www.entity.ShoppingOrderLogExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingOrderLogMapper {
    long countByExample(ShoppingOrderLogExample example);

    int deleteByExample(ShoppingOrderLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingOrderLog record);

    int insertSelective(ShoppingOrderLog record);

    List<ShoppingOrderLog> selectByExampleWithBLOBs(ShoppingOrderLogExample example);

    List<ShoppingOrderLog> selectByExample(ShoppingOrderLogExample example);

    ShoppingOrderLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingOrderLog record, @Param("example") ShoppingOrderLogExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingOrderLog record, @Param("example") ShoppingOrderLogExample example);

    int updateByExample(@Param("record") ShoppingOrderLog record, @Param("example") ShoppingOrderLogExample example);

    int updateByPrimaryKeySelective(ShoppingOrderLog record);

    int updateByPrimaryKeyWithBLOBs(ShoppingOrderLog record);

    int updateByPrimaryKey(ShoppingOrderLog record);

    List<ShoppingOrderLog> queryByCondition(Map<String, Object> params);
}

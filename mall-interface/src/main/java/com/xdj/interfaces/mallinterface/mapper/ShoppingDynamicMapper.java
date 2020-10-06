package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingDynamic;
import com.xdj.www.entity.ShoppingDynamicExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingDynamicMapper {
    long countByExample(ShoppingDynamicExample example);

    int deleteByExample(ShoppingDynamicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingDynamic record);

    int insertSelective(ShoppingDynamic record);

    List<ShoppingDynamic> selectByExampleWithBLOBs(ShoppingDynamicExample example);

    List<ShoppingDynamic> selectByExample(ShoppingDynamicExample example);

    ShoppingDynamic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingDynamic record, @Param("example") ShoppingDynamicExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingDynamic record, @Param("example") ShoppingDynamicExample example);

    int updateByExample(@Param("record") ShoppingDynamic record, @Param("example") ShoppingDynamicExample example);

    int updateByPrimaryKeySelective(ShoppingDynamic record);

    int updateByPrimaryKeyWithBLOBs(ShoppingDynamic record);

    int updateByPrimaryKey(ShoppingDynamic record);

    List<ShoppingDynamic> pageList(Map<String, Object> params);

    int count(Map<String, Object> params);
}

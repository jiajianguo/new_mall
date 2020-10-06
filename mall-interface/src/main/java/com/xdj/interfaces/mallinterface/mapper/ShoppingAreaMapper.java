package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingArea;
import com.xdj.www.entity.ShoppingAreaExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingAreaMapper {
    long countByExample(ShoppingAreaExample example);

    int deleteByExample(ShoppingAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingArea record);

    int insertSelective(ShoppingArea record);

    List<ShoppingArea> selectByExample(ShoppingAreaExample example);

    ShoppingArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingArea record, @Param("example") ShoppingAreaExample example);

    int updateByExample(@Param("record") ShoppingArea record, @Param("example") ShoppingAreaExample example);

    int updateByPrimaryKeySelective(ShoppingArea record);

    int updateByPrimaryKey(ShoppingArea record);

    List<ShoppingArea> queryByCondition(Map params);
}

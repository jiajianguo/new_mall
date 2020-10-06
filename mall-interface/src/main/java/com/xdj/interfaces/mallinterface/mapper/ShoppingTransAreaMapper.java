package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingTransArea;
import com.xdj.www.entity.ShoppingTransAreaExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingTransAreaMapper {
    long countByExample(ShoppingTransAreaExample example);

    int deleteByExample(ShoppingTransAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingTransArea record);

    int insertSelective(ShoppingTransArea record);

    List<ShoppingTransArea> selectByExample(ShoppingTransAreaExample example);

    ShoppingTransArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingTransArea record, @Param("example") ShoppingTransAreaExample example);

    int updateByExample(@Param("record") ShoppingTransArea record, @Param("example") ShoppingTransAreaExample example);

    int updateByPrimaryKeySelective(ShoppingTransArea record);

    int updateByPrimaryKey(ShoppingTransArea record);
}

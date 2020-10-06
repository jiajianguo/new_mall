package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingHomeAddention;
import com.xdj.www.entity.ShoppingHomeAddentionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingHomeAddentionMapper {
    long countByExample(ShoppingHomeAddentionExample example);

    int deleteByExample(ShoppingHomeAddentionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingHomeAddention record);

    int insertSelective(ShoppingHomeAddention record);

    List<ShoppingHomeAddention> selectByExample(ShoppingHomeAddentionExample example);

    ShoppingHomeAddention selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingHomeAddention record, @Param("example") ShoppingHomeAddentionExample example);

    int updateByExample(@Param("record") ShoppingHomeAddention record, @Param("example") ShoppingHomeAddentionExample example);

    int updateByPrimaryKeySelective(ShoppingHomeAddention record);

    int updateByPrimaryKey(ShoppingHomeAddention record);
}

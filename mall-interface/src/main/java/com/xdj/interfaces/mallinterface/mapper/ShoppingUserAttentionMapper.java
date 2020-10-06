package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingUserAttention;
import com.xdj.www.entity.ShoppingUserAttentionExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
@Mapper
public interface ShoppingUserAttentionMapper {
    long countByExample(ShoppingUserAttentionExample example);

    int deleteByExample(ShoppingUserAttentionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingUserAttention record);

    int insertSelective(ShoppingUserAttention record);

    List<ShoppingUserAttention> selectByExample(ShoppingUserAttentionExample example);

    ShoppingUserAttention selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingUserAttention record, @Param("example") ShoppingUserAttentionExample example);

    int updateByExample(@Param("record") ShoppingUserAttention record, @Param("example") ShoppingUserAttentionExample example);

    int updateByPrimaryKeySelective(ShoppingUserAttention record);

    int updateByPrimaryKey(ShoppingUserAttention record);

    List<ShoppingUserAttention> queryByCondition(Map map);
}

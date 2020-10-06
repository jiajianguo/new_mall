package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingWatermark;
import com.xdj.www.entity.ShoppingWatermarkExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingWatermarkMapper {
    long countByExample(ShoppingWatermarkExample example);

    int deleteByExample(ShoppingWatermarkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingWatermark record);

    int insertSelective(ShoppingWatermark record);

    List<ShoppingWatermark> selectByExample(ShoppingWatermarkExample example);

    ShoppingWatermark selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingWatermark record, @Param("example") ShoppingWatermarkExample example);

    int updateByExample(@Param("record") ShoppingWatermark record, @Param("example") ShoppingWatermarkExample example);

    int updateByPrimaryKeySelective(ShoppingWatermark record);

    int updateByPrimaryKey(ShoppingWatermark record);
}

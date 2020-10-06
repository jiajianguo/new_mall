package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingActivity;
import com.xdj.www.entity.ShoppingActivityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingActivityMapper {
    long countByExample(ShoppingActivityExample example);

    int deleteByExample(ShoppingActivityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingActivity record);

    int insertSelective(ShoppingActivity record);

    List<ShoppingActivity> selectByExampleWithBLOBs(ShoppingActivityExample example);

    List<ShoppingActivity> selectByExample(ShoppingActivityExample example);

    ShoppingActivity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingActivity record, @Param("example") ShoppingActivityExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingActivity record, @Param("example") ShoppingActivityExample example);

    int updateByExample(@Param("record") ShoppingActivity record, @Param("example") ShoppingActivityExample example);

    int updateByPrimaryKeySelective(ShoppingActivity record);

    int updateByPrimaryKeyWithBLOBs(ShoppingActivity record);

    int updateByPrimaryKey(ShoppingActivity record);
}

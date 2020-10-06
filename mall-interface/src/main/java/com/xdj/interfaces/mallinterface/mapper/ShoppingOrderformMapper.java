package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingOrderform;
import com.xdj.www.entity.ShoppingOrderformExample;
import com.xdj.www.entity.ShoppingOrderformWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingOrderformMapper {
    long countByExample(ShoppingOrderformExample example);

    int deleteByExample(ShoppingOrderformExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingOrderformWithBLOBs record);

    int insertSelective(ShoppingOrderformWithBLOBs record);

    List<ShoppingOrderformWithBLOBs> selectByExampleWithBLOBs(ShoppingOrderformExample example);

    List<ShoppingOrderform> selectByExample(ShoppingOrderformExample example);

    ShoppingOrderformWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingOrderformWithBLOBs record, @Param("example") ShoppingOrderformExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingOrderformWithBLOBs record, @Param("example") ShoppingOrderformExample example);

    int updateByExample(@Param("record") ShoppingOrderform record, @Param("example") ShoppingOrderformExample example);

    int updateByPrimaryKeySelective(ShoppingOrderformWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingOrderformWithBLOBs record);

    int updateByPrimaryKey(ShoppingOrderform record);

    List<ShoppingOrderformWithBLOBs> pageList(Map<String, Object> params);

    int count(Map<String, Object> params);

    List<ShoppingOrderformWithBLOBs> selectByOrderNo(@Param("orderId") String orderId);
}

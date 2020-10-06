package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodsFloor;
import com.xdj.www.entity.ShoppingGoodsFloorExample;
import com.xdj.www.entity.ShoppingGoodsFloorWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoodsFloorMapper {
    long countByExample(ShoppingGoodsFloorExample example);

    int deleteByExample(ShoppingGoodsFloorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGoodsFloorWithBLOBs record);

    int insertSelective(ShoppingGoodsFloorWithBLOBs record);

    List<ShoppingGoodsFloorWithBLOBs> selectByExampleWithBLOBs(ShoppingGoodsFloorExample example);

    List<ShoppingGoodsFloor> selectByExample(ShoppingGoodsFloorExample example);

    ShoppingGoodsFloorWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGoodsFloorWithBLOBs record, @Param("example") ShoppingGoodsFloorExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingGoodsFloorWithBLOBs record, @Param("example") ShoppingGoodsFloorExample example);

    int updateByExample(@Param("record") ShoppingGoodsFloor record, @Param("example") ShoppingGoodsFloorExample example);

    int updateByPrimaryKeySelective(ShoppingGoodsFloorWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingGoodsFloorWithBLOBs record);

    int updateByPrimaryKey(ShoppingGoodsFloor record);

    List queryByCondition(Map params);
}

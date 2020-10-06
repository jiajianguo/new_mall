package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodsspecification;
import com.xdj.www.entity.ShoppingGoodsspecificationExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoodsspecificationMapper {
    long countByExample(ShoppingGoodsspecificationExample example);

    int deleteByExample(ShoppingGoodsspecificationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGoodsspecification record);

    int insertSelective(ShoppingGoodsspecification record);

    List<ShoppingGoodsspecification> selectByExample(ShoppingGoodsspecificationExample example);

    ShoppingGoodsspecification selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGoodsspecification record, @Param("example") ShoppingGoodsspecificationExample example);

    int updateByExample(@Param("record") ShoppingGoodsspecification record, @Param("example") ShoppingGoodsspecificationExample example);

    int updateByPrimaryKeySelective(ShoppingGoodsspecification record);

    int updateByPrimaryKey(ShoppingGoodsspecification record);

    List<ShoppingGoodsspecification> queryByConditoin(Map<String, Object> para);
}

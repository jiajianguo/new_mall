package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodsspecproperty;
import com.xdj.www.entity.ShoppingGoodsspecpropertyExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoodsspecpropertyMapper {
    long countByExample(ShoppingGoodsspecpropertyExample example);

    int deleteByExample(ShoppingGoodsspecpropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGoodsspecproperty record);

    int insertSelective(ShoppingGoodsspecproperty record);

    List<ShoppingGoodsspecproperty> selectByExample(ShoppingGoodsspecpropertyExample example);

    ShoppingGoodsspecproperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGoodsspecproperty record, @Param("example") ShoppingGoodsspecpropertyExample example);

    int updateByExample(@Param("record") ShoppingGoodsspecproperty record, @Param("example") ShoppingGoodsspecpropertyExample example);

    int updateByPrimaryKeySelective(ShoppingGoodsspecproperty record);

    int updateByPrimaryKey(ShoppingGoodsspecproperty record);

    List<ShoppingGoodsspecproperty> queryByConditoin(Map<String, Object> para);
}

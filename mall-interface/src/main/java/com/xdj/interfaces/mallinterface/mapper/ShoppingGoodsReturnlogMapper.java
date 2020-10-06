package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodsReturnlog;
import com.xdj.www.entity.ShoppingGoodsReturnlogExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoodsReturnlogMapper {
    long countByExample(ShoppingGoodsReturnlogExample example);

    int deleteByExample(ShoppingGoodsReturnlogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGoodsReturnlog record);

    int insertSelective(ShoppingGoodsReturnlog record);

    List<ShoppingGoodsReturnlog> selectByExample(ShoppingGoodsReturnlogExample example);

    ShoppingGoodsReturnlog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGoodsReturnlog record, @Param("example") ShoppingGoodsReturnlogExample example);

    int updateByExample(@Param("record") ShoppingGoodsReturnlog record, @Param("example") ShoppingGoodsReturnlogExample example);

    int updateByPrimaryKeySelective(ShoppingGoodsReturnlog record);

    int updateByPrimaryKey(ShoppingGoodsReturnlog record);

    List<ShoppingGoodsReturnlog> queryByCondition(Map<String, Object> params);
}

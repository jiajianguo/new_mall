package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodsReturn;
import com.xdj.www.entity.ShoppingGoodsReturnExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoodsReturnMapper {
    long countByExample(ShoppingGoodsReturnExample example);

    int deleteByExample(ShoppingGoodsReturnExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGoodsReturn record);

    int insertSelective(ShoppingGoodsReturn record);

    List<ShoppingGoodsReturn> selectByExampleWithBLOBs(ShoppingGoodsReturnExample example);

    List<ShoppingGoodsReturn> selectByExample(ShoppingGoodsReturnExample example);

    ShoppingGoodsReturn selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGoodsReturn record, @Param("example") ShoppingGoodsReturnExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingGoodsReturn record, @Param("example") ShoppingGoodsReturnExample example);

    int updateByExample(@Param("record") ShoppingGoodsReturn record, @Param("example") ShoppingGoodsReturnExample example);

    int updateByPrimaryKeySelective(ShoppingGoodsReturn record);

    int updateByPrimaryKeyWithBLOBs(ShoppingGoodsReturn record);

    int updateByPrimaryKey(ShoppingGoodsReturn record);
}

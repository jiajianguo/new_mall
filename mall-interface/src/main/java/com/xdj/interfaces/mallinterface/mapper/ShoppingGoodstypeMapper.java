package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodstype;
import com.xdj.www.entity.ShoppingGoodstypeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoodstypeMapper {
    long countByExample(ShoppingGoodstypeExample example);

    int deleteByExample(ShoppingGoodstypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGoodstype record);

    int insertSelective(ShoppingGoodstype record);

    List<ShoppingGoodstype> selectByExample(ShoppingGoodstypeExample example);

    ShoppingGoodstype selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGoodstype record, @Param("example") ShoppingGoodstypeExample example);

    int updateByExample(@Param("record") ShoppingGoodstype record, @Param("example") ShoppingGoodstypeExample example);

    int updateByPrimaryKeySelective(ShoppingGoodstype record);

    int updateByPrimaryKey(ShoppingGoodstype record);
}

package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodstypeSpec;
import com.xdj.www.entity.ShoppingGoodstypeSpecExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoodstypeSpecMapper {
    long countByExample(ShoppingGoodstypeSpecExample example);

    int deleteByExample(ShoppingGoodstypeSpecExample example);

    int insert(ShoppingGoodstypeSpec record);

    int insertSelective(ShoppingGoodstypeSpec record);

    List<ShoppingGoodstypeSpec> selectByExample(ShoppingGoodstypeSpecExample example);

    int updateByExampleSelective(@Param("record") ShoppingGoodstypeSpec record, @Param("example") ShoppingGoodstypeSpecExample example);

    int updateByExample(@Param("record") ShoppingGoodstypeSpec record, @Param("example") ShoppingGoodstypeSpecExample example);
}

package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodstypeBrand;
import com.xdj.www.entity.ShoppingGoodstypeBrandExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoodstypeBrandMapper {
    long countByExample(ShoppingGoodstypeBrandExample example);

    int deleteByExample(ShoppingGoodstypeBrandExample example);

    int insert(ShoppingGoodstypeBrand record);

    int insertSelective(ShoppingGoodstypeBrand record);

    List<ShoppingGoodstypeBrand> selectByExample(ShoppingGoodstypeBrandExample example);

    int updateByExampleSelective(@Param("record") ShoppingGoodstypeBrand record, @Param("example") ShoppingGoodstypeBrandExample example);

    int updateByExample(@Param("record") ShoppingGoodstypeBrand record, @Param("example") ShoppingGoodstypeBrandExample example);
}

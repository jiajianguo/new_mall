package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingUsergoodsclass;
import com.xdj.www.entity.ShoppingUsergoodsclassExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingUsergoodsclassMapper {
    long countByExample(ShoppingUsergoodsclassExample example);

    int deleteByExample(ShoppingUsergoodsclassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingUsergoodsclass record);

    int insertSelective(ShoppingUsergoodsclass record);

    List<ShoppingUsergoodsclass> selectByExample(ShoppingUsergoodsclassExample example);

    ShoppingUsergoodsclass selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingUsergoodsclass record, @Param("example") ShoppingUsergoodsclassExample example);

    int updateByExample(@Param("record") ShoppingUsergoodsclass record, @Param("example") ShoppingUsergoodsclassExample example);

    int updateByPrimaryKeySelective(ShoppingUsergoodsclass record);

    int updateByPrimaryKey(ShoppingUsergoodsclass record);

    List queryByCondition(Map map);
}

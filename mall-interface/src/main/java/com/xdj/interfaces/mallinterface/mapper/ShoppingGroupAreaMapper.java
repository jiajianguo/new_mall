package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGroupArea;
import com.xdj.www.entity.ShoppingGroupAreaExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGroupAreaMapper {
    long countByExample(ShoppingGroupAreaExample example);

    int deleteByExample(ShoppingGroupAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGroupArea record);

    int insertSelective(ShoppingGroupArea record);

    List<ShoppingGroupArea> selectByExample(ShoppingGroupAreaExample example);

    ShoppingGroupArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGroupArea record, @Param("example") ShoppingGroupAreaExample example);

    int updateByExample(@Param("record") ShoppingGroupArea record, @Param("example") ShoppingGroupAreaExample example);

    int updateByPrimaryKeySelective(ShoppingGroupArea record);

    int updateByPrimaryKey(ShoppingGroupArea record);

    List<ShoppingGroupArea> queryByCondition(Map<String, Object> params);
}

package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingAdvert;
import com.xdj.www.entity.ShoppingAdvertExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingAdvertMapper {
    long countByExample(ShoppingAdvertExample example);

    int deleteByExample(ShoppingAdvertExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingAdvert record);

    int insertSelective(ShoppingAdvert record);

    List<ShoppingAdvert> selectByExample(ShoppingAdvertExample example);

    ShoppingAdvert selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingAdvert record, @Param("example") ShoppingAdvertExample example);

    int updateByExample(@Param("record") ShoppingAdvert record, @Param("example") ShoppingAdvertExample example);

    int updateByPrimaryKeySelective(ShoppingAdvert record);

    int updateByPrimaryKey(ShoppingAdvert record);

    List<ShoppingAdvert> queryByCondition(Map<String, Object> params);
}

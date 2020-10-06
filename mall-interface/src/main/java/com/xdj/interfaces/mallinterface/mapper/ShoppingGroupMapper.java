package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGroup;
import com.xdj.www.entity.ShoppingGroupExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShoppingGroupMapper {
    long countByExample(ShoppingGroupExample example);

    int deleteByExample(ShoppingGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGroup record);

    int insertSelective(ShoppingGroup record);

    List<ShoppingGroup> selectByExample(ShoppingGroupExample example);

    ShoppingGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGroup record, @Param("example") ShoppingGroupExample example);

    int updateByExample(@Param("record") ShoppingGroup record, @Param("example") ShoppingGroupExample example);

    int updateByPrimaryKeySelective(ShoppingGroup record);

    int updateByPrimaryKey(ShoppingGroup record);

    List<ShoppingGroup> queryByCondition(Map params);

    List<ShoppingGroup> queryBytime(Map params);

    int count(Map params);
}

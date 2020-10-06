package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingHomepage;
import com.xdj.www.entity.ShoppingHomepageExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingHomepageMapper {
    long countByExample(ShoppingHomepageExample example);

    int deleteByExample(ShoppingHomepageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingHomepage record);

    int insertSelective(ShoppingHomepage record);

    List<ShoppingHomepage> selectByExample(ShoppingHomepageExample example);

    ShoppingHomepage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingHomepage record, @Param("example") ShoppingHomepageExample example);

    int updateByExample(@Param("record") ShoppingHomepage record, @Param("example") ShoppingHomepageExample example);

    int updateByPrimaryKeySelective(ShoppingHomepage record);

    int updateByPrimaryKey(ShoppingHomepage record);

    List<ShoppingHomepage> queryByCondition(Map map);
}

package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingNavigation;
import com.xdj.www.entity.ShoppingNavigationExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingNavigationMapper {
    long countByExample(ShoppingNavigationExample example);

    int deleteByExample(ShoppingNavigationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingNavigation record);

    int insertSelective(ShoppingNavigation record);

    List<ShoppingNavigation> selectByExample(ShoppingNavigationExample example);

    ShoppingNavigation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingNavigation record, @Param("example") ShoppingNavigationExample example);

    int updateByExample(@Param("record") ShoppingNavigation record, @Param("example") ShoppingNavigationExample example);

    int updateByPrimaryKeySelective(ShoppingNavigation record);

    int updateByPrimaryKey(ShoppingNavigation record);

    List<ShoppingNavigation> queryByConditin(Map<String, Object> paras);
}

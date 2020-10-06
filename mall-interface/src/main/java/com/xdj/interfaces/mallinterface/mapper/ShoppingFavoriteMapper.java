package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingFavorite;
import com.xdj.www.entity.ShoppingFavoriteExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingFavoriteMapper {
    long countByExample(ShoppingFavoriteExample example);

    int deleteByExample(ShoppingFavoriteExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingFavorite record);

    int insertSelective(ShoppingFavorite record);

    List<ShoppingFavorite> selectByExample(ShoppingFavoriteExample example);

    ShoppingFavorite selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingFavorite record, @Param("example") ShoppingFavoriteExample example);

    int updateByExample(@Param("record") ShoppingFavorite record, @Param("example") ShoppingFavoriteExample example);

    int updateByPrimaryKeySelective(ShoppingFavorite record);

    int updateByPrimaryKey(ShoppingFavorite record);

    List<ShoppingFavorite> queryByCondition(Map params);

    int count(Map<String, Object> map);
}

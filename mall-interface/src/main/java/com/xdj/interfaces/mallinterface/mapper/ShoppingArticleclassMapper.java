package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingArticleclass;
import com.xdj.www.entity.ShoppingArticleclassExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
@Mapper
public interface ShoppingArticleclassMapper {

    long countByExample(ShoppingArticleclassExample example);

    int deleteByExample(ShoppingArticleclassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingArticleclass record);

    int insertSelective(ShoppingArticleclass record);

    List<ShoppingArticleclass> selectByExample(ShoppingArticleclassExample example);

    ShoppingArticleclass selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingArticleclass record, @Param("example") ShoppingArticleclassExample example);

    int updateByExample(@Param("record") ShoppingArticleclass record, @Param("example") ShoppingArticleclassExample example);

    int updateByPrimaryKeySelective(ShoppingArticleclass record);

    int updateByPrimaryKey(ShoppingArticleclass record);

    List<ShoppingArticleclass> queryByCondition(Map<String, Object> para);

    ShoppingArticleclass queryByMap(Map<String, Object> para);
}

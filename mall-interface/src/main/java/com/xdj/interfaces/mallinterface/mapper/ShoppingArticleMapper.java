package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingArticle;
import com.xdj.www.entity.ShoppingArticleExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingArticleMapper {
    long countByExample(ShoppingArticleExample example);

    int deleteByExample(ShoppingArticleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingArticle record);

    int insertSelective(ShoppingArticle record);

    List<ShoppingArticle> selectByExampleWithBLOBs(ShoppingArticleExample example);

    List<ShoppingArticle> selectByExample(ShoppingArticleExample example);

    ShoppingArticle selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingArticle record, @Param("example") ShoppingArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingArticle record, @Param("example") ShoppingArticleExample example);

    int updateByExample(@Param("record") ShoppingArticle record, @Param("example") ShoppingArticleExample example);

    int updateByPrimaryKeySelective(ShoppingArticle record);

    int updateByPrimaryKeyWithBLOBs(ShoppingArticle record);

    int updateByPrimaryKey(ShoppingArticle record);

    List<ShoppingArticle> pageList(Map<String, Object> para);

    int pageCount(Map<String, Object> para);

    List<ShoppingArticle> queryByCondition(Map<String, Object> para);

    ShoppingArticle queryByMap(Map<String, Object> para);
}

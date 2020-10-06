package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingTemplate;
import com.xdj.www.entity.ShoppingTemplateExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingTemplateMapper {
    long countByExample(ShoppingTemplateExample example);

    int deleteByExample(ShoppingTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingTemplate record);

    int insertSelective(ShoppingTemplate record);

    List<ShoppingTemplate> selectByExampleWithBLOBs(ShoppingTemplateExample example);

    List<ShoppingTemplate> selectByExample(ShoppingTemplateExample example);

    ShoppingTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingTemplate record, @Param("example") ShoppingTemplateExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingTemplate record, @Param("example") ShoppingTemplateExample example);

    int updateByExample(@Param("record") ShoppingTemplate record, @Param("example") ShoppingTemplateExample example);

    int updateByPrimaryKeySelective(ShoppingTemplate record);

    int updateByPrimaryKeyWithBLOBs(ShoppingTemplate record);

    int updateByPrimaryKey(ShoppingTemplate record);

    ShoppingTemplate queryByCondition(Map<String, Object> param);
}

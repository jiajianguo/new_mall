package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingMobileverifycode;
import com.xdj.www.entity.ShoppingMobileverifycodeExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingMobileverifycodeMapper {
    long countByExample(ShoppingMobileverifycodeExample example);

    int deleteByExample(ShoppingMobileverifycodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingMobileverifycode record);

    int insertSelective(ShoppingMobileverifycode record);

    List<ShoppingMobileverifycode> selectByExample(ShoppingMobileverifycodeExample example);

    ShoppingMobileverifycode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingMobileverifycode record, @Param("example") ShoppingMobileverifycodeExample example);

    int updateByExample(@Param("record") ShoppingMobileverifycode record, @Param("example") ShoppingMobileverifycodeExample example);

    int updateByPrimaryKeySelective(ShoppingMobileverifycode record);

    int updateByPrimaryKey(ShoppingMobileverifycode record);

    ShoppingMobileverifycode queryByCondition(Map<String, Object> params);
}

package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingUserconfig;
import com.xdj.www.entity.ShoppingUserconfigExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
@Mapper
public interface ShoppingUserconfigMapper {
    long countByExample(ShoppingUserconfigExample example);

    int deleteByExample(ShoppingUserconfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingUserconfig record);

    int insertSelective(ShoppingUserconfig record);

    List<ShoppingUserconfig> selectByExample(ShoppingUserconfigExample example);

    ShoppingUserconfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingUserconfig record, @Param("example") ShoppingUserconfigExample example);

    int updateByExample(@Param("record") ShoppingUserconfig record, @Param("example") ShoppingUserconfigExample example);

    int updateByPrimaryKeySelective(ShoppingUserconfig record);

    int updateByPrimaryKey(ShoppingUserconfig record);

    ShoppingUserconfig getUserConfig();
}

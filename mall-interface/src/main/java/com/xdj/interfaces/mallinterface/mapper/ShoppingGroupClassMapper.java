package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGroupClass;
import com.xdj.www.entity.ShoppingGroupClassExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGroupClassMapper {
    long countByExample(ShoppingGroupClassExample example);

    int deleteByExample(ShoppingGroupClassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGroupClass record);

    int insertSelective(ShoppingGroupClass record);

    List<ShoppingGroupClass> selectByExample(ShoppingGroupClassExample example);

    ShoppingGroupClass selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGroupClass record, @Param("example") ShoppingGroupClassExample example);

    int updateByExample(@Param("record") ShoppingGroupClass record, @Param("example") ShoppingGroupClassExample example);

    int updateByPrimaryKeySelective(ShoppingGroupClass record);

    int updateByPrimaryKey(ShoppingGroupClass record);

    List<ShoppingGroupClass> queryByCondition(Map params);
}

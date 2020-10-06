package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodstypeproperty;
import com.xdj.www.entity.ShoppingGoodstypepropertyExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoodstypepropertyMapper {
    long countByExample(ShoppingGoodstypepropertyExample example);

    int deleteByExample(ShoppingGoodstypepropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGoodstypeproperty record);

    int insertSelective(ShoppingGoodstypeproperty record);

    List<ShoppingGoodstypeproperty> selectByExample(ShoppingGoodstypepropertyExample example);

    ShoppingGoodstypeproperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGoodstypeproperty record, @Param("example") ShoppingGoodstypepropertyExample example);

    int updateByExample(@Param("record") ShoppingGoodstypeproperty record, @Param("example") ShoppingGoodstypepropertyExample example);

    int updateByPrimaryKeySelective(ShoppingGoodstypeproperty record);

    int updateByPrimaryKey(ShoppingGoodstypeproperty record);

    List<ShoppingGoodstypeproperty> queryByCondition(Map<String, Object> para);

    List<ShoppingGoodstypeproperty> queryByMany(Map<String, Object> para);
}

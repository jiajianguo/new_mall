package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingCombinLog;
import com.xdj.www.entity.ShoppingCombinLogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ShoppingCombinLogMapper {
    long countByExample(ShoppingCombinLogExample example);

    int deleteByExample(ShoppingCombinLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingCombinLog record);

    int insertSelective(ShoppingCombinLog record);

    List<ShoppingCombinLog> selectByExample(ShoppingCombinLogExample example);

    ShoppingCombinLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingCombinLog record, @Param("example") ShoppingCombinLogExample example);

    int updateByExample(@Param("record") ShoppingCombinLog record, @Param("example") ShoppingCombinLogExample example);

    int updateByPrimaryKeySelective(ShoppingCombinLog record);

    int updateByPrimaryKey(ShoppingCombinLog record);
}

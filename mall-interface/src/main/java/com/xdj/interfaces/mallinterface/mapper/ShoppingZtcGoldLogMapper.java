package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingZtcGoldLog;
import com.xdj.www.entity.ShoppingZtcGoldLogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingZtcGoldLogMapper {
    long countByExample(ShoppingZtcGoldLogExample example);

    int deleteByExample(ShoppingZtcGoldLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingZtcGoldLog record);

    int insertSelective(ShoppingZtcGoldLog record);

    List<ShoppingZtcGoldLog> selectByExample(ShoppingZtcGoldLogExample example);

    ShoppingZtcGoldLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingZtcGoldLog record, @Param("example") ShoppingZtcGoldLogExample example);

    int updateByExample(@Param("record") ShoppingZtcGoldLog record, @Param("example") ShoppingZtcGoldLogExample example);

    int updateByPrimaryKeySelective(ShoppingZtcGoldLog record);

    int updateByPrimaryKey(ShoppingZtcGoldLog record);
}

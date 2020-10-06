package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoldLog;
import com.xdj.www.entity.ShoppingGoldLogExample;
import com.xdj.www.entity.ShoppingGoldLogWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoldLogMapper {
    long countByExample(ShoppingGoldLogExample example);

    int deleteByExample(ShoppingGoldLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGoldLogWithBLOBs record);

    int insertSelective(ShoppingGoldLogWithBLOBs record);

    List<ShoppingGoldLogWithBLOBs> selectByExampleWithBLOBs(ShoppingGoldLogExample example);

    List<ShoppingGoldLog> selectByExample(ShoppingGoldLogExample example);

    ShoppingGoldLogWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGoldLogWithBLOBs record, @Param("example") ShoppingGoldLogExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingGoldLogWithBLOBs record, @Param("example") ShoppingGoldLogExample example);

    int updateByExample(@Param("record") ShoppingGoldLog record, @Param("example") ShoppingGoldLogExample example);

    int updateByPrimaryKeySelective(ShoppingGoldLogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingGoldLogWithBLOBs record);

    int updateByPrimaryKey(ShoppingGoldLog record);
}

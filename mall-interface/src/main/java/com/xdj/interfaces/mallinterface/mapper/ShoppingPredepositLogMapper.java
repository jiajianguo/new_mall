package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingPredepositLog;
import com.xdj.www.entity.ShoppingPredepositLogExample;
import java.util.List;
import java.util.Map;

import com.xdj.www.entity.ShoppingPredepositWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingPredepositLogMapper {
    long countByExample(ShoppingPredepositLogExample example);

    int deleteByExample(ShoppingPredepositLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingPredepositLog record);

    int insertSelective(ShoppingPredepositLog record);

    List<ShoppingPredepositLog> selectByExampleWithBLOBs(ShoppingPredepositLogExample example);

    List<ShoppingPredepositLog> selectByExample(ShoppingPredepositLogExample example);

    ShoppingPredepositLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingPredepositLog record, @Param("example") ShoppingPredepositLogExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingPredepositLog record, @Param("example") ShoppingPredepositLogExample example);

    int updateByExample(@Param("record") ShoppingPredepositLog record, @Param("example") ShoppingPredepositLogExample example);

    int updateByPrimaryKeySelective(ShoppingPredepositLog record);

    int updateByPrimaryKeyWithBLOBs(ShoppingPredepositLog record);

    int updateByPrimaryKey(ShoppingPredepositLog record);

    List<ShoppingPredepositLog> queryByCondition(Map<String, Object> map);

    int count(Map<String, Object> map);
}

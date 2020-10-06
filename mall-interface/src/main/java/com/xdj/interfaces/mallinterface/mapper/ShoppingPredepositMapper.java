package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingPredeposit;
import com.xdj.www.entity.ShoppingPredepositExample;
import com.xdj.www.entity.ShoppingPredepositWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingPredepositMapper {
    long countByExample(ShoppingPredepositExample example);

    int deleteByExample(ShoppingPredepositExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingPredepositWithBLOBs record);

    int insertSelective(ShoppingPredepositWithBLOBs record);

    List<ShoppingPredepositWithBLOBs> selectByExampleWithBLOBs(ShoppingPredepositExample example);

    List<ShoppingPredeposit> selectByExample(ShoppingPredepositExample example);

    ShoppingPredepositWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingPredepositWithBLOBs record, @Param("example") ShoppingPredepositExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingPredepositWithBLOBs record, @Param("example") ShoppingPredepositExample example);

    int updateByExample(@Param("record") ShoppingPredeposit record, @Param("example") ShoppingPredepositExample example);

    int updateByPrimaryKeySelective(ShoppingPredepositWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingPredepositWithBLOBs record);

    int updateByPrimaryKey(ShoppingPredeposit record);

    List<ShoppingPredepositWithBLOBs> queryByCondition(Map<String, Object> map);

    int count(Map<String, Object> map);
}

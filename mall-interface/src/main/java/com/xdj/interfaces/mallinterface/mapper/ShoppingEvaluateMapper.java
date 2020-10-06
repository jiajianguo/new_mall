package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingEvaluate;
import com.xdj.www.entity.ShoppingEvaluateExample;
import com.xdj.www.entity.ShoppingEvaluateWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShoppingEvaluateMapper {
    long countByExample(ShoppingEvaluateExample example);

    int deleteByExample(ShoppingEvaluateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingEvaluateWithBLOBs record);

    int insertSelective(ShoppingEvaluateWithBLOBs record);

    List<ShoppingEvaluateWithBLOBs> selectByExampleWithBLOBs(ShoppingEvaluateExample example);

    List<ShoppingEvaluate> selectByExample(ShoppingEvaluateExample example);

    ShoppingEvaluateWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingEvaluateWithBLOBs record, @Param("example") ShoppingEvaluateExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingEvaluateWithBLOBs record, @Param("example") ShoppingEvaluateExample example);

    int updateByExample(@Param("record") ShoppingEvaluate record, @Param("example") ShoppingEvaluateExample example);

    int updateByPrimaryKeySelective(ShoppingEvaluateWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingEvaluateWithBLOBs record);

    int updateByPrimaryKey(ShoppingEvaluate record);

    List queryByCondition(Map params);


    int count(Map<String, Object> params);

    List<ShoppingEvaluateWithBLOBs> queryBySg(Map<String, Object> params);

    int countSg(Map<String, Object> params);

    int queryCount(Map params);
}

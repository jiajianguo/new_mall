package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingVisit;
import com.xdj.www.entity.ShoppingVisitExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
@Mapper
public interface ShoppingVisitMapper {
    long countByExample(ShoppingVisitExample example);

    int deleteByExample(ShoppingVisitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingVisit record);

    int insertSelective(ShoppingVisit record);

    List<ShoppingVisit> selectByExample(ShoppingVisitExample example);

    ShoppingVisit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingVisit record, @Param("example") ShoppingVisitExample example);

    int updateByExample(@Param("record") ShoppingVisit record, @Param("example") ShoppingVisitExample example);

    int updateByPrimaryKeySelective(ShoppingVisit record);

    int updateByPrimaryKey(ShoppingVisit record);

    List<ShoppingVisit> queryByCondition(Map map);
}

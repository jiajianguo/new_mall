package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodsReturnitem;
import com.xdj.www.entity.ShoppingGoodsReturnitemExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
@Mapper
public interface ShoppingGoodsReturnitemMapper {
    long countByExample(ShoppingGoodsReturnitemExample example);

    int deleteByExample(ShoppingGoodsReturnitemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGoodsReturnitem record);

    int insertSelective(ShoppingGoodsReturnitem record);

    List<ShoppingGoodsReturnitem> selectByExampleWithBLOBs(ShoppingGoodsReturnitemExample example);

    List<ShoppingGoodsReturnitem> selectByExample(ShoppingGoodsReturnitemExample example);

    ShoppingGoodsReturnitem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGoodsReturnitem record, @Param("example") ShoppingGoodsReturnitemExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingGoodsReturnitem record, @Param("example") ShoppingGoodsReturnitemExample example);

    int updateByExample(@Param("record") ShoppingGoodsReturnitem record, @Param("example") ShoppingGoodsReturnitemExample example);

    int updateByPrimaryKeySelective(ShoppingGoodsReturnitem record);

    int updateByPrimaryKeyWithBLOBs(ShoppingGoodsReturnitem record);

    int updateByPrimaryKey(ShoppingGoodsReturnitem record);

    List<ShoppingGoodsReturnitem> queryByCondition(Map<String, Object> para);
}

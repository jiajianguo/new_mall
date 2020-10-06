package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodsclass;
import com.xdj.www.entity.ShoppingGoodsclassExample;
import com.xdj.www.entity.ShoppingGoodsclassWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoodsclassMapper {
    long countByExample(ShoppingGoodsclassExample example);

    int deleteByExample(ShoppingGoodsclassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGoodsclassWithBLOBs record);

    int insertSelective(ShoppingGoodsclassWithBLOBs record);

    List<ShoppingGoodsclassWithBLOBs> selectByExampleWithBLOBs(ShoppingGoodsclassExample example);

    List<ShoppingGoodsclass> selectByExample(ShoppingGoodsclassExample example);

    ShoppingGoodsclassWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGoodsclassWithBLOBs record, @Param("example") ShoppingGoodsclassExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingGoodsclassWithBLOBs record, @Param("example") ShoppingGoodsclassExample example);

    int updateByExample(@Param("record") ShoppingGoodsclass record, @Param("example") ShoppingGoodsclassExample example);

    int updateByPrimaryKeySelective(ShoppingGoodsclassWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingGoodsclassWithBLOBs record);

    int updateByPrimaryKey(ShoppingGoodsclass record);

    List<ShoppingGoodsclassWithBLOBs> queryByCondition(Map<String, Object> params);
}

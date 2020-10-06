package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoods;
import com.xdj.www.entity.ShoppingGoodsExample;
import com.xdj.www.entity.ShoppingGoodsWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
@Mapper
public interface ShoppingGoodsMapper {

    long countByExample(ShoppingGoodsExample example);

    int deleteByExample(ShoppingGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGoodsWithBLOBs record);

    int insertSelective(ShoppingGoodsWithBLOBs record);

    List<ShoppingGoodsWithBLOBs> selectByExampleWithBLOBs(ShoppingGoodsExample example);

    List<ShoppingGoods> selectByExample(ShoppingGoodsExample example);

    ShoppingGoodsWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGoodsWithBLOBs record, @Param("example") ShoppingGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingGoodsWithBLOBs record, @Param("example") ShoppingGoodsExample example);

    int updateByExample(@Param("record") ShoppingGoods record, @Param("example") ShoppingGoodsExample example);

    int updateByPrimaryKeySelective(ShoppingGoodsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingGoodsWithBLOBs record);

    int updateByPrimaryKey(ShoppingGoods record);

    int count(Map<String, Object> para);

    List<ShoppingGoods> pageList(Map<String, Object> goods);

    List<ShoppingGoodsWithBLOBs> queryByCondition(Map params);

    List<ShoppingGoodsWithBLOBs> queryMsg(Map paras);

    int queryMsgCount(Map paras);

    ShoppingGoodsWithBLOBs getObjById(@Param("id") Long id);

    List<ShoppingGoodsWithBLOBs> getCombinGoods(@Param("id") Long id);
}

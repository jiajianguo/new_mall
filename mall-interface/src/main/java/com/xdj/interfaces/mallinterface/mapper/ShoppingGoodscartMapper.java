package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodscart;
import com.xdj.www.entity.ShoppingGoodscartExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoodscartMapper {
    long countByExample(ShoppingGoodscartExample example);

    int deleteByExample(ShoppingGoodscartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGoodscart record);

    int insertSelective(ShoppingGoodscart record);

    List<ShoppingGoodscart> selectByExampleWithBLOBs(ShoppingGoodscartExample example);

    List<ShoppingGoodscart> selectByExample(ShoppingGoodscartExample example);

    ShoppingGoodscart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGoodscart record, @Param("example") ShoppingGoodscartExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingGoodscart record, @Param("example") ShoppingGoodscartExample example);

    int updateByExample(@Param("record") ShoppingGoodscart record, @Param("example") ShoppingGoodscartExample example);

    int updateByPrimaryKeySelective(ShoppingGoodscart record);

    int updateByPrimaryKeyWithBLOBs(ShoppingGoodscart record);

    int updateByPrimaryKey(ShoppingGoodscart record);

    List<ShoppingGoodscart> queryByCondition(Map params);

    int pageCount(Map<String, Object> params);

    List<ShoppingGoodscart> pageList(Map<String, Object> params);
}

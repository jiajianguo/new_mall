package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingStore;
import com.xdj.www.entity.ShoppingStoreExample;
import com.xdj.www.entity.ShoppingStoreWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingStoreMapper {
    long countByExample(ShoppingStoreExample example);

    int deleteByExample(ShoppingStoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingStoreWithBLOBs record);

    int insertSelective(ShoppingStoreWithBLOBs record);

    List<ShoppingStoreWithBLOBs> selectByExampleWithBLOBs(ShoppingStoreExample example);

    List<ShoppingStoreWithBLOBs> selectByExample(ShoppingStoreExample example);

    ShoppingStoreWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingStoreWithBLOBs record, @Param("example") ShoppingStoreExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingStoreWithBLOBs record, @Param("example") ShoppingStoreExample example);

    int updateByExample(@Param("record") ShoppingStore record, @Param("example") ShoppingStoreExample example);

    int updateByPrimaryKeySelective(ShoppingStoreWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingStoreWithBLOBs record);

    int updateByPrimaryKey(ShoppingStore record);

    ShoppingStoreWithBLOBs queryOne(Map<String, Object> map);

    List queryByCondition(Map params);

    ShoppingStoreWithBLOBs queryById(@Param("id") Long id);

    List<ShoppingStoreWithBLOBs> pageList(Map<String, Object> params);

    int count(Map<String, Object> params);
}

package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingStoreNav;
import com.xdj.www.entity.ShoppingStoreNavExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingStoreNavMapper {
    long countByExample(ShoppingStoreNavExample example);

    int deleteByExample(ShoppingStoreNavExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingStoreNav record);

    int insertSelective(ShoppingStoreNav record);

    List<ShoppingStoreNav> selectByExampleWithBLOBs(ShoppingStoreNavExample example);

    List<ShoppingStoreNav> selectByExample(ShoppingStoreNavExample example);

    ShoppingStoreNav selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingStoreNav record, @Param("example") ShoppingStoreNavExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingStoreNav record, @Param("example") ShoppingStoreNavExample example);

    int updateByExample(@Param("record") ShoppingStoreNav record, @Param("example") ShoppingStoreNavExample example);

    int updateByPrimaryKeySelective(ShoppingStoreNav record);

    int updateByPrimaryKeyWithBLOBs(ShoppingStoreNav record);

    int updateByPrimaryKey(ShoppingStoreNav record);

    List<ShoppingStoreNav> queryByCondition(Map params);
}

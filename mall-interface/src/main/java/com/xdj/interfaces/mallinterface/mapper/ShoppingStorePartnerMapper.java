package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingStorePartner;
import com.xdj.www.entity.ShoppingStorePartnerExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingStorePartnerMapper {
    long countByExample(ShoppingStorePartnerExample example);

    int deleteByExample(ShoppingStorePartnerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingStorePartner record);

    int insertSelective(ShoppingStorePartner record);

    List<ShoppingStorePartner> selectByExample(ShoppingStorePartnerExample example);

    ShoppingStorePartner selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingStorePartner record, @Param("example") ShoppingStorePartnerExample example);

    int updateByExample(@Param("record") ShoppingStorePartner record, @Param("example") ShoppingStorePartnerExample example);

    int updateByPrimaryKeySelective(ShoppingStorePartner record);

    int updateByPrimaryKey(ShoppingStorePartner record);

    List<ShoppingStorePartner> queryByCondition(Map params);
}

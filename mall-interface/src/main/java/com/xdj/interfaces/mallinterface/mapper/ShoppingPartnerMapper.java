package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingPartner;
import com.xdj.www.entity.ShoppingPartnerExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingPartnerMapper {
    long countByExample(ShoppingPartnerExample example);

    int deleteByExample(ShoppingPartnerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingPartner record);

    int insertSelective(ShoppingPartner record);

    List<ShoppingPartner> selectByExample(ShoppingPartnerExample example);

    ShoppingPartner selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingPartner record, @Param("example") ShoppingPartnerExample example);

    int updateByExample(@Param("record") ShoppingPartner record, @Param("example") ShoppingPartnerExample example);

    int updateByPrimaryKeySelective(ShoppingPartner record);

    int updateByPrimaryKey(ShoppingPartner record);

    List<ShoppingPartner> queryByCondition(Map params);
}

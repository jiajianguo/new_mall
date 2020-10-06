package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingExpressCompany;
import com.xdj.www.entity.ShoppingExpressCompanyExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingExpressCompanyMapper {
    long countByExample(ShoppingExpressCompanyExample example);

    int deleteByExample(ShoppingExpressCompanyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingExpressCompany record);

    int insertSelective(ShoppingExpressCompany record);

    List<ShoppingExpressCompany> selectByExample(ShoppingExpressCompanyExample example);

    ShoppingExpressCompany selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingExpressCompany record, @Param("example") ShoppingExpressCompanyExample example);

    int updateByExample(@Param("record") ShoppingExpressCompany record, @Param("example") ShoppingExpressCompanyExample example);

    int updateByPrimaryKeySelective(ShoppingExpressCompany record);

    int updateByPrimaryKey(ShoppingExpressCompany record);
}

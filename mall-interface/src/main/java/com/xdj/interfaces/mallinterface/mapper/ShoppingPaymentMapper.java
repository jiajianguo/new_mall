package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingPayment;
import com.xdj.www.entity.ShoppingPaymentExample;
import com.xdj.www.entity.ShoppingPaymentWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingPaymentMapper {
    long countByExample(ShoppingPaymentExample example);

    int deleteByExample(ShoppingPaymentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingPaymentWithBLOBs record);

    int insertSelective(ShoppingPaymentWithBLOBs record);

    List<ShoppingPaymentWithBLOBs> selectByExampleWithBLOBs(ShoppingPaymentExample example);

    List<ShoppingPayment> selectByExample(ShoppingPaymentExample example);

    ShoppingPaymentWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingPaymentWithBLOBs record, @Param("example") ShoppingPaymentExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingPaymentWithBLOBs record, @Param("example") ShoppingPaymentExample example);

    int updateByExample(@Param("record") ShoppingPayment record, @Param("example") ShoppingPaymentExample example);

    int updateByPrimaryKeySelective(ShoppingPaymentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingPaymentWithBLOBs record);

    int updateByPrimaryKey(ShoppingPayment record);

    List queryByCondition(Map params);
}

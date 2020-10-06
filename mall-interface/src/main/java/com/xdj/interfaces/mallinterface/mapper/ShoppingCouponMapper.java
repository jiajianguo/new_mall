package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingCoupon;
import com.xdj.www.entity.ShoppingCouponExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.mail.MailSessionDefinition;

@Mapper
public interface ShoppingCouponMapper {
    long countByExample(ShoppingCouponExample example);

    int deleteByExample(ShoppingCouponExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingCoupon record);

    int insertSelective(ShoppingCoupon record);

    List<ShoppingCoupon> selectByExample(ShoppingCouponExample example);

    ShoppingCoupon selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingCoupon record, @Param("example") ShoppingCouponExample example);

    int updateByExample(@Param("record") ShoppingCoupon record, @Param("example") ShoppingCouponExample example);

    int updateByPrimaryKeySelective(ShoppingCoupon record);

    int updateByPrimaryKey(ShoppingCoupon record);
}

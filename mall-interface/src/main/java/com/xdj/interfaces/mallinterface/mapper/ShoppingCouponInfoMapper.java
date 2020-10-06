package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingCoupon;
import com.xdj.www.entity.ShoppingCouponInfo;
import com.xdj.www.entity.ShoppingCouponInfoExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingCouponInfoMapper {
    long countByExample(ShoppingCouponInfoExample example);

    int deleteByExample(ShoppingCouponInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingCouponInfo record);

    int insertSelective(ShoppingCouponInfo record);

    List<ShoppingCouponInfo> selectByExample(ShoppingCouponInfoExample example);

    ShoppingCouponInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingCouponInfo record, @Param("example") ShoppingCouponInfoExample example);

    int updateByExample(@Param("record") ShoppingCouponInfo record, @Param("example") ShoppingCouponInfoExample example);

    int updateByPrimaryKeySelective(ShoppingCouponInfo record);

    int updateByPrimaryKey(ShoppingCouponInfo record);

    List<ShoppingCouponInfo> queryByCondition(Map params);

    List<ShoppingCoupon> pageList(Map<String, Object> params);

    int pageCount(Map<String, Object> params);
}

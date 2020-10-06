package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingCoupon;
import com.xdj.www.entity.ShoppingCouponInfo;
import com.xdj.www.entity.ShoppingCouponInfoExample;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public abstract interface ICouponInfoService
{
  public abstract int save(ShoppingCouponInfo paramCouponInfo);

  public abstract ShoppingCouponInfo getObjById(Long paramLong);

  public abstract int delete(Long paramLong);

  public abstract int batchDelete(List<Long> paramList);



  public abstract boolean update(ShoppingCouponInfo paramCouponInfo);


  public abstract   List<ShoppingCouponInfo> queryByCondition(Map params);


  int pageCount(Map<String, Object> params);

  long countByExample(ShoppingCouponInfoExample example);
}





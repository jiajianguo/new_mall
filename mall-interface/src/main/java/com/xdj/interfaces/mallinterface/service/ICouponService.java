package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingCoupon;
import com.xdj.www.entity.ShoppingCouponInfoExample;

import java.util.List;
import java.util.Map;

public abstract interface ICouponService {
  public abstract int save(ShoppingCoupon paramCoupon);

  public abstract ShoppingCoupon getObjById(Long paramLong);

  public abstract int delete(Long paramLong);

  public abstract int batchDelete(List<Long> paramList);


  public abstract boolean update(ShoppingCoupon paramCoupon);


}





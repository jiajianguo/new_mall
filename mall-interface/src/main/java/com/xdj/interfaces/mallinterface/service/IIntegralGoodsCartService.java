package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingIntegralGoodscart;

import java.util.List;
import java.util.Map;

public abstract interface IIntegralGoodsCartService
{
  public abstract boolean save(ShoppingIntegralGoodscart paramIntegralGoodsCart);

  public abstract ShoppingIntegralGoodscart getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);


  public abstract boolean update(ShoppingIntegralGoodscart paramIntegralGoodsCart);

  public abstract   List<ShoppingIntegralGoodscart> queryByCondition(Map<String, Object> params);
}





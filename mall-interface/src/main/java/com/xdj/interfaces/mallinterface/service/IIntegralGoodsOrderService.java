package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingIntegralGoodsorder;
import com.xdj.www.entity.ShoppingIntegralGoodsorderWithBLOBs;

import java.util.List;
import java.util.Map;

public abstract interface IIntegralGoodsOrderService
{
  public abstract boolean save(ShoppingIntegralGoodsorderWithBLOBs paramIntegralGoodsOrder);

  public abstract ShoppingIntegralGoodsorderWithBLOBs getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingIntegralGoodsorderWithBLOBs paramIntegralGoodsOrder);

  public abstract  List<ShoppingIntegralGoodsorderWithBLOBs> queryByCondition(Map<String, Object> params);

  public abstract int pageCount(Map<String, Object> params);
}





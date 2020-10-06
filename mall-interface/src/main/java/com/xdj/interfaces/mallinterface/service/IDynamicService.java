package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingDynamic;

import java.util.List;
import java.util.Map;

public abstract interface IDynamicService
{
  public abstract boolean save(ShoppingDynamic paramDynamic);

  public abstract ShoppingDynamic getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingDynamic paramDynamic);

  public abstract  List<ShoppingDynamic> pageList(Map<String, Object> params);

  int count(Map<String, Object> params);
}





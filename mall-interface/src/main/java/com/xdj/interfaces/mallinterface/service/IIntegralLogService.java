package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingIntegrallog;

import java.util.List;
import java.util.Map;

public abstract interface IIntegralLogService
{
  public abstract boolean save(ShoppingIntegrallog paramIntegralLog);

  public abstract ShoppingIntegrallog getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingIntegrallog paramIntegralLog);

}





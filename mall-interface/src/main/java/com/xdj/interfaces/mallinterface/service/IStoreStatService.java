package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingStoreStat;

import java.util.List;
import java.util.Map;

public abstract interface IStoreStatService
{
  public abstract boolean save(ShoppingStoreStat paramStoreStat);

  public abstract ShoppingStoreStat getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingStoreStat paramStoreStat);

}





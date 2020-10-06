package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingStorePoint;

import java.util.List;
import java.util.Map;

public abstract interface IStorePointService
{
  public abstract boolean save(ShoppingStorePoint paramStorePoint);

  public abstract ShoppingStorePoint getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingStorePoint paramStorePoint);

  public abstract   ShoppingStorePoint queryOne(Long storeId);
}





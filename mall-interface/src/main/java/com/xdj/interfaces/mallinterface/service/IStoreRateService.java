package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingStoreRate;

public abstract interface IStoreRateService
{
  public abstract boolean save(ShoppingStoreRate storeRate);

  public abstract ShoppingStoreRate getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean update(ShoppingStoreRate storeRate);

}



 
 
package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingAdvert;

import java.util.List;
import java.util.Map;


public abstract interface IAdvertService
{
  public abstract boolean save(ShoppingAdvert paramAdvert);

  public abstract ShoppingAdvert getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract int update(ShoppingAdvert paramAdvert);

  public abstract   List<ShoppingAdvert> queryByCondition(Map<String, Object> params);
}





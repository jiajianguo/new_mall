package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingWatermark;

import java.util.List;
import java.util.Map;

public abstract interface IWaterMarkService
{
  public abstract boolean save(ShoppingWatermark paramWaterMark);

  public abstract ShoppingWatermark getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingWatermark paramWaterMark);

}





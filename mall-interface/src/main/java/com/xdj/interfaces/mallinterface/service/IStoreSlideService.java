package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingStoreSlide;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface IStoreSlideService
{
  public abstract boolean save(ShoppingStoreSlide paramStoreSlide);

  public abstract ShoppingStoreSlide getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Serializable> paramList);

  public abstract boolean update(ShoppingStoreSlide paramStoreSlide);

  public abstract   List<ShoppingStoreSlide> queryByCondition(Map<String, Object> params);
}





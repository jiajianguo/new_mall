package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingGroupClass;

import java.util.List;
import java.util.Map;

public abstract interface IGroupClassService
{
  public abstract boolean save(ShoppingGroupClass paramGroupClass);

  public abstract ShoppingGroupClass getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingGroupClass paramGroupClass);

  public abstract   List<ShoppingGroupClass> queryByCondition(Map params);
}





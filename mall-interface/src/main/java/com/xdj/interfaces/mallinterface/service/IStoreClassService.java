package com.xdj.interfaces.mallinterface.service;




import com.xdj.www.entity.ShoppingStoreclass;

import java.util.List;
import java.util.Map;

public abstract interface IStoreClassService
{
  public abstract boolean save(ShoppingStoreclass paramStoreClass);

  public abstract ShoppingStoreclass getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);


  public abstract boolean update(ShoppingStoreclass paramStoreClass);

  public abstract   List<ShoppingStoreclass> queryByCondition(Map<String, Object> params);
}





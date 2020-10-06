package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingStore;
import com.xdj.www.entity.ShoppingStoreExample;
import com.xdj.www.entity.ShoppingStoreWithBLOBs;

import java.util.List;
import java.util.Map;

public abstract interface IStoreService
{
  public abstract boolean save(ShoppingStoreWithBLOBs paramStore);

  public abstract ShoppingStoreWithBLOBs getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingStoreWithBLOBs paramStore);

  public abstract  ShoppingStoreWithBLOBs queryOne(Map<String,Object> map );

  public abstract ShoppingStoreWithBLOBs getOne(Map params);

  public abstract   List<ShoppingStoreWithBLOBs> queryByCondition(Map params);

  public abstract   List<ShoppingStoreWithBLOBs> selectByExample(ShoppingStoreExample example);

  public abstract List<ShoppingStoreWithBLOBs> pageList(Map<String, Object> params);

  public abstract   int count(Map<String, Object> params);
}





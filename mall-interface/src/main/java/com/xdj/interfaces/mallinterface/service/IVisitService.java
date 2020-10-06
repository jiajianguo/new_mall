package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingVisit;

import java.util.List;
import java.util.Map;

public abstract interface IVisitService
{
  public abstract boolean save(ShoppingVisit paramVisit);

  public abstract ShoppingVisit getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingVisit paramVisit);

  public abstract   List<ShoppingVisit> queryByCondition(Map map);
}





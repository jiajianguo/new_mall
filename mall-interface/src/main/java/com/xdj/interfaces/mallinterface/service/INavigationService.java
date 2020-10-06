package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingNavigation;

import java.util.List;
import java.util.Map;

public abstract interface INavigationService
{
  public abstract boolean save(ShoppingNavigation paramNavigation);

  public abstract ShoppingNavigation getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingNavigation paramNavigation);

  public abstract  List<ShoppingNavigation> queryByConditin(Map<String,Object> paras);

}





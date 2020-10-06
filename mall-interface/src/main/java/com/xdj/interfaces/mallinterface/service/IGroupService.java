package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingGroup;

import java.util.List;
import java.util.Map;

public abstract interface IGroupService
{
  public abstract boolean save(ShoppingGroup paramGroup);

  public abstract ShoppingGroup getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingGroup paramGroup);

  public abstract   List<ShoppingGroup> queryByCondition(Map params);

    List<ShoppingGroup> queryBytime(Map params);

  int count(Map params);
}





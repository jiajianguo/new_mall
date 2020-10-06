package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingArea;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface IAreaService
{
  public abstract boolean save(ShoppingArea paramArea);

  public abstract ShoppingArea getObjById(Long paramLong);

  public abstract int delete(Long paramLong);

  public abstract int batchDelete(List<Long> paramList);

  public abstract int update(ShoppingArea paramArea);

  public List<ShoppingArea> queryByCondition(Map params);
}





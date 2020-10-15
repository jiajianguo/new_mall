package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingAddress;

import java.util.List;
import java.util.Map;

public abstract interface IAddressService
{
  public abstract boolean save(ShoppingAddress paramAddress);

  public abstract ShoppingAddress getObjById(Long paramLong);

  public abstract int delete(Long paramLong);

  public abstract int batchDelete(List<Long> paramList);

  public abstract int update(ShoppingAddress paramAddress);


  public abstract List<ShoppingAddress> queryByCondition(Map params);

  public abstract int count(Map params);

  public abstract  int updateByPrimaryKeySelective(ShoppingAddress addr);
}





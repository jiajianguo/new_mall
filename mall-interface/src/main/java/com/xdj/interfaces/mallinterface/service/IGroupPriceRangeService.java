package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingGroupPriceRange;

import java.util.List;
import java.util.Map;

public abstract interface IGroupPriceRangeService
{
  public abstract boolean save(ShoppingGroupPriceRange paramGroupPriceRange);

  public abstract ShoppingGroupPriceRange getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingGroupPriceRange paramGroupPriceRange);

  public abstract   List<ShoppingGroupPriceRange> queryByCondition(Map params);
}





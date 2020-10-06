package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingGroupGoods;

import java.util.List;
import java.util.Map;

public abstract interface IGroupGoodsService
{
  public abstract boolean save(ShoppingGroupGoods paramGroupGoods);

  public abstract ShoppingGroupGoods getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingGroupGoods paramGroupGoods);

  public abstract List<ShoppingGroupGoods> queryByCondition(Map params);
  public abstract   int count(Map params);
}





package com.xdj.interfaces.mallinterface.service;



import com.xdj.interfaces.mallinterface.query.IPageList;
import com.xdj.interfaces.mallinterface.query.IQueryObject;
import com.xdj.www.entity.ShoppingIntegralGoods;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface IIntegralGoodsService
{
  public abstract boolean save(ShoppingIntegralGoods paramIntegralGoods);

  public abstract ShoppingIntegralGoods getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingIntegralGoods paramIntegralGoods);

   public abstract List<ShoppingIntegralGoods> queryByCondition(Map params);
}





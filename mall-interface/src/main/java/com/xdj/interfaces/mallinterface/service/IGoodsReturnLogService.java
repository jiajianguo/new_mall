package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingGoodsReturnlog;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface IGoodsReturnLogService
{
  public abstract boolean save(ShoppingGoodsReturnlog paramGoodsReturnLog);

  public abstract ShoppingGoodsReturnlog getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingGoodsReturnlog paramGoodsReturnLog);

  public abstract   List<ShoppingGoodsReturnlog> queryByCondition(Map<String, Object> params);
}





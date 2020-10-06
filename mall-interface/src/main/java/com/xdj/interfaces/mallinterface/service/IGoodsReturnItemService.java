package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingGoodsReturnitem;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public abstract interface IGoodsReturnItemService
{
  public abstract boolean save(ShoppingGoodsReturnitem paramGoodsReturnItem);

  public abstract ShoppingGoodsReturnitem getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingGoodsReturnitem paramGoodsReturnItem);

   public abstract List<ShoppingGoodsReturnitem> queryByCondition(Map<String, Object> para);
}





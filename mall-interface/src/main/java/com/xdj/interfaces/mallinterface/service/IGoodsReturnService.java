package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingGoodsReturn;
import java.util.List;
import java.util.Map;

public abstract interface IGoodsReturnService
{
  public abstract boolean save(ShoppingGoodsReturn paramGoodsReturn);

  public abstract ShoppingGoodsReturn getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingGoodsReturn paramGoodsReturn);

}





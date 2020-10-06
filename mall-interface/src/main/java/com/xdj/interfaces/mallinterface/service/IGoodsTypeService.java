package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingGoodstype;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface IGoodsTypeService
{
  public abstract boolean save(ShoppingGoodstype paramGoodsType);

  public abstract ShoppingGoodstype getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingGoodstype paramGoodsType);

}





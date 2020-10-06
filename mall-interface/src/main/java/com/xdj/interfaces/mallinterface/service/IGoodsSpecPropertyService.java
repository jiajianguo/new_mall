package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingGoodsspecproperty;


import java.io.Serializable;
import java.util.List;
import java.util.Map;


public  interface IGoodsSpecPropertyService
{
  public abstract boolean save(ShoppingGoodsspecproperty paramGoodsSpecProperty);

  public abstract ShoppingGoodsspecproperty getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Serializable> paramList);

  public abstract boolean update(ShoppingGoodsspecproperty paramGoodsSpecProperty);

  public abstract List<ShoppingGoodsspecproperty> queryByConditoin(Map<String, Object> para);
}





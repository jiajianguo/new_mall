package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingActivityGoods;

import java.util.List;
import java.util.Map;


/**
 * @author Administrator
 */
public abstract interface IActivityGoodsService{
  public abstract  List<ShoppingActivityGoods> list(Map<String,Object> para);

  public abstract  int count(Map<String,Object> para);

  public abstract   List<ShoppingActivityGoods> pageList(Map<String, Object> params);
}





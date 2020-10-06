package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingHomepageGoodsclass;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public abstract interface IHomePageGoodsClassService
{
  public abstract boolean save(ShoppingHomepageGoodsclass paramHomePageGoodsClass);

  public abstract ShoppingHomepageGoodsclass getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingHomepageGoodsclass paramHomePageGoodsClass);

  public abstract  List<ShoppingHomepageGoodsclass> queryByCondition(Map<String, Object> params);
}





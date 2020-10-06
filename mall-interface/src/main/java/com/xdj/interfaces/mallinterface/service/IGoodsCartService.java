package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingGoodscart;

import java.util.List;
import java.util.Map;

public abstract interface IGoodsCartService
{
  public abstract boolean save(ShoppingGoodscart paramGoodsCart);

  public abstract ShoppingGoodscart getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract  int update(ShoppingGoodscart gc);

  public abstract   List<ShoppingGoodscart> queryByCondition(Map params);

  public abstract   int deleteByScid(Long id);

  public abstract   int pageCount(Map<String, Object> params);

  List<ShoppingGoodscart> pageList(Map<String, Object> params);
}





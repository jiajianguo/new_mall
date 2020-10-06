package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingStorecart;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public  interface IStoreCartService{
  public abstract int save(ShoppingStorecart paramStoreCart);

  public abstract ShoppingStorecart getObjById(Long paramLong);

  public abstract int delete(Long paramLong);

  public abstract int batchDelete(List<Long> paramList);


  public abstract int update(ShoppingStorecart paramStoreCart);

  List<ShoppingStorecart> queryByCondition(Map params);

    List<ShoppingStorecart> queryCookiecart(Map params);
}





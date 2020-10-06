package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingStoreNav;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public abstract interface IStoreNavigationService{

  public abstract boolean save(ShoppingStoreNav paramStoreNavigation);

  public abstract ShoppingStoreNav getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingStoreNav paramStoreNavigation);

  public abstract   List<ShoppingStoreNav> queryByCondition(Map params);
}





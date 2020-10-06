package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingStorePartner;

import java.util.List;
import java.util.Map;

public abstract interface IStorePartnerService
{
  public abstract boolean save(ShoppingStorePartner paramStorePartner);

  public abstract ShoppingStorePartner getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);


  public abstract boolean update(ShoppingStorePartner paramStorePartner);

  public abstract   List<ShoppingStorePartner> queryByCondition(Map params);
}





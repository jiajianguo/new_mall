package com.xdj.interfaces.mallinterface.service;




import com.xdj.www.entity.ShoppingPartner;

import java.util.List;
import java.util.Map;

public abstract interface IPartnerService
{
  public abstract boolean save(ShoppingPartner paramPartner);

  public abstract ShoppingPartner getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingPartner paramPartner);

  public abstract   List<ShoppingPartner> queryByCondition(Map params);
}





package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingDeliveryLog;

import java.util.List;


public abstract interface IDeliveryLogService
{
  public abstract boolean save(ShoppingDeliveryLog paramDeliveryLog);

  public abstract ShoppingDeliveryLog getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);


  public abstract boolean update(ShoppingDeliveryLog paramDeliveryLog);


}





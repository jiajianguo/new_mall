package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingPayment;
import com.xdj.www.entity.ShoppingPaymentWithBLOBs;

import java.util.List;
import java.util.Map;

public abstract interface IPaymentService
{
  public abstract boolean save(ShoppingPaymentWithBLOBs paramPayment);

  public abstract ShoppingPaymentWithBLOBs getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);



  public abstract boolean update(ShoppingPaymentWithBLOBs paramPayment);

    List queryByCondition(Map params);
}





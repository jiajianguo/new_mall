package com.xdj.interfaces.mallinterface.service;




import com.xdj.www.entity.ShoppingExpressCompany;

import java.util.List;
import java.util.Map;

public abstract interface IExpressCompanyService
{
  public abstract boolean save(ShoppingExpressCompany paramExpressCompany);

  public abstract ShoppingExpressCompany getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingExpressCompany paramExpressCompany);

}





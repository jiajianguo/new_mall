package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingOrderform;
import com.xdj.www.entity.ShoppingOrderformWithBLOBs;

import java.util.List;
import java.util.Map;

public abstract interface IOrderFormService
{
  public abstract int save(ShoppingOrderformWithBLOBs paramOrderForm);

  public abstract ShoppingOrderformWithBLOBs getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);


  public abstract boolean update(ShoppingOrderformWithBLOBs paramOrderForm);

  public abstract   List<ShoppingOrderformWithBLOBs> pageList(Map<String, Object> params);

  public abstract int count(Map<String, Object> params);

  public abstract List<ShoppingOrderformWithBLOBs>  selectByOrderNo(String s);
}





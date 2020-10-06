package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingPredepositWithBLOBs;

import java.util.List;
import java.util.Map;


/**
 * @author Administrator
 */
public abstract interface IPredepositService
{
  public abstract int save(ShoppingPredepositWithBLOBs paramPredeposit);

  public abstract ShoppingPredepositWithBLOBs getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingPredepositWithBLOBs paramPredeposit);

    List<ShoppingPredepositWithBLOBs> queryByCondition(Map<String, Object> map);

  int count(Map<String, Object> map);
}





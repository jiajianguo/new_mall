package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingPredepositCash;
import com.xdj.www.entity.ShoppingPredepositCashWithBLOBs;

import java.util.List;
import java.util.Map;

public abstract interface IPredepositCashService
{
  public abstract boolean save(ShoppingPredepositCashWithBLOBs paramPredepositCash);

  public abstract ShoppingPredepositCashWithBLOBs getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingPredepositCashWithBLOBs paramPredepositCash);

  List<ShoppingPredepositCashWithBLOBs> queryByCondition(Map<String, Object> map);

  int count(Map<String, Object> map);
}





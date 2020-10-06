package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingPredepositLog;
import com.xdj.www.entity.ShoppingPredepositWithBLOBs;

import java.util.List;
import java.util.Map;

public abstract interface IPredepositLogService
{
  public abstract boolean save(ShoppingPredepositLog paramPredepositLog);

  public abstract ShoppingPredepositLog getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingPredepositLog paramPredepositLog);

    List<ShoppingPredepositLog> queryByCondition(Map<String, Object> map);

  int count(Map<String, Object> map);
}





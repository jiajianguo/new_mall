package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingOrderLog;
import java.util.List;
import java.util.Map;

public abstract interface IOrderFormLogService
{
  public abstract boolean save(ShoppingOrderLog paramOrderFormLog);

  public abstract ShoppingOrderLog getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingOrderLog paramOrderFormLog);

   public abstract List<ShoppingOrderLog> queryByCondition(Map<String, Object> params);

    int deleteByOfid(Long id);
}





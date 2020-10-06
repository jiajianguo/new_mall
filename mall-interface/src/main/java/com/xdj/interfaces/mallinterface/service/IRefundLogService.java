package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingRefundLog;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface IRefundLogService
{
  public abstract boolean save(ShoppingRefundLog paramRefundLog);

  public abstract ShoppingRefundLog getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);


  public abstract boolean update(ShoppingRefundLog paramRefundLog);

  public abstract   List<ShoppingRefundLog> queryByCondition(Map<String, Object> params);
}





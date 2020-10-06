package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingGoldLog;
import com.xdj.www.entity.ShoppingGoldLogWithBLOBs;

import java.util.List;
import java.util.Map;

public abstract interface IGoldLogService
{
  public abstract boolean save(ShoppingGoldLogWithBLOBs paramGoldLog);

  public abstract ShoppingGoldLog getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingGoldLogWithBLOBs paramGoldLog);

}





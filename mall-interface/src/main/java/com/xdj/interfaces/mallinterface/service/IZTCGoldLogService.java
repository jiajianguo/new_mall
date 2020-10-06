package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingZtcGoldLog;

import java.util.List;
import java.util.Map;

public abstract interface IZTCGoldLogService
{
  public abstract boolean save(ShoppingZtcGoldLog paramZTCGoldLog);

  public abstract ShoppingZtcGoldLog getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);



  public abstract boolean update(ShoppingZtcGoldLog paramZTCGoldLog);

}





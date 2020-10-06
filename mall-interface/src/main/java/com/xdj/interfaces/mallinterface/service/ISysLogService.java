package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingSyslog;

import java.util.List;
import java.util.Map;

public abstract interface ISysLogService
{
  public abstract boolean save(ShoppingSyslog paramSysLog);

  public abstract ShoppingSyslog getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingSyslog paramSysLog);

}





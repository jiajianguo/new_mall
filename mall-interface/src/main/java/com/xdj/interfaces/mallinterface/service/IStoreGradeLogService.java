package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingStoregradeLog;

import java.util.List;
import java.util.Map;

public abstract interface IStoreGradeLogService
{
  public abstract boolean save(ShoppingStoregradeLog paramStoreGradeLog);

  public abstract ShoppingStoregradeLog getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);


  public abstract boolean update(ShoppingStoregradeLog paramStoreGradeLog);

}





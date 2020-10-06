package com.xdj.interfaces.mallinterface.service;





import com.xdj.www.entity.ShoppingChattinglog;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface IChattingLogService
{
  public abstract int save(ShoppingChattinglog paramChattingLog);

  public abstract ShoppingChattinglog getObjById(Long paramLong);

  public abstract int delete(Long paramLong);

  public abstract int batchDelete(List<Long> paramList);



  public abstract int update(ShoppingChattinglog paramChattingLog);


}





package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingCombinLog;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface ICombinLogService
{
  public abstract int save(ShoppingCombinLog paramCombinLog);

  public abstract ShoppingCombinLog getObjById(Long paramLong);

  public abstract int delete(Long paramLong);

  public abstract int batchDelete(List<Long> paramList);

  public abstract int update(ShoppingCombinLog paramCombinLog);


}





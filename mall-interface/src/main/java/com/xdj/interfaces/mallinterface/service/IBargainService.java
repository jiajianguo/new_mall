package com.xdj.interfaces.mallinterface.service;




import com.xdj.www.entity.ShoppingBargain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface IBargainService
{
  public abstract int save(ShoppingBargain paramBargain);

  public abstract ShoppingBargain getObjById(Long paramLong);

  public abstract int delete(Long paramLong);

  public abstract int batchDelete(List<Long> paramList);


  public abstract int update(ShoppingBargain paramBargain);

}





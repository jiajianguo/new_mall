package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingTransArea;

import java.util.List;
import java.util.Map;

public abstract interface ITransAreaService
{
  public abstract boolean save(ShoppingTransArea paramTransArea);

  public abstract ShoppingTransArea getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingTransArea paramTransArea);
}





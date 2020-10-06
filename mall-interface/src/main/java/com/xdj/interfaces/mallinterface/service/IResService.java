package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingRes;
import com.xdj.www.entity.ShoppingResExample;

import java.util.List;

public abstract interface IResService
{
  public abstract boolean save(ShoppingRes paramRes);

  public abstract boolean delete(Long paramLong);

  public abstract boolean update(ShoppingRes paramRes);

  public abstract ShoppingRes getObjById(Long paramLong);

    List<ShoppingRes> selectByExample(ShoppingResExample resExample);
}





package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingUsergoodsclass;

import java.util.List;
import java.util.Map;

public abstract interface IUserGoodsClassService
{
  public abstract boolean save(ShoppingUsergoodsclass paramUserGoodsClass);

  public abstract ShoppingUsergoodsclass getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingUsergoodsclass paramUserGoodsClass);

  public abstract   List queryByCondition(Map map);

}





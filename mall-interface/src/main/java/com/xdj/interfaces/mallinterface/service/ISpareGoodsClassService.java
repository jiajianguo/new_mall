package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingSpareGoodsclass;

import java.util.List;
import java.util.Map;

public abstract interface ISpareGoodsClassService
{
  public abstract boolean save(ShoppingSpareGoodsclass paramSpareGoodsClass);

  public abstract ShoppingSpareGoodsclass getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingSpareGoodsclass paramSpareGoodsClass);

  public abstract List<ShoppingSpareGoodsclass> queryByCondition(Map params);
}





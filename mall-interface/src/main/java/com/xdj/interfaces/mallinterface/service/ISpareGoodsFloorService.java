package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingSpareGoodsfloor;

import java.util.List;
import java.util.Map;

public abstract interface ISpareGoodsFloorService
{
  public abstract boolean save(ShoppingSpareGoodsfloor paramSpareGoodsFloor);

  public abstract ShoppingSpareGoodsfloor getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingSpareGoodsfloor paramSpareGoodsFloor);

  public abstract   List<ShoppingSpareGoodsfloor> queryByCondition(Map params);
}





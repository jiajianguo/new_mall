package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingGoodsFloor;
import com.xdj.www.entity.ShoppingGoodsFloorWithBLOBs;

import java.util.List;
import java.util.Map;


public abstract interface IGoodsFloorService
{
  public abstract boolean save(ShoppingGoodsFloorWithBLOBs paramGoodsFloor);

  public abstract ShoppingGoodsFloor getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingGoodsFloorWithBLOBs paramGoodsFloor);

  public abstract List queryByCondition(Map params);
}





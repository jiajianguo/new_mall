package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingGoodsclass;
import com.xdj.www.entity.ShoppingGoodsclassWithBLOBs;

import java.util.List;
import java.util.Map;

public abstract interface IGoodsClassService
{
  public abstract boolean save(ShoppingGoodsclassWithBLOBs paramGoodsClass);

  public abstract ShoppingGoodsclassWithBLOBs getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingGoodsclassWithBLOBs paramGoodsClass);

  public abstract  List<ShoppingGoodsclassWithBLOBs>  queryByCondition(Map<String,Object> params);
}





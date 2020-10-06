package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingGoodsbrand;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public abstract interface IGoodsBrandService
{
  public abstract boolean save(ShoppingGoodsbrand paramGoodsBrand);

  public abstract ShoppingGoodsbrand getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Serializable> paramList);


  public abstract int update(ShoppingGoodsbrand paramGoodsBrand);

  public abstract  List<ShoppingGoodsbrand> queryByCondition(Map<String,Object> para);
}





package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingGoodsclassstaple;

import java.util.List;


public abstract interface IGoodsClassStapleService
{
  public abstract boolean save(ShoppingGoodsclassstaple paramGoodsClassStaple);

  public abstract ShoppingGoodsclassstaple getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingGoodsclassstaple paramGoodsClassStaple);

  public abstract  List<ShoppingGoodsclassstaple> queryByStoreId(Long id);

}





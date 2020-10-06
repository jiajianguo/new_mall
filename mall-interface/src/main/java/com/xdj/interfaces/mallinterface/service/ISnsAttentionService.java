package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingUserAttention;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public abstract interface ISnsAttentionService
{
  public abstract boolean save(ShoppingUserAttention paramSnsAttention);

  public abstract ShoppingUserAttention getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingUserAttention paramSnsAttention);

  public abstract  List<ShoppingUserAttention> queryByCondition(Map map);
}





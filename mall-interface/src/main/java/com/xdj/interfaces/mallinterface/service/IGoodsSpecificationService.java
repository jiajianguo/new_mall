package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingGoodsspecification;
import java.util.List;
import java.util.Map;

public abstract interface IGoodsSpecificationService
{
  public abstract boolean save(ShoppingGoodsspecification paramGoodsSpecification);

  public abstract ShoppingGoodsspecification getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingGoodsspecification paramGoodsSpecification);

  public abstract List<ShoppingGoodsspecification> queryByConditoin(Map<String, Object> para);
}





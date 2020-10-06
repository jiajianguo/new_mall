package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingGoodstypeproperty;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface IGoodsTypePropertyService
{
  public abstract boolean save(ShoppingGoodstypeproperty paramGoodsTypeProperty);

  public abstract ShoppingGoodstypeproperty getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingGoodstypeproperty paramGoodsTypeProperty);

  public abstract List<ShoppingGoodstypeproperty> queryByCondition(Map<String, Object> para);

  public abstract   List<ShoppingGoodstypeproperty> queryByMany(Map<String, Object> para);
}





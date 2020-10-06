package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingStoregrade;

import java.util.List;
import java.util.Map;

public abstract interface IStoreGradeService
{
  public abstract boolean save(ShoppingStoregrade paramStoreGrade);

  public abstract ShoppingStoregrade getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingStoregrade paramStoreGrade);

  public abstract   List<ShoppingStoregrade> queryByCondition(Map<String, Object> params);
}





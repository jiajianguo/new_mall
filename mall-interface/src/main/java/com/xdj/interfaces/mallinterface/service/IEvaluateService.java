package com.xdj.interfaces.mallinterface.service;




import com.xdj.www.entity.ShoppingEvaluate;
import com.xdj.www.entity.ShoppingEvaluateWithBLOBs;

import java.util.List;
import java.util.Map;

public abstract interface IEvaluateService
{
  public abstract boolean save(ShoppingEvaluateWithBLOBs paramEvaluate);

  public abstract ShoppingEvaluate getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update( ShoppingEvaluateWithBLOBs paramEvaluate);

  public abstract List<ShoppingEvaluateWithBLOBs> queryByCondition(Map params);

  public abstract  int count(Map<String, Object> params);

  public abstract  List<ShoppingEvaluateWithBLOBs> queryBySg(Map<String, Object> params);

 public abstract int countSg(Map<String, Object> params);

    public abstract int queryCount(Map params);


}





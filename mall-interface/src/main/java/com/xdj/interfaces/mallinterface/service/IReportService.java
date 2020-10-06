package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingReport;
import com.xdj.www.entity.ShoppingReportWithBLOBs;

import java.util.List;
import java.util.Map;

public abstract interface IReportService
{
  public abstract boolean save(ShoppingReportWithBLOBs paramReport);

  public abstract ShoppingReportWithBLOBs getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);


  public abstract boolean update(ShoppingReportWithBLOBs paramReport);

  List queryByCondition(Map<String, Object> params);

  int count(Map<String, Object> map);
}





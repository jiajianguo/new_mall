package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingReportType;

import java.util.List;
import java.util.Map;

public abstract interface IReportTypeService
{
  public abstract boolean save(ShoppingReportType paramReportType);

  public abstract ShoppingReportType getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);


  public abstract boolean update(ShoppingReportType paramReportType);

    List<ShoppingReportType> queryByCondition(Map<String, Object> params);
}





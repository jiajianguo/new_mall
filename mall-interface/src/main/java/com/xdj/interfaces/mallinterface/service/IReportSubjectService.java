package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingReportSubject;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface IReportSubjectService
{
  public abstract boolean save(ShoppingReportSubject paramReportSubject);

  public abstract ShoppingReportSubject getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);


  public abstract boolean update(ShoppingReportSubject paramReportSubject);

    List<ShoppingReportSubject> queryByCondition(Map<String, Object> params);
}





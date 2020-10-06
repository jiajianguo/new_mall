package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingComplaintSubject;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public abstract interface IComplaintSubjectService
{
  public abstract int save(ShoppingComplaintSubject paramComplaintSubject);

  public abstract ShoppingComplaintSubject getObjById(Long paramLong);

  public abstract int delete(Long paramLong);

  public abstract int batchDelete(List<Long> paramList);

  public abstract int update(ShoppingComplaintSubject paramComplaintSubject);

    List<ShoppingComplaintSubject> queryByCondition(Map<String, Object> params);
}





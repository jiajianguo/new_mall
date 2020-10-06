package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingComplaint;
import com.xdj.www.entity.ShoppingComplaintWithBLOBs;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface IComplaintService
{
  public abstract boolean save(ShoppingComplaintWithBLOBs paramComplaint);

  public abstract ShoppingComplaintWithBLOBs getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);


  public abstract boolean update(ShoppingComplaintWithBLOBs paramComplaint);

    List<ShoppingComplaintWithBLOBs> queryByCondition(Map<String, Object> map);

  int count(Map<String, Object> map);
}





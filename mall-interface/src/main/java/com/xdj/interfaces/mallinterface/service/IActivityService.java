package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingActivity;

import java.util.List;
import java.util.Map;

public abstract interface IActivityService{

  public abstract boolean save(ShoppingActivity paramActivity);

  public abstract ShoppingActivity getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);



  public abstract boolean update(ShoppingActivity paramActivity);


}





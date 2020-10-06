package com.xdj.interfaces.mallinterface.service;





import com.xdj.www.entity.ShoppingGroupArea;

import java.util.List;
import java.util.Map;

public abstract interface IGroupAreaService
{
  public abstract boolean save(ShoppingGroupArea paramGroupArea);

  public abstract ShoppingGroupArea getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);


  public abstract boolean update(ShoppingGroupArea paramGroupArea);

  public abstract   List<ShoppingGroupArea> queryByCondition(Map<String, Object> params);
}





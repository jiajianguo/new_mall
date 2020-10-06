package com.xdj.interfaces.mallinterface.service;




import com.xdj.www.entity.ShoppingHomepage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface IHomePageService
{
  public abstract boolean save(ShoppingHomepage paramHomePage);

  public abstract ShoppingHomepage getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingHomepage paramHomePage);

  public abstract    List<ShoppingHomepage> queryByCondition(Map map);
}





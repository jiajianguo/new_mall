package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingTemplate;

import java.util.List;
import java.util.Map;

public abstract interface ITemplateService
{
  public abstract boolean save(ShoppingTemplate paramTemplate);

  public abstract ShoppingTemplate getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingTemplate paramTemplate);

    ShoppingTemplate queryByCondition(Map<String, Object> param);
}





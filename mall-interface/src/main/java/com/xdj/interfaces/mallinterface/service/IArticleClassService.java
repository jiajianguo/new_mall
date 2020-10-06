package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingArticleclass;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public abstract interface IArticleClassService{

  public abstract boolean save(ShoppingArticleclass paramArticleClass);

  public abstract ShoppingArticleclass getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Serializable> paramList);

  public abstract ShoppingArticleclass queryByMap(Map<String,Object> para);

  public abstract int update(ShoppingArticleclass paramArticleClass);

  public abstract int count(Map<String,Object> para);

  public  abstract List<ShoppingArticleclass> queryByCondition(Map<String,Object> para);
}





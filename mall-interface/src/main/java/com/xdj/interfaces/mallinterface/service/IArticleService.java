package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingArticle;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface IArticleService
{
  public abstract boolean save(ShoppingArticle paramArticle);

  public abstract ShoppingArticle getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Serializable> paramList);

  public abstract boolean update(ShoppingArticle paramArticle);


  public abstract  List<ShoppingArticle> list(Map<String,Object> para);

  public abstract  int count(Map<String,Object> para);

  public abstract List<ShoppingArticle> queryByCondition(Map<String,Object> para);

  public abstract  ShoppingArticle  queryByMap (Map<String,Object> para);
}





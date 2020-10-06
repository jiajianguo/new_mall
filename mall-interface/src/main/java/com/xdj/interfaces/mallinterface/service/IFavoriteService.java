package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingFavorite;
import com.xdj.www.entity.ShoppingFavoriteExample;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public abstract interface IFavoriteService{

  public abstract boolean save(ShoppingFavorite paramFavorite);

  public abstract ShoppingFavorite getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingFavorite paramFavorite);


  public abstract   List<ShoppingFavorite> queryByCondition(Map params);

  public abstract List<ShoppingFavorite> selectExample(ShoppingFavoriteExample example);


  int count(Map<String, Object> map);
}





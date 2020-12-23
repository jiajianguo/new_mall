package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingUserconfig;

import java.util.List;

/**
 * @author Administrator
 */
public abstract interface IUserConfigService{

  public abstract boolean save(ShoppingUserconfig paramUserConfig);

  public abstract ShoppingUserconfig getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingUserconfig paramUserConfig);

  public abstract  ShoppingUserconfig getUserConfig();

}





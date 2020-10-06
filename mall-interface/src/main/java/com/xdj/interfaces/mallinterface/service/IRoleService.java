package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingRole;

import java.util.List;
import java.util.Map;

public abstract interface IRoleService
{
  public abstract boolean save(ShoppingRole paramRole);

  public abstract boolean delete(Long paramLong);

  public abstract boolean update(ShoppingRole paramRole);

  public abstract ShoppingRole getObjById(Long paramLong);

    List<ShoppingRole> queryByCondition(Map params);

  List<ShoppingRole> queryRoleByUserId(Long id);
}





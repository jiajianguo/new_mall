package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingRolegroup;


import java.util.List;
import java.util.Map;

public abstract interface IRoleGroupService
{
  public abstract boolean save(ShoppingRolegroup paramRoleGroup);

  public abstract ShoppingRolegroup getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);


  public abstract boolean update(ShoppingRolegroup paramRoleGroup);

}





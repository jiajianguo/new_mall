package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingUserFriend;
import java.util.List;
import java.util.Map;

public abstract interface ISnsFriendService
{
  public abstract boolean save(ShoppingUserFriend paramSnsFriend);

  public abstract ShoppingUserFriend getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);


  public abstract boolean update(ShoppingUserFriend paramSnsFriend);

  public abstract   List<ShoppingUserFriend> queryByCondition(Map<String, Object> map);

  int count(Map<String, Object> map);
}





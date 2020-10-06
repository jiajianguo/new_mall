package com.xdj.interfaces.mallinterface.service;




import com.xdj.www.entity.ShoppingChattingfriend;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public abstract interface IChattingFriendService
{
  public abstract boolean save(ShoppingChattingfriend paramChattingFriend);

  public abstract ShoppingChattingfriend getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingChattingfriend paramChattingFriend);

}





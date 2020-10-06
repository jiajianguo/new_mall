package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingMessage;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public abstract interface IMessageService{
  public abstract boolean save(ShoppingMessage paramMessage);
  public abstract ShoppingMessage getObjById(Long paramLong);
  public abstract boolean delete(Long paramLong);
  public abstract boolean batchDelete(List<Long> paramList);
  public abstract boolean update(ShoppingMessage paramMessage);
  public abstract  List<ShoppingMessage> queryByCondition(Map<String,Object> params);

  int count(Map<String, Object> map);
}





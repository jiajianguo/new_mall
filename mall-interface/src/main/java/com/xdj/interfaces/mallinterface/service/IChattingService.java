package com.xdj.interfaces.mallinterface.service;




import com.xdj.www.entity.ShoppingChatting;

import java.util.List;


public abstract interface IChattingService {
  public abstract boolean save(ShoppingChatting paramChatting);

  public abstract ShoppingChatting getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingChatting paramChatting);


}





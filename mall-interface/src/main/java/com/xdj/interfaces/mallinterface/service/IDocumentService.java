package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingDocument;

import java.util.List;
import java.util.Map;

public abstract interface IDocumentService
{
  public abstract boolean save(ShoppingDocument paramDocument);

  public abstract ShoppingDocument getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingDocument paramDocument);


}





package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingTransport;
import com.xdj.www.entity.ShoppingTransportWithBLOBs;

import java.util.List;
import java.util.Map;

public abstract interface ITransportService
{
  public abstract boolean save(ShoppingTransportWithBLOBs paramTransport);

  public abstract ShoppingTransportWithBLOBs getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingTransportWithBLOBs paramTransport);

}





package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingConsult;
import com.xdj.www.entity.ShoppingConsultWithBLOBs;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public  interface IConsultService
{
  public abstract int save(ShoppingConsultWithBLOBs paramConsult);

  public abstract ShoppingConsult getObjById(Long paramLong);

  public abstract int delete(Long paramLong);

  public abstract int batchDelete(List<Long> paramList);



  public abstract int update(ShoppingConsultWithBLOBs paramConsult);

    List<ShoppingConsultWithBLOBs> queryByCondition(Map<String, Object> map);

  int count(Map<String, Object> map);
}





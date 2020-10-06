package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingAdvPosExample;
import com.xdj.www.entity.ShoppingAdvPosWithBLOBs;


import java.io.Serializable;
import java.util.List;


/**
 * @author Administrator
 */
public abstract interface IAdvertPositionService{

  public abstract boolean save(ShoppingAdvPosWithBLOBs paramAdvertPosition);
  public abstract ShoppingAdvPosWithBLOBs getObjById(Long paramLong);
  public abstract boolean delete(Long paramLong);
  public abstract boolean batchDelete(List<Long> paramList);

  public abstract  List<ShoppingAdvPosWithBLOBs> selectExample(ShoppingAdvPosExample ex);
}





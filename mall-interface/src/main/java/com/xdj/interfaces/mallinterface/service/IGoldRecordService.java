package com.xdj.interfaces.mallinterface.service;




import com.xdj.www.entity.ShoppingGoldRecordWithBLOBs;

import java.util.List;


/**
 * @author Administrator
 */
public abstract interface IGoldRecordService
{
  public abstract boolean save(ShoppingGoldRecordWithBLOBs paramGoldRecord);

  public abstract ShoppingGoldRecordWithBLOBs getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingGoldRecordWithBLOBs paramGoldRecord);

}





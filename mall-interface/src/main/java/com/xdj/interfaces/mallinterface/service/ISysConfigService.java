package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingSysconfigWithBLOBs;

/**
 * @author Administrator
 */
public abstract interface ISysConfigService
{
  public abstract boolean save(ShoppingSysconfigWithBLOBs paramSysConfig);

  public abstract boolean delete(Long id);

  public abstract boolean update(ShoppingSysconfigWithBLOBs paramSysConfig);

  public abstract ShoppingSysconfigWithBLOBs getSysConfig();
}





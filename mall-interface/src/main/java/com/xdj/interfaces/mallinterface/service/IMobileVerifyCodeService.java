package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingMobileverifycode;

import java.util.List;
import java.util.Map;

public abstract interface IMobileVerifyCodeService
{
  public abstract boolean save(ShoppingMobileverifycode paramMobileVerifyCode);

  public abstract ShoppingMobileverifycode getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);


  public abstract boolean update(ShoppingMobileverifycode paramMobileVerifyCode);

    ShoppingMobileverifycode queryByCondition(Map<String, Object> params);
}





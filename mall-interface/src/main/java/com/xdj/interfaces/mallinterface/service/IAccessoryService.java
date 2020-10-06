package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingAccessory;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public abstract interface IAccessoryService{

  public abstract int save(ShoppingAccessory paramAccessory);

  public abstract int delete(Long paramLong);

  public abstract int update(ShoppingAccessory paramAccessory);

  public abstract ShoppingAccessory getObjById(Long paramLong);

  public abstract  List<ShoppingAccessory> queryByCondition(Map<String, Object> params);

  public abstract List<ShoppingAccessory> queryByGoodsId(Long goods_id);
}





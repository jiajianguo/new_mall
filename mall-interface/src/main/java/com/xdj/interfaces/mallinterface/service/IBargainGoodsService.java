package com.xdj.interfaces.mallinterface.service;




import com.xdj.www.entity.ShoppingBargainGoods;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public abstract interface IBargainGoodsService {

  public abstract boolean save(ShoppingBargainGoods paramBargainGoods);

  public abstract ShoppingBargainGoods getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingBargainGoods paramBargainGoods);

  public abstract List<ShoppingBargainGoods> list(Map<String,Object> para);

  public abstract int count(Map<String,Object> para);

  public abstract  List<ShoppingBargainGoods> queryByCondition(Map<String,Object> para);

  public abstract List<ShoppingBargainGoods> pageList(Map<String, Object> params);
}





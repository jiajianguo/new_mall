package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingGoods;
import com.xdj.www.entity.ShoppingGoodsExample;
import com.xdj.www.entity.ShoppingGoodsWithBLOBs;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public abstract interface IGoodsService {
  public abstract boolean save(ShoppingGoodsWithBLOBs paramGoods);

  public abstract ShoppingGoodsWithBLOBs getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract int update(ShoppingGoodsWithBLOBs paramGoods);

  public abstract int count(Map<String,Object> goods);

  public abstract  List<ShoppingGoods> list (Map<String,Object> goods);

  public abstract List<ShoppingGoodsWithBLOBs> queryByCondition(Map params);

  public abstract List<ShoppingGoodsWithBLOBs> queryMsg(Map paras);

  public abstract  int queryMsgCount(Map paras);

  public abstract   List<ShoppingGoodsWithBLOBs> getCombinGoods(Long id);

  public abstract   List<ShoppingGoodsWithBLOBs> selectExample(ShoppingGoodsExample ex);

  public abstract  List<ShoppingGoodsWithBLOBs> pageList(Map params);
}





package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingSpareGoods;
import com.xdj.www.entity.ShoppingSpareGoodsWithBLOBs;

import java.util.List;
import java.util.Map;


public abstract interface ISpareGoodsService
{
  public abstract boolean save(ShoppingSpareGoodsWithBLOBs paramSpareGoods);

  public abstract ShoppingSpareGoodsWithBLOBs getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingSpareGoodsWithBLOBs paramSpareGoods);

    List<ShoppingSpareGoodsWithBLOBs> queryByCondition(Map params);

    int count(Map params);

  List<ShoppingSpareGoodsWithBLOBs> pageList(Map params);
}





package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingDeliveryGoods;

import java.util.List;
import java.util.Map;


public abstract interface IDeliveryGoodsService
{
   abstract int save(ShoppingDeliveryGoods paramDeliveryGoods);

   abstract ShoppingDeliveryGoods getObjById(Long paramLong);

   abstract int delete(Long paramLong);

   abstract int batchDelete(List<Long> paramList);


   abstract int update(ShoppingDeliveryGoods paramDeliveryGoods);

   public abstract List<ShoppingDeliveryGoods> queryByCondition(Map params);

   public abstract ShoppingDeliveryGoods queryByGoodsId(Long goodsId);

   public abstract List<ShoppingDeliveryGoods> pageList(Map<String, Object> params);

   public abstract int count(Map<String, Object> params);
}





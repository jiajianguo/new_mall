package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingSecondsKill;
import com.xdj.www.entity.ShoppingSecondsKillExample;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public interface ISeckillService {
   public  List<ShoppingSecondsKill> queryByCondition(Map params);

   public Long selectExample(ShoppingSecondsKillExample example);

   public ShoppingSecondsKill getObjById(Long valueOf);

   public void update(ShoppingSecondsKill sec);
}

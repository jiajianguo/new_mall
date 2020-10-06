 package com.xdj.interfaces.mallinterface.service.impl;



 import com.xdj.interfaces.mallinterface.mapper.ShoppingActivityGoodsMapper;
 import com.xdj.interfaces.mallinterface.service.IActivityGoodsService;

 import com.xdj.www.entity.ShoppingActivityGoods;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;


 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;


 /**
  * @author Administrator
  */
 @Service
 public class ActivityGoodsServiceImpl implements IActivityGoodsService{

     @Resource
     private ShoppingActivityGoodsMapper shoppingActivityGoodsMapper;


     @Override
     @Cacheable(value = "activityGoods" )
     public List<ShoppingActivityGoods> list(Map<String, Object> para) {
         return shoppingActivityGoodsMapper.pageList(para);
     }

     @Override
     @Cacheable(value = "activityGoodis" )
     public int count(Map<String, Object> para) {
         return shoppingActivityGoodsMapper.count(para);
     }

     @Override
     @Cacheable(value = "activityGoods" )
     public List<ShoppingActivityGoods> pageList(Map<String, Object> params) {
         return shoppingActivityGoodsMapper.pageList(params);
     }
 }





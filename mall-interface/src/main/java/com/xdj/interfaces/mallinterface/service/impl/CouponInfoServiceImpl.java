 package com.xdj.interfaces.mallinterface.service.impl;

 import com.xdj.interfaces.mallinterface.mapper.ShoppingCouponInfoMapper;
 import com.xdj.interfaces.mallinterface.service.ICouponInfoService;
 import com.xdj.www.entity.ShoppingCoupon;
 import com.xdj.www.entity.ShoppingCouponInfo;
 import com.xdj.www.entity.ShoppingCouponInfoExample;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
import java.util.List;
 import java.util.Map;

 /**
  * @author Administrator
  */
 @Service
 @Transactional
 public class CouponInfoServiceImpl  implements ICouponInfoService
 {

   @Resource
   private ShoppingCouponInfoMapper couponInfoDao;

   @Override
   @CachePut(cacheNames = "insertcouponInfo",condition = "#couponInfo != null")
   public int save(ShoppingCouponInfo couponInfo)
   {
     try
     {
       this.couponInfoDao.insertSelective(couponInfo);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @Cacheable(cacheNames = "couponInfo",condition = "#id != null")
   public ShoppingCouponInfo getObjById(Long id)
   {
       ShoppingCouponInfo couponInfo = couponInfoDao.selectByPrimaryKey(id);
     if (couponInfo != null) {
       return couponInfo;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delcouponInfo",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public int delete(Long id) {
     try {
       this.couponInfoDao.deleteByPrimaryKey(id);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @CacheEvict(cacheNames = "delscouponInfo",allEntries = true,beforeInvocation =  true,condition = "#couponInfoIds != null")
   public int batchDelete(List<Long> couponInfoIds)
   {
     for (long id : couponInfoIds) {
       delete(id);
     }
     return 1;
   }


   @Override
   @CachePut(cacheNames = "updatecouponInfo" ,condition = "#couponInfo != null")
   public boolean update(ShoppingCouponInfo couponInfo) {
     try {
       this.couponInfoDao.updateByPrimaryKeySelective(couponInfo);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "querycouponInfo")
     public List<ShoppingCouponInfo> queryByCondition(Map params) {
         return couponInfoDao.queryByCondition(params);
     }



     @Override
     @Cacheable("countcouponInfo")
     public int pageCount(Map<String, Object> params) {
         return couponInfoDao. pageCount(params);
     }

     @Override
     public long countByExample(ShoppingCouponInfoExample example) {
         return couponInfoDao.countByExample(example);
     }

 }





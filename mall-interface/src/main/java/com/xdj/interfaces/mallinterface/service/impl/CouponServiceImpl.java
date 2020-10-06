 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingCouponMapper;
 import com.xdj.interfaces.mallinterface.service.ICouponService;
 import com.xdj.www.entity.ShoppingCoupon;
 import com.xdj.www.entity.ShoppingCouponInfoExample;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.util.List;

 /**
  * @author Administrator
  */
 @Service
 @Transactional
 public class CouponServiceImpl  implements ICouponService
 {

   @Resource
   private ShoppingCouponMapper couponDao;

   @Override
   @CachePut(cacheNames = "insertcoupon",condition = "#coupon != null")
   public int save(ShoppingCoupon coupon)
   {
     try
     {
       this.couponDao.insertSelective(coupon);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @Cacheable(cacheNames = "coupon",condition = "#id != null",unless = "#result==null")
   public ShoppingCoupon getObjById(Long id)
   {
       ShoppingCoupon coupon = this.couponDao.selectByPrimaryKey(id);
     if (coupon != null) {
       return coupon;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delcoupon",allEntries = true,beforeInvocation = true,condition = "#coupon != null")
   public int delete(Long id) {
     try {
       this.couponDao.deleteByPrimaryKey(id);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @CacheEvict(cacheNames = "delscoupon",condition = "#couponIds != null")
   public int batchDelete(List<Long> couponIds)
   {
     for (Long id : couponIds) {
       delete(id);
     }
     return 1;
   }

   @Override
   @CachePut(cacheNames = "updatecoupon",condition = "#coupon != null")
   public boolean update(ShoppingCoupon coupon) {
     try {
       this.couponDao.updateByPrimaryKeySelective(coupon);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }





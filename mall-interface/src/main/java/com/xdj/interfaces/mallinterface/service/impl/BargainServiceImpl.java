 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingBargainMapper;
 import com.xdj.interfaces.mallinterface.service.IBargainService;
 import com.xdj.www.entity.ShoppingBargain;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;

 /**
  * @author Administrator
  */
 @Service
 public class BargainServiceImpl implements IBargainService
 {

   @Resource
   private ShoppingBargainMapper bargainDao;

   @Override
   @CachePut(cacheNames = "insertBargrain",condition = "#bargain != null")
   public int save(ShoppingBargain bargain)
   {
     try
     {
       this.bargainDao.insertSelective(bargain);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @Cacheable(cacheNames = "bargain",condition = "#id != null")
   public ShoppingBargain getObjById(Long id)
   {
       ShoppingBargain bargain =this.bargainDao.selectByPrimaryKey(id);
     if (bargain != null) {
       return bargain;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delBargrain",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public int delete(Long id) {
     try {
       this.bargainDao.deleteByPrimaryKey(id);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @CacheEvict(cacheNames = "delsBargrain",allEntries = true,beforeInvocation = true,condition = "#bargainIds != null")
   public int batchDelete(List<Long> bargainIds)
   {
     for (Long id : bargainIds) {
       delete(id);
     }
     return 1;
   }



   @Override
   @CachePut(cacheNames = "updateBargain",condition = "#bargain !=  null")
   public int update(ShoppingBargain bargain) {
     try {
       this.bargainDao.updateByPrimaryKeySelective(bargain);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }


 }





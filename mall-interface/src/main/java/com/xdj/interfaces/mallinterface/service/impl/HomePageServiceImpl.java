 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingHomepageMapper;
 import com.xdj.interfaces.mallinterface.service.IHomePageService;
 import com.xdj.www.entity.ShoppingHomepage;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;
 import java.util.Map;

 @Service
 @Transactional
 public class HomePageServiceImpl implements IHomePageService
 {

   @Resource
   private ShoppingHomepageMapper homePageDao;

   @Override
   @CachePut(cacheNames = "inserthomePage",condition = "#homePage !=  null")
   public boolean save(ShoppingHomepage homePage)
   {
     try
     {
       this.homePageDao.insertSelective(homePage);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "homePage" ,condition = "#id != null")
   public ShoppingHomepage getObjById(Long id)
   {
       ShoppingHomepage homePage = homePageDao.selectByPrimaryKey(id);
     if (homePage != null) {
       return homePage;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delhomePage",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.homePageDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delshomePage",allEntries = true,beforeInvocation = true,condition = "homePageIds != null")
   public boolean batchDelete(List<Long> homePageIds)
   {
     for (Serializable id : homePageIds) {
       delete((Long)id);
     }
     return true;
   }


   @Override
   @CachePut(cacheNames = "updatehomePage")
   public boolean update(ShoppingHomepage homePage) {
     try {
       this.homePageDao.updateByPrimaryKeySelective(homePage);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "conditionhomePage")
     public List<ShoppingHomepage> queryByCondition(Map map) {
         return homePageDao.queryByCondition(map);
     }


 }





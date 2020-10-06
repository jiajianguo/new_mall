 package com.xdj.interfaces.mallinterface.service.impl;

 import com.xdj.interfaces.mallinterface.mapper.ShoppingHomepageGoodsclassMapper;
 import com.xdj.interfaces.mallinterface.service.IHomePageGoodsClassService;
 import com.xdj.www.entity.ShoppingHomepageGoodsclass;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 @Transactional
 public class HomePageGoodsClassServiceImpl implements IHomePageGoodsClassService
 {
   @Resource
   private ShoppingHomepageGoodsclassMapper homePageGoodsClassDao;

   @Override
   @CachePut(cacheNames = "inserthomepagegc",condition = "#homePageGoodsClass!=null")
   public boolean save(ShoppingHomepageGoodsclass homePageGoodsClass)
   {
     try
     {
       this.homePageGoodsClassDao.insertSelective(homePageGoodsClass);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "homepagegc",condition = "#id!=null")
   public ShoppingHomepageGoodsclass getObjById(Long id)
   {
       ShoppingHomepageGoodsclass homePageGoodsClass = this.homePageGoodsClassDao.selectByPrimaryKey(id);
     if (homePageGoodsClass != null) {
       return homePageGoodsClass;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delhomepagegc",allEntries = true,beforeInvocation = true,condition = "#id != null ")
   public boolean delete(Long id) {
     try {
       this.homePageGoodsClassDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delshomepagegc",allEntries = true,beforeInvocation = true,condition = "#homePageGoodsClassIds != null ")
   public boolean batchDelete(List<Long> homePageGoodsClassIds)
   {
     for (Long id : homePageGoodsClassIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatepagegoodsgc",condition = "#homePageGoodsClass!=null")
   public boolean update(ShoppingHomepageGoodsclass homePageGoodsClass) {
     try {
       this.homePageGoodsClassDao.updateByPrimaryKeySelective(homePageGoodsClass);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "conditionhomepagegc")
     public List<ShoppingHomepageGoodsclass> queryByCondition(Map<String, Object> params) {
         return homePageGoodsClassDao.queryByCondition(params);
     }


 }





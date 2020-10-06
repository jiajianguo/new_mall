 package com.xdj.interfaces.mallinterface.service.impl;



 import com.xdj.interfaces.mallinterface.mapper.ShoppingBrandcategoryMapper;
 import com.xdj.interfaces.mallinterface.service.IGoodsBrandCategoryService;
 import com.xdj.www.entity.ShoppingBrandcategory;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;


 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;
 import java.util.Map;

 /**
  * @author Administrator
  */
 @Service
 public class GoodsBrandCategoryServiceImpl implements IGoodsBrandCategoryService
 {

   @Resource
   private ShoppingBrandcategoryMapper goodsBrandCategoryDao;

   @Override
   @CachePut(cacheNames = "insertgoodsBrandCategory",condition = "#goodsBrandCategory != null")
   public boolean save(ShoppingBrandcategory goodsBrandCategory)
   {
     try
     {
       this.goodsBrandCategoryDao.insertSelective(goodsBrandCategory);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "goodsBrandCategory" ,condition = "#id != null",unless = "#result==null")
   public ShoppingBrandcategory getObjById(Long id)
   {
       ShoppingBrandcategory goodsBrandCategory = this.goodsBrandCategoryDao.selectByPrimaryKey(id);
     if (goodsBrandCategory != null) {
       return goodsBrandCategory;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delgoodsBrandCategory",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.goodsBrandCategoryDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsgoodsBrandCategory",allEntries = true,beforeInvocation = true,condition = "#goodsBrandCategoryIds != null")
   public boolean batchDelete(List<Long> goodsBrandCategoryIds)
   {
     for (Serializable id : goodsBrandCategoryIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updategoodsBrandCategory",condition = "#goodsBrandCategory != null")
   public boolean update(ShoppingBrandcategory goodsBrandCategory) {
     try {
       this.goodsBrandCategoryDao.updateByPrimaryKey(goodsBrandCategory);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }
     return false;
   }

     @Override
     @Cacheable(cacheNames = "conditiongoodsBrandCategory",unless = "#result==null")
     public List<ShoppingBrandcategory> queryByCondition(Map<String, Object> params) {
       return goodsBrandCategoryDao.queryByCondition(params);
     }


 }





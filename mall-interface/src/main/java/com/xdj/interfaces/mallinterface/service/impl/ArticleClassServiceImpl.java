 package com.xdj.interfaces.mallinterface.service.impl;



 import com.xdj.interfaces.mallinterface.mapper.ShoppingArticleclassMapper;


 import com.xdj.interfaces.mallinterface.service.IArticleClassService;

 import com.xdj.www.entity.ShoppingArticleclass;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;
 import java.util.Map;


 /**
  * @author Administrator
  */
 @Service
 @Transactional
 public class ArticleClassServiceImpl implements IArticleClassService
 {

   @Resource
   private ShoppingArticleclassMapper shoppingArticleclassMapper;

   @Override
   @CachePut(cacheNames = "insertArtclass",condition = "#articleClass != null")
   public boolean save(ShoppingArticleclass articleClass)
   {
     try
     {
       this.shoppingArticleclassMapper.insert(articleClass);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "artclass",condition = "#id != null ",unless = "#result==null")
   public ShoppingArticleclass getObjById(Long id)
   {
     ShoppingArticleclass articleClass = this.shoppingArticleclassMapper.selectByPrimaryKey(id);
     if (articleClass != null) {
       return articleClass;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delartclass",allEntries = true,beforeInvocation = true,condition = "#id >0")
   public boolean delete(Long id) {
     try {
       this.shoppingArticleclassMapper.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsartclass",allEntries = true,beforeInvocation = true,condition = "#articleClassIds  != null")
   public boolean batchDelete(List<Serializable> articleClassIds)
   {
     for (Serializable id : articleClassIds) {
       delete((Long)id);
     }
     return true;
   }

   @Override
   @Cacheable(cacheNames = "queryartclass",unless = "#result==null")
   public ShoppingArticleclass queryByMap(Map<String, Object> para) {
     return shoppingArticleclassMapper.queryByMap(para);
   }

   @Override
   @CachePut(cacheNames = "updateartclass",condition = "#paramArticleClass != null")
   public int update(ShoppingArticleclass paramArticleClass) {
     return shoppingArticleclassMapper.updateByPrimaryKey(paramArticleClass);
   }

   @Override
   @CachePut(cacheNames = "countartclass")
   public int count(Map<String, Object> para) {
     return 0;
   }

   @Override
   @Cacheable(cacheNames = "artsclass",unless = "#result==null")
   public List<ShoppingArticleclass> queryByCondition(Map<String, Object> para) {
     return shoppingArticleclassMapper.queryByCondition(para);
   }


 }





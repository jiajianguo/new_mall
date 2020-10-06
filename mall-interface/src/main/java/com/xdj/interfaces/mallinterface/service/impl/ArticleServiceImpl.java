 package com.xdj.interfaces.mallinterface.service.impl;



 import com.xdj.interfaces.mallinterface.mapper.ShoppingArticleMapper;
 import com.xdj.interfaces.mallinterface.service.IArticleService;
 import com.xdj.www.entity.ShoppingArticle;
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
 public class ArticleServiceImpl  implements IArticleService
 {

   @Resource
   private ShoppingArticleMapper shoppingArticleMapper;

   @Override
   @CachePut(cacheNames = "insertArt",condition = "#article != null")
   public boolean save(ShoppingArticle article)
   {
     try
     {
       this.shoppingArticleMapper.insert(article);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "art",condition ="#id != null",unless = "#result== null")
   public ShoppingArticle getObjById(Long id)
   {
     ShoppingArticle article = shoppingArticleMapper.selectByPrimaryKey(id);
     if (article != null) {
       return article;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delArt",allEntries = true,beforeInvocation = true,condition = "#id >0L")
   public boolean delete(Long id) {
     try {
       this.shoppingArticleMapper.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsArt",allEntries = true,beforeInvocation = true,condition = "#articleIds >0L")
   public boolean batchDelete(List<Serializable> articleIds)
   {
     for (Serializable id : articleIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updateArt",condition = "#article != null")
   public boolean update(ShoppingArticle article) {
     try {
       this.shoppingArticleMapper.updateByPrimaryKey(article);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "articles",unless = "#result== null")
   public List<ShoppingArticle> list(Map<String, Object> para) {
     return shoppingArticleMapper.pageList(para);
   }

   @Override
   @Cacheable(cacheNames = "countarticles",unless = "#result== null")
   public int count(Map<String, Object> para) {
     return shoppingArticleMapper.pageCount(para);
   }

   @Override
   @Cacheable(cacheNames = "conditionArticles",unless = "#result== null")
   public List<ShoppingArticle> queryByCondition(Map<String, Object> para) {
       return shoppingArticleMapper.queryByCondition(para);
   }

   @Override
   @Cacheable(cacheNames = "conditionArticles",unless = "#result== null")
   public ShoppingArticle queryByMap(Map<String, Object> para) {
         return shoppingArticleMapper.queryByMap(para);
     }


 }





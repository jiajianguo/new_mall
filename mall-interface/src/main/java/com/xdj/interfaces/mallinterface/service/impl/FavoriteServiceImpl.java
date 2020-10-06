 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingFavoriteMapper;
 import com.xdj.interfaces.mallinterface.service.IFavoriteService;
 import com.xdj.www.entity.ShoppingFavorite;
 import com.xdj.www.entity.ShoppingFavoriteExample;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 /**
  * @author Administrator
  */

 @Service
 public class FavoriteServiceImpl  implements IFavoriteService
 {

   @Resource
   private ShoppingFavoriteMapper favoriteDao;

   @Override
   @CachePut(cacheNames = "insertfavorite" ,condition = "#favorite != null")
   public boolean save(ShoppingFavorite favorite)
   {
     try
     {
       this.favoriteDao.insertSelective(favorite);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "favorite",condition = "#id != null",unless = "#result==null")
   public ShoppingFavorite getObjById(Long id)
   {
       ShoppingFavorite favorite = favoriteDao.selectByPrimaryKey(id);
     if (favorite != null) {
       return favorite;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delfavorite",allEntries = true,beforeInvocation = true,condition = "#id !=  null")
   public boolean delete(Long id) {
     try {
       this.favoriteDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsfavorite",allEntries = true,beforeInvocation = true,condition = "#favoriteIds !=  null")
   public boolean batchDelete(List<Long> favoriteIds)
   {
     for (Long id : favoriteIds) {
       delete(id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatefavorite",condition = "#favorite != null")
   public boolean update(ShoppingFavorite favorite) {
     try {
       this.favoriteDao.updateByPrimaryKeySelective(favorite);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "queryfavorite",unless = "#result==null")
   public List<ShoppingFavorite> queryByCondition(Map params) {
     return favoriteDao.queryByCondition(params);
   }

   @Override
   @Cacheable(cacheNames = "examplefavorite",unless = "#result==null")
   public List<ShoppingFavorite> selectExample(ShoppingFavoriteExample example) {
     return favoriteDao.selectByExample(example);
   }

   @Override
   @Cacheable(cacheNames = "countfavorite",unless = "#result==null")
   public int count(Map<String, Object> map) {
     return favoriteDao.count(map);
   }

 }





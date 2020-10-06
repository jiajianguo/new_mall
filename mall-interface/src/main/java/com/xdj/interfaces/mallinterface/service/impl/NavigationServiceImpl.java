 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingNavigationMapper;
 import com.xdj.interfaces.mallinterface.service.INavigationService;
 import com.xdj.www.entity.ShoppingNavigation;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class NavigationServiceImpl implements INavigationService {

   @Resource
   private ShoppingNavigationMapper navigationDao;

   @Override
   @CachePut(cacheNames = "insertnav",condition = "#navigation != null")
   public boolean save(ShoppingNavigation navigation)
   {
     try
     {
       this.navigationDao.insertSelective(navigation);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "navigation",condition = "#id!=null",unless = "#result==null")
   public ShoppingNavigation getObjById(Long id)
   {
       ShoppingNavigation navigation = this.navigationDao.selectByPrimaryKey(id);
     if (navigation != null) {
       return navigation;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delnav",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.navigationDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsnav",allEntries = true,beforeInvocation = true,condition = "#navigationIds != null")
   public boolean batchDelete(List<Long> navigationIds)
   {
     for (Long id : navigationIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatenav")
   public boolean update(ShoppingNavigation navigation) {
     try {
       this.navigationDao.updateByPrimaryKeySelective(navigation);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conditionnav")
   public List<ShoppingNavigation> queryByConditin(Map<String, Object> paras) {
     return navigationDao.queryByConditin(paras);
   }


 }





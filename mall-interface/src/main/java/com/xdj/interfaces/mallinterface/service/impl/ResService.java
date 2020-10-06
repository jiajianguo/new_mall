 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingResMapper;
 import com.xdj.interfaces.mallinterface.service.IResService;
 import com.xdj.www.entity.ShoppingRes;
 import com.xdj.www.entity.ShoppingResExample;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;

 @Service
 public class ResService implements IResService
 {

   @Resource
   private ShoppingResMapper resDAO;

   @Override
   @CacheEvict(cacheNames = "delres",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id)
   {
     try
     {
       this.resDAO.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CachePut(cacheNames = "insertres",condition = "#res != null")
   public boolean save(ShoppingRes res)
   {
     try
     {
       this.resDAO.insertSelective(res);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CachePut(cacheNames = "updateres",condition = "#res != null")
   public boolean update(ShoppingRes res)
   {
     try
     {
       this.resDAO.updateByPrimaryKeySelective(res);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "res",condition = "#id!=null",unless = "#result==null")
   public ShoppingRes getObjById(Long id)
   {
     return this.resDAO.selectByPrimaryKey(id);
   }

   @Override
   @Cacheable(cacheNames = "ress",condition = "#resExample != null",unless = "#result==null")
   public List<ShoppingRes> selectByExample(ShoppingResExample resExample) {
     return resDAO.selectByExample(resExample);
   }


 }





 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingExpressCompanyMapper;
 import com.xdj.interfaces.mallinterface.service.IExpressCompanyService;
 import com.xdj.www.entity.ShoppingExpressCompany;
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
 public class ExpressCompanyServiceImpl implements IExpressCompanyService {

   @Resource
   private ShoppingExpressCompanyMapper expressCompanyDao;

   @Override
   @CachePut(cacheNames = "insertexpressCompany",condition = "#expressCompany != null")
   public boolean save(ShoppingExpressCompany expressCompany)
   {
     try
     {
       this.expressCompanyDao.insertSelective(expressCompany);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "expressCompany",condition = "#id != null",unless = "#result==null")
   public ShoppingExpressCompany getObjById(Long id)
   {
       ShoppingExpressCompany expressCompany = this.expressCompanyDao.selectByPrimaryKey(id);
     if (expressCompany != null) {
       return expressCompany;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delexpressCompany",allEntries = true,beforeInvocation = true,condition = "#id !=  null")
   public boolean delete(Long id) {
     try {
       this.expressCompanyDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsexpressCompany",allEntries = true,beforeInvocation = true,condition = "#expressCompanyIds != null")
   public boolean batchDelete(List<Long> expressCompanyIds)
   {
     for (Long id : expressCompanyIds) {
       delete(id);
     }
     return true;
   }

   @Override
   @CachePut(cacheNames = "updateexpressCompany",condition = "#expressCompany != null")
   public boolean update(ShoppingExpressCompany expressCompany) {
     try {
       this.expressCompanyDao.updateByPrimaryKeySelective(expressCompany);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

 }





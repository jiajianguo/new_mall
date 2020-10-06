 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingTemplateMapper;
 import com.xdj.interfaces.mallinterface.service.ITemplateService;
 import com.xdj.www.entity.ShoppingTemplate;
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
 public class TemplateServiceImpl  implements ITemplateService
 {

   @Resource
   private ShoppingTemplateMapper templateDao;

   @Override
   @CachePut(cacheNames = "savetemplate",condition = "#template != null")
   public boolean save(ShoppingTemplate template)
   {
     try
     {
       this.templateDao.insertSelective(template);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "template",unless = "#result== null")
   public ShoppingTemplate getObjById(Long id)
   {
       ShoppingTemplate template =this.templateDao.selectByPrimaryKey(id);
     if (template != null) {
       return template;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "deltemplate",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.templateDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delstemplate",allEntries = true,beforeInvocation = true,condition = "#templateIds != null")
   public boolean batchDelete(List<Long> templateIds)
   {
     for (Serializable id : templateIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatetemplate",condition = "#template != null")
   public boolean update(ShoppingTemplate template) {
     try {
       this.templateDao.updateByPrimaryKeySelective(template);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     public ShoppingTemplate queryByCondition(Map<String, Object> param) {
         return templateDao.queryByCondition(param);
     }


 }





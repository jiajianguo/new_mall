 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingReportSubjectMapper;
 import com.xdj.interfaces.mallinterface.service.IReportSubjectService;
 import com.xdj.www.entity.ShoppingReportSubject;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class ReportSubjectServiceImpl  implements IReportSubjectService
 {

   @Resource
   private ShoppingReportSubjectMapper reportSubjectDao;

   @Override
   @CachePut(cacheNames = "insertreportsub",condition = "#reportSubject != null")
   public boolean save(ShoppingReportSubject reportSubject)
   {
     try
     {
       this.reportSubjectDao.insertSelective(reportSubject);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "reportsub",condition = "#id!=null",unless = "#result==null")
   public ShoppingReportSubject getObjById(Long id)
   {
       ShoppingReportSubject reportSubject = this.reportSubjectDao.selectByPrimaryKey(id);
     if (reportSubject != null) {
       return reportSubject;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delreportsub",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.reportSubjectDao.selectByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsreportsub",allEntries = true,beforeInvocation = true,condition = "#reportSubjectIds != null")
   public boolean batchDelete(List<Long> reportSubjectIds)
   {
     for (Long id : reportSubjectIds) {
       delete((Long)id);
     }
     return true;
   }


   @Override
   @CachePut(cacheNames = "updatereportsub",condition = "#reportSubject != null")
   public boolean update(ShoppingReportSubject reportSubject) {
     try {
       this.reportSubjectDao.updateByPrimaryKeySelective(reportSubject);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conreportsub",unless = "#result== null")
   public List<ShoppingReportSubject> queryByCondition(Map<String, Object> params) {
     return reportSubjectDao.queryByCondition(params);
   }


 }





 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingReportTypeMapper;
 import com.xdj.interfaces.mallinterface.service.IReportTypeService;
 import com.xdj.www.entity.ShoppingReportType;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;
 import java.util.Map;

 @Service
 public class ReportTypeServiceImpl implements IReportTypeService
 {

   @Resource
   private ShoppingReportTypeMapper reportTypeDao;

   @Override
   @CachePut(cacheNames = "insertretype",condition = "#reportType != null")
   public boolean save(ShoppingReportType reportType)
   {
     try
     {
       this.reportTypeDao.insertSelective(reportType);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "reporttype",condition = "#id!=null",unless = "#result==null")
   public ShoppingReportType getObjById(Long id)
   {
       ShoppingReportType reportType =this.reportTypeDao.selectByPrimaryKey(id);
     if (reportType != null) {
       return reportType;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delreporttype",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.reportTypeDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsreporttype",allEntries = true,beforeInvocation = true,condition = "#reportTypeIds != null")
   public boolean batchDelete(List<Long> reportTypeIds)
   {
     for (Serializable id : reportTypeIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updateretype",condition = "#reportType != null")
   public boolean update(ShoppingReportType reportType) {
     try {
       this.reportTypeDao.updateByPrimaryKeySelective(reportType);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "conditionretype",unless = "#result== null")
     public List<ShoppingReportType> queryByCondition(Map<String, Object> params) {
         return reportTypeDao.queryByCondition(params);
     }


 }





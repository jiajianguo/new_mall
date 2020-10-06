 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingReportMapper;
 import com.xdj.interfaces.mallinterface.service.IReportService;
 import com.xdj.www.entity.ShoppingReportWithBLOBs;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;
 import java.util.Map;

 @Service
 @Transactional
 public class ReportServiceImpl implements IReportService
 {

   @Resource
   private ShoppingReportMapper reportDao;

   @Override
   @CachePut(cacheNames = "insertreport",condition = "#report != null")
   public boolean save(ShoppingReportWithBLOBs report)
   {
     try
     {
       this.reportDao.insertSelective(report);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "report",condition = "#id!=null",unless = "#result==null")
   public ShoppingReportWithBLOBs getObjById(Long id)
   {
       ShoppingReportWithBLOBs report = this.reportDao.selectByPrimaryKey(id);
     if (report != null) {
       return report;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delreport",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.reportDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsreport",allEntries = true,beforeInvocation = true,condition = "#reportIds != null")
   public boolean batchDelete(List<Long> reportIds)
   {
     for (Serializable id : reportIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatereport",condition = "#report != null")
   public boolean update(ShoppingReportWithBLOBs report) {
     try {
       this.reportDao.updateByPrimaryKeySelective(report);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "conditionreport",unless = "#result= null")
     public List queryByCondition(Map<String, Object> params) {
         return reportDao.queryByCondition(params);
     }

     @Override
     @Cacheable(cacheNames = "countreport",unless = "#result= null")
     public int count(Map<String, Object> map) {
         return reportDao.count(map);
     }

 }





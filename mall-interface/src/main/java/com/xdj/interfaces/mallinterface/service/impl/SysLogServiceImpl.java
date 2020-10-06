 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingSyslogMapper;
 import com.xdj.interfaces.mallinterface.service.ISysLogService;
 import com.xdj.www.entity.ShoppingSyslog;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;

 @Service("iSysLogService")
 public class SysLogServiceImpl implements ISysLogService
 {

   @Resource
   private ShoppingSyslogMapper sysLogDao;

   @Override
   @CachePut(cacheNames = "savasyslog",condition = "#sysLog != null")
   public boolean save(ShoppingSyslog sysLog)
   {
     try
     {
       this.sysLogDao.insertSelective(sysLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "syslog",unless = "#result== null")
   public ShoppingSyslog getObjById(Long id)
   {
       ShoppingSyslog sysLog = this.sysLogDao.selectByPrimaryKey(id);
     if (sysLog != null) {
       return sysLog;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delsyslog",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.sysLogDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delssyslog",allEntries = true,beforeInvocation = true,condition = "#sysLogIds != null")
   public boolean batchDelete(List<Long> sysLogIds)
   {
     for (Serializable id : sysLogIds) {
       delete((Long)id);
     }
     return true;
   }


   @Override
   @CachePut(cacheNames = "updatesyslog",condition = "#sysLog != null")
   public boolean update(ShoppingSyslog sysLog) {
     try {
       this.sysLogDao.updateByPrimaryKeySelective(sysLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }





 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingTransportMapper;
 import com.xdj.interfaces.mallinterface.service.ITransportService;
 import com.xdj.www.entity.ShoppingTransportWithBLOBs;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;

 @Service
 public class TransportServiceImpl  implements ITransportService
 {

   @Resource
   private ShoppingTransportMapper transportDao;

   @Override
   @CachePut(cacheNames = "savetrans",condition = "#transport != null")
   public boolean save(ShoppingTransportWithBLOBs transport)
   {
     try
     {
       this.transportDao.insertSelective(transport);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "trans",unless = "#result== null")
   public ShoppingTransportWithBLOBs getObjById(Long id)
   {
       ShoppingTransportWithBLOBs transport = this.transportDao.selectByPrimaryKey(id);
     if (transport != null) {
       return transport;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "deltrans",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.transportDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delstrans",allEntries = true,beforeInvocation = true,condition = "#transportIds != null")
   public boolean batchDelete(List<Long> transportIds)
   {
     for (Long id : transportIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatetrans",condition = "#transport != null")
   public boolean update(ShoppingTransportWithBLOBs transport) {
     try {
       this.transportDao.updateByPrimaryKeySelective(transport);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }





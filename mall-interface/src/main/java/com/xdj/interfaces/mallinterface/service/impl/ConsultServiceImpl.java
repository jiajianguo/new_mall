 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingConsultMapper;
 import com.xdj.interfaces.mallinterface.service.IConsultService;
 import com.xdj.www.entity.ShoppingConsultWithBLOBs;
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
 public class ConsultServiceImpl implements IConsultService
 {

   @Resource
   private ShoppingConsultMapper consultDao;

   @Override
   @CachePut(cacheNames = "insertconsult",condition = "#consult != null")
   public int save(ShoppingConsultWithBLOBs consult)
   {
     try
     {
       this.consultDao.insertSelective(consult);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @Cacheable(cacheNames = "consult",condition = "#id != null",unless = "#result==null")
   public ShoppingConsultWithBLOBs getObjById(Long id)
   {
       ShoppingConsultWithBLOBs consult =this.consultDao.selectByPrimaryKey(id);
     if (consult != null) {
       return consult;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delconsult",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public int delete(Long id) {
     try {
       this.consultDao.deleteByPrimaryKey(id);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @CacheEvict(cacheNames = "delsconsult",allEntries = true,beforeInvocation = true,condition = "#consultIds != null ")
   public int batchDelete(List<Long> consultIds)
   {
     for (Long id : consultIds) {
       delete(id);
     }
     return 1;
   }



   @Override
   public int update(ShoppingConsultWithBLOBs consult) {
     try {
       this.consultDao.updateByPrimaryKeyWithBLOBs(consult);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   public List<ShoppingConsultWithBLOBs> queryByCondition(Map<String, Object> map) {
     return consultDao.queryByCondition(map);
   }

   @Override
   public int count(Map<String, Object> map) {
     return consultDao.count(map);
   }


 }





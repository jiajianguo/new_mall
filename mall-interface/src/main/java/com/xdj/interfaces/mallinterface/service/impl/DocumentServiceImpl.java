 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingDocumentMapper;
 import com.xdj.interfaces.mallinterface.service.IDocumentService;
 import com.xdj.www.entity.ShoppingDocument;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.util.List;

 /**
  * @author Administrator
  */
 @Service
 public class DocumentServiceImpl implements IDocumentService {

   @Resource
   private ShoppingDocumentMapper documentDao;

   @Override
   @CachePut(cacheNames = "insertdocument",condition = "#document != null")
   public boolean save(ShoppingDocument document)
   {
     try
     {
       this.documentDao.insertSelective(document);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "document",condition = "#id != null",unless = "#result==null")
   public ShoppingDocument getObjById(Long id)
   {
     ShoppingDocument document = this.documentDao.selectByPrimaryKey(id);
     if (document != null) {
       return document;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "deldocument",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.documentDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsdocument",allEntries = true,beforeInvocation = true,condition = "#documentIds != null")
   public boolean batchDelete(List<Long> documentIds)
   {
     for (Long id : documentIds) {
       delete(id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatedocument",condition = "#document != null")
   public boolean update(ShoppingDocument document) {
     try {
       this.documentDao.updateByPrimaryKeySelective(document);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }




 }





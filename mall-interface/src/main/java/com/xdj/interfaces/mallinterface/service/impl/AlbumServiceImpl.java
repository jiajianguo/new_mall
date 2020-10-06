 package com.xdj.interfaces.mallinterface.service.impl;



 import com.xdj.interfaces.mallinterface.mapper.ShoppingAlbumMapper;
 import com.xdj.interfaces.mallinterface.mapper.ShoppingUserMapper;
 import com.xdj.interfaces.mallinterface.service.IAlbumService;
 import com.xdj.www.entity.ShoppingAlbum;
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
 public class AlbumServiceImpl implements IAlbumService {

   @Resource
   private ShoppingAlbumMapper albumDao;

   @Override
   @CachePut(cacheNames = "insertalbum",condition = "#album != null")
   public int save(ShoppingAlbum album){
     try{
       this.albumDao.insertSelective(album);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @Cacheable(cacheNames = "album",condition = "#id != null",unless = "#result==null")
   public ShoppingAlbum getObjById(Long id)
   {
     ShoppingAlbum album =this.albumDao.selectByPrimaryKey(id);
     if (album != null) {
       return album;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delAlbum",allEntries = true,beforeInvocation = true,condition = "#id >0")
   public int delete(Long id) {
     try {
       this.albumDao.deleteByPrimaryKey(id);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @CacheEvict(cacheNames = "delsAlbum",allEntries = true,beforeInvocation = true,condition = "#id >0")
   public int batchDelete(List<Long> albumIds)
   {
     for (Long id : albumIds) {
       delete(id);
     }
     return 1;
   }


   @Override
   @CachePut(cacheNames = "updateAlbum",condition = "#album != null")
   public int update(ShoppingAlbum album) {
     try {
       this.albumDao.updateByPrimaryKeySelective(album);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }


 }





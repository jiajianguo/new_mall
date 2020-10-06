 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingAccessoryMapper;
 import com.xdj.interfaces.mallinterface.service.IAccessoryService;

 import com.xdj.www.entity.ShoppingAccessory;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;


 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 /**
  * cache  返回值时是以键值对进行缓存的，值就是方法的返回结果，至于键的话，Spring又支持两种策略，默认策略和自定义策略
  * @author Administrator
  * @Cacheable 可以标记在一个方法上，也可以标记在一个类上。当标记在一个方法上时表示该方法是支持缓存的，当标记在一个类上时则表示该类所有的方法都是支持缓存的
  *     @Cacheable可以指定三个属性，value、key和condition
  *         value属性是必须指定的，其表示当前方法的返回值是会被缓存在哪个Cache上的，对应Cache的名称,也可以指定多个用逗号分隔
  *         key 使用key属性自定义key -> 使用方法参数时我们可以直接使用“#参数名”或者“#p参数index”
  */

 @Service("accessoryService")
 public class AccessoryServiceImpl implements IAccessoryService
 {

   @Resource
   private ShoppingAccessoryMapper accessoryDAO;

   @Override
   @CacheEvict(cacheNames = "delAccessory", allEntries = true, beforeInvocation = true, condition = "#id >0")
   public int delete(Long id){
     try{
       this.accessoryDAO.deleteByPrimaryKey(id);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }
     return 0;
   }

   @Override
   public ShoppingAccessory getObjById(Long id)
   {
     return this.accessoryDAO.selectByPrimaryKey(id);
   }

   @Override
   @Cacheable(cacheNames = "accessorys" )
   public List<ShoppingAccessory> queryByCondition(Map<String, Object> params) {
     return accessoryDAO.queryByCondition(params);
   }

     @Override
     @Cacheable(cacheNames = "accessories",key = "#goods_id",condition = "#goods_id>0")
     public List<ShoppingAccessory> queryByGoodsId(Long goods_id) {
         return accessoryDAO.queryByGoodsId(goods_id);
     }

     @Override
     @CachePut(cacheNames = "updateAccessory", condition = "#acc !=null", unless = "#result>0")
   public int save(ShoppingAccessory acc)
   {
     try {
       return this.accessoryDAO.insertSelective(acc);
     } catch (Exception e) {
     }
     return 0;
   }

   @Override
   @CachePut(cacheNames = "updateAccessory", condition = "#acc != null", unless = "#result>0")
   public int update(ShoppingAccessory acc)
   {
     try
     {
       this.accessoryDAO.updateByPrimaryKey(acc);
       return 1;
     } catch (Exception e) {
     }
     return 0;
   }

 }





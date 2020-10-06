 package com.xdj.interfaces.mallinterface.controller.view;



 import com.xdj.interfaces.mallinterface.service.IAreaService;
 import com.xdj.www.core.tools.CommUtil;
 import com.xdj.www.entity.*;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 @Component
 public class AreaViewTools{
   @Autowired
   private IAreaService areaService;

   public String generic_area_info(String area_id)
   {
     String area_info = "";
     ShoppingArea area = this.areaService.getObjById(CommUtil.null2Long(area_id));
     if (area != null) {
       area_info = area.getAreaname() + " ";
       if (area.getParentId() != null) {
         String info = generic_area_info(area.getParentId().toString());
         area_info = info + area_info;
       }
     }
     return area_info;
   }

   public final void addChilds(ShoppingArea area){
       if(area != null){
           Map<String,Object> map = new HashMap<String,Object>();
           map.put("parent_id","= ".concat(area.getId().toString()));
           List<ShoppingArea> childs = areaService.queryByCondition(map);
           area.setChilds(childs);
       }
   }

   public final void addParent(ShoppingArea area){
       if(area != null ){
           if(area.getParentId() != null){
               area.setParent(areaService.getObjById( area.getParentId()));
           }else{
               area.setParent(area);
           }

       }
   }

   public final void addManyChilds(List<ShoppingArea> areas,boolean isParent){
       if(areas != null){
           for(ShoppingArea s: areas){
               addChilds(s);
               if(isParent){
                   addParent(s);
               }
           }
       }
   }

     public final void addGrandpa(ShoppingArea area){

         if(area != null && area.getParentId() != null){
             ShoppingArea parent= addParents (area);
             if(parent != null){
                 addParent(parent);
             }
             area.setParent(parent);
         }
     }

     public final ShoppingArea addParents(ShoppingArea area){
         if(area != null && area.getParentId() != null){
             return   areaService.getObjById( area.getParentId());
         }
         return null;
     }

     public void addAddrAreas(List<ShoppingAddress> addrs,boolean isAddGrandpa) {
       if(addrs != null){
            for(ShoppingAddress s: addrs){
                addAddrArea(s,isAddGrandpa);
            }
       }
     }

     public void addAddrArea(ShoppingAddress addr,boolean isAddGrandpa) {
       if(addr != null){
           ShoppingArea area = areaService.getObjById(addr.getAreaId());
           if(area != null && isAddGrandpa){
               addGrandpa(area);
           }
           addr.setArea(area);
       }
     }

     public void addAdressAreas(List<ShoppingAddress> pList) {
         if(pList!=null&&pList.size()>0){
             for (ShoppingAddress address : pList) {
                 addAdressArea(address);
             }
         }

     }

     public void addAdressArea(ShoppingAddress address) {
         if(address.getAreaId()!=null){
             ShoppingArea area = areaService.getObjById(address.getAreaId());
             if(area != null){
                 addGrandpa(area);
             }
             address.setArea(area);
         }
     }

     public void addStoreArea(ShoppingStoreWithBLOBs st) {
       if(st != null && st.getAreaId() != null){
           ShoppingArea area = areaService.getObjById(st.getAreaId());
           addGrandpa(area);
           st.setArea(area);
       }
     }

     public final void addStoreAreas(List<ShoppingStoreWithBLOBs> pList) {
       if(pList != null){
           for(ShoppingStoreWithBLOBs s: pList){
               addStoreArea(s);
           }
       }
     }

     public final  void addUserAreas(List<ShoppingUser> pList) {
       if(pList != null){
            for(ShoppingUser s: pList){
                addUserArea(s);
            }
       }
     }

     public final  void addUserArea(ShoppingUser user) {
        if(user !=  null){
           ShoppingArea area= areaService.getObjById(user.getAreaId());
           addGrandpa(area);
           user.setArea(area);
        }
     }
 }





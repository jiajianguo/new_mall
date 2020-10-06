 package com.xdj.interfaces.mallinterface.controller.view;




 import com.xdj.interfaces.mallinterface.service.IActivityService;
 import com.xdj.interfaces.mallinterface.service.IArticleService;
 import com.xdj.interfaces.mallinterface.service.IGoodsClassService;
 import com.xdj.interfaces.mallinterface.service.INavigationService;
 import com.xdj.www.entity.ShoppingNavigation;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 @Component
 public class NavViewTools{

   @Autowired
   private INavigationService navService;

   public List<ShoppingNavigation> queryNav(int location, int count)
   {
     List navs = new ArrayList();
     Map params = new HashMap();
     params.put("display", Boolean.valueOf(true));
     params.put("location", Integer.valueOf(location));
     params.put("type", "diy");
     params.put("start",0);
     params.put("orderBy","sequence");
     params.put("sort","asc");
     if(count == -1){
        count= 6;
     }
     params.put("pageSize",count);
     navs = this.navService.queryByConditin(params);
     //("select obj from Navigation obj where obj.display=:display and obj.location=:location and obj.type!=:type order by obj.sequence asc", params, 0, count);
     return navs;
   }
 }





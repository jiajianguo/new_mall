 package com.xdj.interfaces.mallinterface.pay.tools;

 import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
 import com.xdj.interfaces.mallinterface.service.IPaymentService;
 import com.xdj.interfaces.mallinterface.service.IUserService;
 import com.xdj.interfaces.mallinterface.util.CommUtil;
 import com.xdj.www.entity.ShoppingPayment;
 import com.xdj.www.entity.ShoppingPaymentWithBLOBs;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;
 import org.springframework.web.servlet.ModelAndView;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 @Component
 public class PaymentTools
 {

   @Autowired
   private IPaymentService paymentService;

   @Autowired
   private IUserService userService;

   public boolean queryPayment(String mark, String type)
   {
     Map params = new HashMap();
     params.put("mark", mark);
     params.put("type", type);
     List objs = this.paymentService.queryByCondition(params);
      /* .query("select obj from Payment obj where obj.mark=:mark and obj.type=:type", params, -1, -1);*/
     if (objs.size() > 0) {
       return ((ShoppingPayment)objs.get(0)).getInstall();
     }
     return false;
   }

   public Map queryPayment(String mark) {
     Map params = new HashMap();
     params.put("mark", mark);
     params.put("type", "user");
     Long store_id = null;
     store_id = this.userService.getObjById(
       SecurityUserHolder.getCurrentUser().getId()).getStore().getId();
     params.put("store_id", store_id);
     List objs = this.paymentService.queryByCondition(params);
       //.query("select obj from Payment obj where obj.mark=:mark and obj.type=:type and obj.store.id=:store_id", params, -1, -1);
     Map ret = new HashMap();
     if (objs.size() == 1) {
       ret.put("install", Boolean.valueOf(((ShoppingPaymentWithBLOBs)objs.get(0)).getInstall()));
       ret.put("already", Boolean.valueOf(true));
     } else {
       ret.put("install", Boolean.valueOf(false));
       ret.put("already", Boolean.valueOf(false));
     }
     return ret;
   }

   public Map queryStorePayment(String mark, Long store_id) {
     Map ret = new HashMap();
     Map params = new HashMap();
     params.put("mark", mark);
     params.put("store_id", CommUtil.null2Long(store_id));
     List objs = this.paymentService.queryByCondition(params);
       //.query("select obj from Payment obj where obj.mark=:mark and obj.store.id=:store_id", params, -1, -1);
     if (objs.size() == 1) {
       ret.put("install", Boolean.valueOf(((ShoppingPaymentWithBLOBs)objs.get(0)).getInstall()));
       ret.put("content", ((ShoppingPaymentWithBLOBs)objs.get(0)).getContent());
     } else {
       ret.put("install", Boolean.valueOf(false));
       ret.put("content", "");
     }
     return ret;
   }

   public Map<String,String> queryShopPayment(String mark) {
     Map ret = new HashMap();
     Map params = new HashMap();
     params.put("mark", mark);
     params.put("type", "admin");
     List<ShoppingPaymentWithBLOBs> objs = this.paymentService.queryByCondition(params);
       //.query("select obj from Payment obj where obj.mark=:mark and obj.type=:type", params, -1, -1);
     if (objs.size() == 1) {
       ret.put("install", Boolean.valueOf(objs.get(0).getInstall()));
       ret.put("content", objs.get(0).getContent());
     } else {
       ret.put("install", Boolean.valueOf(false));
       ret.put("content", "");
     }
     return ret;
   }

   public final  void returnData(String mark, ModelAndView mv){
     Map<String,String> result = queryShopPayment(mark);
     mv.addObject(mark,result.get("install"));
     mv.addObject(mark.concat("Content"),result.get("content"));
   }

   public final void returnStoreData(String mark,Long id,ModelAndView mv){
     Map<String,String> result = queryStorePayment(mark,id);
     mv.addObject("un".concat(mark),result.get("install"));
     mv.addObject("un".concat(mark.concat("Content")),result.get("content"));
   }
 }





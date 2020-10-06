 package com.xdj.interfaces.mallinterface.controller.view;

 import com.google.gson.Gson;
 import com.xdj.interfaces.mallinterface.service.*;
 import com.xdj.www.core.tools.CommUtil;
 import com.xdj.www.entity.*;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.stereotype.Component;

 import javax.annotation.Resource;
 import java.util.*;

 @Component
 public class GoodsFloorTools {
   @Resource
   private IGoodsService goodsService;
   @Resource
   private IGoodsClassService goodsClassService;
   @Resource
   private IAccessoryService accessoryService;
   @Resource
   private IAdvertPositionService advertPositionService;
   @Resource
   private IAdvertService advertService;
   @Resource
   private IGoodsBrandService goodsBrandService;
   @Resource
   private StoreViewTools storeViewTools;
   private Logger log = LoggerFactory.getLogger("goodstools");

   public List<ShoppingGoodsclassWithBLOBs> generic_gf_gc(String json){
     List<ShoppingGoodsclassWithBLOBs> gcs = new ArrayList();
     if ((json != null) && (!json.equals(""))) {
       List<Map> list = new Gson().fromJson( json,List.class);
       for (Map map : list) {
         ShoppingGoodsclassWithBLOBs the_gc = this.goodsClassService.getObjById(CommUtil.null2Long(map.get("pid")));
         if (the_gc != null) {
           int count = CommUtil.null2Int(map.get("gc_count"));
           List<ShoppingGoodsclassWithBLOBs> s= new ArrayList<ShoppingGoodsclassWithBLOBs>();
           for (int i = 1; i <= count; i++) {
             ShoppingGoodsclassWithBLOBs child = this.goodsClassService.getObjById(CommUtil.null2Long(map.get("gc_id" +i)));
             s.add(child);
           }
           the_gc.setChilds(s);
           gcs.add(the_gc);
         }
       }
     }
     return gcs;
   }

   public List<ShoppingGoodsWithBLOBs> generic_goods(String json) {
     List<ShoppingGoodsWithBLOBs> goods_list = new ArrayList();
     if ((json != null) && (!json.equals(""))) {
       Map map = new Gson().fromJson(json,Map.class);
       for (int i = 1; i <= 10; i++) {
         String key = "goods_id" + i;
         ShoppingGoodsWithBLOBs goods = this.goodsService.getObjById( CommUtil.null2Long(map.get(key)));
         if (goods != null) {
           if(goods.getGoodsMainPhotoId() != null){
             goods.setGoods_main_photo(accessoryService.getObjById(goods.getGoodsMainPhotoId()));
           }
           goods_list.add(goods);
         }
       }
     }

     return goods_list;
   }

   public Map generic_goods_list(String json) {
     Map map = new HashMap();
     map.put("list_title", "商品排行");
     if ((json != null) && (!json.equals(""))) {
       Map list = new Gson().fromJson(json,Map.class);
       map.put("list_title", CommUtil.null2String(list.get("list_title")));
       ShoppingGoodsWithBLOBs goods = this.goodsService.getObjById( CommUtil.null2Long(list.get("goods_id1")));
       goods.setGoods_main_photo(accessoryService.getObjById(goods.getGoodsMainPhotoId()));
       storeViewTools.addGoodsStore(goods);
       map.put("goods1", goods);
       ShoppingGoodsWithBLOBs goods1 = this.goodsService.getObjById( CommUtil.null2Long(list.get("goods_id2")));
       goods1.setGoods_main_photo(accessoryService.getObjById(goods1.getGoodsMainPhotoId()));
       storeViewTools.addGoodsStore(goods1);
       map.put("goods2", goods1);
       ShoppingGoodsWithBLOBs goods2 = this.goodsService.getObjById( CommUtil.null2Long(list.get("goods_id3")));
       goods2.setGoods_main_photo(accessoryService.getObjById(goods2.getGoodsMainPhotoId()));
       storeViewTools.addGoodsStore(goods2);
       map.put("goods3",goods2);
       ShoppingGoodsWithBLOBs goods3= this.goodsService.getObjById( CommUtil.null2Long(list.get("goods_id4")));
       goods3.setGoods_main_photo(accessoryService.getObjById(goods3.getGoodsMainPhotoId()));
       storeViewTools.addGoodsStore(goods3);
       map.put("goods4", goods3);
       ShoppingGoodsWithBLOBs goods4= this.goodsService.getObjById( CommUtil.null2Long(list.get("goods_id5")));
       goods4.setGoods_main_photo(accessoryService.getObjById(goods4.getGoodsMainPhotoId()));
       storeViewTools.addGoodsStore(goods4);
       map.put("goods5", goods4);
       ShoppingGoodsWithBLOBs goods5= this.goodsService.getObjById( CommUtil.null2Long(list.get("goods_id6")));
       if(goods5 != null){
         goods5.setGoods_main_photo(accessoryService.getObjById(goods5.getGoodsMainPhotoId()));
         storeViewTools.addGoodsStore(goods5);
       }
       map.put("goods6", goods5);
     }
     return map;
   }

   public  ShoppingAccessory genericAdvert (String url,String json){
     if ((json != null) && (!json.equals(""))) {
       Map map = new Gson().fromJson(json,Map.class);
       ShoppingAdvPos ap = null;
       if (CommUtil.null2String(map.get("adv_id")).equals("")) {
         ShoppingAccessory img = this.accessoryService.getObjById(CommUtil.null2Long(map.get("acc_id")));
         if(img != null){
           img.setUrl(url);
         }
         return img;
       }else{
         ap=this.advertPositionService.getObjById(CommUtil.null2Long(map.get("adv_id")));
         Map<String,Object> params= new HashMap<String,Object>();
         params.put("ad_ap_id",ap.getId());
         params.put("ad_begin_time",new Date());
         params.put("ad_end_time",new Date());
         params.put("ad_status",1);
         List<ShoppingAdvert> advs = advertService.queryByCondition(params);
         ShoppingAdvPos obj = new ShoppingAdvPos();
         if (advs.size() > 0) {
           if (obj.getApType().equals("img")) {
             if (obj.getApShowType() == 0) {
               ShoppingAccessory accessory = accessoryService.getObjById(advs.get(0).getAdAccId());
               obj.setApAcc(accessory);
               obj.setApAccUrl(advs.get(0).getAdUrl());
               obj.setAdvId(advs.get(0).getId());
             }
             if (obj.getApShowType() == 1) {
               Random random = new Random();
               int i = random.nextInt(advs.size());
               ShoppingAccessory accessory = accessoryService.getObjById(advs.get(i).getAdAccId());
               obj.setApAcc(accessory);
               obj.setApAccUrl(advs.get(i).getAdUrl());
               obj.setAdvId(advs.get(i).getId());
             }
           }
         } else {
           ShoppingAccessory accessory = accessoryService.getObjById(ap.getApAccId());
           obj.setApAcc(accessory);
           obj.setApText(ap.getApText());
           obj.setApAccUrl(ap.getApAccUrl());
           ShoppingAdvert adv = new ShoppingAdvert();
           adv.setAdUrl(obj.getApAccUrl());
           adv.setAdAcc(accessory);
           List<ShoppingAdvert> as = new ArrayList<ShoppingAdvert>();
           as.add(adv);
           obj.setAdvs(as);
         }
         return obj.getApAcc();
       }
     }
     return null;
   }

   public String generic_adv(String web_url, String json) {
     String template = "<div style='float:left;overflow:hidden;'>";
     if ((json != null) && (!json.equals(""))) {
       Map map = new Gson().fromJson(json,Map.class);
       if (CommUtil.null2String(map.get("adv_id")).equals("")) {
         ShoppingAccessory img = this.accessoryService.getObjById(CommUtil.null2Long(map.get("acc_id")));
         if (img != null) {
           String url = CommUtil.null2String(map.get("acc_url"));
           template = template + "<a href='" + url +"' target='_blank'><img src='" + web_url + "/" +
             img.getPath() + "/" + img.getName() + "' /></a>";
         }
       } else {
         ShoppingAdvPos ap = this.advertPositionService.getObjById(CommUtil.null2Long(map.get("adv_id")));
         Map<String,Object> params= new HashMap<String,Object>();
         params.put("ad_ap_id",ap.getId());
         params.put("ad_begin_time",new Date());
         params.put("ad_end_time",new Date());
         params.put("ad_status",1);
         List<ShoppingAdvert> advs = advertService.queryByCondition(params);
         ShoppingAdvPos obj = new ShoppingAdvPos();
         if (advs.size() > 0) {
           if (obj.getApType().equals("img")) {
             if (obj.getApShowType() == 0) {
               obj.setApAcc(advs.get(0).getAdAcc());
               obj.setApAccUrl(advs.get(0).getAdUrl());
               obj.setAdvId(advs.get(0).getId());
             }
             if (obj.getApShowType() == 1) {
               Random random = new Random();
               int i = random.nextInt(advs.size());
               obj.setApAcc(advs.get(i).getAdAcc());
               obj.setApAccUrl(advs.get(i).getAdUrl());
               obj.setAdvId(advs.get(i).getId());
             }
           }
         } else {
           obj.setApAcc(ap.getApAcc());
           obj.setApText(ap.getApText());
           obj.setApAccUrl(ap.getApAccUrl());
           ShoppingAdvert adv = new ShoppingAdvert();
           adv.setAdUrl(obj.getApAccUrl());
           adv.setAdAcc(ap.getApAcc());
           obj.getAdvs().add(adv);
         }

         template = template + "<a href='" + obj.getApAccUrl() +
           "' target='_blank'><img src='" + web_url + "/" +
           obj.getApAcc().getPath() + "/" +
           obj.getApAcc().getName() + "' /></a>";
       }
     }
     template = template + "</div>";
     return template;
   }

   public List<ShoppingGoodsbrand> generic_brand(String json) {
     List brands = new ArrayList();
     if ((json != null) && (!json.equals(""))) {
       Map map = new Gson().fromJson( json,Map.class);
       for (int i = 1; i <= 11; i++) {
         String key = "brand_id" + i;
         ShoppingGoodsbrand brand = this.goodsBrandService.getObjById(CommUtil.null2Long(map.get(key)));
         if (brand != null) {
           ShoppingAccessory accessory=accessoryService.getObjById(brand.getBrandlogoId());
           brand.setBrandLogo(accessory);
           brands.add(brand);
         }
       }
     }
     return brands;
   }
 }





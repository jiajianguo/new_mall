 package com.xdj.interfaces.mallinterface.controller.view;


 import com.google.gson.Gson;
 import com.xdj.interfaces.mallinterface.mapper.ShoppingStoreMapper;
 import com.xdj.interfaces.mallinterface.service.*;
 import com.xdj.www.core.tools.CommUtil;
 import com.xdj.www.entity.*;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.stereotype.Component;
 import org.springframework.web.servlet.ModelAndView;

 import javax.annotation.Resource;
 import java.math.BigDecimal;
 import java.util.*;

 /**
  * @author Administrator
  */
 @Component
 public class StoreViewTools {
   @Resource
   private IStoreService storeService;
   @Resource
   private ISysConfigService configService;
   @Resource
   private IUserService userService;
   @Resource
   private IEvaluateService evaluateService;
   @Resource
   private IGoodsService goodsService;
   @Resource
   private IStoreClassService storeClassService;
   @Resource
   private IAreaService areaService;
   @Resource
   private IAccessoryService accessoryService;
   @Resource
   private  IStorePointService storePointService;
   @Resource
   private IStorePartnerService storePartnerService;
   @Resource
   private IUserGoodsClassService userGoodsClassService;
   @Resource
   private UserGoodsClassTools userGoodsClassTools;
   @Resource
   private IStoreGradeService storeGradeService;
   @Resource
   private ShoppingStoreMapper shoppingStoreMapper;
   @Resource
   private IStoreSlideService storeSlideService;
   @Resource
   private AccessoryViewTools accessoryViewTools;
   @Resource
   private AreaViewTools areaViewTools;
   @Resource
   private StoreViewTools storeViewTools;



   public int query_evaluates(Long store_id, int evaluate_val, String type, String date_symbol, int date_count){
     Calendar cal = Calendar.getInstance();
     if (type.equals("date")) {
       cal.add(6, date_count);
     }
     if (type.equals("week")) {
       cal.add(3, date_count);
     }
     if (type.equals("month")) {
       cal.add(2, date_count);
     }
     String symbol = "than";
     if (date_symbol.equals("before")) {
       symbol = "less";
     }
     Map params = new HashMap();
     params.put("store_id", store_id);
     params.put("symbolTime", cal.getTime());
     params.put("evaluate_buyer_val", Integer.valueOf(CommUtil.null2Int(Integer.valueOf(evaluate_val))));
     params.put("symbol", symbol);
     int evas = this.evaluateService.queryCount(params);
             //query("select obj from Evaluate obj where obj.evaluate_goods.goods_store.id=:store_id and obj.evaluate_buyer_val=:evaluate_buyer_val and obj.addTime" +
                   //  symbol + ":addTime", params, -1, -1);
     return evas;
   }

   private  final static Logger log = LoggerFactory.getLogger("StoreViewTools");

   public ModelAndView store_left1(ModelAndView mv,ShoppingStoreWithBLOBs store) {
     mv.addObject("store", store);
     add_store_common_info(mv, store);
     Map params = new HashMap();
     params.put("store_id", store.getId());
     params.put("orderBy","sequence");
     params.put("sort","asc");
     List<ShoppingStorePartner> partners = this.storePartnerService .queryByCondition(params);
     mv.addObject("partners", partners);
     return mv;
   }

   private void add_store_common_info(ModelAndView mv, ShoppingStoreWithBLOBs store) {
     ShoppingUser user = userService.queryOneByStoreId(store.getId());
     Map params = new HashMap();
     params.put("user_id", user.getId());
     params.put("display", 1);
     params.put("parent_id","is null");
     params.put("orderBy","sequence");
     params.put("sort","asc");
     List<ShoppingUsergoodsclass> ugcs = this.userGoodsClassService.queryByCondition(params);
     userGoodsClassTools.addChilds(ugcs);
             //.query("select obj from UserGoodsClass obj where obj.user.id=:user_id and obj.display=:display and obj.parent.id is null order by obj.sequence asc",
                    // params, -1, -1);
     mv.addObject("ugcs", ugcs);
     params.clear();
     params.put("recommend", Boolean.valueOf(true));
     params.put("goods_store_id", store.getId());
     params.put("goods_status", 0);
     params.put("orderBy","addTime");
     params.put("sort","desc");
     params.put("start",0);
     params.put("pageSize",8);
     List<ShoppingGoodsWithBLOBs> goods_recommend = this.goodsService.queryByCondition(params);
     //query("select obj from Goods obj where obj.goods_recommend=:recommend and obj.goods_store.id=:goods_store_id and obj.goods_status=:goods_status order by obj.addTime desc",
     //      params, 0, 8);
     params.clear();
     params.put("goods_store_id", store.getId());
     params.put("goods_status", Integer.valueOf(0));
     List<ShoppingGoodsWithBLOBs> goods_new = this.goodsService.queryByCondition(params);
             //.query("select obj from Goods obj where obj.goods_store.id=:goods_store_id and obj.goods_status=:goods_status order by obj.addTime desc ",
                    // params, 0, 12);
     mv.addObject("goods_recommend", goods_recommend);
     mv.addObject("goods_new", goods_new);
   }


   public final void generic_evaluate(ShoppingStoreWithBLOBs store, ModelAndView mv) {
     double description_result = 0.0D;
     double service_result = 0.0D;
     double ship_result = 0.0D;
     if ((store != null) && (store.getScId() != null) && (store.getPoint() != null)) {
       ShoppingStoreclass sc = this.storeClassService.getObjById(store.getScId());
       float description_evaluate = CommUtil.null2Float(sc.getDescriptionEvaluate());
       float service_evaluate = CommUtil.null2Float(sc .getServiceEvaluate());
       float ship_evaluate = CommUtil.null2Float(sc.getShipEvaluate());
       float store_description_evaluate = CommUtil.null2Float(store.getPoint().getDescriptionEvaluate());
       float store_service_evaluate = CommUtil.null2Float(store.getPoint().getServiceEvaluate());
       float store_ship_evaluate = CommUtil.null2Float(store.getPoint().getShipEvaluate());

       description_result = CommUtil.div(Float.valueOf(store_description_evaluate -
               description_evaluate), Float.valueOf(description_evaluate));
       service_result = CommUtil.div(Float.valueOf(store_service_evaluate -
               service_evaluate), Float.valueOf(service_evaluate));
       ship_result = CommUtil.div(Float.valueOf(store_ship_evaluate - ship_evaluate),
               Float.valueOf(ship_evaluate));
     }
     if (description_result > 0.0D) {
       mv.addObject("description_css", "better");
       mv.addObject("description_type", "高于");
       mv.addObject(
               "description_result",
               CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(description_result), Integer.valueOf(100)) > 100.0D ? 100.0D :
                       CommUtil.mul(Double.valueOf(description_result), Integer.valueOf(100)))) +
                       "%");
     }
     if (description_result == 0.0D) {
       mv.addObject("description_css", "better");
       mv.addObject("description_type", "持平");
       mv.addObject("description_result", "-----");
     }
     if (description_result < 0.0D) {
       mv.addObject("description_css", "lower");
       mv.addObject("description_type", "低于");
       mv.addObject(
               "description_result",
               CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(-description_result), Integer.valueOf(100)))) +
                       "%");
     }
     if (service_result > 0.0D) {
       mv.addObject("service_css", "better");
       mv.addObject("service_type", "高于");
       mv.addObject("service_result",
               CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(service_result), Integer.valueOf(100)))) +
                       "%");
     }
     if (service_result == 0.0D) {
       mv.addObject("service_css", "better");
       mv.addObject("service_type", "持平");
       mv.addObject("service_result", "-----");
     }
     if (service_result < 0.0D) {
       mv.addObject("service_css", "lower");
       mv.addObject("service_type", "低于");
       mv.addObject("service_result",
               CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(-service_result), Integer.valueOf(100)))) +
                       "%");
     }
     if (ship_result > 0.0D) {
       mv.addObject("ship_css", "better");
       mv.addObject("ship_type", "高于");
       mv.addObject("ship_result",
               CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(ship_result), Integer.valueOf(100)))) + "%");
     }
     if (ship_result == 0.0D) {
       mv.addObject("ship_css", "better");
       mv.addObject("ship_type", "持平");
       mv.addObject("ship_result", "-----");
     }
     if (ship_result < 0.0D) {
       mv.addObject("ship_css", "lower");
       mv.addObject("ship_type", "低于");
       mv.addObject("ship_result",
               CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(-ship_result), Integer.valueOf(100)))) + "%");
     }
     if(store.getGoods_list() != null){
       mv.addObject("goods_count",store.getGoods_list().size());
     }

   }

   public final void addPoint (ShoppingStoreWithBLOBs store){
     if(store != null ){
        ShoppingStorePoint  point = storePointService.queryOne(store.getId());
        store.setPoint(point);
     }
   }

   public final void addStoreLogo(ShoppingStoreWithBLOBs store){
     if(store != null && store.getStoreLogoId() != null){
       store.setStoreLogo(accessoryService.getObjById(store.getStoreLogoId()));
     }
   }

   public final void addBanner(ShoppingStoreWithBLOBs store){
     if(store != null && store.getStoreBannerId() != null){
        store.setStore_banner(accessoryService.getObjById(store.getStoreBannerId()));
     }
   }

   public final void addUser (ShoppingStoreWithBLOBs store){
     if(store != null ){
       ShoppingUser user = userService.queryOneByStoreId(store.getId());
        store.setUser(user);
     }
   }

   public final void addGoods(ShoppingStoreWithBLOBs store){
     if(store != null){
        Map<String,Object>  para = new HashMap<String,Object>();
        para.put("goods_store_id",store.getId());
        para.put("goods_status",0);
        List<ShoppingGoodsWithBLOBs> goods = goodsService.queryByCondition(para);
        if( goods != null){
          store.setGoods_list(goods);
        }
     }
   }

   public final  void addArea (ShoppingStoreWithBLOBs store){
     if(store != null){
        ShoppingArea area =areaService.getObjById(store.getAreaId());
        areaViewTools.addGrandpa(area);
        store.setArea(area);
     }
   }

   public String genericFunction(ShoppingStoregrade grade)
   {
     String fun = "";
     if (grade.getAddFunciton().equals("")) {
       fun = "无";
     }
     String[] list = grade.getAddFunciton().split(",");
     for (String s : list) {
       if (s.equals("editor_multimedia")) {
         fun = "富文本编辑器" + fun;
       }
     }
     return fun;
   }

   public String genericImageSuffix(String imageSuffix)
   {
     String suffix = "";
     String[] list = imageSuffix.split("\\|");
     for (String l : list) {
       suffix = "*." + l + ";" + suffix;
     }
     return suffix.substring(0, suffix.length() - 1);
   }

   public final void  store_credits(Long storeId,ModelAndView mv){
     int credit =generic_store_credit(storeId.toString());
     String creditsImg= "";
     if(0< credit && credit <10){
       credit = credit/2 +1;
       creditsImg="/style/common/images/level_0.gif";
     }
     if(credit >= 10 && credit < 20){
       credit = (credit-10)/2 +1;
       creditsImg="/style/common/images/level_1.gif";
     }
     if(credit >= 20){
       credit = (credit-20)/2 +1;
       creditsImg="/style/common/images/level_2.gif";
     }
     if(credit > 5 ){
       credit =5;
     }
     List<Integer> credits= new ArrayList();
     int counts =0;
     for(int i=0;i< credit;i++){
       credits.add(counts+1);
     }
     mv.addObject("creditsImg",creditsImg);
     mv.addObject("credit",credit);
     mv.addObject("credits",credits);
   }
   /**
    * 店铺信用
    * @param id
    * @return
    */
   public  int generic_store_credit(String id){
     int credit = 0;
     String sys_credit = this.configService.getSysConfig().getCreditrule();
     Map map =  new Gson().fromJson( sys_credit,HashMap.class);
     List list = new ArrayList();
     for (Iterator it = map.keySet().iterator(); it.hasNext(); ) {
       String key = (String)it.next();
       list.add(new Double(map.get(key).toString()).intValue());
     }
     Integer[] ints = (Integer[])list.toArray(new Integer[list.size()]);

     Arrays.sort(ints, new Comparator(){
       @Override
       public int compare(Object obj1, Object obj2)
       {
         int a = CommUtil.null2Int(obj1);
         int b = CommUtil.null2Int(obj2);
         if (a == b) {
           return 0;
         }
         return a > b ? 1 : -1;
       }
     });
     ShoppingStore store = this.storeService.getObjById(Long.valueOf(Long.parseLong(id)));
     for (int i = 0; i < ints.length - 1; i++) {
       if ((ints[i].intValue() > store.getStoreCredit()) ||(ints[(i + 1)].intValue() < store.getStoreCredit())) {
         continue;
       }
       credit = i + 1;
       break;
     }

     if (store.getStoreCredit() >= ints[(ints.length - 1)].intValue()) {
       credit = ints.length;
     }
     return credit;
   }

   public int generic_user_credit(Long id) {
     int credit = 0;
     String user_credit = this.configService.getSysConfig().getUserCreditrule();
     Map map = new Gson().fromJson(user_credit,HashMap.class);
     List<Double> list = new ArrayList();
     for (Iterator it = map.keySet().iterator(); it.hasNext(); ) {
       String key = (String)it.next();
       list.add(new BigDecimal(map.get(key).toString()).doubleValue());
     }
     Double[] ints =list.toArray(new Double[list.size()]);
     Arrays.sort(ints, new Comparator(){
       @Override
       public int compare(Object obj1, Object obj2)
       {
         int a = CommUtil.null2Int(obj1);
         int b = CommUtil.null2Int(obj2);
         if (a == b) {
           return 0;
         }
         return a > b ? 1 : -1;
       }
     });
     ShoppingUser user = this.userService.getObjById(id);
     for (int i = 0; i < ints.length - 1; i++) {
       if ((ints[i].intValue() > user.getUserCredit()) ||
         (ints[(i + 1)].intValue() < user.getUserCredit())) {
         continue;
       }
       credit = i + 1;
       break;
     }

     if (user.getUserCredit() >= ints[(ints.length - 1)].intValue()) {
       credit = ints.length;
     }
     return credit;
   }

   public List<ShoppingStoreWithBLOBs> query_recommend_store(int count){
     Map params = new HashMap();
     params.put("store_recommend", Boolean.valueOf(true));
     params.put("orderBy","store_recommend_time");
     params.put("sort","desc");
     params.put("start",0);
     params.put("pageSize",count);
     return this.storeService.queryByCondition(params);
   }

   public List<ShoppingGoodsWithBLOBs> query_recommend_store_goods(ShoppingStoreWithBLOBs store, int begin, int max){
     Map params = new HashMap();
     params.put("recommend", Boolean.valueOf(true));
     params.put("store_id", store.getId());
     params.put("goods_status", Integer.valueOf(0));
     if(begin > -1){
       params.put("start",begin);
     }
     if(max >0){
       params.put("pageSize",max);
     }

     List<ShoppingGoodsWithBLOBs> goods = this.goodsService.queryByCondition(params);
     if (goods.size() < 5) {
       int count = 5 - goods.size();
       for (int i = 0; i < count; i++) {
         goods.add(null);
       }
     }
     return goods;
   }

   public int query_evaluate(String store_id, int evaluate_val, String type, String date_symbol, int date_count){
     Calendar cal = Calendar.getInstance();
     if (type.equals("date")) {
       cal.add(6, date_count);
     }
     if (type.equals("week")) {
       cal.add(3, date_count);
     }
     if (type.equals("month")) {
       cal.add(2, date_count);
     }
     String symbol = "&gt;=";
     if (date_symbol.equals("before")) {
       symbol = "&lt;=";
     }
     Map params = new HashMap();
     params.put("store_id", CommUtil.null2Long(store_id));
     params.put("addTime", symbol +" " + cal.getTime());
     params.put("evaluate_buyer_val", Integer.valueOf(CommUtil.null2Int(Integer.valueOf(evaluate_val))));
     List evas = this.evaluateService.queryByCondition(params);
     return evas.size();
   }

   public Map query_point(ShoppingStoreWithBLOBs store){
     Map map = new HashMap();
     double description_result = 0.0D;
     double service_result = 0.0D;
     double ship_result = 0.0D;
     if (store.getScId() != null) {
       ShoppingStoreclass sc = this.storeClassService.getObjById(store.getScId());
       float description_evaluate = CommUtil.null2Float(sc.getDescriptionEvaluate());
       float service_evaluate = CommUtil.null2Float(sc.getServiceEvaluate());
       float ship_evaluate = CommUtil.null2Float(sc.getShipEvaluate());
       if (store.getPoint() != null) {
         float store_description_evaluate = CommUtil.null2Float(store.getPoint().getDescriptionEvaluate());
         float store_service_evaluate = CommUtil.null2Float(store.getPoint().getServiceEvaluate());
         float store_ship_evaluate = CommUtil.null2Float(store.getPoint().getShipEvaluate());
         description_result = CommUtil.div(Float.valueOf(store_description_evaluate -
           description_evaluate), Float.valueOf(description_evaluate));
         service_result = CommUtil.div(Float.valueOf(store_service_evaluate -
           service_evaluate), Float.valueOf(service_evaluate));
         ship_result = CommUtil.div(Float.valueOf(store_ship_evaluate - ship_evaluate),
           Float.valueOf(ship_evaluate));
       }
     }
     if (description_result > 0.0D) {
       map.put("description_css", "better");
       map.put("description_type", "高于");
       map.put("description_result",
         CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(description_result), Integer.valueOf(100)))) +
         "%");
     }
     if (description_result == 0.0D) {
       map.put("description_css", "better");
       map.put("description_type", "持平");
       map.put("description_result", "-----");
     }
     if (description_result < 0.0D) {
       map.put("description_css", "lower");
       map.put("description_type", "低于");
       map.put("description_result",
         CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(-description_result), Integer.valueOf(100)))) +
         "%");
     }
     if (service_result > 0.0D) {
       map.put("service_css", "better");
       map.put("service_type", "高于");
       map.put("service_result",
         CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(service_result), Integer.valueOf(100)))) +
         "%");
     }
     if (service_result == 0.0D) {
       map.put("service_css", "better");
       map.put("service_type", "持平");
       map.put("service_result", "-----");
     }
     if (service_result < 0.0D) {
       map.put("service_css", "lower");
       map.put("service_type", "低于");
       map.put("service_result",
         CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(-service_result), Integer.valueOf(100)))) +
         "%");
     }
     if (ship_result > 0.0D) {
       map.put("ship_css", "better");
       map.put("ship_type", "高于");
       map.put("ship_result",
         CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(ship_result), Integer.valueOf(100)))) + "%");
     }
     if (ship_result == 0.0D) {
       map.put("ship_css", "better");
       map.put("ship_type", "持平");
       map.put("ship_result", "-----");
     }
     if (ship_result < 0.0D) {
       map.put("ship_css", "lower");
       map.put("ship_type", "低于");
       map.put("ship_result",
         CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(-ship_result), Integer.valueOf(100)))) + "%");
     }
     return map;
   }

   public void addGrade(ShoppingStoreWithBLOBs store) {
        if(store != null && store.getGradeId() != null){
          store.setGrade(storeGradeService.getObjById(store.getGradeId()));
        }
     }

   public void addStoreGoods(ShoppingStoreWithBLOBs store) {
     if(store != null){
       Map<String,Object> para = new HashMap<String,Object>();
       para.put("goods_store_id",store.getId());
       para.put("goods_status",0);
       List<ShoppingGoodsWithBLOBs> goods = goodsService.queryByCondition(para);
       store.setGoods_list(goods);
     }
   }

   public ShoppingStorecart addStore(ShoppingStorecart s) {
     if(s != null && s.getStoreId() != null){
       ShoppingStoreWithBLOBs st=  shoppingStoreMapper.queryById(s.getStoreId());
       s.setStore(st);
     }
     return s;
   }

   public List<ShoppingStorecart> addStores(List<ShoppingStorecart> cart){
     if(cart.size() >0){
      List<ShoppingStorecart> carts=new ArrayList<ShoppingStorecart>();
       for(ShoppingStorecart s: cart){
         ShoppingStorecart st=addStore(s);
         carts.add(st);
       }
       return carts;
     }else{
       return cart;
     }
   }

   public void addSlider(ShoppingStoreWithBLOBs store) {
     if(store != null ){
         Map<String,Object> params = new HashMap<>();
         params.put("store_id",store.getId());
         List<ShoppingStoreSlide>  slides = storeSlideService.queryByCondition(params);
         if(slides != null){
           for(ShoppingStoreSlide s: slides){
             accessoryViewTools.addStoreSliderImg(s);
           }
         }
         store.setSlides(slides);
     }
   }

     public void addOrderStores(List<ShoppingOrderformWithBLOBs> pList, boolean isAddUser) {
        if(pList != null){
          for(ShoppingOrderformWithBLOBs order: pList){
            if(order != null && order.getStoreId() != null){
              ShoppingStoreWithBLOBs st= storeService.getObjById(order.getStoreId());
              if(isAddUser){
                addUser(st);
              }
              order.setStore(st);
            }
          }
        }
     }

   public void addOrderStore(ShoppingOrderformWithBLOBs order, boolean isAddUser) {
     if(order != null){
         if(order != null && order.getStoreId() != null){
           ShoppingStoreWithBLOBs st= storeService.getObjById(order.getStoreId());
           if(isAddUser){
             addUser(st);
             areaViewTools.addStoreArea(st);
           }
           order.setStore(st);
         }
     }
   }

   public void addDynamicStores(List<ShoppingDynamic> pList) {
     if(pList != null){
       for(ShoppingDynamic s: pList){
         addDynamicStore(s);
       }
     }
   }

   public void addDynamicStore(ShoppingDynamic s) {
     if(s != null && s.getStoreId() != null){
        ShoppingStoreWithBLOBs store= storeService.getObjById(s.getStoreId());
        accessoryViewTools.addStoreLogo(store);
        s.setStore(store);
     }
   }


   public void addGoodsStore(ShoppingGoodsWithBLOBs goods) {
     if(goods != null && goods.getGoodsStoreId() != null){
       ShoppingStoreWithBLOBs store= storeService.getObjById(goods.getGoodsStoreId());
       addUser(store);
        goods.setGoods_store(store);
     }
   }


   public void addStoreGoodss(List<ShoppingGoodsWithBLOBs> pList) {
     if(pList.size()>0){
       for (ShoppingGoodsWithBLOBs goods : pList) {
         addGoodsStore(goods);
       }
     }
   }

   public void addStoreGoodslist(List<ShoppingStoreWithBLOBs> pList) {
     if (pList.size()>0){
       for (ShoppingStoreWithBLOBs store : pList) {
         addStoreGoods(store);
       }
     }
   }

   public void addPoints(List<ShoppingStoreWithBLOBs> pList) {
     if (pList.size()>0){
       for (ShoppingStoreWithBLOBs store : pList) {
         addPoint(store);
       }
     }
   }

   public void addStoreclassChilds(List<ShoppingStoreclass> scs) {
     if(scs != null){
       for(ShoppingStoreclass s: scs){
         addStoreclassChild(s);
       }
     }
   }

   public final void  addStoreclassChild(ShoppingStoreclass s){
     if(s != null){
       Map<String,Object> params = new HashMap<>();
       params.put("parent_id","=".concat(s.getId().toString()));
       List<ShoppingStoreclass> childs = storeClassService.queryByCondition(params);
       s.setChilds(childs);
     }
   }

   public void addRecommendGoods(List<ShoppingStoreWithBLOBs> pList) {
     if(pList != null){
        for(ShoppingStoreWithBLOBs s: pList){
          List<ShoppingGoodsWithBLOBs> goods =storeViewTools.query_recommend_store_goods(s,0,10);
          if(goods != null){
            for(ShoppingGoodsWithBLOBs i: goods ){
              accessoryViewTools.addMainPhoto(i);
            }
          }
          s.setRecommend_goods(goods);
        }
     }
   }

     public void addGoodsStores(List<ShoppingGoodsWithBLOBs> store_reommend_goods_list) {
        if(store_reommend_goods_list != null){
          for(ShoppingGoodsWithBLOBs g: store_reommend_goods_list){
             addGoodsStore(g);
          }
        }
     }
 }





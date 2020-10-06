 package com.xdj.interfaces.mallinterface.controller.view;



 import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
 import com.xdj.interfaces.mallinterface.service.*;
 import com.xdj.www.core.tools.CommUtil;
 import com.xdj.www.entity.*;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.stereotype.Component;

 import javax.annotation.Resource;
 import javax.servlet.http.HttpServletRequest;
 import java.util.*;

 /**
  * @author Administrator
  */
 @Component
 public class GoodsViewTools {
   @Resource
   private HttpServletRequest request;
   @Resource
   private IGoodsService goodsService;
   @Resource
   private IGoodsClassService goodsClassService;
   @Resource
   private IStoreService storeService;
   @Resource
   private IUserGoodsClassService userGoodsClassService;
   @Resource
   private IGroupService groupService;
   @Resource
   private  ITransportService transportService;
   @Resource
   private  IDeliveryGoodsService deliveryGoodsService;
   @Resource
   private IGoodsSpecificationService goodsSpecificationService;
   @Resource
   private IGoodsSpecPropertyService goodsSpecPropertyService;
   @Resource
   private IGoodsTypeService goodsTypeService;
   @Resource
   private IGoodsTypePropertyService goodsTypePropertyService;
   @Resource
   private GoodsTypeSpcificationService goodsTypeSpcificationService;
   @Resource
   private IEvaluateService evaluateService;
   @Resource
   private GoodsTypeBrandService goodsTypeBrandService;
   @Resource
   private StoreViewTools storeViewTools;
   @Resource
   private IGroupGoodsService groupGoodsService;

   @Resource
   private AccessoryViewTools accessViewTools;


   private Logger log = LoggerFactory.getLogger("goodstools");

   /**
    * 规格添加
    * @param goods
    */
   public final void addSpecis(ShoppingGoodsWithBLOBs goods){
     if(goods != null && goods.getGoods_specs() != null ){
        for(ShoppingGoodsspecproperty s: goods.getGoods_specs()){
           s.setSpec(goodsSpecificationService.getObjById(s.getSpecId()));
        }
     }
   }

   public final  void addGoodsSpecis(ShoppingGoodsWithBLOBs goods){
     if(goods != null && goods.getGoods_specs() != null ){
       List<ShoppingGoodsspecification> specis = new ArrayList<ShoppingGoodsspecification>();
       Map  para = new HashMap();
       for(ShoppingGoodsspecproperty s: goods.getGoods_specs()){
          ShoppingGoodsspecification spec= goodsSpecificationService.getObjById(s.getSpecId());
           if(!para.containsKey(spec.getId())){
             specis.add(spec);
             para.put(spec.getId(),spec.getId());
           }
       }
       goods.setSpecification(specis);
     }
   }

   public final void addSpec(ShoppingGoodsWithBLOBs goods){
     if(goods != null ){
       Map<String,Object> para = new HashMap<String,Object>();
       para.put("goods_id",goods.getId());
       List<ShoppingGoodsspecproperty>  specs=goodsSpecPropertyService.queryByConditoin(para);
       if(specs != null){
         for( ShoppingGoodsspecproperty s: specs){
              s.setSpec(goodsSpecificationService.getObjById(s.getSpecId()));
         }
       }
       goods.setGoods_specs(specs);

     }
   }

   public final void addDeliveryGoods(ShoppingGoodsWithBLOBs goods){
     if(goods != null ){
        ShoppingDeliveryGoods dg = deliveryGoodsService.queryByGoodsId(goods.getId());
        if(dg != null){
          if(dg.getdDeliveryGoodsId() != null){
            ShoppingGoodsWithBLOBs g = goodsService.getObjById(dg.getdDeliveryGoodsId());
            accessViewTools.addMainPhoto(g);
            dg.setD_delivery_goods(g);
          }
          goods.setDg(dg);
        }

     }
   }

   public final void addTransport(ShoppingGoodsWithBLOBs goods){
     if(goods != null && goods.getTransportId() != null){
       ShoppingTransportWithBLOBs transport = transportService.getObjById(goods.getTransportId());
       goods.setTransport(transport);
     }
   }

   /**
    * 团购商品添加图片
    */
   public  final List<ShoppingGroupGoods> addGgImg(List<ShoppingGroupGoods> goodsList){
     List<ShoppingGroupGoods> list=new ArrayList<>();
     if(goodsList.size()>0){
       for (ShoppingGroupGoods groupGoods : goodsList) {
         accessViewTools.addGroupImg(groupGoods);
         list.add(groupGoods);
       }
     }
     return list;
   }
   /**
    * 推荐商品添加图片
    */
   public  final List<ShoppingGoodsWithBLOBs> addRecommendImg(List<ShoppingGoodsWithBLOBs> goodslist){
     List<ShoppingGoodsWithBLOBs> list=new ArrayList<>();
     if(goodslist!=null&&goodslist.size()>0){
       for (ShoppingGoodsWithBLOBs good : goodslist) {
         accessViewTools.addMainPhoto(good);
       }
     }
     return list;
   }

   /**
    * 添加店铺信息
    * @param goods
    */
   public final void setStore (ShoppingGoodsWithBLOBs goods){
     if(goods != null && goods.getGoodsStoreId() != null){
        ShoppingStoreWithBLOBs st= storeService.getObjById(goods.getGoodsStoreId());
        storeViewTools.addGrade(st);
        goods.setGoods_store(st);
     }
   }

   /**
    * 添加店铺信息
    * @param goods
    */
   public final void setStores (List<ShoppingGoodsWithBLOBs> goods){
     if(goods != null){
       for(ShoppingGoodsWithBLOBs g: goods){
         setStore(g);
       }
     }
   }

   /**
    * 添加团购信息
    * @param goods
    */
   public final void setGroup (ShoppingGoodsWithBLOBs goods){
     if(goods != null && goods.getGroupId() != null){
       goods.setGroup(groupService.getObjById(goods.getGroupId()));
     }
   }
   @SuppressWarnings("unchecked")


   public List<ShoppingGoodsspecification> generic_spec(Long id)
   {
     List<ShoppingGoodsspecification> specs = new ArrayList();
     if ((id != null) && (!id.equals(""))) {
       ShoppingGoodsWithBLOBs goods = this.goodsService.getObjById(id);
       for (ShoppingGoodsspecproperty gsp : goods.getGoods_specs()) {
         ShoppingGoodsspecification spec = gsp.getSpec();
         if (!specs.contains(spec)) {
           specs.add(spec);
         }
       }
     }
     Collections.sort(specs, new Comparator(){
       public int compare(Object gs1, Object gs2)
       {
         return (((ShoppingGoodsspecification)gs1).getSequence()) - (((ShoppingGoodsspecification)gs2).getSequence());
       }
     });
     return specs;
   }

   public List<ShoppingUsergoodsclass> query_user_class(String pid){
     List list = new ArrayList();
     if ((pid == null) || (pid.equals(""))) {
       Map map = new HashMap();
       map.put("uid", SecurityUserHolder.getCurrentUser().getId());
       map.put("sort","asc");
       map.put("orderBy","sequence");
       map.put("parent_id","is null");
       list = this.userGoodsClassService.queryByCondition(map);
               //query("select obj from UserGoodsClass obj where obj.parent.id is null and obj.user.id = :uid order by obj.sequence asc",
         //map, -1, -1);
     } else {
       Map params = new HashMap();
       params.put("pid", Long.valueOf(Long.parseLong(pid)));
       params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
       params.put("parent_id","=".concat(pid));
       params.put("sort","asc");
       params.put("orderBy","sequence");

       list = this.userGoodsClassService.queryByCondition(params);
               //query("select obj from UserGoodsClass obj where obj.parent.id=:pid and obj.user.id = :uid order by obj.sequence asc",params, -1, -1);
     }
     return list;
   }

   public List<ShoppingGoodsWithBLOBs> query_with_gc(String gc_id, int count){
     List<ShoppingGoodsWithBLOBs> list = new ArrayList();
     ShoppingGoodsclassWithBLOBs gc = this.goodsClassService.getObjById(CommUtil.null2Long(gc_id));
     if (gc != null) {
       Set ids = genericIds(gc);
       Map params = new HashMap();
       params.put("ids", ids);
       params.put("goods_status", Integer.valueOf(0));
       params.put("sort","desc");
       params.put("orderBy","goods_click");
       params.put("pageSize",count);
       params.put("start",0);
       list = this.goodsService.queryByCondition(params);
        // .query("select obj from Goods obj where obj.gc.id in (:ids) and obj.goods_status=:goods_status order by obj.goods_click desc",
        // params, 0, count);
     }
     return list;
   }

   private Set<Long> genericIds(ShoppingGoodsclassWithBLOBs gc) {
     Set ids = new HashSet();
     ids.add(gc.getId());
     for (ShoppingGoodsclassWithBLOBs child : gc.getChilds()) {
       Set<Long> cids = genericIds(child);
       for (Long cid : cids) {
         ids.add(cid);
       }
       ids.add(child.getId());
     }
     return ids;
   }

   public List<ShoppingGoodsWithBLOBs> sort_sale_goods(String store_id, int count) {
     List list = new ArrayList();
     Map params = new HashMap();
     params.put("store_id", CommUtil.null2Long(store_id));
     params.put("goods_status", Integer.valueOf(0));
     params.put("sort","desc");
     params.put("orderBy","goods_salenum");
     params.put("pageSize",count);
     params.put("start",0);
     list = this.goodsService.queryByCondition(params);
       //.query("select obj from Goods obj where obj.goods_store.id=:store_id and obj.goods_status=:goods_status order by obj.goods_salenum desc",
       //params, 0, count);
     return list;
   }

   public List<ShoppingGoodsWithBLOBs> sort_collect_goods(String store_id, int count) {
     List list = new ArrayList();
     Map params = new HashMap();
     params.put("goods_store_id", CommUtil.null2Long(store_id));
     params.put("goods_status", Integer.valueOf(0));
     params.put("sort","desc");
     params.put("orderBy","goods_collect");
     list = this.goodsService.queryByCondition(params);
       //.query("select obj from Goods obj where obj.goods_store.id=:store_id and obj.goods_status=:goods_status order by obj.goods_collect desc",
       //params, 0, count);
     return list;
   }

   public List<ShoppingGoodsWithBLOBs> query_combin_goods(String id) {
     return this.goodsService.getObjById(CommUtil.null2Long(id)).getCombin_goods();
   }

   /**
    * 添加商品分类子分类
    * @param gc
    */
   public final void  addChilds(ShoppingGoodsclassWithBLOBs gc){
      if(gc != null){
         Map<String,Object> params = new HashMap<String,Object>();
         params.put("parent_id","= ".concat(gc.getId().toString()));
         List<ShoppingGoodsclassWithBLOBs> childs = goodsClassService.queryByCondition(params);

         gc.setChilds(childs);
      }
   }

   /**
    * 添加父分类
    * @param gc
    */
   public final void addParent(ShoppingGoodsclassWithBLOBs gc){
     if(gc != null){
       if(gc.getParentId() != null){
         ShoppingGoodsclassWithBLOBs parent = goodsClassService.getObjById(gc.getParentId());
         gc.setParent(parent);
       }
     }
   }

   /**
    * 添加商品分类类型
    * @param gc
    */
   public final void addGoodsClassType(ShoppingGoodsclassWithBLOBs gc){
      if(gc != null){
         if(gc.getGoodstypeId() != null){
              ShoppingGoodstype  type= goodsTypeService.getObjById(gc.getGoodstypeId());
              addTypeSpecification(type);
              addTypeProperties(type);
              addGbs(type);
              gc.setGoodsType(type);
         }
      }
   }

   /**
    * 添加商品类型属性
    * @param type
    */
   public final void addTypeProperties (ShoppingGoodstype type){
      if(type != null){
        Map<String,Object>  para = new HashMap<String,Object>();
        para.put("goodsType_id",type.getId());
        List<ShoppingGoodstypeproperty> properties = goodsTypePropertyService.queryByCondition(para);
        if(properties != null){
          for(ShoppingGoodstypeproperty s: properties){
            if(s.getValue() != null){
                List values= Arrays.asList(s.getValue().split(","));
                s.setValues(values);
            }
          }
        }
        type.setProperties(properties);
      }
   }

   /**
    * 商品类型特征
    * @param type
    */
   public final void addTypeSpecification (ShoppingGoodstype type){
     if(type != null){
       Map<String,Object>  para = new HashMap<String,Object>();
       para.put("type_id",type.getId());
       List<ShoppingGoodsspecification> specifications = goodsTypeSpcificationService.queryByCondition(para);
       if(specifications != null){
          for(ShoppingGoodsspecification s: specifications){
            addProperties(s);
          }
       }
       type.setGss(specifications);
     }
   }

   /**
    *
    * @param type
    */
   public final void addGbs (ShoppingGoodstype type){
     if(type != null){
       Map<String,Object>  para = new HashMap<String,Object>();
       para.put("type_id",type.getId());
       List<ShoppingGoodsbrand> brands = goodsTypeBrandService.queryByCondition(para);
       type.setGbs(brands);
     }
   }

   public final void addProperties (ShoppingGoodsspecification spec){
     if(spec != null){
       Map<String,Object> para = new HashMap<String,Object>();
       para.put("spec_id",spec.getId());
       List<ShoppingGoodstypeproperty> properties  = goodsTypePropertyService.queryByCondition(para);
       spec.setProperties(properties);
     }
   }


   public final void addStoreGrade(List<ShoppingGoodsWithBLOBs> goods){
     if(goods != null){
       for(ShoppingGoodsWithBLOBs s: goods){
         if(s.getGoods_store() != null){
             storeViewTools.addGrade(s.getGoods_store());
         }else if(s.getGoodsStoreId() != null){
             ShoppingStoreWithBLOBs store= storeService.getObjById(s.getGoodsStoreId());
             storeViewTools.addGrade(store);
         }
       }
     }
   }

   public final void  addEvalutes(List<ShoppingGoodsWithBLOBs> goods){
     if(goods != null){
       for(ShoppingGoodsWithBLOBs g: goods){
         addEvalute(g);
       }
     }
   }

   public final void addEvalute(ShoppingGoodsWithBLOBs goods){
     if(goods != null){
       Map<String,Object>  paras  = new HashMap<String,Object>();
       paras.put("evaluate_goods_id",goods.getId());
       List<ShoppingEvaluateWithBLOBs> eval = evaluateService.queryByCondition(paras);
       goods.setEvaluates(eval);
     }
   }

   public void addGroup(ShoppingGoodsWithBLOBs goods) {
     if(goods != null){
       goods.setGroup(groupService.getObjById(goods.getGroupId()));
     }
   }

   public void addgroupGoodsList(ShoppingGoodsWithBLOBs goods) {
      if(goods != null){
        if(goods.getGroupId() != null){
          Map<String,Object> params = new HashMap<String,Object>();
          params.put("group_id",goods.getGroupId());
          List<ShoppingGroupGoods> groupGoods = groupGoodsService.queryByCondition(params);
          goods.setGroup_goods_list(groupGoods);
        }
      }
   }

   public void addActvityGoods(List<ShoppingActivityGoods> pList) {
     if(pList != null){
       for(ShoppingActivityGoods s: pList){
         if(s.getAgGoodsId() != null){
           ShoppingGoodsWithBLOBs goods = goodsService.getObjById(s.getAgGoodsId());
           if(goods != null && goods.getGoodsMainPhotoId() != null){
             accessViewTools.addMainPhoto(goods);
           }
            s.setAg_goods(goods);
         }
       }
     }
   }

   public void addBargainGoods(ShoppingBargainGoods s) {
     if(s != null && s.getBgGoodsId() != null){
       ShoppingGoodsWithBLOBs goods = goodsService.getObjById(s.getBgGoodsId());
       if(goods != null && goods.getGoodsMainPhotoId() != null) {
         accessViewTools.addMainPhoto(goods);
       }
       s.setBg_goods(goods);
     }
   }

   public void addBargainGoods(List<ShoppingBargainGoods> pList) {
     if(pList != null){
       for(ShoppingBargainGoods s: pList){
          addBargainGoods(s);
       }
     }
   }

   public void addDeliveryGoodsMsg(List<ShoppingDeliveryGoods> pList) {
     if(pList != null){
       for(ShoppingDeliveryGoods s: pList){
         addDeliGoods(s);
       }
     }
   }

   public void addDeliGoods(ShoppingDeliveryGoods s){
     if(s !=null && s.getdGoodsId() != null){
       ShoppingGoodsWithBLOBs goods = goodsService.getObjById(s.getdGoodsId());
       if(goods != null){
         accessViewTools.addMainPhoto(goods);
       }
       s.setD_goods(goods);
     }
   }

   public void addDeliveryGoods1(List<ShoppingDeliveryGoods> pList) {
     if(pList != null){
       for(ShoppingDeliveryGoods s: pList){
         addDeliGoods1(s);
       }
     }
   }

   public void addDeliGoods1(ShoppingDeliveryGoods s){
     if(s !=null && s.getdDeliveryGoodsId() != null){
       ShoppingGoodsWithBLOBs goods = goodsService.getObjById(s.getdDeliveryGoodsId());
       if(goods != null){
         accessViewTools.addMainPhoto(goods);
       }
       s.setD_delivery_goods(goods);
     }
   }

   public void addGoods(ShoppingSecondsKill s) {
     if(s != null){
        boolean flag =true;
       if(s.getSgImgId() != null){
         accessViewTools.addSeckillPhoto(s);
         flag =false;
       }
       addSkGoods(s,flag);

     }
   }

   private void addSkGoods(ShoppingSecondsKill s,boolean confirm) {
     if(s != null && s.getSgGoodsId() != null){
       ShoppingGoodsWithBLOBs goods=goodsService.getObjById(s.getSgGoodsId());
       if(confirm){
         accessViewTools.addMainPhoto(goods);
       }
       s.setGoods(goods);
     }
   }


   public void addggGoods(List<ShoppingGroupGoods> pList) {
     if(pList!=null&&pList.size()>0){
       for (ShoppingGroupGoods groupGoods : pList) {
         ShoppingGoodsWithBLOBs goods =goodsService.getObjById(groupGoods.getGgGoodsId()) ;
         accessViewTools.addMainPhoto(goods);
         storeViewTools.addGoodsStore(goods);
         groupGoods.setGg_goods(goods);

       }
     }
   }

   public List<ShoppingGroupGoods> query_goods(String group_id)
   {
     List list = new ArrayList();
     Map params = new HashMap();
     params.put("group_id", CommUtil.null2Long(group_id));
     params.put("orderBy","addTime");
     params.put("sort","desc");
     params.put("start",Integer.valueOf(0));
     params.put("pageSize",Integer.valueOf(6));
     list = this.groupGoodsService.queryByCondition(params);
             //.query("select obj from GroupGoods obj where obj.group.id=:group_id order by obj.addTime desc", params, 0, count);
     return list;
   }

   public void addDynamicGoods(List<ShoppingDynamic> pList) {
     if(pList != null){
       for(ShoppingDynamic s: pList){
         addDynamicGood(s);
       }
     }
   }

   public void addDynamicGood(ShoppingDynamic dynamic) {
     if(dynamic != null && dynamic.getGoodsId() != null){
        ShoppingGoodsWithBLOBs goods= goodsService.getObjById(dynamic.getGoodsId());
        storeViewTools.addGoodsStore(goods);
        dynamic.setGoods(goods);
     }
   }

   public  void addFavoriteGoods(List<ShoppingFavorite> pList){
     if(pList != null){
       for(ShoppingFavorite f: pList){
         addFavoriteGood(f);
       }
     }
   }

   private void addFavoriteGood(ShoppingFavorite f) {
     if(f != null && f. getGoodsId() != null){
       ShoppingGoodsWithBLOBs goods= goodsService.getObjById(f.getGoodsId());
       storeViewTools.addGoodsStore(goods);
       accessViewTools.addMainPhoto(goods);
       f.setGoods(goods);
     }
     if(f != null && f.getStoreId() != null){
       ShoppingStoreWithBLOBs store= storeService.getObjById(f.getStoreId());
       storeViewTools.addUser(store);
       storeViewTools.addArea(store);
       f.setStore(store);
     }
   }


   public final  void addGoodsCartGoods(List<ShoppingGoodscart> pList) {
     if(pList != null){
       for(ShoppingGoodscart s: pList){
         addGoodsCartGood(s);
       }
     }
   }

   public final  void addGoodsCartGood(ShoppingGoodscart s) {
     if(s != null && s.getGoodsId() != null){
       s.setGoods(goodsService.getObjById(s.getGoodsId()));
     }
   }

   //店铺评价中添加评价的商品信息
     public void addEvaluteGoods(List<ShoppingEvaluateWithBLOBs> evas) {
     if(evas.size()>0){
       for (ShoppingEvaluateWithBLOBs eva : evas) {
         addEvaluteGood(eva);
       }
     }
     }

   private void addEvaluteGood(ShoppingEvaluateWithBLOBs eva) {
     if(eva!=null&&eva.getEvaluateGoodsId()!=null){
       eva.setEvaluate_goods(goodsService.getObjById(eva.getEvaluateGoodsId()));
     }
   }


   public void addAllChilds(ShoppingGoodsclassWithBLOBs gc) {
     if(gc != null){
       Map<String,Object> params = new HashMap<String,Object>();
       params.put("parent_id","= ".concat(gc.getId().toString()));
       List<ShoppingGoodsclassWithBLOBs> list= new ArrayList<>();
       List<ShoppingGoodsclassWithBLOBs> childs = goodsClassService.queryByCondition(params);
       if(childs != null && !childs.isEmpty()){
         for(ShoppingGoodsclassWithBLOBs c: childs){
           params.clear();
           params.put("parent_id","= ".concat(c.getId().toString()));
           List<ShoppingGoodsclassWithBLOBs> grandson = goodsClassService.queryByCondition(params);
           if(grandson != null && !grandson.isEmpty()){
             list.addAll(grandson);
           }
         }
       }
       childs.addAll(list);
       gc.setChilds(childs);
     }
   }
 }





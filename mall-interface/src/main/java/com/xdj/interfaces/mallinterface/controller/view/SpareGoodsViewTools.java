 package com.xdj.interfaces.mallinterface.controller.view;


 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;

 import com.xdj.interfaces.mallinterface.service.IAccessoryService;
 import com.xdj.interfaces.mallinterface.service.ISpareGoodsClassService;;
 import com.xdj.interfaces.mallinterface.service.ISpareGoodsService;
 import com.xdj.www.entity.*;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;

 import javax.annotation.Resource;

 @Component
 public class SpareGoodsViewTools
 {

   @Autowired
   private ISpareGoodsClassService sparegoodsclassService;
     @Resource
     private ISpareGoodsService spareGoodsService;
     @Resource
     private IAccessoryService accessoryService;

   public List<ShoppingSpareGoodsclass> query_childclass(ShoppingSpareGoodsclass sgc)
   {
     List list = new ArrayList();
     for (ShoppingSpareGoodsclass child : queryChilds(sgc)) {
       list.add(child);
       for (ShoppingSpareGoodsclass c : queryChilds(child)) {
         list.add(c);
       }
     }
     return list;
   }

   public  List<ShoppingSpareGoodsclass> queryChilds(ShoppingSpareGoodsclass sgc){
       Map params = new HashMap();
       params.put("parent_id", "=".concat(sgc.getId()+""));
       params.put("orderBy","sequence");
       params.put("sort","asc");
       return sparegoodsclassService.queryByCondition(params);
   }

   //查询空闲商品的父类型
     public final void addGrandpa(ShoppingSpareGoodsclass sgc){

         if(sgc != null && sgc.getParentId() != null){
             ShoppingSpareGoodsclass parent= addParents(sgc);
             if(parent.getParentId() != null){
                 parent.setParent(addParents(parent));
             }
             sgc.setParent(parent);
         }
     }

     public final ShoppingSpareGoodsclass addParents(ShoppingSpareGoodsclass sgc){
         if(sgc != null && sgc.getParentId() != null){
             return   sparegoodsclassService.getObjById( sgc.getParentId());
         }
         return null;
     }



     public List<ShoppingSpareGoodsclass> query_floorClass(ShoppingSpareGoodsfloor sgf)
   {
       ShoppingSpareGoodsclass spareGoodsclass = sparegoodsclassService.getObjById(sgf.getSgcId());
     List list = new ArrayList();
     for (ShoppingSpareGoodsclass child : queryChilds(spareGoodsclass)) {
       if (child.getViewinfloor()) {
         list.add(child);
       }
       for (ShoppingSpareGoodsclass c : queryChilds(child)) {
         if (c.getViewinfloor()) {
           list.add(c);
         }
       }
     }

     return list;
   }

     public List<ShoppingSpareGoodsWithBLOBs> querySgs(ShoppingSpareGoodsfloor sgf){
         Map params = new HashMap();
         params.put("sgf_id",sgf.getId() );
         List<ShoppingSpareGoodsWithBLOBs> sgs=spareGoodsService.queryByCondition(params);
         for (ShoppingSpareGoodsWithBLOBs sg : sgs) {
            sg.setMain_img(accessoryService.getObjById(sg.getMainImgId()));
         }
         return sgs;
     }

   public String ClearContent(String inputString)
   {
     String htmlStr = inputString;
     String textStr = "";
     try
     {
       String regEx_script = "<[//s]*?script[^>]*?>[//s//S]*?<[//s]*?///[//s]*?script[//s]*?>";
       String regEx_style = "<[//s]*?style[^>]*?>[//s//S]*?<[//s]*?///[//s]*?style[//s]*?>";
       String regEx_html = "<[^>]+>";
       String regEx_html1 = "<[^>]+";
       Pattern p_script = Pattern.compile(regEx_script, 2);
       Matcher m_script = p_script.matcher(htmlStr);
       htmlStr = m_script.replaceAll("");

       Pattern p_style = Pattern.compile(regEx_style, 2);
       Matcher m_style = p_style.matcher(htmlStr);
       htmlStr = m_style.replaceAll("");

       Pattern p_html = Pattern.compile(regEx_html, 2);
       Matcher m_html = p_html.matcher(htmlStr);
       htmlStr = m_html.replaceAll("");

       Pattern p_html1 = Pattern.compile(regEx_html1, 2);
       Matcher m_html1 = p_html1.matcher(htmlStr);
       htmlStr = m_html1.replaceAll("");

       textStr = htmlStr;
     } catch (Exception e) {
       System.err.println("Html2Text: " + e.getMessage());
     }
     return textStr;
   }

     public ShoppingAccessory queryMainImg(ShoppingSpareGoodsWithBLOBs spareGoods) {
       if(spareGoods.getMainImgId()!=null){
           return accessoryService.getObjById(spareGoods.getMainImgId());
       }
      return null;
     }
 }





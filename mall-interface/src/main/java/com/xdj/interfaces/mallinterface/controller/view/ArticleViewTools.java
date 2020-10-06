 package com.xdj.interfaces.mallinterface.controller.view;


 import com.xdj.interfaces.mallinterface.service.IArticleService;
import com.xdj.www.entity.ShoppingArticle;
 import com.xdj.www.entity.ShoppingArticleclass;
 import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 /**
  * @author Administrator
  */
 @Component
 public class ArticleViewTools
 {

   @Resource
   private IArticleService articleService;

   public ShoppingArticle queryArticle(Long id, int position)
   {
     Map<String,Object> params = new HashMap<>();
     ShoppingArticle article = this.articleService.getObjById(id);
     if (article != null) {
       params.put("addTime", article.getAddtime());
       params.put("articleClass_id", article.getArticleclassId());
       params.put("display", Boolean.valueOf(true));
       params.put("flag",position);
       params.put("orderBy","addTime");
       params.put("sort","desc");
       params.put("start",0);
       params.put("pageSize",1);
       List<ShoppingArticle> objs = this.articleService.queryByCondition(params);
       if (objs.size() > 0) {
         return objs.get(0);
       }
       ShoppingArticle obj = new ShoppingArticle();
       obj.setTitle("没有了");
       return obj;
     }

     ShoppingArticle obj = new ShoppingArticle();
     obj.setTitle("没有了");
     return obj;
   }


     public List<ShoppingArticle> queryArticles(ShoppingArticleclass articleclass) {
       if (articleclass!=null){
               Map<String,Object> params = new HashMap<>();
               params.put("articleClass_id",articleclass.getId());
               params.put( "display", Boolean.valueOf( true ) );
               params.put("orderBy","addTime");
               params.put("sort","desc");
               params.put("start",0);
               params.put("pageSize",5);
               List<ShoppingArticle> list=articleService.queryByCondition(params);
               return list;
       }
         return  null;
     }

 }





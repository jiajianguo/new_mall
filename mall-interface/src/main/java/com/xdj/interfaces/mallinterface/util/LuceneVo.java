 package com.xdj.interfaces.mallinterface.util;

 /**
  * @author Administrator
  */
 public class LuceneVo {
   public static final String ID = "id";
   public static final String TITLE = "title";
   public static final String TYPE = "type";
   public static final String CONTENT = "content";
   public static final String URL = "url";
   public static final String STORE_PRICE = "store_price";
   public static final String ADD_TIME = "add_time";
   public static final String GOODS_SALENUM = "goods_salenum";
   private Long vo_id;
   private String vo_type;
   private String vo_title;
   private String vo_content;
   private String vo_url;
   private float vo_store_price;
   private long vo_add_time;
   private int vo_goods_salenum;
   private String  vo_goods_collect;
   private String  path;
   private String name;

   public String getVo_goods_collect() {
     return vo_goods_collect;
   }

   public void setVo_goods_collect(String vo_goods_collect) {
     this.vo_goods_collect = vo_goods_collect;
   }

   public String getPath() {
     return path;
   }

   public void setPath(String path) {
     this.path = path;
   }

   public String getName() {
     return name;
   }

   public void setName(String name) {
     this.name = name;
   }

   public long getVo_add_time()
   {
     return this.vo_add_time;
   }

   public void setVo_add_time(long vo_add_time) {
     this.vo_add_time = vo_add_time;
   }

   public int getVo_goods_salenum() {
     return this.vo_goods_salenum;
   }

   public void setVo_goods_salenum(int vo_goods_salenum) {
     this.vo_goods_salenum = vo_goods_salenum;
   }

   public float getVo_store_price()
   {
     return this.vo_store_price;
   }

   public void setVo_store_price(float vo_store_price) {
     this.vo_store_price = vo_store_price;
   }

   public Long getVo_id() {
     return this.vo_id;
   }

   public void setVo_id(Long vo_id) {
     this.vo_id = vo_id;
   }

   public String getVo_type() {
     return this.vo_type;
   }

   public void setVo_type(String vo_type) {
     this.vo_type = vo_type;
   }

   public String getVo_title() {
     return this.vo_title;
   }

   public void setVo_title(String vo_title) {
     this.vo_title = vo_title;
   }

   public String getVo_content() {
     return this.vo_content;
   }

   public void setVo_content(String vo_content) {
     this.vo_content = vo_content;
   }

   public String getVo_url() {
     return this.vo_url;
   }

   public void setVo_url(String vo_url) {
     this.vo_url = vo_url;
   }

   @Override
   public String toString() {
     return "LuceneVo{" +
             "vo_id=" + vo_id +
             ", vo_type='" + vo_type + '\'' +
             ", vo_title='" + vo_title + '\'' +
             ", vo_content='" + vo_content + '\'' +
             ", vo_url='" + vo_url + '\'' +
             ", vo_store_price=" + vo_store_price +
             ", vo_add_time=" + vo_add_time +
             ", vo_goods_salenum=" + vo_goods_salenum +
             ", path='" + path + '\'' +
             ", name='" + name + '\'' +
             '}';
   }
 }


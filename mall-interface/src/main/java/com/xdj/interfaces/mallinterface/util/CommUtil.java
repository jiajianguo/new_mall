 package com.xdj.interfaces.mallinterface.util;


 import com.xdj.interfaces.mallinterface.mv.PageModel;
 import com.xdj.interfaces.mallinterface.query.IPageList;
 import com.xdj.www.core.tools.StringUtils;
 import com.xdj.www.entity.*;
 import org.apache.poi.ss.formula.functions.T;
 import org.jsoup.Jsoup;
 import org.jsoup.safety.Whitelist;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.web.multipart.MultipartHttpServletRequest;
 import org.springframework.web.multipart.commons.CommonsMultipartFile;
 import org.springframework.web.servlet.ModelAndView;
 import javax.imageio.ImageIO;
 import javax.servlet.http.HttpServletRequest;
 import java.awt.*;

 import java.awt.image.BufferedImage;
 import java.io.*;
 import java.math.BigDecimal;
 import java.net.URL;
 import java.net.URLDecoder;
 import java.net.URLEncoder;
 import java.text.DecimalFormat;
 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 import java.util.List;
 import java.util.*;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;

 public class CommUtil{
   private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

   private static final Whitelist user_content_filter = Whitelist.relaxed();
   static int totalFolder;
   static int totalFile;
   static Logger log = LoggerFactory.getLogger("common");
   static{
     user_content_filter.addTags(new String[] { "embed", "object", "param", "span", "div",
       "font" });
     user_content_filter.addAttributes(":all", new String[] { "style", "class", "id",
       "name" });
     user_content_filter.addAttributes("object", new String[] { "width", "height",
       "classid", "codebase" });
     user_content_filter.addAttributes("param", new String[] { "name", "value" });
     user_content_filter.addAttributes("embed", new String[] { "src", "quality", "width",
       "height", "allowFullScreen", "allowScriptAccess", "flashvars",
       "name", "type", "pluginspage" });
     totalFolder = 0;
     totalFile = 0;
   }
   public static int getRandomInt(int size){
     int i= (int) (Math.random()*size);
     return i;
   }

   public static String first2low(String str)
   {
     String s = "";
     s = str.substring(0, 1).toLowerCase() + str.substring(1);
     return s;
   }

   public static String first2upper(String str) {
     String s = "";
     s = str.substring(0, 1).toUpperCase() + str.substring(1);
     return s;
   }

   public static List<String> str2list(String s)throws IOException
   {
     List list = new ArrayList();
     if ((s != null) && (!s.equals(""))) {
       StringReader fr = new StringReader(s);
       BufferedReader br = new BufferedReader(fr);
       String aline = "";
       while ((aline = br.readLine()) != null) {
         list.add(aline);
       }
     }
     return list;
   }

   public static Date formatDate(String s) {
     Date d = null;
     try {
       d = dateFormat.parse(s);
     } catch (Exception localException) {
     }
     return d;
   }

   public static Date formatDate(String s, String format) {
     Date d = null;
     try {
       SimpleDateFormat dFormat = new SimpleDateFormat(format);
       d = dFormat.parse(s);
     } catch (Exception localException) {
     }
     return d;
   }

   public static String formatTime(String format, Object v) {
     if (v == null) {
       return null;
     }
     if (v.equals("")) {
       return "";
     }
     SimpleDateFormat df = new SimpleDateFormat(format);
     return df.format(v);
   }

   public static String formatLongDate(Object v) {
     if ((v == null) || (v.equals(""))){
       return "";
     }

     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     return df.format(v);
   }

   public static String formatShortDate(Object v) {
     if (v == null){
       return null;
     }

     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
     return df.format(v);
   }

   public static String decode(String s) {
     String ret = s;
     try {
       ret = URLDecoder.decode(s.trim(), "UTF-8");
     } catch (Exception localException) {
     }
     return ret;
   }

   public static String encode(String s) {
     String ret = s;
     try {
       ret = URLEncoder.encode(s.trim(), "UTF-8");
     } catch (Exception localException) {
     }
     return ret;
   }

   public static String convert(String str, String coding) {
     String newStr = "";
     if (str != null){
       try {
         newStr = new String(str.getBytes("ISO-8859-1"), coding);
       } catch (Exception e) {
         return newStr;
       }
     }
     return newStr;
   }


   public static boolean isImg(String extend) {
     boolean ret = false;
     List<String> list = new ArrayList<String>();
     list.add("jpg");
     list.add("jpeg");
     list.add("bmp");
     list.add("gif");
     list.add("png");
     list.add("tif");
     for (String s : list) {
       if (s.equals(extend))
         ret = true;
     }
     return ret;
   }

   public static List copyList(List list, int begin, int end) {
     List l = new ArrayList();
     if (list == null) {
       return l;
     }
     if (end > list.size()) {
       end = list.size();
     }
     for (int i = begin; i < end; i++) {
       l.add(list.get(i));
     }
     return l;
   }



   public static void copyFile(String oldPath, String newPath)
   {
     try
     {
       int bytesum = 0;
       int byteread = 0;
       File oldfile = new File(oldPath);
       if (oldfile.exists()) {
         InputStream inStream = new FileInputStream(oldPath);
         FileOutputStream fs = new FileOutputStream(newPath);
         byte[] buffer = new byte[1444];

         while ((byteread = inStream.read(buffer)) != -1) {
           bytesum += byteread;
           fs.write(buffer, 0, byteread);
         }
         inStream.close();
       }
     } catch (Exception e) {
       System.out.println("复制单个文件操作出错 ");
       e.printStackTrace();
     }
   }

   public static boolean deleteFolder(String path)
   {
     boolean flag = false;
     File file = new File(path);

     if (!file.exists()) {
       return flag;
     }

     if (file.isFile()) {
       return deleteFile(path);
     }
     return deleteDirectory(path);
   }

   public static boolean deleteFile(String path)
   {
     boolean flag = false;
     File file = new File(path);

     if ((file.isFile()) && (file.exists())) {
       file.delete();
       flag = true;
     }
     return flag;
   }

   public static boolean deleteDirectory(String path)
   {
     if (!path.endsWith(File.separator)) {
       path = path + File.separator;
     }
     File dirFile = new File(path);

     if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
       return false;
     }
     boolean flag = true;

     File[] files = dirFile.listFiles();
     for (int i = 0; i < files.length; i++)
     {
       if (files[i].isFile()) {
         flag = deleteFile(files[i].getAbsolutePath());
         if (!flag){
           break;
         }

       }
       else {
         flag = deleteDirectory(files[i].getAbsolutePath());
         if (!flag){
           break;
         }

       }
     }
     if (!flag) {
       return false;
     }

     return dirFile.delete();
   }

   public static String showPageStaticHtml(String url, int currentPage, int pages)
   {
     String s = "";
     if (pages > 0) {
       if (currentPage >= 1) {
         s = s + "<a href='" + url + "_1.htm'>首页</a> ";
         if (currentPage > 1) {
           s = s + "<a href='" + url + "_" + (currentPage - 1) +
             ".htm'>上一页</a> ";
         }
       }
       int beginPage = currentPage - 3 < 1 ? 1 : currentPage - 3;
       if (beginPage <= pages) {
         s = s + "第　";
         int i = beginPage; for (int j = 0; (i <= pages) && (j < 6); j++) {
           if (i == currentPage)
             s = s + "<a class='this' href='" + url + "_" + i +
               ".htm'>" + i + "</a> ";
           else
             s = s + "<a href='" + url + "_" + i + ".htm'>" + i +
               "</a> ";
           i++;
         }

         s = s + "页　";
       }
       if (currentPage <= pages) {
         if (currentPage < pages) {
           s = s + "<a href='" + url + "_" + (currentPage + 1) +
             ".htm'>下一页</a> ";
         }
         s = s + "<a href='" + url + "_" + pages + ".htm'>末页</a> ";
       }
     }
     return s;
   }

   public static String showPageHtml(String url, String params, int currentPage, int pages)
   {
     String s = "";
     if (pages > 0) {
       if (currentPage >= 1) {
         s = s + "<a href='" + url + "?currentPage=1" + params +
           "'>首页</a> ";
         if (currentPage > 1) {
           s = s + "<a href='" + url + "?currentPage=" + (
             currentPage - 1) + params + "'>上一页</a> ";
         }
       }
       int beginPage = currentPage - 3 < 1 ? 1 : currentPage - 3;
       if (beginPage <= pages) {
         s = s + "第　";
         int i = beginPage; for (int j = 0; (i <= pages) && (j < 6); j++) {
           if (i == currentPage) {
             s = s + "<a class='this' href='" + url + "?currentPage=" +
                     i + params + "'>" + i + "</a> ";
           } else {
             s = s + "<a href='" + url + "?currentPage=" + i + params +
                     "'>" + i + "</a> ";
           }
           i++;
         }

         s = s + "页　";
       }
       if (currentPage <= pages) {
         if (currentPage < pages) {
           s = s + "<a href='" + url + "?currentPage=" + (
             currentPage + 1) + params + "'>下一页</a> ";
         }
         s = s + "<a href='" + url + "?currentPage=" + pages + params +
           "'>末页</a> ";
       }
     }

     return s;
   }

   public static String showPageFormHtml(int currentPage, int pages)
   {
     String s = "";
     if (pages > 0) {
       if (currentPage >= 1) {
         s = s + "<a href='javascript:void(0);' onclick='return gotoPage(1)'>首页</a> ";
         if (currentPage > 1) {
           s = s + "<a href='javascript:void(0);' onclick='return gotoPage(" + (
             currentPage - 1) + ")'>上一页</a> ";
         }
       }
       int beginPage = currentPage - 3 < 1 ? 1 : currentPage - 3;
       if (beginPage <= pages) {
         s = s + "第　";
         int i = beginPage; for (int j = 0; (i <= pages) && (j < 6); j++) {
           if (i == currentPage){
             s = s + "<a class='this' href='javascript:void(0);' onclick='return gotoPage(" +
                     i + ")'>" + i + "</a> ";
           } else{
             s = s + "<a href='javascript:void(0);' onclick='return gotoPage(" +
                     i +
                     ")'>" + i + "</a> ";
           }

           i++;
         }

         s = s + "页　";
       }
       if (currentPage <= pages) {
         if (currentPage < pages) {
           s = s + "<a href='javascript:void(0);' onclick='return gotoPage(" + (
             currentPage + 1) + ")'>下一页</a> ";
         }
         s = s + "<a href='javascript:void(0);' onclick='return gotoPage(" +
           pages + ")'>末页</a> ";
       }
     }

     return s;
   }

   public static String showPageAjaxHtml(String url, String params, int currentPage, int pages)
   {
     String s = "";
     if (pages > 0) {
       String address = url + "?1=1" + params;
       if (currentPage >= 1) {
         s = s + "<a href='javascript:void(0);' onclick='return ajaxPage(\"" +
           address + "\",1,this)'>首页</a> ";
         s = s + "<a href='javascript:void(0);' onclick='return ajaxPage(\"" +
           address +
           "\"," + (
           currentPage - 1) +
           ",this)'>上一页</a> ";
       }

       int beginPage = currentPage - 3 < 1 ? 1 : currentPage - 3;
       if (beginPage <= pages) {
         s = s + "第　";
         int i = beginPage; for (int j = 0; (i <= pages) && (j < 6); j++) {
           if (i == currentPage) {
             s = s + "<a class='this' href='javascript:void(0);' onclick='return ajaxPage(\"" +
                     address +
                     "\"," +
                     i +
                     ",this)'>" +
                     i +
                     "</a> ";
           }else {
             s = s + "<a href='javascript:void(0);' onclick='return ajaxPage(\"" +
                     address + "\"," + i +
                     ",this)'>" + i + "</a> ";
           }
           i++;
         }

         s = s + "页　";
       }
       if (currentPage <= pages) {
         s = s + "<a href='javascript:void(0);' onclick='return ajaxPage(\"" +
           address +
           "\"," + (
           currentPage + 1) +
           ",this)'>下一页</a> ";
         s = s + "<a href='javascript:void(0);' onclick='return ajaxPage(\"" +
           address + "\"," + pages + ",this)'>末页</a> ";
       }
     }

     return s;
   }


   public static String showBrandGoodsAjaxHtml(List<Object> lists, Map<String, Object> map) {
     StringBuffer s = new StringBuffer(300);
     String img = null;
     String loadimg = map.get("imageWebServer")+ "/static/style/common/images/loader.gif";
     String errorimg = map.get("webPath")+"/"+map.get("goodsImagePath")+"/"+map.get("goodsImageName");
     String goods_url = null;
     if (lists!=null && lists.size()>0) {

       for(int i=0;i<lists.size();i++){
         ShoppingGoodsWithBLOBs goods = (ShoppingGoodsWithBLOBs)lists.get(i);
         img = null;
         if(goods.getGoods_main_photo()!=null){
           img=map.get("imageWebServer")+"/"+goods.getGoods_main_photo().getPath()+"/"+goods.getGoods_main_photo().getName()+"_small."+goods.getGoods_main_photo().getExt();
         } else{
           img=map.get("imageWebServer")+"/"+map.get("goodsImagePath")+"/"+map.get("goodsImageName");
         }
         goods_url=map.get("webPath")+"/goods_"+goods.getId()+".htm";
         if((Boolean)map.get("IsSecondDomainOpen")) {
           goods_url="http://"+goods.getGoods_store().getStoreSecondDomain()+"."+map.get("domainPath")+"/goods_"+goods.getId()+".htm";
         }

         s.append("<a href='").append(goods_url).append("'>");
         s.append("<dl><dt><img src='").append(loadimg).append("' original='").append(img).append("' onerror='this.src=").append(errorimg).append(";'/>");
         s.append("</dt><dd><h3>");
         if(goods.getGroupBuy()==2){
           s.append("<span style=\"color:#F00;\">[团购]</span>");
         }
         if(goods.getActivityStatus()==2){
           s.append("<span style=\"color:#F00;\">[活动]</span>");
         }
         if(goods.getCombinStatus()==2){
           s.append("<span style=\"color:#F00;\">[组合]</span>");
         }
         if(goods.getBargainStatus()==2){
           s.append("<span style=\"color:#F00;\">[特价]</span>");
         }
         if(goods.getDeliveryStatus()==2){
           s.append("<span style=\"color:#F00;\">[买就送]</span>");
         }
         s.append("<b>").append(CommUtil.substring(goods.getGoodsName(),25)).append("</b></h3>");
         s.append("<span>市场价：<b class=\"goods2market\">¥").append(goods.getGoodsPrice()).append("</b><i>，</i> </span>");
         s.append("<span>商城价：<strong>¥").append(goods.getStorePrice()).append("</strong></span>").append("<em>");
         s.append("<span>描述相符：<i style=\"color:#F00\">").append(CommUtil.null2Double(goods.getDescriptionEvaluate())).append("</i> 分， </span>");
         s.append("<span>累计评价：<i style=\"color:#f60\">").append(goods.getEvaluates().size()).append("，</i></span>");
         s.append("<span>已售出<strong class=\"orange\">").append(goods.getGoodsSalenum()).append("</strong>笔</span>").append("</em></dd></dl></a>");

       }
     }

     return s.toString();
   }

   public static String showBrandGoodsAjaxHtml1(List<Object> lists, Map<String, Object> map) {
	   StringBuffer s = new StringBuffer(300);
	   String img = null;
	   String loadimg = map.get("imageWebServer")+ "/static/style/common/images/loader.gif";
	   String errorimg = map.get("webPath")+"/"+map.get("goodsImagePath")+"/"+map.get("goodsImageName");
	   String goods_url = null;
	   if (lists!=null && lists.size()>0) {

		   for(int i=0;i<lists.size();i++){
             ShoppingGoodsWithBLOBs goods = (ShoppingGoodsWithBLOBs)lists.get(i);
			   img = null;
			   if(goods.getGoods_main_photo()!=null){
                 img=map.get("imageWebServer")+"/"+goods.getGoods_main_photo().getPath()+"/"+goods.getGoods_main_photo().getName()+"_small."+goods.getGoods_main_photo().getExt();
               } else{
                 img=map.get("imageWebServer")+"/"+map.get("goodsImagePath")+"/"+map.get("goodsImageName");
               }
		       goods_url=map.get("webPath")+"/goods_"+goods.getId()+".htm";
		       if((Boolean)map.get("IsSecondDomainOpen")) {
		    	   goods_url="http://"+goods.getGoods_store().getStoreSecondDomain()+"."+map.get("domainPath")+"/goods_"+goods.getId()+".htm";
		       }

		       s.append("<a href='").append(goods_url).append("'>");
		       s.append("<dl><dt><img src='").append(loadimg).append("' original='").append(img).append("' onerror='this.src=").append(errorimg).append(";'/>");
		       s.append("</dt><dd><h3>");
		       if(goods.getGroupBuy()==2){
		    	   s.append("<span style=\"color:#F00;\">[团购]</span>");
		       }
		       if(goods.getActivityStatus()==2){
		    	   s.append("<span style=\"color:#F00;\">[活动]</span>");
		       }
		       if(goods.getCombinStatus()==2){
		    	   s.append("<span style=\"color:#F00;\">[组合]</span>");
		       }
		       if(goods.getBargainStatus()==2){
		    	   s.append("<span style=\"color:#F00;\">[特价]</span>");
		       }
		       if(goods.getDeliveryStatus()==2){
		    	   s.append("<span style=\"color:#F00;\">[买就送]</span>");
		       }
		       s.append("<b>").append(CommUtil.substring(goods.getGoodsName(),25)).append("</b></h3>");
		       s.append("<span>市场价：<b class=\"goods2market\">¥").append(goods.getGoodsPrice()).append("</b><i>，</i> </span>");
		       s.append("<span>商城价：<strong>¥").append(goods.getStorePrice()).append("</strong></span>").append("<em>");
		       s.append("<span>描述相符：<i style=\"color:#F00\">").append(CommUtil.null2Double(goods.getDescriptionEvaluate())).append("</i> 分， </span>");
		       s.append("<span>累计评价：<i style=\"color:#f60\">").append(goods.getEvaluates().size()).append("，</i></span>");
		       s.append("<span>已售出<strong class=\"orange\">").append(goods.getGoodsSalenum()).append("</strong>笔</span>").append("</em></dd></dl></a>");

		   }
	   }

     return s.toString();
   }

   public static String showLoadGoodsAjaxHtml(List<ShoppingGoodsWithBLOBs> lists, Map<String, Object> map) {
	   StringBuffer s = new StringBuffer(300);
	   String img = null;
	   String loadimg = map.get("imageWebServer")+ "/static/style/common/images/loader.gif";
	   String errorimg = map.get("webPath")+"/"+map.get("goodsImagePath")+"/"+map.get("goodsImageName");
	   String goods_url = null;
	   if (lists!=null && lists.size()>0) {

		   for(int i=0;i<lists.size();i++){

             ShoppingGoodsWithBLOBs goods = lists.get(i);
			   img = null;
			   if(goods.getGoods_main_photo()!=null) {
                 img = map.get("imageWebServer") + "/" + goods.getGoods_main_photo().getPath() + "/" + goods.getGoods_main_photo().getName() + "_small." + goods.getGoods_main_photo().getExt();
               }else{
                 img=map.get("imageWebServer")+"/"+map.get("goodsImagePath")+"/"+map.get("goodsImageName");
               }
		       goods_url=map.get("webPath")+"/goods_"+goods.getId()+".htm";
		       if((Boolean)map.get("IsSecondDomainOpen")) {
		    	   goods_url="http://"+goods.getGoods_store().getStoreSecondDomain()+"."+map.get("domainPath")+"/goods_"+goods.getId()+".htm";
		       }
		       s.append("<a href='").append(goods_url).append("'>");
		       s.append("<dl><dt><img src='").append(loadimg).append("' original='").append(img).append("' onerror='this.src=").append(errorimg).append(";'/>");
		       s.append("</dt><dd><h3>");
		       if(goods.getGroupBuy()==2){
		    	   s.append("<span style=\"color:#F00;\">[团购]</span>");
		       }
		       if(goods.getActivityStatus()==2){
		    	   s.append("<span style=\"color:#F00;\">[活动]</span>");
		       }
		       if(goods.getCombinStatus()==2){
		    	   s.append("<span style=\"color:#F00;\">[组合]</span>");
		       }
		       if(goods.getBargainStatus()==2){
		    	   s.append("<span style=\"color:#F00;\">[特价]</span>");
		       }
		       if(goods.getDeliveryStatus()==2){
		    	   s.append("<span style=\"color:#F00;\">[买就送]</span>");
		       }
		       s.append("<b>").append(CommUtil.substring(goods.getGoodsName(),25)).append("</b></h3>");
		       s.append("<span>市场价：<b class=\"goods2market\">¥").append(goods.getGoodsPrice()).append("</b><i>，</i> </span>");
		       s.append("<span>商城价：<strong>¥").append(goods.getStorePrice()).append("</strong></span>").append("<em>");
		       s.append("<span>描述相符：<i style=\"color:#F00\">").append(CommUtil.null2Double(goods.getDescriptionEvaluate())).append("</i> 分， </span>");
		       s.append("<span>累计评价：<i style=\"color:#f60\">").append(goods.getEvaluates().size()).append("，</i></span>");
		       s.append("<span>已售出<strong class=\"orange\">").append(goods.getGoodsSalenum()).append("</strong>笔</span>").append("</em></dd></dl></a>");

		   }
	   }
     return s.toString();
   }

   public static String showOrdersAjaxHtml(List<ShoppingOrderform> lists, Map<String, Object> map) {
	   StringBuffer s = new StringBuffer(300);
	   String img = null;
	   String goods_url = null;
	   if (lists!=null && lists.size()>0) {
		   for(int i=0;i<lists.size();i++){
			   ShoppingOrderform obj = (ShoppingOrderform)lists.get(i);
			   s.append("<div class='order_page_box'><h1><span class='fl'>订单号：");
			   s.append(obj.getOrderId()).append("</span><span class='fr'>");
			   if(obj.getOrderStatus()==0){
				   s.append("已取消");
			   } else if(obj.getOrderStatus()==10){
				   s.append("待发货");
			   } else if(obj.getOrderStatus()==20){
				   s.append("待发货");
			   } else if(obj.getOrderStatus()==30){
				   s.append("待收货");
			   } else if(obj.getOrderStatus()==40){
				   s.append("已收货");
			   } else {
				   s.append("&nbsp;");
			   }
			   s.append("</span></h1>");
			   for(ShoppingGoodscart gc : obj.getGcs()) {
				   if(gc.getGoods().getGoods_main_photo()!=null) {
                     img = map.get("imageWebServer") + "/" + gc.getGoods().getGoods_main_photo().getPath() + "/" + gc.getGoods().getGoods_main_photo().getName() + "_small." + gc.getGoods().getGoods_main_photo().getExt();
                   }else {
                     img = map.get("imageWebServer") + "/" + map.get("goodsImagePath") + "/" + map.get("goodsImageName");
                   }
			       goods_url=map.get("webPath")+"/goods_"+gc.getGoods().getId()+".htm";
			       if((Boolean)map.get("IsSecondDomainOpen")) {
			    	   goods_url="http://"+gc.getGoods().getGoods_store().getStoreSecondDomain()+"."+map.get("domainPath")+"/goods_"+gc.getGoods().getId()+".htm";
			       }
			       s.append("<div class='order_goods'><div class='dt'>").append("<a href='").append(goods_url).append("' >");
			       s.append("<img src='").append(img).append("' width='50' height='50'></a></div>");
			       s.append("<div style='float: left;'>").append("<a href='").append(goods_url).append("' >");
			       s.append("<span style='line-height: 24px'>").append(gc.getGoods().getGoodsName()).append("</span></a><br></div></div>");

			   }
			   s.append("<div class='order_total'> 实付：<b>¥").append(obj.getTotalprice()).append("&nbsp;").append("<i style='color:#59cfff'>(含运费:¥");
		       s.append(CommUtil.null2Float(obj.getShipPrice())).append(")</i></b></div>");

		       s.append("<div class='order_box_bt'>");
		       if(obj.getOrderStatus()==0 ) {
		    	   s.append("<a style='color:#ff4f19; text-decoration:underline;' href='javascript:void(0);' ");
		    	   s.append("onclick=\"if(confirm('删除订单，删除后不可恢复，是否继续?'))window.location.href='").append(map.get("webPath"));
		    	   s.append("/_delete.htm?id=").append(obj.getId()).append("&currentPage=").append(map.get("currentPage")).append("'\" >删除订单</a>");
		       }
		       if(obj.getOrderStatus()==10 ) {
		    	   s.append("<a style='color:#ff4f19; text-decoration:underline;' href='javascript:void(0);' ");
		    	   s.append("onclick=\"if(confirm('取消订单，是否继续?'))window.location.href='").append(map.get("webPath"));
		    	   s.append("/buyer/order_cancel.htm?id=").append(obj.getId()).append("&currentPage=").append(map.get("currentPage")).append("'\" >取消订单</a>");
		       }

		       if(obj.getOrderStatus()==47) {
		    	   s.append("退货完成,已结束");
		       }

               if(obj.getOrderStatus()==48) {
            	   s.append("卖家拒绝退货申请");
               }

               if(obj.getOrderStatus()==49)  {
            	   s.append("退货失败");
               }

	  		   if(obj.getOrderStatus()==65) {
	  			   s.append("已结束,不可评价");
	  		   }

	  		   if(obj.getOrderStatus()==10){
	  			   s.append("<a href=").append(map.get("webPath")).append("/order_pay_view.htm?id=").append(obj.getId()).append(" target='_blank' class='bg_orange'>付款</a>");
	  		   }
	  		   if(obj.getOrderStatus()==30){
	  			   s.append("<a href='javascript:void(0);' ");
	  			   s.append("onclick=\"if(confirm('订单确认收货，是否继续?'))window.location.href='").append(map.get("webPath"));
		    	   s.append("/buyer/order_cofirm_save.htm?id=").append(obj.getId()).append("&currentPage=").append(map.get("currentPage")).append("'\" >确认收货</a>");
	  		   }
	  		   s.append("</div>");
			   s.append("</div>");
		   }
	   }

     return s.toString();
   }

   public static void saveWebPaths(Map<String, Object> map, ShoppingSysconfig config, HttpServletRequest request){
	   	String contextPath = request.getContextPath().equals("/") ? "" : request.getContextPath();
		String webPath = CommUtil.getURL(request, config);
		String port = ":" + CommUtil.null2Int(Integer.valueOf(request.getServerPort()));
		if ((config.getSecondDomainOpen()) && (!CommUtil.generic_domain(request).equals("localhost"))) {
			webPath = "http://www." + CommUtil.generic_domain(request) + port + contextPath;
		}
		if(config.getSiteUrl()!=null && !"".equalsIgnoreCase(config.getSiteUrl())){
			webPath = config.getSiteUrl() + contextPath;
		}
		map.put("domainPath", CommUtil.generic_domain(request));
		map.put("webPath", webPath);
		if ((config.getImagewebserver() != null) && (!config.getImagewebserver().equals(""))){
          map.put("imageWebServer", config.getImagewebserver());
        }else {
			map.put("imageWebServer", webPath);
		}
		map.put("goodsImagePath",config.getGoodsImage().getPath());
		map.put("goodsImageName",config.getGoodsImage().getName());
		map.put("IsSecondDomainOpen",config.getSecondDomainOpen());

   }

   public static void saveLucene2Map(String type, LuceneResult pList, Map<String, Object> map){
     if (pList != null) {
       map.put("totalPage", Integer.valueOf(pList.getPages()));
       map.put("pageSize", Integer.valueOf(pList.getPageSize()));
       map.put("rows", Integer.valueOf(pList.getRows()));
       map.put("currentPage", new Integer(pList.getCurrentPage()));
       map.put("ajaxLoadHtml", showLoadGoodsAjaxHtml(pList.getGoods_list(), map));
     }
   }

   public static void saveLucene2ModelAndView(String type, LuceneResult pList, ModelAndView mv){
     if (pList != null) {
       log.info("---result--{}" ,type);
       if (type.equals("goods")) {
         mv.addObject("searchGoods", pList.getGoods_list());
         log.info("---goods--{}" ,pList.getGoods_list().size());
       }
       if (type.equals("store")) {
         mv.addObject("stores", pList.getStore_list());
         log.info("---store--{}" , pList.getStore_list().size());
       }
       mv.addObject("totalPage", Integer.valueOf(pList.getPages()));
       mv.addObject("pageSize", Integer.valueOf(pList.getPageSize()));
       mv.addObject("rows", Integer.valueOf(pList.getRows()));
       mv.addObject("currentPage", new Integer(pList.getCurrentPage()));
       mv.addObject("gotoPageFormHTML", showPageFormHtml(pList.getCurrentPage(), pList.getPages()));
     }
   }

   public static void saveIPageList2Map(String url, String staticURL, String params, IPageList pList, Map<String, Object> map) {
     if (pList != null) {
       map.put("totalPage", new Integer(pList.getPages()));
       map.put("pageSize", Integer.valueOf(pList.getPageSize()));
       map.put("rows", new Integer(pList.getRowCount()));
       map.put("currentPage", new Integer(pList.getCurrentPage()));
       if("brand_goods".equalsIgnoreCase(String.valueOf(map.get("show")))) {
    	   map.put("ajaxLoadHtml", showBrandGoodsAjaxHtml(pList.getResult(),map));
       } else if("orders".equalsIgnoreCase(String.valueOf(map.get("show")))){
    	   map.put("ajaxLoadHtml", showOrdersAjaxHtml(pList.getResult(),map));
       }

     }
   }
   public static void saveIPageList2Map(String url, String staticURL, String params, PageModel pList, Map<String, Object> map)
   {
     if (pList != null) {
       map.put("totalPage", new Integer(pList.getPages()));
       map.put("pageSize", Integer.valueOf(pList.getPageSize()));
       map.put("rows", new Integer(pList.getRowCount()));
       map.put("currentPage", new Integer(pList.getCurrentPage()));
       if("brand_goods".equalsIgnoreCase(String.valueOf(map.get("show")))) {
         map.put("ajaxLoadHtml", showBrandGoodsAjaxHtml(pList.getResult(),map));
       } else if("orders".equalsIgnoreCase(String.valueOf(map.get("show")))){
         map.put("ajaxLoadHtml", showOrdersAjaxHtml((List<ShoppingOrderform>)pList.getResult(),map));
       }
     }
   }

   private static Object showBrandGoodsAjaxHtml(Object result, Map<String, Object> map) {
     StringBuffer s = new StringBuffer(300);
     String img = null;
     String loadimg = map.get("imageWebServer")+ "/static/style/common/images/loader.gif";
     String errorimg = map.get("webPath")+"/"+map.get("goodsImagePath")+"/"+map.get("goodsImageName");
     String goods_url = null;
     List<ShoppingGoodsWithBLOBs> lists = null;
     if(result != null){
       lists = (List<ShoppingGoodsWithBLOBs>) result;
     }
     if (lists!=null && lists.size()>0) {
       for(int i=0;i<lists.size();i++){
         ShoppingGoodsWithBLOBs goods = (ShoppingGoodsWithBLOBs)lists.get(i);
         img = null;
         if(goods.getGoods_main_photo()!=null){
           img=map.get("imageWebServer")+"/"+goods.getGoods_main_photo().getPath()+"/"+goods.getGoods_main_photo().getName()+"_small."+goods.getGoods_main_photo().getExt();
         } else{
           img=map.get("imageWebServer")+"/"+map.get("goodsImagePath")+"/"+map.get("goodsImageName");
         }
         goods_url=map.get("webPath")+"/goods_"+goods.getId()+".htm";
         if((Boolean)map.get("IsSecondDomainOpen")) {
           goods_url="http://"+goods.getGoods_store().getStoreSecondDomain()+"."+map.get("domainPath")+"/goods_"+goods.getId()+".htm";
         }

         s.append("<a href='").append(goods_url).append("'>");
         s.append("<dl><dt><img src='").append(loadimg).append("' original='").append(img).append("' onerror='this.src=").append(errorimg).append(";'/>");
         s.append("</dt><dd><h3>");
         if(goods.getGroupBuy()==2){
           s.append("<span style=\"color:#F00;\">[团购]</span>");
         }
         if(goods.getActivityStatus()==2){
           s.append("<span style=\"color:#F00;\">[活动]</span>");
         }
         if(goods.getCombinStatus()==2){
           s.append("<span style=\"color:#F00;\">[组合]</span>");
         }
         if(goods.getBargainStatus()==2){
           s.append("<span style=\"color:#F00;\">[特价]</span>");
         }
         if(goods.getDeliveryStatus()==2){
           s.append("<span style=\"color:#F00;\">[买就送]</span>");
         }
         s.append("<b>").append(CommUtil.substring(goods.getGoodsName(),25)).append("</b></h3>");
         s.append("<span>市场价：<b class=\"goods2market\">¥").append(goods.getGoodsPrice()).append("</b><i>，</i> </span>");
         s.append("<span>商城价：<strong>¥").append(goods.getStorePrice()).append("</strong></span>").append("<em>");
         s.append("<span>描述相符：<i style=\"color:#F00\">").append(CommUtil.null2Double(goods.getDescriptionEvaluate())).append("</i> 分， </span>");
         s.append("<span>累计评价：<i style=\"color:#f60\">").append(goods.getEvaluates().size()).append("，</i></span>");
         s.append("<span>已售出<strong class=\"orange\">").append(goods.getGoodsSalenum()).append("</strong>笔</span>").append("</em></dd></dl></a>");

       }
     }

     return s.toString();
   }

   public static void saveIPageList2ModelAndView(String url, String staticURL, String params, IPageList pList, ModelAndView mv)
   {
     if (pList != null) {
       mv.addObject("objs", pList.getResult());
       mv.addObject("totalPage", new Integer(pList.getPages()));
       mv.addObject("pageSize", Integer.valueOf(pList.getPageSize()));
       mv.addObject("rows", new Integer(pList.getRowCount()));
       mv.addObject("currentPage", new Integer(pList.getCurrentPage()));
       mv.addObject("gotoPageHTML", showPageHtml(url, params, pList.getCurrentPage(), pList.getPages()));
       mv.addObject("gotoPageFormHTML", showPageFormHtml(pList.getCurrentPage(), pList.getPages()));
       mv.addObject("gotoPageStaticHTML", showPageStaticHtml(staticURL, pList.getCurrentPage(), pList.getPages()));
       mv.addObject("gotoPageAjaxHTML", showPageAjaxHtml(url, params, pList.getCurrentPage(), pList.getPages()));
     }
   }
   public static void saveIPageList2ModelAndView(String url, String staticURL, String params, PageModel pList, ModelAndView mv)
   {
     if (pList != null) {
       mv.addObject("objs", pList.getResult());
       mv.addObject("totalPage", new Integer(pList.getPages()));
       mv.addObject("pageSize", Integer.valueOf(pList.getPageSize()));
       mv.addObject("rows", new Integer(pList.getRowCount()));
       mv.addObject("currentPage", new Integer(pList.getCurrentPage()));
       mv.addObject("gotoPageHTML", showPageHtml(url, params, pList.getCurrentPage(), pList.getPages()));
       mv.addObject("gotoPageFormHTML", showPageFormHtml(pList.getCurrentPage(), pList.getPages()));
       mv.addObject("gotoPageStaticHTML", showPageStaticHtml(staticURL, pList.getCurrentPage(), pList.getPages()));
       mv.addObject("gotoPageAjaxHTML", showPageAjaxHtml(url, params, pList.getCurrentPage(), pList.getPages()));
     }
   }
   public static char randomChar() {
     char[] chars = { 'a', 'A', 'b', 'B', 1,'c', 'C', 'd', 'D',
       'e', 'E', 'f',7, 'F', 'g', 'G', 2,'h', 'H', 'i', 'I', 'j',9, 'J',
       'k', 'K', 6,'l', 'L', 'm', 'M', 3,'n', 'N', 'o', 'O',5, 'p', 'P',
       'q', 'Q', 'r', 'R', 's', 'S', 't', 4,'T', 'u', 'U', 'v', 'V',
       'w', 'W',8, 'x', 'X', 'y', 'Y', 'z', 'Z',0 };
     int index = (int)(Math.random() * 62.0D) - 1;
     if (index < 0) {
       index = 0;
     }
     return chars[index];
   }

   public static String  getRandomChar(int size){
     StringBuffer s= new StringBuffer();
     for(int i=0;i<size;i++){
       s.append(randomChar());
     }
     return s.toString();
   }


   public static String[] splitByChar(String s, String c) {
     String[] list = s.split(c);
     return list;
   }

   public static Object requestByParam(HttpServletRequest request, String param) {
     if (!request.getParameter(param).equals("")) {
       return request.getParameter(param);
     }
     return null;
   }

   public static String substring(String s, int maxLength)
   {
     if (!StringUtils.hasLength(s)){
       return s;
       }
     if (s.length() <= maxLength) {
       return s;
     }
     return s.substring(0, maxLength) + "...";
   }

   public static String substringfrom(String s, String from) {
     if (s.indexOf(from) < 0) {
       return "";
     }
     return s.substring(s.indexOf(from) + from.length());
   }

   public static int null2Int(Object s) {
     int v = 0;
     if (s != null) {
       try {
         v = Integer.parseInt(s.toString());
       } catch (Exception localException) {
       }
     }
     return v;
   }

   public static float null2Float(Object s) {
     float v = 0.0F;
     if (s != null){
       try {
         v = Float.parseFloat(s.toString());
       } catch (Exception localException) {
       }
     }

     return v;
   }

   public static double null2Double(Object s) {
     double v = 0.0D;
     if (s != null){
       try {
         v = Double.parseDouble(null2String(s));
       } catch (Exception localException) {
       }
     }
     return v;
   }

   public static boolean null2Boolean(Object s) {
     boolean v = false;
     if (s != null){
       try {
         v = Boolean.parseBoolean(s.toString());
       } catch (Exception localException) {
       }
     }
     return v;
   }

   public static String null2String(Object s) {
     return s == null ? "" : s.toString().trim();
   }

   public static Long null2Long(Object s) {
     Long v = Long.valueOf(-1L);
     if (s != null && !"".equals(s) ) {
       try {
         v = Long.valueOf(Long.parseLong(s.toString()));
         return v;
       } catch (Exception e) {
         e.printStackTrace();
       }
     }
     return null;
   }

   public static String getTimeInfo(long time) {
     int hour = (int)time / 3600000;
     long balance = time - hour * 1000 * 60 * 60;
     int minute = (int)balance / 60000;
     balance -= minute * 1000 * 60;
     int seconds = (int)balance / 1000;
     String ret = "";
     if (hour > 0){
       ret = ret + hour + "小时";
     }

     if (minute > 0){
       ret = ret + minute + "分";
     }

     else if ((minute <= 0) && (seconds > 0)){
       ret = ret + "零";
     }

     if (seconds > 0){
       ret = ret + seconds + "秒";
     }
     return ret;
   }

   public static String getIpAddr(HttpServletRequest request) {
     String ip = request.getHeader("x-forwarded-for");
     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
       ip = request.getHeader("Proxy-Client-IP");
     }
     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
       ip = request.getHeader("WL-Proxy-Client-IP");
     }
     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
       ip = request.getRemoteAddr();
     }
     return ip;
   }

   public static int indexOf(String s, String sub) {
     return s.trim().indexOf(sub.trim());
   }

   public static Map cal_time_space(Date begin, Date end) {
     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     long l = end.getTime() - begin.getTime();
     long day = l / 86400000L;
     long hour = l / 3600000L - day * 24L;
     long min = l / 60000L - day * 24L * 60L - hour * 60L;
     long second = l / 1000L - day * 24L * 60L * 60L - hour * 60L * 60L - min * 60L;
     Map map = new HashMap();
     map.put("day", Long.valueOf(day));
     map.put("hour", Long.valueOf(hour));
     map.put("min", Long.valueOf(min));
     map.put("second", Long.valueOf(second));
     return map;
   }

   public static final String randomString(int length) {
     char[] numbersAndLetters = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
       .toCharArray();
     if (length < 1) {
       return "";
     }
     Random randGen = new Random();
     char[] randBuffer = new char[length];
     for (int i = 0; i < randBuffer.length; i++) {
       randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
     }
     return new String(randBuffer);
   }

   public static final String randomInt(int length) {
     if (length < 1) {
       return null;
     }
     Random randGen = new Random();
     char[] numbersAndLetters = "0123456789".toCharArray();

     char[] randBuffer = new char[length];
     for (int i = 0; i < randBuffer.length; i++) {
       randBuffer[i] = numbersAndLetters[randGen.nextInt(10)];
     }
     return new String(randBuffer);
   }

   public static long getDateDistance(String time1, String time2)
   {
     long quot = 0L;
     SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
     try {
       Date date1 = ft.parse(time1);
       Date date2 = ft.parse(time2);
       quot = date1.getTime() - date2.getTime();
       quot = quot / 1000L / 60L / 60L / 24L;
     } catch (ParseException e) {
       e.printStackTrace();
     }
     return quot;
   }

   public static double div(Object a, Object b)
   {
     double ret = 0.0D;
     if ((!null2String(a).equals("")) && (!null2String(b).equals(""))) {
       BigDecimal e = new BigDecimal(null2String(a));
       BigDecimal f = new BigDecimal(null2String(b));
       if (null2Double(f) > 0.0D) {
         ret = e.divide(f, 3, 1).doubleValue();
       }
     }
     DecimalFormat df = new DecimalFormat("0.00");
     return Double.valueOf(df.format(ret)).doubleValue();
   }

   public static double subtract(Object a, Object b)
   {
     double ret = 0.0D;
     BigDecimal e = new BigDecimal(null2Double(a));
     BigDecimal f = new BigDecimal(null2Double(b));
     ret = e.subtract(f).doubleValue();
     DecimalFormat df = new DecimalFormat("0.00");
     return Double.valueOf(df.format(ret)).doubleValue();
   }

   public static double add(Object a, Object b)
   {
     double ret = 0.0D;
     BigDecimal e = new BigDecimal(null2Double(a));
     BigDecimal f = new BigDecimal(null2Double(b));
     ret = e.add(f).doubleValue();
     DecimalFormat df = new DecimalFormat("0.00");
     return Double.valueOf(df.format(ret)).doubleValue();
   }

   public static double mul(Object a, Object b)
   {
     BigDecimal e = new BigDecimal(null2Double(a));
     BigDecimal f = new BigDecimal(null2Double(b));
     double ret = e.multiply(f).doubleValue();
     DecimalFormat df = new DecimalFormat("0.00");
     return Double.valueOf(df.format(ret)).doubleValue();
   }

   public static double formatMoney(Object money) {
     DecimalFormat df = new DecimalFormat("0.00");
     return Double.valueOf(df.format(money)).doubleValue();
   }

   public static int M2byte(float m) {
     float a = m * 1024.0F * 1024.0F;
     return (int)a;
   }

   public static boolean convertIntToBoolean(int intValue) {
     return intValue != 0;
   }

   public static String getURL(HttpServletRequest request) {

     String contextPath = request.getContextPath().equals("/") ? "" : request.getContextPath();

     String url = "http://" + request.getServerName();
     if (null2Int(Integer.valueOf(request.getServerPort())) != 80) {
       url = url + ":" + null2Int(Integer.valueOf(request.getServerPort())) + contextPath;
     }
     else {
       url = url + contextPath;
     }
     return url;

   }

   public static String getURL(HttpServletRequest request, ShoppingSysconfig config) {

	     String contextPath = request.getContextPath().equals("/") ? "" : request.getContextPath();

	     String url = "http://" + request.getServerName();
	     if (null2Int(Integer.valueOf(request.getServerPort())) != 80){
           url = url + ":" + null2Int(Integer.valueOf(request.getServerPort())) + contextPath;
         }else {
	       url = url + contextPath;
	     }
	     if(config.getSiteUrl()!=null && !"".equalsIgnoreCase(config.getSiteUrl())){
	    	 if(!"/".equalsIgnoreCase(contextPath)){
               url = config.getSiteUrl() + contextPath;
             }else{
               url = config.getSiteUrl();
             }

		 }
	     return url;

	   }

   public static String filterHTML(String content) {
     Whitelist whiteList = new Whitelist();
     String s = Jsoup.clean(content, user_content_filter);
     return s;
   }

   public static int parseDate(String type, Date date) {
     Calendar cal = Calendar.getInstance();
     cal.setTime(date);
     if (type.equals("y")) {
       return cal.get(1);
     }
     if (type.equals("M")) {
       return cal.get(2) + 1;
     }
     if (type.equals("d")) {
       return cal.get(5);
     }
     if (type.equals("H")) {
       return cal.get(11);
     }
     if (type.equals("m")) {
       return cal.get(12);
     }
     if (type.equals("s")) {
       return cal.get(13);
     }
     return 0;
   }

   public static int[] readImgWH(String imgurl)
   {
     boolean b = false;
     try
     {
       URL url = new URL(imgurl);

       BufferedInputStream bis = new BufferedInputStream(
         url.openStream());

       byte[] bytes = new byte[100];

       OutputStream bos = new FileOutputStream(
         new File("C:\\thetempimg.gif"));
       int len;
       while ((len = bis.read(bytes)) > 0)
       {
         bos.write(bytes, 0, len);
       }
       bis.close();
       bos.flush();
       bos.close();

       b = true;
     }
     catch (Exception e) {
       b = false;
     }
     int[] a = new int[2];
     if (b)
     {
       File file = new File("C:\\thetempimg.gif");
       BufferedImage bi = null;
       boolean imgwrong = false;
       try
       {
         bi = ImageIO.read(file);
         try
         {
           int i = bi.getType();
           imgwrong = true;
         } catch (Exception e) {
           imgwrong = false;
         }
       } catch (IOException ex) {
         ex.printStackTrace();
       }
       if (imgwrong) {
         a[0] = bi.getWidth();
         a[1] = bi.getHeight();
       } else {
         a = null;
       }

       file.delete();
     } else {
       a = null;
     }
     return a;
   }

   public static boolean del_acc(HttpServletRequest request, ShoppingAccessory acc)
   {
     boolean ret = true;
     boolean ret1 = true;
     if (acc != null) {
       String path = request.getSession().getServletContext().getRealPath("/")  + acc.getPath() +
         File.separator + acc.getName();
       String small_path =  request.getSession().getServletContext().getRealPath("/") + acc.getPath() +
         File.separator + acc.getName() + "_small." + acc.getExt();
       ret = deleteFile(path);
       ret1 = deleteFile(small_path);
     }
     return (ret) && (ret1);
   }

   public static boolean fileExist(String path)
   {
     File file = new File(path);
     return file.exists();
   }

   public static int splitLength(String s, String c)
   {
     int v = 0;
     if (!s.trim().equals("")) {
       v = s.split(c).length;
     }
     return v;
   }

   public static double fileSize(File folder)
   {
     totalFolder += 1;

     long foldersize = 0L;
     File[] filelist = folder.listFiles();
     for (int i = 0; i < filelist.length; i++) {
       if (filelist[i].isDirectory()) {
         foldersize = (long)(foldersize + fileSize(filelist[i]));
       } else {
         totalFile += 1;
         foldersize += filelist[i].length();
       }
     }
     return div(Long.valueOf(foldersize), Integer.valueOf(1024));
   }

   public static int fileCount(File file)
   {
     if (file == null) {
       return 0;
     }
     if (!file.isDirectory()) {
       return 1;
     }
     int fileCount = 0;
     File[] files = file.listFiles();
     for (File f : files) {
       if (f.isFile()) {
         fileCount++;
       } else if (f.isDirectory()) {
         fileCount++;
         fileCount += fileCount(file);
       }
     }
     return fileCount;
   }

   public static String get_all_url(HttpServletRequest request)
   {
     String query_url = request.getRequestURI();
     if ((request.getQueryString() != null) &&
       (!request.getQueryString().equals(""))) {
       query_url = query_url + "?" + request.getQueryString();
     }
     return query_url;
   }

   public static Color getColor(String color)
   {
     if (color.charAt(0) == '#') {
       color = color.substring(1);
     }
     if (color.length() != 6) {
       return null;
     }
     try
     {
       int r = Integer.parseInt(color.substring(0, 2), 16);
       int g = Integer.parseInt(color.substring(2, 4), 16);
       int b = Integer.parseInt(color.substring(4), 16);
       return new Color(r, g, b); } catch (NumberFormatException nfe) {
     }
     return null;
   }

   public static Set<Integer> randomInt(int a, int length)
   {
     Set list = new TreeSet();
     int size = length;
     if (length > a) {
       size = a;
     }
     while (list.size() < size) {
       Random random = new Random();
       int b = random.nextInt(a);
       list.add(Integer.valueOf(b));
     }
     return list;
   }

   public static Double formatDouble(Object obj, int len)
   {
     Double ret = Double.valueOf(0.0D);
     String format = "0.0";
     for (int i = 1; i < len; i++) {
       format = format + "0";
     }
     DecimalFormat df = new DecimalFormat(format);
     return Double.valueOf(df.format(obj));
   }

   public static boolean isChinese(char c)
   {
     Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);

     return (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) ||
       (ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) ||
       (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) ||
       (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) ||
       (ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) ||
       (ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
   }

   public static boolean isMessyCode(String strName)
   {
     Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
     Matcher m = p.matcher(strName);
     String after = m.replaceAll("");
     String temp = after.replaceAll("\\p{P}", "");
     char[] ch = temp.trim().toCharArray();
     float chLength = ch.length;
     float count = 0.0F;
     for (int i = 0; i < ch.length; i++) {
       char c = ch[i];
       if (Character.isLetterOrDigit(c)){
         continue;
       }

       if (!isChinese(c)) {
         count += 1.0F;
         System.out.print(c);
       }
     }

     float result = count / chLength;

     return result > 0.4D;
   }

   public static String trimSpaces(String IP)
   {
     while (IP.startsWith(" ")) {
       IP = IP.substring(1, IP.length()).trim();
     }
     while (IP.endsWith(" ")) {
       IP = IP.substring(0, IP.length() - 1).trim();
     }
     return IP;
   }

   public static boolean isIp(String IP)
   {
     boolean b = false;
     IP = trimSpaces(IP);
     if (IP.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
       String[] s = IP.split("\\.");
       if ((Integer.parseInt(s[0]) < 255) && (Integer.parseInt(s[1]) < 255) &&
            (Integer.parseInt(s[2]) < 255) &&(Integer.parseInt(s[3]) < 255)) {
         b = true;
       }
     }
     return b;
   }

   public static String generic_domain(HttpServletRequest request)
   {
     String system_domain = "localhost";
     String serverName = request.getServerName();
     if (isIp(serverName)){
       system_domain = serverName;
     } else {
       system_domain = serverName.substring(serverName.indexOf(".") + 1);
     }

     return system_domain;
   }

   public static Map saveFileToServer(HttpServletRequest request, String filePath, String saveFilePathName, String saveFileName, String[] extendes)
           throws IOException
   {
     MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
     CommonsMultipartFile file = (CommonsMultipartFile)multipartRequest.getFile(filePath);
     Map map = new HashMap();
     if ((file != null) && (!file.isEmpty()))
     {
       String extend = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
       if ((saveFileName == null) || (saveFileName.trim().equals(""))) {
         saveFileName = UUID.randomUUID().toString() + "." + extend;
       }
       if (saveFileName.lastIndexOf(".") < 0) {
         saveFileName = saveFileName + "." + extend;
       }
       float fileSize = Float.valueOf((float)file.getSize()).floatValue();
       List errors = new ArrayList();
       boolean flag = true;
       if (extendes != null) {
         for (String s : extendes) {
           if (extend.toLowerCase().equals(s))
             flag = true;
         }
       }
       if (flag) {
         File path = new File(saveFilePathName);
         if (!path.exists()) {
           path.mkdir();
         }
         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
         DataOutputStream out = new DataOutputStream(
                 new FileOutputStream(saveFilePathName + File.separator + saveFileName));
         InputStream is = null;
         try {
           is = file.getInputStream();
           int size = (int)fileSize;
           byte[] buffer = new byte[size];
           while (is.read(buffer) > 0)
             out.write(buffer);
         }
         catch (IOException exception) {
           exception.printStackTrace();
         } finally {
           if (is != null) {
             is.close();
           }
           if (out != null) {
             out.close();
           }
         }
         if (isImg(extend)) {
           File img = new File(saveFilePathName + File.separator + saveFileName);
           try {
             BufferedImage bis = ImageIO.read(img);
             int w = bis.getWidth();
             int h = bis.getHeight();
             map.put("width", Integer.valueOf(w));
             map.put("height", Integer.valueOf(h));
           }
           catch (Exception localException)
           {
           }
         }
         map.put("mime", extend);
         map.put("fileName", saveFileName);
         map.put("fileSize", Float.valueOf(fileSize));
         map.put("error", errors);
         map.put("oldName", file.getOriginalFilename());
       }
       else
       {
         errors.add("不允许的扩展名");
       }
     } else {
       map.put("width", Integer.valueOf(0));
       map.put("height", Integer.valueOf(0));
       map.put("mime", "");
       map.put("fileName", "");
       map.put("fileSize", Float.valueOf(0.0F));
       map.put("oldName", "");
     }
     return map;
   }


   public static PageModel createPageModel(int pageNow, int count , T pList, int pages){
     PageModel<Object> page = new PageModel();
     page.setCurrentPage(pageNow);
     page.setResult(pList);
     page.setRowCount(count);
     page.setPages(pages);
     return page;
   }
 }

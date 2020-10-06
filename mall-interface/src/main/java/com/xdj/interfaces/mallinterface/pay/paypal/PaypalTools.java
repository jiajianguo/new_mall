 package com.xdj.interfaces.mallinterface.pay.paypal;

 import com.xdj.www.core.domain.virtual.SysMap;
 import com.xdj.www.core.tools.CommUtil;


 import java.util.List;


 public class PaypalTools
 {
   public static String buildForm(List<SysMap> list)
   {
     StringBuffer sb = new StringBuffer();
     sb.append("<body onLoad=\"javascript:document.paypal.submit()\">");
     sb
       .append("<form id=\"paypalForm\" action=\"https://www.paypal.com/cgi-bin/webscr\" method=\"POST\" name=\"paypal\" >");
     for (SysMap sm : list) {
       sb.append("<input type=\"hidden\" name=\"" +
         CommUtil.null2String(sm.getKey()) + "\"    value=\"" +
         CommUtil.null2String(sm.getValue()) + "\" size=\"100\">");
     }
     sb.append("</form><body>");
     return sb.toString();

   }
 }





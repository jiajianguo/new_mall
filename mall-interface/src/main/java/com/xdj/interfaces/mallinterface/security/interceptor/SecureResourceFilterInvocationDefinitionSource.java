 package com.xdj.interfaces.mallinterface.security.interceptor;


 import java.util.Collection;
 import java.util.Map;
 import javax.servlet.ServletContext;
 import org.springframework.beans.factory.InitializingBean;
 import org.springframework.security.web.FilterInvocation;

 public class SecureResourceFilterInvocationDefinitionSource implements InitializingBean{

   public Collection getConfigAttributeDefinitions()
   {
     return null;
   }

   public boolean supports(Class clazz)
   {
     return true;
   }

   private Map<String, String> getUrlAuthorities(FilterInvocation filterInvocation)
   {
     ServletContext servletContext = filterInvocation.getHttpRequest()
       .getSession().getServletContext();
     return (Map)servletContext
       .getAttribute("urlAuthorities");
   }

     @Override
     public void afterPropertiesSet() throws Exception {

     }
 }


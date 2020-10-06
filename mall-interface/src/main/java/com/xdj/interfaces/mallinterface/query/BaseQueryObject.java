package com.xdj.interfaces.mallinterface.query;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author Administrator
 */
public class BaseQueryObject extends QueryObject {


  public BaseQueryObject(String currentPage, ModelAndView mv, String orderBy, String orderType)
  {
    super(currentPage, mv, orderBy, orderType);
  }

  @Override
  public String getQuery()
  {
    return super.getQuery();
  }

}

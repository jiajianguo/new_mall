package com.xdj.interfaces.mallinterface.query;

import com.xdj.www.core.domain.virtual.SysMap;

import java.util.Map;

public abstract interface IQueryObject
{
  public abstract String getQuery();

  public abstract Map getParameters();

  public abstract PageObject getPageObj();

  public abstract IQueryObject addQuery(String paramString, Map paramMap);

  public abstract IQueryObject addQuery(String paramString1, SysMap paramSysMap, String paramString2);

  public abstract IQueryObject addQuery(String paramString1, Object paramObject, String paramString2, String paramString3);
}

package com.xdj.www.core.exception;


/**
 * @author Administrator
 */
public class CanotRemoveObjectException extends RuntimeException{
  private static final long serialVersionUID = 1L;

  @Override
  public void printStackTrace()
  {
    System.out.println("删除对象错误!");
    super.printStackTrace();
  }
}

package com.xdj.interfaces.mallinterface.mv;


import lombok.Getter;
import lombok.Setter;

/**
 * @author Administrator
 */
@Getter
@Setter
public class PageModel<T> {
    private int rowCount;
    private T result;
    private int pages;
    private int pageSize;
    private int currentPage;
}

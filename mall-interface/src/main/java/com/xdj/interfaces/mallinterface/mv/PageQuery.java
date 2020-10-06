package com.xdj.interfaces.mallinterface.mv;

import com.xdj.www.entity.ShoppingGoodsWithBLOBs;
import org.apache.lucene.search.Sort;

/**
 * @author Administrator
 */
public class PageQuery {
    private int  pageNow;
    private ShoppingGoodsWithBLOBs goods;
    private int pageSize;
    private Sort  sort;

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public ShoppingGoodsWithBLOBs getGoods() {
        return goods;
    }

    public void setGoods(ShoppingGoodsWithBLOBs goods) {
        this.goods = goods;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }
}

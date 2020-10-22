package com.xdj.interfaces.mallinterface.controller.shop;

import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.www.core.tools.CommUtil;
import com.xdj.www.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@RestController
public class FavoriteController {

    @Resource
    private IFavoriteService favoriteService;
    @Resource
    private IGoodsService goodsService;

    @Autowired
    private IStoreService storeService;
    public static Logger log= LoggerFactory.getLogger("favorite");

    @RequestMapping({"/add_goods_favorite.htm"})
    public void add_goods_favorite(HttpServletResponse response, String id) {
        ShoppingFavoriteExample example = new ShoppingFavoriteExample();
        example.createCriteria()
                .andUserIdEqualTo(SecurityUserHolder.getCurrentUser().getId())
                .andGoodsIdEqualTo(CommUtil.null2Long(id));
        List<ShoppingFavorite> list =  this.favoriteService.selectExample(example);
        int ret = 0;
        if (list == null || list.size() < 1) {
            ShoppingGoodsWithBLOBs goods = this.goodsService.getObjById(CommUtil.null2Long(id));
            ShoppingFavorite obj = new ShoppingFavorite();
            obj.setAddtime(new Date());
            obj.setType(0);
            obj.setUserId(SecurityUserHolder.getCurrentUser().getId());
            obj.setGoodsId(goods.getId());
            obj.setDeletestatus(false);
            this.favoriteService.save(obj);
            goods.setGoodsCollect(goods.getGoodsCollect() + 1);
            log.info("----info---{}",goods.getGoodsCollect());
            this.goodsService.update(goods);
        } else {
            ret = 1;
        }
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try
        {
            PrintWriter writer = response.getWriter();
            writer.print(ret);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping({"/add_store_favorite.htm"})
    public void add_store_favorite(HttpServletResponse response, String id) {

        ShoppingFavoriteExample example = new ShoppingFavoriteExample();
        example.createCriteria()
                .andUserIdEqualTo(SecurityUserHolder.getCurrentUser().getId())
                .andStoreIdEqualTo(CommUtil.null2Long(id));
        List<ShoppingFavorite> list = this.favoriteService.selectExample(example);

        int ret = 0;
        if (list.size() == 0) {
            ShoppingFavorite obj = new ShoppingFavorite();
            obj.setAddtime(new Date());
            obj.setType(1);
            obj.setUserId(SecurityUserHolder.getCurrentUser().getId());
            obj.setStoreId(CommUtil.null2Long(id));
            obj.setDeletestatus(false);
            this.favoriteService.save(obj);
            ShoppingStoreWithBLOBs store = storeService.getObjById(CommUtil.null2Long(id));
            store.setFavoriteCount(store.getFavoriteCount() + 1);
            this.storeService.update(store);
        } else {
            ret = 1;
        }
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try
        {
            PrintWriter writer = response.getWriter();
            writer.print(ret);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

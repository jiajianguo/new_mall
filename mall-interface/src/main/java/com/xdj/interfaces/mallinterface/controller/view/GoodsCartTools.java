package com.xdj.interfaces.mallinterface.controller.view;

import com.xdj.interfaces.mallinterface.service.IGoodsCartService;
import com.xdj.interfaces.mallinterface.service.IGoodsService;
import com.xdj.interfaces.mallinterface.service.IOrderFormService;
import com.xdj.interfaces.mallinterface.service.IUserService;
import com.xdj.www.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Component
public class GoodsCartTools {
    @Resource
    private IGoodsCartService goodsCartService;
    @Resource
    private IGoodsService goodsService;
    @Resource
    private IUserService userService;
    @Resource
    private IOrderFormService orderFormService;
    @Resource
    private AccessoryViewTools accessoryViewTools;
    private  Logger log = LoggerFactory.getLogger(this.getClass());



    public final void addOfUser(ShoppingGoodscart gc){
        if ((gc.getOfId() != null)) {
            ShoppingOrderformWithBLOBs of = orderFormService.getObjById(gc.getOfId());
            if(of.getUserId()!=null){
                ShoppingUser user = userService.getObjById(of.getUserId());
                of.setUser(user);
            }
            gc.setOf(of);
        }

    }

    public final  void  addGcs(ShoppingStorecart sc) {
        if(sc != null ){
            Map<String,Object> params = new HashMap<String,Object>();
            params.put("sc_id",sc.getId());
            params.put("deleteStatus",0);
            List<ShoppingGoodscart> gcs = goodsCartService.queryByCondition(params);
            sc.setGcs(gcs);
        }

    }
    /*public void  addGcss(ShoppingStorecart sc) {
        if(sc != null ){
            Map<String,Object> params = new HashMap<String,Object>();
            params.put("sc_id",sc.getId());
            List<ShoppingGoodscart> gcs = goodsCartService.queryByCondition(params);
            sc.setGcs(gcs);
        }
    }*/



    public void  addGcss(ShoppingStorecart sc) {
        if(sc != null ){
            Map<String,Object> params = new HashMap<String,Object>();
            params.put("sc_id",sc.getId());
            List<ShoppingGoodscart> gcs = goodsCartService.queryByCondition(params);
            for (ShoppingGoodscart gc : gcs) {
                log.info("--------遍历goodscart-----------");
                ShoppingGoodsWithBLOBs goods = goodsService.getObjById(gc.getGoodsId());
                if( "combin".equals(gc.getCartType())){
                    List<ShoppingGoodsWithBLOBs> combins=goodsService.getCombinGoods(goods.getId());
                    goods.setCombin_goods(combins);
                }
                accessoryViewTools.addMainPhoto(goods);
                gc.setGoods(goods);
            }
            sc.setGcs(gcs);
        }
    }

    public void insertGcs(List<ShoppingStorecart> scs){
        if(scs.size() >0){
            for(ShoppingStorecart s: scs){
                addGcss(s);
            }
        }
    }

    public void addOrderGcs(ShoppingOrderformWithBLOBs order) {
        if(order != null){
            Map<String,Object> para = new HashMap<>();
            para.put("of_id",order.getId());
            para.put("deleteStatus",true);
            List<ShoppingGoodscart> gcs = goodsCartService.queryByCondition(para);
            for(ShoppingGoodscart gc: gcs){
                ShoppingGoodsWithBLOBs goods = goodsService.getObjById(gc.getGoodsId());
                accessoryViewTools.addMainPhoto(goods);
                gc.setGoods(goods);
            }
            order.setGcs(gcs);
        }
    }

    public void addSc(ShoppingGoodscart gc) {
        if(gc != null){

        }
    }
}

package com.xdj.interfaces.mallinterface.controller.view;

import com.xdj.interfaces.mallinterface.service.IAccessoryService;
import com.xdj.interfaces.mallinterface.service.IIntegralGoodsOrderService;
import com.xdj.interfaces.mallinterface.service.IIntegralGoodsService;
import com.xdj.www.entity.ShoppingIntegralGoods;
import com.xdj.www.entity.ShoppingIntegralGoodscart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Component
public class IntegralViewTools {
    @Resource
    private IAccessoryService accessoryService;
    @Resource
    private IIntegralGoodsService integralGoodsService;
    @Resource
    private IIntegralGoodsOrderService integralGoodsOrderService;
    private Logger log = LoggerFactory.getLogger("IntegralTool");

    /**
     * 积分商品订单
     * @param carts
     */
    public final void addOrders(List<ShoppingIntegralGoodscart> carts){
        if(carts != null){
            for(ShoppingIntegralGoodscart cart: carts){
                addOrder(cart);
            }
        }
    }

    private void addOrder(ShoppingIntegralGoodscart cart) {
        if(cart != null){
            if(cart.getOrderId() != null){
                cart.setOrder(integralGoodsOrderService.getObjById(cart.getOrderId()));
            }
        }
    }

    /**
     * 添加积分商品主图
     * @param integral
     */
    public final void addGoodsImg(ShoppingIntegralGoods integral){
        if(integral != null && integral.getIgGoodsImgId() != null){
            integral.setIgGoodsImg(accessoryService.getObjById(integral.getIgGoodsImgId()));
        }
    }

    /**
     * 添加多个积分商品主图
     * @param integrals
     */
    public final  void addGoodsImgs(List<ShoppingIntegralGoods> integrals){
        if(integrals != null){
            for(ShoppingIntegralGoods s: integrals){
                addGoodsImg(s);
            }
        }
    }

    /**
     * 添加多个积分商品
     * @param carts
     */
    public final void goodscartAddIntegralGoods(List<ShoppingIntegralGoodscart> carts){
        if(carts != null){
            for( ShoppingIntegralGoodscart  cart: carts){
                goodscartAddGoods(cart);
            }
        }
    }

    /**
     * 添加单个积分商品
     * @param cart
     */
    public final void  goodscartAddGoods(ShoppingIntegralGoodscart cart){
        if(cart != null){
            ShoppingIntegralGoods goods= integralGoodsService.getObjById(cart.getGoodsId());
            addGoodsImg(goods);
            cart.setGoods(goods);
        }
    }


}

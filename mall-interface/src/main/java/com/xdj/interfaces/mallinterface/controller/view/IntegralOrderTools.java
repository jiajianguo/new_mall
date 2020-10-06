package com.xdj.interfaces.mallinterface.controller.view;

import com.xdj.interfaces.mallinterface.service.IIntegralGoodsCartService;
import com.xdj.interfaces.mallinterface.service.IIntegralGoodsService;
import com.xdj.www.entity.ShoppingIntegralGoods;
import com.xdj.www.entity.ShoppingIntegralGoodscart;
import com.xdj.www.entity.ShoppingIntegralGoodsorderWithBLOBs;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Component
public class IntegralOrderTools {
    @Resource
    private IIntegralGoodsCartService iIntegralGoodsCartService;
    @Resource
    private IIntegralGoodsService integralGoodsService;
    @Resource
    private AccessoryViewTools accessoryViewTools;


    public void addGoodsorderGcs(List<ShoppingIntegralGoodsorderWithBLOBs> pList,boolean isAddGoods) {
        if(pList != null){
            for(ShoppingIntegralGoodsorderWithBLOBs s: pList){
                addGoodsorderGc(s,isAddGoods);
            }
        }
    }

    public void addGoodsorderGc(ShoppingIntegralGoodsorderWithBLOBs order,boolean isAddGoods) {
        if(order != null){
            Map<String,Object> params = new HashMap<>();
            params.put("order_id",order.getId());
            List<ShoppingIntegralGoodscart> ls = iIntegralGoodsCartService.queryByCondition(params);
            if(ls != null && isAddGoods){
                for(ShoppingIntegralGoodscart s: ls){
                    ShoppingIntegralGoods goods =  integralGoodsService.getObjById(s.getGoodsId());
                    if(goods.getIgGoodsImgId() != null){
                        accessoryViewTools.addIntegralGoodsImg(goods);
                    }
                    s.setGoods(goods);
                }

            }
        }
    }
}

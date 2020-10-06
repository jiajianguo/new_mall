package com.xdj.interfaces.mallinterface.controller.view;

import com.xdj.interfaces.mallinterface.service.IGoodsSpecPropertyService;
import com.xdj.www.entity.ShoppingGoodscart;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
@Component
public class GoodsSpecPropertyTools {
    @Resource
    private IGoodsSpecPropertyService goodsSpecPropertyService;

    public void addGsps(ShoppingGoodscart gc) {
        if (gc != null && gc.getGoodsId() != null){
            Map<String,Object> params = new HashMap<>();
            params.put("goods_id",gc.getGoodsId());
            gc.setGsps(goodsSpecPropertyService.queryByConditoin(params));
        }
    }
}

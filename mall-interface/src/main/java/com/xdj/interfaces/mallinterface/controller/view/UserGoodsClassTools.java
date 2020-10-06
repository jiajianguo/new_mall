package com.xdj.interfaces.mallinterface.controller.view;

import com.xdj.interfaces.mallinterface.service.IUserGoodsClassService;
import com.xdj.www.entity.ShoppingUsergoodsclass;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Component
public class UserGoodsClassTools {
    @Resource
    private IUserGoodsClassService userGoodsClassService;


    public final void addChild(ShoppingUsergoodsclass gc){
        Map<String,Object> para = new HashMap<String,Object>();
        para.put("parent_id","= ".concat(gc.getId().toString()));
        List<ShoppingUsergoodsclass>  childs = userGoodsClassService.queryByCondition(para);
        gc.setChilds(childs);
    }

    public final void addParent(ShoppingUsergoodsclass gc){

    }

    public final void addChilds(List<ShoppingUsergoodsclass> gcs){
        if(gcs != null){
            for(ShoppingUsergoodsclass s: gcs){
                addChild(s);
            }
        }
    }
}

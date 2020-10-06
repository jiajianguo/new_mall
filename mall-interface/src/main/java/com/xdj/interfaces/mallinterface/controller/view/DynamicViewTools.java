package com.xdj.interfaces.mallinterface.controller.view;

import com.xdj.interfaces.mallinterface.service.IDynamicService;
import com.xdj.www.entity.ShoppingDynamic;
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
public class DynamicViewTools {
    @Resource
    private IDynamicService dynamicService;
    @Resource
    private UserViewTools  userViewTools;

    public final void addChilds(List<ShoppingDynamic> list,boolean flag){
        if(list != null){
            for(ShoppingDynamic s: list){
                addChild(s,flag);
            }
        }
    }

    public final void addChild (ShoppingDynamic s,boolean flag){
        if(s != null){
            Map<String,Object> params = new HashMap<>();
            params.put("dissParent_id","=".concat(s.getId()+""));
            List<ShoppingDynamic> childs = dynamicService.pageList(params);
            if(flag){
                for(ShoppingDynamic d: childs){
                    userViewTools.addDynamicUsers(childs,flag);
                }
            }
            s.setChilds(childs);
        }
    }
}

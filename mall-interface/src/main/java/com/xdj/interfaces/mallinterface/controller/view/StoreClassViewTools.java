package com.xdj.interfaces.mallinterface.controller.view;

import com.xdj.interfaces.mallinterface.service.IStoreClassService;
import com.xdj.www.entity.ShoppingStoreWithBLOBs;
import com.xdj.www.entity.ShoppingStoreclass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Component
public class StoreClassViewTools {
    @Resource
    private IStoreClassService storeClassService;

    private final Logger log =LoggerFactory.getLogger("storeclass");

    public final  void addScs(List<ShoppingStoreWithBLOBs> pList,boolean isParent,boolean isChilds) {
        if(pList != null){
            for(ShoppingStoreWithBLOBs s: pList){
                addSc(s,isParent,isChilds);
            }
        }
    }

    public final  void addSc(ShoppingStoreWithBLOBs s,boolean isParent,boolean isChilds){
        if(s != null){
            ShoppingStoreclass c = storeClassService.getObjById(s.getScId());
            if(isParent ){
                addParent(c);
            }
            if(isChilds){
                addChild(c);
            }
            s.setSc(c);
        }
    }

    public final void addChild(ShoppingStoreclass sc) {
        if(sc != null){
            Map<String,Object> params = new HashMap<>();
            params.put("parent_id","=".concat(sc.getId().toString()));
            List<ShoppingStoreclass> childs = storeClassService.queryByCondition(params);
            sc.setChilds(childs);
        }
    }

    public final  void addParent(ShoppingStoreclass sc){
        if(sc != null && sc.getParentId() != null){
            sc.setParent(storeClassService.getObjById(sc.getParentId()));
        }
    }
}

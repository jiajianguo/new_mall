package com.xdj.interfaces.mallinterface.controller.view;

import com.xdj.interfaces.mallinterface.service.IAccessoryService;
import com.xdj.www.entity.ShoppingGoodsbrand;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Component
public class BrandViewTools {
    @Resource
    private IAccessoryService accessoryService;
    /**
     * 添加logo 图片
     * @param brand
     */
    public final void addLogo(ShoppingGoodsbrand brand){
        if(brand != null){
            if(brand.getBrandlogoId() != null){
               brand.setBrandLogo(accessoryService.getObjById(brand.getBrandlogoId()));
            }
        }
    }

    public void addLogos(List<ShoppingGoodsbrand> gbs) {
        if(gbs != null){
            for(ShoppingGoodsbrand s: gbs){
                addLogo(s);
            }
        }
    }
}

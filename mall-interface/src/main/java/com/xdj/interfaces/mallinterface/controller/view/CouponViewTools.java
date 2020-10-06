package com.xdj.interfaces.mallinterface.controller.view;

import com.xdj.interfaces.mallinterface.service.ICouponService;
import com.xdj.www.entity.ShoppingCouponInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Component
public class CouponViewTools {
    @Resource
    private ICouponService couponService;

    public void addInfoCoupons(List<ShoppingCouponInfo> pList) {
        if(pList != null){
            for(ShoppingCouponInfo info : pList){
                addInfoCoupon(info);
            }
        }
    }

    public void addInfoCoupon(ShoppingCouponInfo info) {
        if(info != null){
            info.setCoupon(couponService.getObjById(info.getCouponId()));
        }
    }
}

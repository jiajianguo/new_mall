package com.xdj.interfaces.mallinterface.controller.view;


import com.xdj.interfaces.mallinterface.service.IGoodsReturnItemService;
import com.xdj.interfaces.mallinterface.service.IGoodsReturnLogService;
import com.xdj.interfaces.mallinterface.service.IGoodsReturnService;
import com.xdj.interfaces.mallinterface.service.IRefundLogService;
import com.xdj.www.entity.ShoppingGoodsReturn;
import com.xdj.www.entity.ShoppingGoodsReturnlog;
import com.xdj.www.entity.ShoppingOrderformWithBLOBs;
import com.xdj.www.entity.ShoppingRefundLog;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 退款退货信息
 * @author Administrator
 */
@Component
public class RefundViewTools {
    @Resource
    private IRefundLogService refundLogService;
    @Resource
    private IGoodsReturnLogService goodsReturnLogService;
    @Resource
    private IGoodsReturnService goodsReturnService;
    @Resource
    private IGoodsReturnItemService goodsReturnItemService;
    @Resource
    private UserViewTools userViewTools;


    public void addOrderRefund(ShoppingOrderformWithBLOBs obj) {
        if(obj != null){
            Map<String,Object> params = new HashMap<>();
            params.put("of_id",obj.getId());
            List<ShoppingRefundLog> logs = refundLogService.queryByCondition(params);
            if(logs != null){
                for(ShoppingRefundLog log: logs){
                    userViewTools.addRefundLogUser(log);
                }
            }
            obj.setRls(logs);
        }
    }


    public void addOrderGrls(ShoppingOrderformWithBLOBs obj) {
        if(obj != null ){
            Map<String,Object> params = new HashMap<>();
            params.put("of_id",obj.getId());
            List<ShoppingGoodsReturnlog> logs = goodsReturnLogService.queryByCondition(params);
            if(logs != null){
                for(ShoppingGoodsReturnlog log: logs){
                    ShoppingGoodsReturn gr = goodsReturnService.getObjById(log.getGrId());
                    if(gr != null){
                        Map<String,Object> para = new HashMap<>();
                        para.put("gr_id",gr.getId());
                        gr.setItems(goodsReturnItemService.queryByCondition(para));
                    }
                    log.setGr(gr);
                }
            }
            obj.setGrls(logs);
        }
    }
}

package com.xdj.interfaces.mallinterface.controller.view;

import com.xdj.interfaces.mallinterface.service.IUserService;
import com.xdj.www.entity.*;
import com.xdj.www.core.tools.CommUtil;

import org.springframework.security.core.session.SessionRegistry;
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
public class UserViewTools {

    @Resource
    private IUserService userService;
    @Resource
    private AccessoryViewTools accessoryViewTools;

    public final void addDynamicUser(ShoppingDynamic dynamic,boolean flag){
        if(dynamic != null && dynamic.getUserId() != null){
           ShoppingUser user=userService.getObjById(dynamic.getUserId());
            if(flag){
                accessoryViewTools.addUserHeadImg(user);
            }
            dynamic.setUser(user);
        }
    }

    public final void addDynamicUsers(List<ShoppingDynamic> dynamics,boolean flag){
        if(dynamics != null ){
            for(ShoppingDynamic s: dynamics){
               addDynamicUser(s,flag);
            }
        }
    }

    public void addVisitsUsers(List<ShoppingVisit> visits,boolean isPhoto) {
        if(visits != null){
            for(ShoppingVisit s: visits){
                addVisitsUser(s,isPhoto);
            }
        }
    }

    public void addVisitsUser(ShoppingVisit visits, boolean isPhoto ) {
        if(visits != null && visits.getUserId() != null){
            ShoppingUser user = userService.getObjById(visits.getUserId());
            if(isPhoto){
                accessoryViewTools.addUserHeadImg(user);
            }
            visits.setUser(user);
        }
    }

    public void addIntegralOrdUser(ShoppingIntegralGoodsorderWithBLOBs obj) {
        if(obj != null && obj.getIgoUserId() != null){
            obj.setIgo_user(userService.getObjById(obj.getIgoUserId()));
        }
    }

    public void addEvalUsers(List<ShoppingEvaluateWithBLOBs> pList) {
        if(pList != null){
            for(ShoppingEvaluateWithBLOBs s: pList){
                addEvalUser(s);
            }
        }
    }

    public void addEvalUser(ShoppingEvaluateWithBLOBs eval) {
        if(eval != null && eval.getEvaluateUserId() != null){
            eval.setEvaluate_user(userService.getObjById(eval.getEvaluateUserId()));
        }
    }

    public void addConsultUsers(List<ShoppingConsultWithBLOBs> consults) {
        if(consults != null){
            for(ShoppingConsultWithBLOBs s: consults){
                addConsultUser(s);
            }
        }
    }

    public void addConsultUser(ShoppingConsultWithBLOBs consult) {
        if(consult != null && consult.getConsultUserId() != null){
            consult.setConsult_user(userService.getObjById(consult.getConsultUserId()));
        }
        if(consult != null && consult.getReplyUserId() != null){
            consult.setReply_user(userService.getObjById(consult.getReplyUserId()));
        }
    }

    public void addFriendUsers(List<ShoppingUserFriend> pList) {
        if(pList!=null&pList.size()>0){
            for (ShoppingUserFriend friend : pList) {
                addFrienduser(friend);
            }
        }
    }

    private void addFrienduser(ShoppingUserFriend friend) {
        if(friend.getFromuserId()!=null){
            ShoppingUser fromuser = userService.getObjById(friend.getFromuserId());
            accessoryViewTools.addUserHeadImg(fromuser);
            friend.setFrom_user(fromuser);
        }
        if(friend.getFromuserId()!=null){
            ShoppingUser touser = userService.getObjById(friend.getFromuserId());
            accessoryViewTools.addUserHeadImg(touser);
            friend.setFrom_user(touser);
        }
    }

    public final  void addOrderLogUser(ShoppingOrderLog log) {
        if(log != null && log.getLogUserId() != null){
            log.setLog_user(userService.getObjById(log.getLogUserId()));
        }
    }

    public void addRefundLogUser(ShoppingRefundLog log) {
        if(log != null){
            log.setRefund_user(userService.getObjById(log.getRefundUserId()));
        }
    }

    public final void addOrderUser(ShoppingOrderformWithBLOBs of) {
       if(of != null && of.getUserId() != null){
            of.setUser(userService.getObjById(of.getUserId()));
        }
    }

    public final  void addStoreUsers(List<ShoppingStoreWithBLOBs> pList) {
        if(pList != null ){
           for(ShoppingStoreWithBLOBs s: pList){
               addStoreUser(s);
           }
        }
    }

    public final  void addStoreUser(ShoppingStoreWithBLOBs s) {
        if(s != null ){
           s.setUser(userService.queryOneByStoreId(s.getId()));
        }
    }
}

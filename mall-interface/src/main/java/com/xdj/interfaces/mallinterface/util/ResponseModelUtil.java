package com.xdj.interfaces.mallinterface.util;

import com.alibaba.fastjson.JSONObject;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.www.core.constant.ResponseModel;
import com.xdj.www.entity.ShoppingSysconfig;
import com.xdj.www.entity.ShoppingUserconfig;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 */
public class ResponseModelUtil {


    /**
     * 返回模板数据封装
     * @param config
     * @param uconfig
     * @param type
     * @param request
     * @return
     */
    public final static ResponseModel<JSONObject> getRes(ShoppingSysconfig config,ShoppingUserconfig uconfig,int type,HttpServletRequest request){
        ResponseModel<JSONObject> res = new ResponseModel<JSONObject>();
        JSONObject resData = new JSONObject();
        resData.put("config",config);
        resData.put("uconfig",uconfig);
        resData.put("suer", SecurityUserHolder.getCurrentUser().getId());
        res.setData(resData);
        return res;
    }
}

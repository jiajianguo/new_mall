package com.xdj.interfaces.mallinterface.controller.shop;

import com.alipay.api.AbstractAlipayClient;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 */

@RestController
public class AlipayController {

    /**
     * 统一下单并支付接口
     *
     */
    @RequestMapping("pay")
    public final void pay(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient("", "", "", "", "", "", "");
        AlipayTradePrecreateRequest req = new AlipayTradePrecreateRequest();
        req.setBizContent("");
        req.setNotifyUrl("");
        alipayClient.execute(req);
    }
}

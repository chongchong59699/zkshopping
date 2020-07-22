package com.qf.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.qf.annotation.TokenValidate;
import com.qf.config.AlipayConfig;
import com.qf.dto.CommitOrderDto;
import com.qf.pojo.AlipayBean;
import com.qf.service.OrderService;
import com.qf.service.PayService;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 订单接口 */
@CrossOrigin
@RestController()
@RequestMapping("api/order")
@Api(tags = "订单控制器")
public class OrderController {
    @Autowired
    private PayService payService;//调用支付服务
    @Autowired
    private OrderService orderService;

    /*阿里支付*/

    /**
     * 下单
     * @param out_trade_no
     * @param subject
     * @param total_amount
     * @param body
     * @param cod
     * @return
     * @throws AlipayApiException
     */
    @PostMapping(value = "alipay")
    public String alipay(String out_trade_no, String subject, String total_amount, String body, CommitOrderDto cod) throws AlipayApiException {
        return payService.aliPay(new AlipayBean()
                .setBody(body)
                .setOut_trade_no(out_trade_no)
                .setTotal_amount(new StringBuffer().append(total_amount))
                .setSubject(subject),cod);
    }
    @GetMapping(value = "getOrdersByUserId/{userId}")
    public R getOrdersByUserId(@PathVariable int userId){
        return orderService.getOrdersByUserId(userId);
    }
    @GetMapping(value = "getOrderByOrderId/{orderId}")
    public R getOrderByOrderId(@PathVariable String orderId){
        return orderService.getOrderByOrderId(orderId);
    }

    /**
     * 支付宝服务器异步通知
     *
     * @param request
     * @throws Exception
     */
    @ResponseBody
    @PostMapping("/notifyUrl")
    public void notifyUrl(HttpServletRequest request) throws Exception {
        orderService.notifyUrl(request);
    }

}
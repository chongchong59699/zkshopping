package com.qf.controller;

import com.alipay.api.AlipayApiException;
import com.qf.annotation.TokenValidate;
import com.qf.dto.CommitOrderDto;
import com.qf.pojo.AlipayBean;
import com.qf.service.OrderService;
import com.qf.service.PayService;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/* 订单接口 */
@CrossOrigin
@RestController()
@RequestMapping("/order")
@Api(tags = "订单支付控制器")
public class OrderController {
    @Autowired
    private PayService payService;//调用支付服务
    @Autowired
    private OrderService orderService;

    /*阿里支付*/

    @PostMapping(value = "alipay")
    public String alipay(String out_trade_no, String subject, String total_amount, String body, CommitOrderDto cod) throws AlipayApiException {
        return payService.aliPay(new AlipayBean()
                .setBody(body)
                .setOut_trade_no(out_trade_no)
                .setTotal_amount(new StringBuffer().append(total_amount))
                .setSubject(subject),cod);
    }
    @GetMapping(value = "getOrdersByUserId/{userid}")
    public R getOrdersByUserId(@PathVariable int userid){
        return orderService.getOrdersByUserId(userid);
    }
}
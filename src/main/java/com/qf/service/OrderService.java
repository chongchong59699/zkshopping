package com.qf.service;

import com.alipay.api.AlipayApiException;
import com.qf.dto.CommitOrderDto;
import com.qf.vo.R;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: OrderService
 * @Author: 刘嘉豪
 * @Date: 2020/7/20
 * @Time: 20:25
 */
public interface OrderService {

    R addOrder(CommitOrderDto cod);

    R getOrdersByUserId(String token);
    void notifyUrl(HttpServletRequest request) throws Exception;

    R getOrderByOrderId(String orderId,String token);
}

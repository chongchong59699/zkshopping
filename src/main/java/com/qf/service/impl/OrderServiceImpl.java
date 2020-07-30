package com.qf.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.qf.config.AlipayConfig;
import com.qf.dao.OrderDao;
import com.qf.dto.CommitOrderDto;
import com.qf.pojo.User;
import com.qf.service.OrderService;
import com.qf.util.JedisCore;
import com.qf.util.JedisUtil;
import com.qf.util.TokenUtil;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName: OrderServiceImpl
 * @Author: 刘嘉豪
 * @Date: 2020/7/20
 * @Time: 20:26
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private JedisCore jedisCore;
    //private JedisCore jedisCore= JedisUtil.getJedisCore();
    @Override
    public R addOrder(CommitOrderDto cod) {
        return R.ok(orderDao.addOrder(cod));
    }

    @Override
    public R getOrdersByUserId(String token,int status) {
        User user = TokenUtil.getUserFromToken(token, jedisCore);
        if(user!=null) {
            return R.ok(orderDao.getOrdersByUserId(user.getId(),status));
        }else {
            return R.error("请重新登录");
        }

    }

    @Override
    public void notifyUrl(HttpServletRequest request) throws Exception {
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        System.out.println(params);

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.sign_type); // 调用SDK验证签名

        if (signVerified) { // 验证成功 更新订单信息
            System.out.println("异步通知成功");
            // 商户订单号
            String out_trade_no = request.getParameter("out_trade_no");
            // 交易状态
            String trade_status = request.getParameter("trade_status");
            //订单创建时间
            String gmt_create = request.getParameter("gmt_create");
            //订单付款时间
            String gmt_payment = request.getParameter("gmt_payment");


            // 修改数据库
            if("TRADE_SUCCESS".equals(trade_status)){
                //System.out.println("订单支付成功，数据库修改");
                int i=orderDao.updateOrderStatus(out_trade_no,gmt_create,gmt_payment);
                //System.out.println(i);
            }

        } else {
            System.out.println("异步通知失败");
        }
    }

    @Override
    public R getOrderByOrderId(String orderId,String token) {
        User user = TokenUtil.getUserFromToken(token, jedisCore);
        if(user!=null) {
            return R.ok(orderDao.getOrderByOrderId(orderId, user.getId()));
        }else {
            return R.error("请重新登录");
        }
    }
}

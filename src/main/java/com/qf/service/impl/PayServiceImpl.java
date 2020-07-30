package com.qf.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.qf.dao.OrderDao;
import com.qf.dao.UserDao;
import com.qf.dto.CommitOrderDto;
import com.qf.pojo.AlipayBean;
import com.qf.pojo.User;
import com.qf.service.OrderService;
import com.qf.service.PayService;
import com.qf.service.UserService;
import com.qf.util.AlipayUtil;
import com.qf.util.JedisCore;
import com.qf.util.JedisUtil;
import com.qf.util.TokenUtil;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "alipayOrderService")
public class PayServiceImpl implements PayService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private JedisCore jedisCore;
    //private JedisCore jedisCore= jedisCore;

    @Override
    public String aliPay(AlipayBean alipayBean, CommitOrderDto cod) throws AlipayApiException {

        User user = TokenUtil.getUserFromToken(cod.getToken(), jedisCore);
        if (user != null) {
            //User user=userDao.selectUserById(cod.getUser_id());

            cod.setBuyer_nickname(user.getNickname());
            cod.setOrder_id(alipayBean.getOut_trade_no());
            cod.setTotal_fee(Double.valueOf(alipayBean.getTotal_amount().toString()));
            //System.out.println(cod);
            cod.setUser_id(user.getId());
            orderDao.addOrder(cod);
            return AlipayUtil.connect(alipayBean);
        } else {
            return JSON.toJSONString(R.error("登录信息失效，请重新登录")) ;
        }
    }
}

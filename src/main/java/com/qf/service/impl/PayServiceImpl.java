package com.qf.service.impl;

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
    @Override
    public String aliPay(AlipayBean alipayBean, CommitOrderDto cod) throws AlipayApiException {

        User user = userDao.selectUserById(cod.getUser_id());

        cod.setBuyer_nickname(user.getNickname());
        cod.setOrder_id(alipayBean.getOut_trade_no());
        cod.setTotal_fee(Double.valueOf(alipayBean.getTotal_amount().toString()));
        //System.out.println(cod);
        orderDao.addOrder(cod);
        return AlipayUtil.connect(alipayBean);
    }
}

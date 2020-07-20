package com.qf.service.impl;

import com.qf.dao.OrderDao;
import com.qf.dto.CommitOrderDto;
import com.qf.service.OrderService;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public R addOrder(CommitOrderDto cod) {
        return R.ok(orderDao.addOrder(cod));
    }

    @Override
    public R getOrdersByUserId(int userid) {
        return R.ok(orderDao.getOrdersByUserId(userid));
    }
}

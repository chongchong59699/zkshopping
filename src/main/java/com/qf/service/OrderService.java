package com.qf.service;

import com.qf.dto.CommitOrderDto;
import com.qf.vo.R;

/**
 * @ClassName: OrderService
 * @Author: 刘嘉豪
 * @Date: 2020/7/20
 * @Time: 20:25
 */
public interface OrderService {

    R addOrder(CommitOrderDto cod);

    R getOrdersByUserId(int userid);

}

package com.qf.service;

import com.alipay.api.AlipayApiException;
import com.qf.dto.CommitOrderDto;
import com.qf.pojo.AlipayBean;

public interface PayService {
    String aliPay(AlipayBean alipayBean, CommitOrderDto cod) throws AlipayApiException;
}

package com.qf.service.impl;

import com.alipay.api.AlipayApiException;
import com.qf.pojo.AlipayBean;
import com.qf.service.PayService;
import com.qf.util.AlipayUtil;
import org.springframework.stereotype.Service;

@Service(value = "alipayOrderService")
public class PayServiceImpl implements PayService {
    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return AlipayUtil.connect(alipayBean);
    }
}

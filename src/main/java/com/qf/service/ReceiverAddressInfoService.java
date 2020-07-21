package com.qf.service;

import com.qf.pojo.ReceiverAddressInfo;
import com.qf.vo.R;

public interface ReceiverAddressInfoService {
    R selectByUid(int uid);
    R insert(ReceiverAddressInfo receverAddressInfo);
    R updateAddress(ReceiverAddressInfo receverAddressInfo);
    R delete(int id);
}

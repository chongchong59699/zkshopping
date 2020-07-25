package com.qf.service;

import com.qf.pojo.ReceiverAddressInfo;
import com.qf.vo.R;

public interface ReceiverAddressInfoService {
    R selectByUid(String token,int uid);
    R insert(String token,ReceiverAddressInfo receverAddressInfo);
    R updateAddress(String token,ReceiverAddressInfo receverAddressInfo);
    R delete(String token,int id);
    R selectById(String token,int id);
}

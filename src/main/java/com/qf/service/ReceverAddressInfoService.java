package com.qf.service;

import com.qf.pojo.ReceverAddressInfo;
import com.qf.vo.R;

public interface ReceverAddressInfoService {
    R selectByUid(int uid);
    R insert(ReceverAddressInfo receverAddressInfo);
}

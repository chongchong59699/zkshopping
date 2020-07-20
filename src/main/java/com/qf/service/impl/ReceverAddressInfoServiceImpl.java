package com.qf.service.impl;

import com.qf.dao.ReceverAddressInfoDao;
import com.qf.pojo.ReceiverAddressInfo;
import com.qf.service.ReceverAddressInfoService;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceverAddressInfoServiceImpl implements ReceverAddressInfoService {
   @Autowired
    private ReceverAddressInfoDao dao;

    @Override
    public R selectByUid(int uid) {
         return R.ok(dao.selectByUid(uid));
    }

    @Override
    public R insert(ReceiverAddressInfo receiverAddressInfo) {
        return R.ok(dao.insert(receiverAddressInfo));
    }

    @Override
    public R updateAddress(ReceiverAddressInfo receiverAddressInfo) {
        return R.ok(dao.update(receiverAddressInfo));
    }

    @Override
    public R delete(int id) {
        return R.ok(dao.delete(id));
    }
}

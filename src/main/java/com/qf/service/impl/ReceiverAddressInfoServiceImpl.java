package com.qf.service.impl;

import com.qf.dao.ReceiverAddressInfoDao;
import com.qf.pojo.ReceiverAddressInfo;
import com.qf.service.ReceiverAddressInfoService;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiverAddressInfoServiceImpl implements ReceiverAddressInfoService {
   @Autowired
    private ReceiverAddressInfoDao dao;

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

    @Override
    public R selectById(int id) {
        return R.ok(dao.selectById(id));
    }
}

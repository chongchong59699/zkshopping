package com.qf.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.qf.config.RedisKeyConfig;
import com.qf.dao.ReceverAddressInfoDao;
import com.qf.pojo.ReceverAddressInfo;
import com.qf.pojo.User;
import com.qf.service.ReceverAddressInfoService;
import com.qf.util.JedisCore;
import com.qf.vo.R;
import jdk.nashorn.internal.ir.CallNode;
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
    public R insert(ReceverAddressInfo receverAddressInfo) {
        return R.ok(dao.insert(receverAddressInfo));
    }

    @Override
    public R updateAddress(ReceverAddressInfo receverAddressInfo) {
        return R.ok(dao.update(receverAddressInfo));
    }

    @Override
    public R delete(int id) {
        return R.ok(dao.delete(id));
    }
}

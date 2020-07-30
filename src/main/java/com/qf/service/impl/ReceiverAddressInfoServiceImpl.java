package com.qf.service.impl;

import com.alibaba.fastjson.JSON;
import com.qf.config.RedisKeyConfig;
import com.qf.dao.ReceiverAddressInfoDao;
import com.qf.pojo.ReceiverAddressInfo;
import com.qf.pojo.User;
import com.qf.service.ReceiverAddressInfoService;
import com.qf.util.JedisCore;
import com.qf.util.JedisUtil;
import com.qf.util.TokenUtil;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiverAddressInfoServiceImpl implements ReceiverAddressInfoService {
    @Autowired
    private ReceiverAddressInfoDao dao;
        @Autowired
    private JedisCore jedisCore;
   // private JedisCore jedisCore = JedisUtil.getJedisCore();

    @Override
    public R selectByUid(String token) {
        User user = TokenUtil.getUserFromToken(token, jedisCore);
        if (user != null) {
            return R.ok(dao.selectByUid(user.getId()));
        } else {
            return R.error("查询失败,请重新查询");
        }

    }

    @Override
    public R insert(String token, ReceiverAddressInfo receiverAddressInfo) {
        if (jedisCore.get(RedisKeyConfig.TOKEN_USER + token) != null) {
            User user = JSON.parseObject(jedisCore.get(RedisKeyConfig.TOKEN_USER + token), User.class);
            receiverAddressInfo.setUser_id(user.getId());
            return R.ok(dao.insert(receiverAddressInfo));
        } else {
            return R.error("请重新登录后再试");

        }

    }

    @Override
    public R updateAddress(String token, ReceiverAddressInfo receiverAddressInfo) {
        User user = TokenUtil.getUserFromToken(token, jedisCore);
        if (user != null) {
            receiverAddressInfo.setUser_id(user.getId());
            return R.ok(dao.update(receiverAddressInfo));
        }

        return R.error("修改失败");

    }

    @Override
    public R delete(String token, int id) {
        User user = TokenUtil.getUserFromToken(token, jedisCore);
        if (user != null) {
            return R.ok(dao.delete(user.getId(), id));
        } else {
            return R.error("删除失败");
        }

    }

    @Override
    public R selectById(String token, int id) {
        User user = TokenUtil.getUserFromToken(token, jedisCore);
        if (user != null) {
            return R.ok(dao.selectById(id));
        } else {

            return R.error("请重新登录");

        }

    }
}

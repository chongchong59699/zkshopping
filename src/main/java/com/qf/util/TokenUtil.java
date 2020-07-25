package com.qf.util;

import com.alibaba.fastjson.JSON;
import com.qf.config.RedisKeyConfig;

import com.qf.constant.SystemConstant;

import com.qf.pojo.User;

import java.util.UUID;


/**
 * @ClassName: TokenUtil
 * @Author: 刘嘉豪
 * @Date: 2020/7/15
 * @Time: 15:27
 */
public class TokenUtil {
    public static String createToken(int uid) {
        return UUID.randomUUID().toString().replace("-", "") + "_" + uid;
    }

    public static User getUserFromToken(String token, JedisCore jedisCore) {

        String userStr = jedisCore.get(RedisKeyConfig.TOKEN_USER + token);
        if (userStr != null) {
            return JSON.parseObject(userStr, User.class);

        } else {
            return null;
        }
    }
}

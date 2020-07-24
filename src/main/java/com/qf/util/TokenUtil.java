package com.qf.util;

import com.alibaba.fastjson.JSON;
import com.qf.config.RedisKeyConfig;
import com.qf.pojo.User;
import com.qf.vo.R;

import java.util.UUID;

/**
 * @ClassName: TokenUtil
 * @Author: 刘嘉豪
 * @Date: 2020/7/15
 * @Time: 15:27
 */
public class TokenUtil {
    public static String createToken(int uid){
        return UUID.randomUUID().toString().replace("-","")+"_"+uid;
    }
    public static User getUserFromToken(String token,JedisCore jedisCore){
        if(jedisCore.get(RedisKeyConfig.TOKEN_USER + token)!=null){
            User user= JSON.parseObject(jedisCore.get(RedisKeyConfig.TOKEN_USER + token),User.class);
            return user;
        }else {
            return null;
        }
    }
}

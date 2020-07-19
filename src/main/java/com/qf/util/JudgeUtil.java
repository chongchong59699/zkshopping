package com.qf.util;

import com.qf.config.RedisKeyConfig;
import com.qf.dto.LoginUserDto;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断用户是手机号登录还是邮箱登录
 *
 * @author: Sophia
 * @date: 2020/7/18
 */
public class JudgeUtil {

    /**
     * 判断用户是手机号登录还是邮箱登录
     *
     * @param loginUserDto 用户登录信息
     * @return
     */
    public static Map<String, String> getPhoneOrEmail(LoginUserDto loginUserDto){
        HashMap<String, String> map = new HashMap<>();

        if (!StringUtil.checkEmpty(loginUserDto.getPhone())){
            // 设置用户账号
            map.put("account", loginUserDto.getPhone());
            map.put("TOKEN", RedisKeyConfig.PHONE_TOKEN);
            map.put("FOR", RedisKeyConfig.PHONE_FOR);
            map.put("ERROR", RedisKeyConfig.PHONE_ERROR);

            return map;
        } else {
            map.put("account", loginUserDto.getEmail());
            map.put("TOKEN", RedisKeyConfig.EMAIL_TOKEN);
            map.put("FOR", RedisKeyConfig.EMAIL_FOR);
            map.put("ERROR", RedisKeyConfig.EMAIL_ERROR);

            return map;
        }
    }
}

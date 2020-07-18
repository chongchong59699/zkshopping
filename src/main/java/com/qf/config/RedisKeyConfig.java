package com.qf.config;

/**
 * @ClassName: RedisKeyConfig
 * @Author: 刘嘉豪
 * @Date: 2020/7/15
 * @Time: 16:09
 */
public class RedisKeyConfig {
    //令牌 Token
    //后面追加手机号 值存储令牌
    public static final String PHONE_TOKEN="zkwg:phone:";
    //后面追加令牌 值存储用户信息
    public static final String TOKEN_USER="zkwg:token:";

    //后面跟手机号 冻结的手机号
    public static final String PHONE_FOR="zkwg:for:phone:";

    //后面跟手机号和时间戳
    public static final String PHONE_ERROR="zkwg:error:phone:";


    //后面追加手机号 值存储令牌
    public static final String EMAIL_TOKEN="zkwg:phone:";

    //后面跟手机号 冻结的手机号
    public static final String EMAIL_FOR="zkwg:for:phone:";

    //后面跟手机号和时间戳
    public static final String EMAIL_ERROR="zkwg:error:phone:";




    //有效期  seconds
    public static final int TOKEN_TIME=30*60; //令牌有效期 单位秒
    public static final int TOKENFOR_TIME=30*60; //冻结账号 单位秒
    public static final int PHONERROR_TIME=10*60; //错误的有效期 单位秒
}

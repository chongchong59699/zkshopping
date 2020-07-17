package com.qf.util;

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
}

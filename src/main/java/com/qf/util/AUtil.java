package com.qf.util;

import java.util.Random;

/**
 * @program: voter
 * @description: 限制文件长传名字长度
 * @author: 任晓雨
 * @create: 2020-07-17 12:14
 */
public class AUtil {
    public static String rename(String fn) {
        if (!StringUtil.checkEmpty(fn)) {
            if (fn.length() > 30) {
                fn = fn.substring(fn.length() - 30);
            }
            fn = System.currentTimeMillis() + "_" + new Random().nextInt(1000) + "_" + fn;
            return fn;
        } else {
            return null;
        }
    }
}

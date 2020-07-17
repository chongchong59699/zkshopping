package com.qf.util;

/**
 * @ClassName: StringUtil
 * @Author: 刘嘉豪
 * @Date: 2020/7/15
 * @Time: 20:49
 */
public class StringUtil {
    public static boolean checkEmpty(String str){
        if (null != str && str.length()>0){
            return false;
        }else {
            return true;
        }
    }

    public static boolean checkEmptys(String... strs){
        for (String s:strs){
            if(!checkEmpty(s)){
                return true;
            }
        }
        return false;
    }
}

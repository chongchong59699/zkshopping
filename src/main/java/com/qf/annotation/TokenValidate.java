package com.qf.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: BeanCopyFiled
 * @Author: 刘嘉豪
 * @Date: 2020/7/16
 * @Time: 14:36
 */

/**
 * 标注该方法是否需要验证token信息
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface TokenValidate {
}

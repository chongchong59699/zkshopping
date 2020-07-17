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
 * 标注该dto属性   value是和pojo对应的属性的名称
 */
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface BeanCopyFiled {
    String value();
}

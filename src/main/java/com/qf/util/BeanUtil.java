package com.qf.util;

import com.qf.annotation.BeanCopyFiled;

import java.lang.reflect.Field;

/**
 * @ClassName: BeanUtil
 * @Author: 刘嘉豪
 * @Date: 2020/7/16
 * @Time: 14:43
 */
public class BeanUtil {

    public static <T> T copyFled(Class<T> clz, Object dto) {
        try {
            T pojo = clz.getConstructor().newInstance();
            Field[] fields = dto.getClass().getDeclaredFields();

            for (Field field : fields) {
                String value;
                BeanCopyFiled bcf = field.getAnnotation(BeanCopyFiled.class);
                if (bcf != null) {
                    value = bcf.value();
                } else {
                    value = field.getName();
                }
                Field fieldT = clz.getDeclaredField(value);
                if (null != fieldT){
                    fieldT.setAccessible(true);
                    field.setAccessible(true);
                    fieldT.set(pojo,field.get(value));
                }
            }
            return pojo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}

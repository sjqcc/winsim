package com.lugew.winsim.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * @author LuGew
 * @since 2020/8/5
 */
@UtilityClass
@Slf4j
public class ReflectionUtil {
    public Field getField(Class<?> clazz, String fieldName) {
        Field field = null;
        Class<?> oldClass = clazz;
        if (null == clazz) {
            throw new RuntimeException("class is null");
        }

        while (null != clazz) {
            try {
                field = clazz.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException e) {
                log.info("field:{} not exist in class:{}", fieldName, clazz.getName());
                clazz = clazz.getSuperclass();
            }
        }
        if (null == field) {
            throw new RuntimeException("field:" + fieldName + " not exist in class:" + oldClass.getName());
        }
        return field;
    }
}

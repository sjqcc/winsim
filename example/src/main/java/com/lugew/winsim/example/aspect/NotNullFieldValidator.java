package com.lugew.winsim.example.aspect;

import java.lang.reflect.Field;

/**
 * @author LuGew
 * @since 2020/7/30
 */
public class NotNullFieldValidator extends AbstractFieldValidator {

    @Override
    public boolean validate(Field field, Object object) {
        field.setAccessible(true);
        Object value = null;
        try {
            value = field.get(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (null == value) {
            throw new RuntimeException("value is null");
        }
        return true;
    }
}

package com.lugew.winsim.example.validation.validator;

import java.lang.reflect.Field;

/**
 * @author LuGew
 * @since 2020/7/30
 */
public class NotNull extends AbstractValidator {

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
            throw new RuntimeException(field.getName() + " cant be null");
        }
        return true;
    }
}

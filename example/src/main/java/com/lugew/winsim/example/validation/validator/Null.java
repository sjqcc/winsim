package com.lugew.winsim.example.validation.validator;

import java.lang.reflect.Field;

/**
 * @author LuGew
 * @since 2020/7/30
 */
public class Null extends AbstractValidator {
    @Override
    public boolean validate(Field field, Object object) {
        field.setAccessible(true);
        try {
            if (field.get(object) != null) {
                throw new RuntimeException(field.getName() + " must be null");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return true;
    }
}

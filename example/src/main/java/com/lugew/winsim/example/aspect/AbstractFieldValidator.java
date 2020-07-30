package com.lugew.winsim.example.aspect;

import java.lang.reflect.Field;

/**
 * @author LuGew
 * @since 2020/7/30
 */
public abstract class AbstractFieldValidator implements FieldValidator {
    @Override
    public boolean validate(Field field, Object object) {
        return null == object;
    }
}

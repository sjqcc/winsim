package com.lugew.winsim.example.aspect;

import java.lang.reflect.Field;

/**
 * @author LuGew
 * @since 2020/7/30
 */
public class NullFieldValidator extends AbstractFieldValidator {
    @Override
    public boolean validate(Field field, Object object) {
        return super.validate(field, object);
    }
}

package com.lugew.winsim.example.validation.validator;

import java.lang.reflect.Field;

/**
 * 抽象字段验证器
 * 扩展时需继承
 *
 * @author LuGew
 * @since 2020/7/30
 */
public abstract class AbstractValidator implements Validator {
    @Override
    public boolean validate(Field field, Object object) {
        return true;
    }

}

package com.lugew.winsim.example.annotation;

import java.lang.annotation.*;

/**
 * 接口参数字段过滤器
 *
 * @author LuGew
 * @since 2020/7/30
 */
@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsValidated {
    /**
     * 非空的字段
     *
     * @return 非空字段组合
     */

    FieldValidated[] value();
}

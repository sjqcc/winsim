package com.lugew.winsim.example.annotation;

import com.lugew.winsim.example.aspect.FieldValidator;

import java.lang.annotation.*;

/**
 * @author LuGew
 * @since 2020/7/30
 */
@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldValidated {
    Class<? extends FieldValidator> validator();

    String[] fields();
}

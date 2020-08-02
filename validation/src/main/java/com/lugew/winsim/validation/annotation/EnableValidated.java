package com.lugew.winsim.validation.annotation;

import com.lugew.winsim.validation.config.ValidatedConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author LuGew
 * @since 2020/8/2
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ValidatedConfiguration.class})
public @interface EnableValidated {
}

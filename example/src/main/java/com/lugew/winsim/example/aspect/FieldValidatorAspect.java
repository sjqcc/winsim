package com.lugew.winsim.example.aspect;

import com.lugew.winsim.example.annotation.FieldsValidated;
import com.lugew.winsim.example.util.FieldsValidatedUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author LuGew
 * @since 2020/7/30
 */
@Aspect
@Slf4j
@Component
public class FieldValidatorAspect {
    @Pointcut("execution(* com.lugew.winsim.example.controller..*.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        log.info("field filter before");
        Object[] arguments = joinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Annotation[][] annotations = method.getParameterAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            Object argument = arguments[i];
            Annotation[] argumentAnnotations = annotations[i];
            if (null != argumentAnnotations) {
                for (Annotation annotation : argumentAnnotations) {
                    if (FieldsValidated.class.equals(annotation.annotationType())) {
                        FieldsValidatedUtil.handle((FieldsValidated) annotation, argument);
                    }
                }
            }
        }
    }


}

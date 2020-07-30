package com.lugew.winsim.example.util;

import com.lugew.winsim.example.annotation.FieldValidated;
import com.lugew.winsim.example.annotation.FieldsValidated;
import com.lugew.winsim.example.aspect.FieldValidator;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author LuGew
 * @since 2020/7/30
 */
@UtilityClass
@Slf4j
public class FieldsValidatedUtil {
    public void handle(FieldsValidated fieldsValidated, Object object) {
        handle(fieldsValidated.value(), object);
    }

    public void handle(FieldValidated[] fieldValidatedArray, Object object) {
        Map<Class<? extends FieldValidator>, Set<Field>> validatorFieldsMap = new HashMap<>();
        Class<?> clazz = object.getClass();
        for (FieldValidated fieldValidated : fieldValidatedArray) {
            String[] fields = fieldValidated.fields();
            Class<? extends FieldValidator> fieldValidator = fieldValidated.validator();
            if (!validatorFieldsMap.containsKey(fieldValidator)) {
                validatorFieldsMap.put(fieldValidator, new HashSet<>());
            }
            for (String fieldString : fields) {
                try {
                    validatorFieldsMap.get(fieldValidator).add(clazz.getDeclaredField(fieldString));
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                    throw new RuntimeException("cant get field" + fieldString + " in " + clazz.getName());
                }
            }

        }

        for (Map.Entry<Class<? extends FieldValidator>, Set<Field>> entry : validatorFieldsMap.entrySet()) {
            FieldValidator fieldValidator = null;
            try {
                fieldValidator = entry.getKey().newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException("cant create new field validator:");
            }
            Set<Field> fields = entry.getValue();
            for (Field field : fields) {

                fieldValidator.validate(field, object);

            }

        }

    }
}

package br.com.taxidobarba.mock;

import java.lang.reflect.Field;
import java.util.Map;

import org.springframework.util.ReflectionUtils;

public abstract class GenericRequestDTOMock {

    public static <T> T createRequestDto(T object, Map<String, Object> attributes) {

        attributes.forEach((attribute, value) -> {
            Field field = ReflectionUtils.findField(object.getClass(), attribute);
            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, object, value);
        });

        return object;
    }

}

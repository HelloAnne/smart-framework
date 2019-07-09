package org.smart4j.framework.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ReflectionUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    public static Object newInstance(Class<?> cls) {
        Object instance;
        try {
            instance = cls.newInstance();
        } catch (InstantiationException e) {
            LOGGER.error("new instance failure.", e);
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            LOGGER.error("new instance failure.", e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    public static Object invokeMethod(Object obj, Method method, Object... args) {
        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(obj, args);
        } catch (IllegalAccessException e) {
            LOGGER.error("invoke method failure.", e);
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            LOGGER.error("invoke method failure.", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void setFeild(Object obj, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            LOGGER.error("set field failure.", e);
            throw new RuntimeException(e);        }

    }
}

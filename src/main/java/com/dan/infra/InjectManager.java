package com.dan.infra;


import com.dan.model.annotations.Inject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InjectManager {
    public static void injectSingleton(Class<?> clazz) {

        System.out.println("-=-=-=-=-=-= Realizando injecões =-=-=-=-=-=-");

        injectByConstructor(clazz.getDeclaredConstructors(), clazz);
        injectByField(clazz.getDeclaredFields(), getInstanceForSingletonManager(clazz));

        System.out.println("-=-=-=-=-=-= Injecões finalizadas ==-=-=-=-=-");
    }

    private static <T> void injectByConstructor(Constructor<?>[] constructors, Class<?> clazz) {

        List<Object> instanceArgs = new ArrayList<>();

        var constructor = getConstructorIdeal(constructors);
        Parameter[] initargs = constructor.getParameters();
        for (Parameter parameter : initargs) {

            injectByConstructor(parameter.getType().getDeclaredConstructors(), parameter.getType());
        }

        if (!SingletonManager.contains(clazz)) {
            for (Parameter initarg : initargs)
                instanceArgs.add(getInstanceForSingletonManager(initarg.getType()));

            var instance = getInstanceForSingletonManager(clazz, instanceArgs.toArray());


            injectByField(instance.getClass().getDeclaredFields(), instance);
        }
    }

    private static Constructor<?> getConstructorIdeal(Constructor<?>[] constructors) {
        return Arrays.stream(constructors).max(Comparator.comparing(c -> c.getParameters().length)).get();
    }


    private static <T> void injectByField(Field[] fields, T obj) {

        for (Field field : fields)

            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                injectByConstructor(field.getType().getDeclaredConstructors(), field.getType());
                injectByField(field.getType().getDeclaredFields(), getInstanceForSingletonManager(field.getType()));

                Object value;
                try {
                    field.setAccessible(true);
                    value = field.get(obj);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                if (value == null)
                    inject(field, obj);
            }
    }


    private static <T> void inject(Field field, T obj) {

        try {
            System.out.println("Injetando por atributo a instância" + getInstanceForSingletonManager(field.getType()) + " em " + field.getType() + " na instância " + obj.getClass().getName() + " (InjectManager.java:67)");

            field.set(obj, getInstanceForSingletonManager(field.getType()));
        } catch (IllegalAccessException e) {

            throw new RuntimeException(e);
        }

    }


    private static <T> T getInstanceForSingletonManager(Class<?> clazz, Object... initargs) {
        try {
            return SingletonManager.getInstace(clazz, initargs);
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {

            throw new RuntimeException(e.getMessage());
        }
    }
}

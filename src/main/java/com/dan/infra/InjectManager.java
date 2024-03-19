package com.dan.infra;


import com.dan.model.annotations.Inject;
import com.dan.service.implementations.UserServiceImpl;
import com.dan.service.interfaces.UserService;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InjectManager {
    public static void injectSingleton(Class<?> clazz) {

        System.out.println("-=-=-=-=-=-= Realizando injecões =-=-=-=-=-=-");

        injectByConstructor(clazz.getDeclaredConstructors(), clazz);
        injectByField(clazz.getDeclaredFields(), SingletonManager.getInstace(clazz));

        System.out.println("-=-=-=-=-=-= Injecões finalizadas ==-=-=-=-=-");
    }

    private static <T> void injectByConstructor(Constructor<?>[] constructors, Class<?> clazz) {

        List<Object> instanceArgs = new ArrayList<>();

        var constructor = getConstructorIdeal(constructors);
        Parameter[] initargs = constructor.getParameters();
        for (Parameter parameter : initargs) {

            if (!SingletonManager.contains(parameter.getType())) {
                injectByConstructor(parameter.getType().getDeclaredConstructors(), parameter.getType());
            }
            instanceArgs.add(SingletonManager.getInstace(parameter.getType()));
        }
        SingletonManager.getInstace(clazz, instanceArgs.toArray());
    }

    private static Constructor<?> getConstructorIdeal(Constructor<?>[] constructors) {
        return Arrays.stream(constructors).max(Comparator.comparing(c -> c.getParameters().length)).get();
    }


    private static <T> void injectByField(Field[] fields, T obj) {

        for (Field field : fields) {
            if (!field.isAnnotationPresent(Inject.class))
                continue;

            field.setAccessible(true);
            if (!SingletonManager.contains(field.getType()))
                injectByConstructor(field.getType().getDeclaredConstructors(), field.getType());
            injectByField(field.getType().getDeclaredFields(), SingletonManager.getInstace(field.getType()));

            if (getField(field, obj) == null)
                inject(field, obj);
        }
    }


    private static <T> void inject(Field field, T obj) {
        System.out.println("Injetando por atributo a instância" + SingletonManager.getInstace(field.getType()) + " em " + field.getType() + " na instância " + obj.getClass().getName() + " (InjectManager.java:67)");
        try {
            field.set(obj, SingletonManager.getInstace(field.getType()));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    private static <T> Object getField(Field f, T obj) {
        try {
            return f.get(obj);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}

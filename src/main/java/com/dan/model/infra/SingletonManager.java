package com.dan.model.infra;

import com.dan.model.annotations.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class SingletonManager {
    private static final Map<Class<?>, Object> instancies = new HashMap<>();

    public static <T> T getInstace(Class<?> clazz) {
        haveAnnotation(clazz);

        if (instancies.containsKey(clazz))
            return (T) instancies.get(clazz);
        var constructorEmpty = getEmptyConstructor(clazz);

        Constructor<?> constructor = constructorEmpty.get();
        constructor.setAccessible(true);

        Object instance = createInstance(constructor);

        instancies.put(clazz, instance);

        return (T) instance;
    }

    private static Object createInstance(Constructor<?> constructor) {
        try {
            return constructor.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("Falha ao criar instancia de " + constructor.getClass().getName());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static void haveAnnotation(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Singleton.class))
            throw new IllegalArgumentException("Considere anotar a classe " + clazz.getName() + " com @Singleton.");
    }

    private static Optional<Constructor<?>> getEmptyConstructor(Class<?> clazz) {



        var constructors = clazz.getDeclaredConstructors();
        for (var c : constructors)
            if (c.getParameters().length == 0) return Optional.of(c);

        throw new IllegalArgumentException("A classe " + clazz.getName() + " não possui um construtor vazio.");
    }
}

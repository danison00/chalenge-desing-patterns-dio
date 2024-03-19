package com.dan.infra;

import com.dan.model.annotations.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;



public class SingletonManager {
    private static final Map<Class<?>, Object> instancies = new HashMap<>();

    public static <T> T getInstace(Class<?> clazz, Object...initargs) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        haveAnnotation(clazz);

        if (instancies.containsKey(clazz)) {
            System.out.println("Obtendo a instância de "+clazz.getName()+"... (SingletonManager.java:21)");
            return (T) instancies.get(clazz);
        }
        Constructor<?> constructor = getEmptyConstructor(clazz).get();
        constructor.setAccessible(true);
        Object instance = createInstance(constructor, initargs);

        instancies.put(clazz, instance);

        return (T) instance;
    }

    private static Object createInstance(Constructor<?> constructor, Object...initargs) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println("Criando instância de " + constructor.getName() + "... (SingletonManager.java:34)");


        return constructor.newInstance(initargs);

    }


    private static void haveAnnotation(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Singleton.class))
            throw new IllegalArgumentException("Considere anotar a classe " + clazz.getName() + " com @Singleton.");
    }

    private static Optional<Constructor<?>> getEmptyConstructor(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredConstructors()).max(Comparator.comparing(constructor -> constructor.getParameters().length));
    }

    public static boolean contains(Class<?> clazz) {
        return instancies.containsKey(clazz);
    }
}

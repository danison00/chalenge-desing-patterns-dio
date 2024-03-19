package com.dan.infra;

import com.dan.model.annotations.Singleton;
import org.reflections.Reflections;

import java.lang.ref.Reference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class Application {

    public static void run(Class<?> clazz) {

        Reflections reflections = new Reflections("com.dan");
        Set<Class<?>> aClasses = reflections.getTypesAnnotatedWith(Singleton.class);
        InjectManager.start(aClasses);

            var obj = SingletonManager.getInstace(clazz);
        try {
            obj.getClass().getMethod("run").invoke(obj);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


    }

}
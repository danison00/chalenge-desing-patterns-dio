package com.dan.infra;

import java.lang.reflect.InvocationTargetException;

public class Application {

    public static void run(Class<?> clazz) {


        InjectManager.injectSingleton(clazz);

            var obj = SingletonManager.getInstace(clazz);
        try {
            obj.getClass().getMethod("run").invoke(obj);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


    }

}
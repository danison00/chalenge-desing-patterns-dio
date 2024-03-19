package com.dan.infra;

import java.lang.reflect.InvocationTargetException;

public class Application {

    public static void run(Class<?> clazz) {


        InjectManager.injectSingleton(clazz);
        try {
            var obj = SingletonManager.getInstace(clazz);
            obj.getClass().getMethod("run").invoke(obj);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }

}
package com.dan.model.infra;


import com.dan.model.annotations.Inject;
import com.dan.model.annotations.Object;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class InjectManager {

    public static <T> void injectSingleton(T obj) {

        Field[] f = obj.getClass().getDeclaredFields();
        findFields(f, obj);

    }

    private static <T> void findFields(Field[] fields, T obj) {

        for (Field field : fields)
            if (field.isAnnotationPresent(Inject.class)) {
                System.out.println(field.getType());
                field.setAccessible(true);

                try {
                    field.set(obj, SingletonManager.getInstace(field.getType()));
                    System.out.println("Injetando " + SingletonManager.getInstace(field.getType()) + " em " + field.getType());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

                List<Constructor<?>> cs = List.of( field.getType().getDeclaredConstructors());
              Optional<Constructor<?>> constructorMaior = cs.stream().max(Comparator.comparing(constructor -> constructor.getParameters().length));

             if (constructorMaior.isPresent()){
                 System.out.println("\n\n\n construtro pesente");
                 System.out.println(constructorMaior.get().getParameters().length);
                 System.out.println("\n\n\n");
             }


                findFields(field.getType().getDeclaredFields(), SingletonManager.getInstace(field.getType()));
            }
    }
}

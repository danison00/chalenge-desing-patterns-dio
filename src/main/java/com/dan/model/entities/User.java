package com.dan.model.entities;

import java.util.Date;

public class User {

    private static int idManager = 0;
    private final int id;
    private String name;
    private String cpf;
    private int age;
    private NotificationPreferences notificationPreferences;

    public User(String name, String cpf, int age,  NotificationPreferences notificationPreferences) {
        this.id = idManager = ++idManager;
        this.name = name;
        this.cpf = cpf;
        this.age = age;
        this.notificationPreferences = notificationPreferences;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", age=" + age +
                '}';
    }
}

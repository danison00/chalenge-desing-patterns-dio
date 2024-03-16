package com.dan.model;

import java.util.Date;

public class User {

    private static int idManager = 0;
    private final int id;
    private String name;
    private String cpf;
    private int age;

    public User(String name, String cpf, int age, Date birthDate) {
        this.id = idManager = idManager++;
        this.name = name;
        this.cpf = cpf;
        this.age = age;
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



}

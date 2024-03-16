package com.dan.model.entities;

public abstract class AbstractIdentifier {

    private final int id;
    private static int idManager = 0;

    public AbstractIdentifier() {

        this.id = idManager = ++idManager;


    }

    public int getId() {
        return id;
    }
}

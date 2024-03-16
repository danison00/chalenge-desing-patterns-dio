package com.dan.model.entities;

import java.time.LocalDateTime;

public class Loan {


    private static int idManager = 0;
    private final int id;
    private final Book book;
    private final User user;
    private final LocalDateTime dateTime;

    public Loan(Book book, User user) {
        this.id = idManager = ++idManager;
        this.book = book;
        this.user = user;
        this.dateTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}

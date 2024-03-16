package com.dan.service;

import com.dan.model.entities.User;

import java.util.List;

public class BookNotificationService {


    public void notify(List<User> users){
        users.forEach(user -> System.out.printf("notificando user: %s", user.getName()));
    }
}

package com.dan.service;

import com.dan.model.annotations.Inject;
import com.dan.model.annotations.Singleton;
import com.dan.model.entities.User;
import com.dan.service.interfaces.observerPattern.Observer;

@Singleton
public class UserService extends AbstractService<User> implements Observer {

    @Inject
    private  BookNotificationService bookNotificationService;

    BookService bookService;

    private UserService( BookService bookService){
       bookService.subscribe(this);
    }

    @Override
    public void notify(String message) {
        var usersToNotify = super.getList().stream().filter(u -> u.getNotificationPreferences().isEnable()).toList();

        bookNotificationService.notify(usersToNotify, message);
    }



}

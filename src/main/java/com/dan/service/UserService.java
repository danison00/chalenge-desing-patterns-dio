package com.dan.service;

import com.dan.model.entities.User;
import com.dan.model.exception.NotFoundException;
import com.dan.model.observer.Observer;
import com.dan.service.interfaces.BookNotificationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UserService extends AbstractService<User> implements Observer {

    private final BookNotificationService bookNotificationService = new BookNotificationService();

    @Override
    public void notify(String message) {
        var usersToNotify = super.getList().stream().filter(u -> u.getNotificationPreferences().isEnable()).toList();

        bookNotificationService.notify(usersToNotify, message);
    }


    static class UserServiceHolder {
        private static final UserService instance = new UserService();
    }

    private UserService() {
        BookService.getInstance().subscribe(this);
    }

    public static UserService getInstance() {
        return UserServiceHolder.instance;
    }




}

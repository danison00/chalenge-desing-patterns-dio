package com.dan.service.implementations;

import com.dan.model.entities.Book;
import com.dan.model.entities.User;
import com.dan.service.interfaces.BookNotificationService;
import com.dan.service.interfaces.BookService;
import com.dan.service.interfaces.UserService;
import com.dan.service.interfaces.observerPattern.Observable;
import com.dan.service.interfaces.observerPattern.Observer;


public class UserServiceImpl extends AbstractServiceImpl<User> implements Observer, UserService {

    private static UserServiceImpl instance;

    public static UserServiceImpl getInstance() {
        if(instance== null)
            instance = new UserServiceImpl();
        return instance;
    }
    private UserServiceImpl() {
        bookNotificationService = BookNotificationServiceImpl.getInstance();
        BookServiceImpl.getInstance().subscribe(this);
    }
    private final BookNotificationService bookNotificationService;


    @Override
    public void notify(String message) {
        var usersToNotify = super.getList().stream().filter(u -> u.getNotificationPreferences().isEnable()).toList();

        bookNotificationService.notify(usersToNotify, message);
    }


    @Override
    public void afterCreater(User user) {
        super.afterCreater(user);
    }
}

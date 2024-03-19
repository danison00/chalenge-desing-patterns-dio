package com.dan.service.implementations;

import com.dan.model.annotations.Singleton;
import com.dan.model.entities.User;
import com.dan.service.interfaces.UserService;
import com.dan.service.interfaces.observerPattern.Observer;

@Singleton
public class UserServiceImpl extends AbstractService<User> implements Observer, UserService {


    private BookNotificationServiceImpl bookNotificationServiceImpl;

   private BookServiceImpl bookServiceImpl;

    private UserServiceImpl(BookServiceImpl bookServiceImpl, BookNotificationServiceImpl bookNotificationServiceImpl){
        bookServiceImpl.subscribe(this);
        this.bookNotificationServiceImpl = bookNotificationServiceImpl;
    }

    @Override
    public void notify(String message) {
        var usersToNotify = super.getList().stream().filter(u -> u.getNotificationPreferences().isEnable()).toList();

        bookNotificationServiceImpl.notify(usersToNotify, message);
    }


}

package com.dan.service.implementations;

import com.dan.model.annotations.Inject;
import com.dan.model.annotations.Singleton;
import com.dan.model.entities.User;
import com.dan.service.interfaces.UserService;
import com.dan.service.interfaces.observerPattern.Observer;

@Singleton
public class UserServiceImpl extends AbstractServiceImpl<User> implements Observer, UserService {

    @Inject
    private BookNotificationServiceImpl bookNotificationServiceImpl;

   private BookServiceImpl bookServiceImpl;

    private UserServiceImpl(BookServiceImpl bookServiceImpl){
        bookServiceImpl.subscribe(this);
    }

    @Override
    public void notify(String message) {
        var usersToNotify = super.getList().stream().filter(u -> u.getNotificationPreferences().isEnable()).toList();

        bookNotificationServiceImpl.notify(usersToNotify, message);
    }


    @Override
    public void afterCreater(User user) {
        super.afterCreater(user);
    }
}

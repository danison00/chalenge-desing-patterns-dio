package com.dan.service.implementations;

import com.dan.model.entities.User;
import com.dan.service.interfaces.BookNotificationService;
import com.dan.service.interfaces.BookService;

import java.util.List;


public class BookNotificationServiceImpl implements BookNotificationService {

    private static BookNotificationServiceImpl instance;
    private BookNotificationServiceImpl() {
    }

    public static BookNotificationServiceImpl getInstance() {
        if(instance== null)
            instance = new BookNotificationServiceImpl();
        return instance;
    }

    @Override
    public void notify(List<User> users, String message) {

        System.out.println("\n **** Notificando Usuários ****");


        users.forEach(u -> {
           var m = new StringBuilder("Olá, ");
            m.append(u.getName()).append("! ").append(message);

            if(u.getNotificationPreferences().isEmailEnable())
                BookNotificationByEmailServiceImpl.getInstance().notify(u.getEmail(), m.toString());

            if (u.getNotificationPreferences().isSmsEnable())
                BookNotificationBySmsServiceImpl.getInstance().notify(u.getPhone(), m.toString());
        });

        System.out.println();
    }

}

package com.dan.service;

import com.dan.model.entities.User;
import com.dan.service.interfaces.BookNotificationStrategy;

import java.util.ArrayList;
import java.util.List;

public class BookNotificationService {


    public void notify(List<User> users, String message) {

        System.out.println("\n **** Notificando Usuários ****");


        users.forEach(u -> {
           var m = new StringBuilder("Olá, ");
            m.append(u.getName()).append("! ").append(message);

            if(u.getNotificationPreferences().isEmailEnable())
                BookNotificationByEmailService.getInstance().notify(u.getEmail(), m.toString());

            if (u.getNotificationPreferences().isSmsEnable())
                BookNotificationBySmsService.getInstance().notify(u.getPhone(), m.toString());
        });

        System.out.println();
    }

}

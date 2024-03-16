package com.dan.service;

import com.dan.model.entities.User;
import com.dan.service.interfaces.BookNotificationStrategy;

import java.util.List;

public class BookNotificationByEmailService implements BookNotificationStrategy {

    private static class BookNotificationByEmailServiceHolder {
        private static final BookNotificationByEmailService instance = new BookNotificationByEmailService();
    }

    private BookNotificationByEmailService() {
    }

    public static BookNotificationByEmailService getInstance() {
        return BookNotificationByEmailService.BookNotificationByEmailServiceHolder.instance;
    }

    @Override
    public void notify(String email, String message) {
        System.out.printf("Enviando email para %s { payload: %s }\n", email, message);
    }
}

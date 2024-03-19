package com.dan.service.implementations;

import com.dan.service.interfaces.BookNotificationStrategy;

public class BookNotificationByEmailServiceImpl implements BookNotificationStrategy {

    private static class BookNotificationByEmailServiceHolder {
        private static final BookNotificationByEmailServiceImpl instance = new BookNotificationByEmailServiceImpl();
    }

    private BookNotificationByEmailServiceImpl() {
    }

    public static BookNotificationByEmailServiceImpl getInstance() {
        return BookNotificationByEmailServiceImpl.BookNotificationByEmailServiceHolder.instance;
    }

    @Override
    public void notify(String email, String message) {
        System.out.printf("Enviando email para %s { payload: %s }\n", email, message);
    }
}

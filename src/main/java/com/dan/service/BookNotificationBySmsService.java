package com.dan.service;

import com.dan.model.entities.User;
import com.dan.service.interfaces.BookNotificationStrategy;

import java.util.List;

public class BookNotificationBySmsService implements BookNotificationStrategy {

   private static class BookNotificationBySmsServiceHolder {
        private static final BookNotificationBySmsService instance = new BookNotificationBySmsService();
    }

    private BookNotificationBySmsService() {
    }

    public static BookNotificationBySmsService getInstance() {
        return BookNotificationBySmsService.BookNotificationBySmsServiceHolder.instance;
    }


    @Override
    public void notify(String destination, String message) {
        System.out.printf("Enviando sms para %s payload: %s\n", destination, message);

    }
}

package com.dan.service.implementations;

import com.dan.service.interfaces.BookNotificationStrategy;
public class BookNotificationBySmsServiceImpl implements BookNotificationStrategy {

    private static final BookNotificationBySmsServiceImpl instance = new BookNotificationBySmsServiceImpl();



    private BookNotificationBySmsServiceImpl() {
    }

    public static BookNotificationBySmsServiceImpl getInstance() {
        return instance;
    }


    @Override
    public void notify(String destination, String message) {
        System.out.printf("Enviando sms para %s payload: %s\n", destination, message);

    }
}

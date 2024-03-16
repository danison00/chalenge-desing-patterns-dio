package com.dan.service.interfaces;

import com.dan.model.entities.User;

import java.util.List;

public interface BookNotificationStrategy {

    void notify(String detination, String message);
}

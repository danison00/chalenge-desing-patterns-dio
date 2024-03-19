package com.dan.service.interfaces;

import com.dan.model.entities.User;

import java.util.List;

public interface BookNotificationService {

    public void notify(List<User> users, String message);
}
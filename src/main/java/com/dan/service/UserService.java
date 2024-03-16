package com.dan.service;

import com.dan.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users = new ArrayList<>();

    static class UserServiceHolder {
        private static final UserService instance = new UserService();
    }

    private UserService() {
    }

    private static UserService getInstance() {
        return UserServiceHolder.instance;
    }

    public void create(User user) {
        this.users.add(user);
        System.out.println("Usuário criado com sucesso!");
    }

    public void deleteById(int id) {
        this.users.removeIf(u -> u.getId() == id);

    }


}

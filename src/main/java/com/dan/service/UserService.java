package com.dan.service;

import com.dan.model.entities.User;
import com.dan.model.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final List<User> users = new ArrayList<>();

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

    public void deleteById(int id) throws NotFoundException {
        findById(id);
        this.users.removeIf(u -> u.getId() == id);

    }

    public User findById(int id) throws NotFoundException {
        for (var u : users)
            if (u.getId() == id)
                return u;

        throw new RuntimeException("Usuário não encontrado");
    }

    public void list() {
        users.forEach((u) -> {
            System.out.println(u.toString());
        });
    }


}

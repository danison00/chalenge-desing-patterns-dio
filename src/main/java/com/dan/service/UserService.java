package com.dan.service;

import com.dan.model.entities.User;
import com.dan.model.exception.NotFoundException;
import com.dan.model.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UserService implements Observer {

    private final List<User> users = new ArrayList<>();
    private final BookNotificationService bookNotificationService = new BookNotificationService();

    @Override
    public void notify(String message) {
        var usersToNotify = users.stream().filter(u -> u.getNotificationPreferences().isEnable()).toList();

        bookNotificationService.notify(usersToNotify);
    }

    static class UserServiceHolder {
        private static final UserService instance = new UserService();
    }

    private UserService() {
        BookService.getInstance().subscribe(this);
    }

    public static UserService getInstance() {
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

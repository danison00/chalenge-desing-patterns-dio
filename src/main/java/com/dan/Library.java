package com.dan;

import com.dan.model.entities.Book;
import com.dan.model.entities.NotificationPreferences;
import com.dan.model.entities.User;
import com.dan.service.implementations.BookServiceImpl;
import com.dan.service.implementations.LoanServiceImpl;
import com.dan.service.implementations.UserServiceImpl;
import com.dan.service.interfaces.BookService;
import com.dan.service.interfaces.LoanService;
import com.dan.service.interfaces.UserService;

import java.util.List;

public class Library {
    private final BookService bookService;

    private final UserService userService;
    private final LoanService loanService;

    public Library() {
        this.bookService = BookServiceImpl.getInstance();
        this.userService = UserServiceImpl.getInstance();
        this.loanService = LoanServiceImpl.getInstance();
    }

    public void run() {
        try {


            List.of(
                    new Book("To Kill a Mockingbird", "Harper Lee", 2),
                    new Book("1984", "George Orwell", 3),
                    new Book("The Great Gatsby", "F. Scott Fitzgerald", 1)
            ).forEach(bookService::create);


            List.of(
                    new User("John Doe", "123.456.789-00", "john@email.com", new NotificationPreferences(true, true, true)),
                    new User("Alice Smith", "987.654.321-00", "alice@email.com", new NotificationPreferences(true, true, false)),
                    new User("Bob Johnson", "111.222.333-44", "bob@email.com", new NotificationPreferences(false, false, true)),
                    new User("Mary Brown", "555.666.777-88", "mary@email.com", new NotificationPreferences(false, true, true)),
                    new User("Emily Davis", "999.888.777-66", "emily@email.com", new NotificationPreferences(false, true, false))
            ).forEach(userService::create);

            bookService.list();
            userService.list();
            loanService.toLoan(6, 1);
            loanService.list();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

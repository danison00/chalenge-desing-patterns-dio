package com.dan;

import com.dan.model.entities.Book;
import com.dan.model.entities.User;
import com.dan.service.BookService;
import com.dan.service.LoanService;
import com.dan.service.UserService;

import java.util.List;

public class AppSystem {
    BookService bookService = BookService.getInstance();
    UserService userService = UserService.getInstance();
    LoanService loanService = LoanService.getInstance(bookService, userService);

    public void run() {
        createBooks();
        createUsers();
        bookService.list();
        userService.list();
        try {
            loanService.toLoan(1, 1);
            bookService.list();
            loanService.toLoan(1, 1);
            bookService.list();
            loanService.toLoan(1, 1);
            bookService.list();
//            loanService.toLoan(1, 1);
//            loanService.toLoan(1, 1);
        } catch (Exception e) {

            System.out.printf("*** %s ***", e.getMessage());
        }
    }

    public void createBooks() {
        List.of(
                new Book("To Kill a Mockingbird", "Harper Lee", 2),
                new Book("1984", "George Orwell", 3),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", 1)
        ).forEach(b -> bookService.create(b));
    }

    public void createUsers() {
        List.of(
                new User("John Doe", "123.456.789-00", 30),
                new User("Alice Smith", "987.654.321-00", 25),
                new User("Bob Johnson", "111.222.333-44", 35),
                new User("Mary Brown", "555.666.777-88", 40),
                new User("Emily Davis", "999.888.777-66", 22)
        ).forEach(u -> userService.create(u));
    }
}

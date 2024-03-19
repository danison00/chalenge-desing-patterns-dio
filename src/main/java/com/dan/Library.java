package com.dan;

import com.dan.model.annotations.Inject;
import com.dan.model.annotations.Singleton;
import com.dan.model.entities.Book;
import com.dan.model.entities.NotificationPreferences;
import com.dan.model.entities.User;
import com.dan.service.implementations.BookServiceImpl;
import com.dan.service.implementations.LoanServiceImpl;
import com.dan.service.implementations.UserServiceImpl;

import java.util.List;

@Singleton
public class Library {
   private BookServiceImpl bookServiceImpl;
   @Inject
   private UserServiceImpl userService;
   private LoanServiceImpl loanServiceImpl;

    public Library(BookServiceImpl bookServiceImpl, LoanServiceImpl loanServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
        this.loanServiceImpl = loanServiceImpl;

    }

    public void run() {
        createUsers();
        createBooks();
        bookServiceImpl.list();
        userService.list();
        try {
           loanServiceImpl.toLoan(6, 1);
            loanServiceImpl.list();

        } catch (Exception e) {

            System.out.printf("*** %s ***", e.getMessage());
        }
    }

    public void createBooks() {



        List.of(
                new Book("To Kill a Mockingbird", "Harper Lee", 2),
                new Book("1984", "George Orwell", 3),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", 1)
        ).forEach(b -> bookServiceImpl.create(b));
    }

    public void createUsers() {


                List.of(
                new User("John Doe", "123.456.789-00", "john@email.com", new NotificationPreferences(true, true, true)),
                new User("Alice Smith", "987.654.321-00", "alice@email.com", new NotificationPreferences(true, true, false)),
                new User("Bob Johnson", "111.222.333-44", "bob@email.com", new NotificationPreferences(false, false, true)),
                new User("Mary Brown", "555.666.777-88", "mary@email.com", new NotificationPreferences(false, true, true)),
                new User("Emily Davis", "999.888.777-66", "emily@email.com", new NotificationPreferences(false, true, false))
        ).forEach(u -> userService.create(u));
    }
}

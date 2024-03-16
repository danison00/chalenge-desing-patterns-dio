package com.dan.service;

import com.dan.model.entities.Loan;
import com.dan.model.exception.NoAvailableCopiesExceptions;

import java.util.ArrayList;
import java.util.List;

public class LoanService {
    private static LoanService instance;

    private final List<Loan> loans = new ArrayList<>();
    private final BookService bookService;
    private final UserService userService;

    private LoanService(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    public static LoanService getInstance(BookService bookService, UserService userService) {
        if (instance == null)
            instance = new LoanService(bookService, userService);
        return instance;
    }

    public void toLoan(int bookId, int userId) throws RuntimeException {
        var book = bookService.findById(bookId);
        var user = userService.findById(userId);

        if (book.getAvailableCopies() <= 0)
            throw new NoAvailableCopiesExceptions("Não há disponível exemplares deste livro");

        book.decrementAvailableCopies();
        loans.add(new Loan(book, user));
        System.out.println("Empréstimo realizado com sucesso!");
    }

    public void list() {
        loans.forEach((l) -> {
            System.out.println(l.toString());
        });
    }
}

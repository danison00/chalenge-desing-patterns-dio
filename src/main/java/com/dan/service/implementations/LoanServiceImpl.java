package com.dan.service.implementations;


import com.dan.model.entities.Loan;
import com.dan.model.exception.NoAvailableCopiesExceptions;
import com.dan.service.interfaces.BookService;
import com.dan.service.interfaces.LoanService;
import com.dan.service.interfaces.UserService;

import java.util.ArrayList;
import java.util.List;

public class LoanServiceImpl implements LoanService {
    private final List<Loan> loans = new ArrayList<>();


    private static BookService bookService;
    private static UserService userService;

    private static LoanServiceImpl instance;

    public static LoanServiceImpl getInstance() {
        if (instance == null)
            instance = new LoanServiceImpl();
        return instance;
    }

    private LoanServiceImpl() {
        userService = UserServiceImpl.getInstance();
        bookService = BookServiceImpl.getInstance();
    }

    @Override
    public void toLoan(int bookId, int userId) {
        var book = bookService.findById(bookId);
        var user = userService.findById(userId);

        if (book.getAvailableCopies() <= 0) {
            System.out.println("Não há disponível exemplares deste livro");
            return;
        }

        book.decrementAvailableCopies();
        loans.add(new Loan(book, user));
        System.out.println("Empréstimo realizado com sucesso!");
    }

    @Override
    public void list() {
        loans.forEach((l) -> {
            System.out.println(l.toString());
        });
    }
}

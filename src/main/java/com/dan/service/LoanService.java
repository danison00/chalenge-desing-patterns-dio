package com.dan.service;

import com.dan.model.annotations.Inject;
import com.dan.model.annotations.Singleton;
import com.dan.model.entities.Loan;
import com.dan.model.exception.NoAvailableCopiesExceptions;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class LoanService {
    private final List<Loan> loans = new ArrayList<>();

    @Inject
    private  BookService bookService;
    @Inject
    private  UserService userService;




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

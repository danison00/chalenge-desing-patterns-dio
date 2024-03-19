package com.dan.service.implementations;

import com.dan.model.annotations.Singleton;
import com.dan.model.entities.Loan;
import com.dan.model.exception.NoAvailableCopiesExceptions;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class LoanServiceImpl {
    private final List<Loan> loans = new ArrayList<>();

    private BookServiceImpl bookServiceImpl;
    private UserServiceImpl userServiceImpl;

    public LoanServiceImpl(BookServiceImpl bookServiceImpl, UserServiceImpl userServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
        this.userServiceImpl = userServiceImpl;
    }

    public void toLoan(int bookId, int userId) throws RuntimeException {
        var book = bookServiceImpl.findById(bookId);
        var user = userServiceImpl.findById(userId);

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

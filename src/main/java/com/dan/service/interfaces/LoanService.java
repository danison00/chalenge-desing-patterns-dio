package com.dan.service.interfaces;

import com.dan.model.entities.Loan;
import com.dan.model.exception.NoAvailableCopiesExceptions;
import com.dan.service.implementations.BookServiceImpl;
import com.dan.service.implementations.UserServiceImpl;

public interface LoanService {

    void toLoan(int bookId, int userId) throws RuntimeException;

    public void list();

}

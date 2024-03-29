package com.dan.service.implementations;

import com.dan.model.entities.Book;
import com.dan.service.interfaces.BookService;
import com.dan.service.interfaces.observerPattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl extends AbstractServiceImpl<Book> implements BookService {
    private static final BookServiceImpl instance = new BookServiceImpl();

    private BookServiceImpl() {
    }

    public static BookServiceImpl getInstance() {
        return instance;
    }


    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        this.observers.add(observer);
    }


    @Override
    public void afterCreater(Book book) {
        System.out.printf("Livro %s adicionado a biblioteca!\n", book.getTitle());
        notifyObservers(book);
    }



    @Override
    public void notifyObservers(Book book) {
        StringBuilder message = new StringBuilder();
        message.append("O livro ").append(book.getTitle()).append(" já esta disponível em nossa biblioteca.");

        this.observers.forEach(o -> {
            o.notify(message.toString());
        });
    }


}

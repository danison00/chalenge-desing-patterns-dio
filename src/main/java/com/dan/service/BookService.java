package com.dan.service;

import com.dan.model.entities.Book;
import com.dan.model.exception.NotFoundException;
import com.dan.model.observer.Observable;
import com.dan.model.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class BookService extends AbstractService<Book> implements Observable<Book> {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        this.observers.add(observer);
    }


    private static class BookServiceHolder {
        private static final BookService instance = new BookService();
    }

    private BookService() {
    }

    public static BookService getInstance() {
        return BookServiceHolder.instance;
    }



    @Override
    protected void afterCreater(Book book) {
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

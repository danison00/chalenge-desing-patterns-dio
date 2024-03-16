package com.dan.service;

import com.dan.model.entities.Book;
import com.dan.model.exception.NotFoundException;
import com.dan.model.observer.Observable;
import com.dan.model.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class BookService implements Observable<Book> {

    private final List<Book> books = new ArrayList<>();

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        this.observers.add(observer);
    }


    static class BookServiceHolder {
        private static final BookService instance = new BookService();
    }

    private BookService() {
    }

    public static BookService getInstance() {
        return BookServiceHolder.instance;
    }

    public void create(Book book) {
        this.books.add(book);
        System.out.println("Livro criado com sucesso!");
        notifyObservers(book);
    }


    public void deleteById(int id) throws NotFoundException {
        findById(id);
        this.books.removeIf(b -> b.getId() == id);

    }

    public Book findById(int id) throws NotFoundException {
        for (var b : books)
            if (b.getId() == id)
                return b;

        throw new NotFoundException("Livro não encontrado");
    }

    public void list() {
        books.forEach((b) -> {
            System.out.println(b.toString());
        });
    }
    @Override
    public void notifyObservers(Book book) {
        StringBuilder message = new StringBuilder();
        message.append("Novo livro disponível em nossa biblioteca!\n")
                .append("Título: ").append(book.getTitle());

        this.observers.forEach(o -> {
            o.notify(message.toString());
        });
    }


}

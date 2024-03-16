package com.dan.service;

import com.dan.model.Book;
import com.dan.model.User;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    List<Book> books = new ArrayList<>();

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
    }

    public void deleteById(int id) {
        this.books.removeIf(b -> b.getId() == id);

    }

    public void listBooks() {
        System.out.println(this.books.toString());

    }
}

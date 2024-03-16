package com.dan.service;

import com.dan.model.entities.Book;
import com.dan.model.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private final List<Book> books = new ArrayList<>();

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

    public void deleteById(int id)  throws NotFoundException {
        findById(id);
        this.books.removeIf(b -> b.getId() == id);

    }
    public Book findById(int id) throws NotFoundException {
        for (var b: books)
            if(b.getId() == id)
                return b;

        throw new NotFoundException("Livro não encontrado");
    }

    public void listBooks() {
        books.forEach((b) -> {
            System.out.println(b.toString());
        });
    }
}

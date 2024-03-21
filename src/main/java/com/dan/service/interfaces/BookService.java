package com.dan.service.interfaces;

import com.dan.model.entities.Book;
import com.dan.service.interfaces.observerPattern.Observable;

public interface BookService extends Service<Book>, Observable<Book> {
}

package com.dan.model.observer;

import com.dan.model.entities.Book;

public interface Observable<T> {

     void subscribe(Observer observer);
     void notifyObservers(T t);


}

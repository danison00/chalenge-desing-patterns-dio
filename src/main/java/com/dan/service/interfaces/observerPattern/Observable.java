package com.dan.service.interfaces.observerPattern;

public interface Observable<T> {

     void subscribe(Observer observer);
     void notifyObservers(T t);


}

package com.dan.service.interfaces;

import com.dan.model.exception.NotFoundException;

import java.util.List;

public interface Service<T> {


    public void create(T t);

    default public void afterCreater(T t){

    }


    public void deleteById(int id) throws NotFoundException;

    public T findById(int id) throws NotFoundException ;

    public void list();
    public List<T> getList();
}

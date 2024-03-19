package com.dan.service.implementations;

import com.dan.model.entities.AbstractIdentifier;
import com.dan.model.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractServiceImpl<T extends AbstractIdentifier> {

    private final List<T> list = new ArrayList<>();


    public void create(T t) {
        this.list.add(t);
        afterCreater(t);
    }

    protected void afterCreater(T t){};


    public void deleteById(int id) throws NotFoundException {
        findById(id);
        this.list.removeIf(o -> o.getId() == id);

    }

    public T findById(int id) throws NotFoundException {
        for (var o : list)
            if (o.getId() == id)
                return o;

        throw new NotFoundException("Não encontrado");
    }

    public void list() {
        list.forEach((o) -> {
            System.out.println(o.toString());
        });

        System.out.println();
    }

    public List<T> getList() {
        return list;
    }
}

package com.example.hibernatecrud_spring.repository;

import java.util.List;

public interface GenericRepository<T, Id> {
    T add(T t);

    T update(T t);

    T find(Integer id);

    List<T> getAll();

    void delete(Integer id);

}

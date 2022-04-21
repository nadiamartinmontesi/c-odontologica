package com.example.demo.service;

//import com.example.demo.exceptions.NotFoundException;

import java.util.Set;

public interface ImplService<T> {

    T save(T t);
    Set<T> findAll();
    void deleteById(Integer id) /*throws NotFoundException*/;
    T findById(Integer id) /*throws NotFoundException*/;
    T update(T t);

}

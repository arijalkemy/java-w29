package com.example.deportes.repository.interfaces;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReadeable<T>{
    T getOneByName(String name);
    List<T> getAll();
}

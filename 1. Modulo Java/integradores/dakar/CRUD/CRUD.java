package com.example.demo.integradores.dakar.CRUD;

import java.util.*;

// Interfaz CRUD genérica
interface CRUD<T> {
    void create(T entity);

    Optional<T> read(String id);

    void update(String id, T entity);

    void delete(String id);

    List<T> listAll();
}
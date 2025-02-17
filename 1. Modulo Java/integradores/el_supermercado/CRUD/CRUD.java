package com.example.demo.integradores.el_supermercado.CRUD;

import com.example.demo.integradores.el_supermercado.Customer;

import java.util.*;
import java.util.stream.Collectors;

// Interfaz CRUD genérica
interface CRUD<T> {
    void create(T entity);

    Optional<T> read(String id);

    void update(String id, T entity);

    void delete(String id);

    List<T> listAll();
}
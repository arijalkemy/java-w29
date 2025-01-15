package com.example.ejercicio_blog.repository;

import java.util.List;
import java.util.Optional;

public interface IEntradaRepository<T> {
    List<T> getAll();
    Boolean add(T entrada);
    Optional<T> findById(Integer id);
}

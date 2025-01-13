package org.example.repository;

import java.util.List;
import java.util.Optional;

public interface ICRUDRepository <T> {
    void save(T entity);
    void printAll();
    Optional<T> findById(Long id);
    void delete(Long id);
    List<T> findAll();
}

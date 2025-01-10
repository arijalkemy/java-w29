package org.example.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<K,T> {
    List<T> findAll();
    Optional<T> findById(K id);
    Boolean save(T entity);
    Boolean delete(T entity);
}

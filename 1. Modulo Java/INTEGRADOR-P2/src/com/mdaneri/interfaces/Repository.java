package com.mdaneri.interfaces;

import java.util.List;
import java.util.Optional;

public interface Repository<K, T> {
    List<T> findAll();
    Optional<T> findById(K id);
    void save(T t);
    void delete(T t);
    void update(T t);
}

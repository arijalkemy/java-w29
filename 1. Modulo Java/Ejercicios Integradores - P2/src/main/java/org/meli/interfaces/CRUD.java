package org.meli.interfaces;

import java.util.List;
import java.util.Optional;

public interface CRUD<T> {
    void create(T entity);
    Optional<T> read(String id);
    void update(T entity);
    void delete(String id);
}
package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.repository;

import java.util.Optional;

public interface CrudRepository<T> {
    Optional<T> save(T t);
    Optional<T> update(T t);
    boolean delete(Integer id);
    Optional<T> findById(Integer id);
}

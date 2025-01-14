package org.example.repository;

import org.example.model.Invoice;

import java.util.Optional;
import java.util.List;

public interface CRUD <T> {

    public void save(T obj);
    public void show();
    public Optional<T> search(int id);
    public void delete(T obj);
    public List<T> all();
}

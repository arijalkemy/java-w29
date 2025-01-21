package com.example.linktracker.repository;

public interface ILinkRepository<T> {
    T save(T entity);
    T findById(Integer id);
}

package com.ejemplodeinyecciondependencias.book.service;

import com.ejemplodeinyecciondependencias.book.entity.Book;

import java.util.List;

public interface IBookService {
    public List<Book> findAll();
    public Book findById(Long id);
}

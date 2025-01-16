package com.ejemplodeinyecciondependencias.book.repository;

import com.ejemplodeinyecciondependencias.book.entity.Book;

import java.util.List;

public interface IBookRepository {
    public List<Book> traerBooks();
    public Book findById(Long id);
}

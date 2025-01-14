package com.ejemplodeinyecciondependencias.book.repository;

import com.ejemplodeinyecciondependencias.book.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryBook {

    public List<Book> findAll() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Book 1", "Author 1"));
        books.add(new Book(2, "Book 2", "Author 2"));

        return books;
    }
}

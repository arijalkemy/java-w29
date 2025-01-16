package com.ejemplodeinyecciondependencias.book.repository;

import com.ejemplodeinyecciondependencias.book.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryBookImp implements IBookRepository{


    public List<Book> findAll() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1L, "Book 1", "Author 1"));
        books.add(new Book(2L, "Book 2", "Author 2"));

        return books;
    }

    @Override
    public List<Book> traerBooks() {
        return findAll();
    }

    @Override
    public Book findById(Long id) {
        for (Book book : findAll()) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }
}

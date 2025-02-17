package com.bootcamp.elastic_obras.service;

import com.bootcamp.elastic_obras.dto.BookDto;

import java.util.List;

public interface IBooksService {
    List<BookDto> findAllBooks();

    List<BookDto> findBooksByAuthor(String author);

    List<BookDto> findBooksByName(String q);

    List<BookDto> findBooksBeforeYear(int firstPublishedYear);

    List<BookDto> findBooksByEditorial(String editorial);

    List<BookDto> findBooksWithMostPagesSorted();
}

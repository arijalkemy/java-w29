package com.example.demo.service;

import com.example.demo.dto.BookDto;

import java.util.List;

public interface IBookService {
    List<BookDto> findAllBooks();

    List<BookDto> findBooksByAuthor(String author);

    List<BookDto> findBooksByName(String q);

    List<BookDto> findBooksBeforeYear(Integer firstPublishedYear);

    List<BookDto> findBooksByEditorial(String editorial);

    List<BookDto> findBooksWithMostPagesSorted();

    BookDto addBook(BookDto bookDto);
}

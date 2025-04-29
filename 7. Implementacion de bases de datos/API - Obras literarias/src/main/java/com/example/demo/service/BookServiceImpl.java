package com.example.demo.service;

import com.example.demo.dto.BookDto;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    private BookRepository repository;
    private ModelMapper mapper ;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<BookDto> findAllBooks() {
        List<Book> books = new ArrayList<>();
        for (Book book : repository.findAll()) {
            books.add(book);
        }
        return books.stream().map(book -> mapper.map(book, BookDto.class)).toList();
    }

    @Override
    public List<BookDto> findBooksByAuthor(String author) {
        return repository.findByAuthor(author).stream()
                .map(b -> mapper.map(b, BookDto.class))
                .toList();
    }

    @Override
    public List<BookDto> findBooksByName(String q) {
        return repository.findByNameContains(q).stream()
                .map(book -> mapper.map(book,BookDto.class))
                .toList();
    }

    @Override
    public List<BookDto> findBooksBeforeYear(Integer firstPublishedYear) {
        return repository.findByFirstPublishedYearLessThanEqual(firstPublishedYear).stream()
                .map(book -> mapper.map(book,BookDto.class))
                .toList();
    }

    @Override
    public List<BookDto> findBooksByEditorial(String editorial) {
        return repository.findByEditorial(editorial).stream()
                .map(book -> mapper.map(book,BookDto.class))
                .toList();
    }

    @Override
    public List<BookDto> findBooksWithMostPagesSorted() {
        List<Book> books = new ArrayList<>();
        for (Book book : repository.findTop5ByNumOfPages()) {
            books.add(book);
        }
        return books.stream().map(book -> mapper.map(book, BookDto.class))
                .toList();
    }

    @Override
    public BookDto addBook(BookDto bookDto) {
        repository.save(mapper.map(bookDto,Book.class));
        return bookDto;
    }
}

package com.bootcamp.elastic_obras.service;

import com.bootcamp.elastic_obras.dto.BookDto;
import com.bootcamp.elastic_obras.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class BooksService implements IBooksService{
    private BookRepository repo;
    private ModelMapper mapper;

    @Autowired
    public BooksService(BookRepository repo) {
        this.repo = repo;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<BookDto> findAllBooks() {
        return StreamSupport.stream(repo.findAll().spliterator(), false)
                .map(b -> mapper.map(b, BookDto.class))
                .toList();
    }

    @Override
    public List<BookDto> findBooksByAuthor(String author) {
        return repo.findByAuthor(author).stream()
                .map(b -> mapper.map(b, BookDto.class))
                .toList();
    }

    @Override
    public List<BookDto> findBooksByName(String q) {
        return repo.findByNameContains(q).stream()
                .map(b -> mapper.map(b, BookDto.class))
                .toList();
    }

    @Override
    public List<BookDto> findBooksBeforeYear(int firstPublishedYear) {
        return repo.findByFirstPublishedYearLessThanEqual(firstPublishedYear).stream()
                .map(b -> mapper.map(b, BookDto.class))
                .toList();
    }

    @Override
    public List<BookDto> findBooksByEditorial(String editorial) {
        return repo.findByEditorial(editorial).stream()
                .map(b -> mapper.map(b, BookDto.class))
                .toList();
    }

    @Override
    public List<BookDto> findBooksWithMostPagesSorted() {
        return StreamSupport.stream(repo.findAll(PageRequest.of(0, 5, Sort.by(Sort.Order.by("no_of_pages")).descending())).spliterator(), false)
                .map(b -> mapper.map(b, BookDto.class))
                .toList();
    }
}

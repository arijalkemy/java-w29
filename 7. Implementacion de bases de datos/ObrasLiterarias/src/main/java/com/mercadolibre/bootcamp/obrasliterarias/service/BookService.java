package com.mercadolibre.bootcamp.obrasliterarias.service;

import com.mercadolibre.bootcamp.obrasliterarias.dto.BookDTO;
import com.mercadolibre.bootcamp.obrasliterarias.model.Book;
import com.mercadolibre.bootcamp.obrasliterarias.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void create(BookDTO bookDTO) {
        bookRepository.save(BookDTO.to(bookDTO));
    }

    @Override
    public List<BookDTO> searchAllByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        return books.stream()
                .map(BookDTO::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> searchAllByTitleContaining(String query) {
        List<Book> books = bookRepository.findByTitleContaining(query);
        return books.stream()
                .map(BookDTO::from)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getTop5BooksByPagesCount() {
        List<Book> books = bookRepository.findTop5ByOrderByPagesCountDesc();
        return books.stream()
                .map(BookDTO::from)
                .collect(Collectors.toList());
    }

    public List<BookDTO> searchAllByEditorial(String editorial) {
        List<Book> books = bookRepository.findByEditorial(editorial);
        return books.stream()
                .map(BookDTO::from)
                .collect(Collectors.toList());
    }

}

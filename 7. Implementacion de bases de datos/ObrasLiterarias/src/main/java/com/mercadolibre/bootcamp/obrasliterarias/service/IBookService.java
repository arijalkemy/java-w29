package com.mercadolibre.bootcamp.obrasliterarias.service;

import com.mercadolibre.bootcamp.obrasliterarias.dto.BookDTO;
import com.mercadolibre.bootcamp.obrasliterarias.model.Book;

import java.util.List;

public interface IBookService {

    void create(BookDTO bookDTO);
    List<BookDTO> searchAllByAuthor(String author);
    List<BookDTO> searchAllByTitleContaining(String query);
    List<BookDTO> getTop5BooksByPagesCount();
    List<BookDTO> searchAllByEditorial(String editorial);

}

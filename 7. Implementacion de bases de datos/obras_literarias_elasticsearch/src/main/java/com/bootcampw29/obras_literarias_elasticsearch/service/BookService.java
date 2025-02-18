package com.bootcampw29.obras_literarias_elasticsearch.service;

import com.bootcampw29.obras_literarias_elasticsearch.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> searchBooksByAuthor(String author);
    List<BookDTO> searchBooksByKeywordTitle(String keyword);
    List<BookDTO> searchTop5BooksByPages();
}

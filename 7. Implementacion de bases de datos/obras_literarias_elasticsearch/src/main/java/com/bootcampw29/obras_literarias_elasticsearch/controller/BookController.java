package com.bootcampw29.obras_literarias_elasticsearch.controller;

import com.bootcampw29.obras_literarias_elasticsearch.dto.BookDTO;
import com.bootcampw29.obras_literarias_elasticsearch.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getBooksByAuthor(@RequestParam String author) {
        return new ResponseEntity<>(this.bookService.searchBooksByAuthor(author), HttpStatus.OK);
    }

    @GetMapping("/title")
    public ResponseEntity<List<BookDTO>> getBooksByTitleKeyword(@RequestParam String keyword) {
        return new ResponseEntity<>(this.bookService.searchBooksByKeywordTitle(keyword), HttpStatus.OK);
    }

    @GetMapping("/top5")
    public ResponseEntity<List<BookDTO>> getTop5BooksByPages() {
        return new ResponseEntity<>(this.bookService.searchTop5BooksByPages(), HttpStatus.OK);
    }
}

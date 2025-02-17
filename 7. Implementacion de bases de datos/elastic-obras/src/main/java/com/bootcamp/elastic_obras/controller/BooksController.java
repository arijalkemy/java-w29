package com.bootcamp.elastic_obras.controller;

import com.bootcamp.elastic_obras.dto.BookDto;
import com.bootcamp.elastic_obras.model.Book;
import com.bootcamp.elastic_obras.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final IBooksService service;

    @Autowired
    public BooksController(IBooksService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return ResponseEntity.ok(service.findAllBooks());
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<BookDto>> getBooksByAuthor(@PathVariable String author){
        return ResponseEntity.ok(service.findBooksByAuthor(author));
    }

    @GetMapping("/name")
    public ResponseEntity<List<BookDto>> getBooksByName(@RequestParam String q){
        return ResponseEntity.ok(service.findBooksByName(q));
    }

    @GetMapping("/year/{firstPublishedYear}")
    public ResponseEntity<List<BookDto>> getBooksBeforeYear(@PathVariable int firstPublishedYear){
        return ResponseEntity.ok(service.findBooksBeforeYear(firstPublishedYear));
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<BookDto>> getBookByEditorial(@PathVariable String editorial){
        return ResponseEntity.ok(service.findBooksByEditorial(editorial));
    }

    @GetMapping("/mostPages")
    public ResponseEntity<List<BookDto>> getBooksWithMostPagesSorted(){
        return ResponseEntity.ok(service.findBooksWithMostPagesSorted());
    }
}

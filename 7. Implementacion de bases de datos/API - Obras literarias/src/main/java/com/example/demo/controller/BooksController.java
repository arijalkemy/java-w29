package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.service.IBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final IBookService service;

    public BooksController(IBookService service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto){
        return new ResponseEntity<>(service.addBook(bookDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return new ResponseEntity<>(service.findAllBooks(),HttpStatus.OK );
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<Iterable<BookDto>> getBooksByAuthor(@PathVariable String author){
        return ResponseEntity.ok(service.findBooksByAuthor(author));
    }

    @GetMapping("/name")
    public ResponseEntity<List<BookDto>> getBooksByName(@RequestParam String q){
        return new ResponseEntity<>(service.findBooksByName(q),HttpStatus.OK);
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

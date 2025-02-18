package com.mercadolibre.bootcamp.obrasliterarias.controller;

import com.mercadolibre.bootcamp.obrasliterarias.dto.BookDTO;
import com.mercadolibre.bootcamp.obrasliterarias.service.IBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody BookDTO bookDTO) {
        bookService.create(bookDTO);
        return ResponseEntity.ok("Book saved succesfully");
    }

    @GetMapping("/by-author")
    public ResponseEntity<List<BookDTO>> getAllByAuthor(@RequestParam String author) {
        return ResponseEntity.ok(bookService.searchAllByAuthor(author));
    }

    @GetMapping("/title-containing")
    public ResponseEntity<List<BookDTO>> getAllByTitleContaining(@RequestParam String query) {
        return ResponseEntity.ok(bookService.searchAllByTitleContaining(query));
    }

    @GetMapping("/top5-by-pages")
    public ResponseEntity<List<BookDTO>> getTop5BooksByPagesCount() {
        return ResponseEntity.ok(bookService.getTop5BooksByPagesCount());
    }

    @GetMapping("/by-editorial") // Nuevo endpoint
    public ResponseEntity<List<BookDTO>> getAllByEditorial(@RequestParam String editorial) {
        return ResponseEntity.ok(bookService.searchAllByEditorial(editorial));
    }

}

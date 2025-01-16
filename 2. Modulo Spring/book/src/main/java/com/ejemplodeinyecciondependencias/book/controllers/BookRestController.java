package com.ejemplodeinyecciondependencias.book.controllers;

import com.ejemplodeinyecciondependencias.book.entity.Book;
import com.ejemplodeinyecciondependencias.book.repository.RepositoryBookImp;
import com.ejemplodeinyecciondependencias.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRestController {

    //Como resultado de usar la anotación @Autowired, Spring inyecta la propiedad repository cuando BookController es creado.
    @Autowired
    IBookService serviceBook;

    @GetMapping
    public List<Book> findAllBooks() {
        return serviceBook.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id){
        return serviceBook.findById(id);
    }
}

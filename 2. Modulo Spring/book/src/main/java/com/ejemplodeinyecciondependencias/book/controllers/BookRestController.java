package com.ejemplodeinyecciondependencias.book.controllers;

import com.ejemplodeinyecciondependencias.book.entity.Book;
import com.ejemplodeinyecciondependencias.book.repository.RepositoryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRestController {

    //Como resultado de usar la anotación @Autowired, Spring inyecta la propiedad repository cuando BookController es creado.
    @Autowired
    RepositoryBook repositoryBook;

    @RequestMapping("/books")
    public List<Book> findAllBooks() {
        return repositoryBook.findAll();
    }
}

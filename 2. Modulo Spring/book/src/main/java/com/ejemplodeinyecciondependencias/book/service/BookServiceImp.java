package com.ejemplodeinyecciondependencias.book.service;

import com.ejemplodeinyecciondependencias.book.entity.Book;
import com.ejemplodeinyecciondependencias.book.exceptions.NotFoundExceptionBook;
import com.ejemplodeinyecciondependencias.book.repository.RepositoryBookImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements IBookService{

    @Autowired
    RepositoryBookImp repositoryBookImp;

    @Override
    public List<Book> findAll() {
        return repositoryBookImp.traerBooks();
    }

    @Override
    public Book findById(Long id) {
        Book libroEncontrado = repositoryBookImp.findById(id);
        if (libroEncontrado == null){
            throw new NotFoundExceptionBook("No se ha encontrado el libro "+id +" en la base de datos");
        }
        return libroEncontrado;
    }
}

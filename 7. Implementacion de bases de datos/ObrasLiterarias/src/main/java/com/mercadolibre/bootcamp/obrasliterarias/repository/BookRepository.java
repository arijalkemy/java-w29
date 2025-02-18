package com.mercadolibre.bootcamp.obrasliterarias.repository;

import com.mercadolibre.bootcamp.obrasliterarias.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends ElasticsearchRepository<Book, String> {

    List<Book> findByAuthor(String author);
    List<Book> findByTitleContaining(String query);
    List<Book> findTop5ByOrderByPagesCountDesc();
    List<Book> findByEditorial(String editorial);
}

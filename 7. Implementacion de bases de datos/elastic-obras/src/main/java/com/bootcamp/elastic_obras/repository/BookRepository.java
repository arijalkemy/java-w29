package com.bootcamp.elastic_obras.repository;

import com.bootcamp.elastic_obras.model.Book;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {
    List<Book> findByAuthor(String author);
    List<Book> findByNameContains(String name);
    List<Book> findByFirstPublishedYearLessThanEqual(int year);
    List<Book> findByEditorial(String editorial);
}

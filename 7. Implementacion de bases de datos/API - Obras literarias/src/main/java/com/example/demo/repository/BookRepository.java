package com.example.demo.repository;


import com.example.demo.model.Book;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends ElasticsearchRepository<Book,String> {
    List<Book> findByAuthor(String author);
    List<Book> findByNameContains(String name);
    List<Book> findByFirstPublishedYearLessThanEqual(int year);
    List<Book> findByEditorial(String editorial);

    @Query("{\"query\": {\"match_all\": {}}, \"size\": 5, \"sort\": [{\"no_of_pages\": {\"order\": \"desc\"}}]}")
    List<Book> findTop5ByNumOfPages();
    //Iterable<Book> findTop5ByOrderByCantidadPaginasDesc();
}

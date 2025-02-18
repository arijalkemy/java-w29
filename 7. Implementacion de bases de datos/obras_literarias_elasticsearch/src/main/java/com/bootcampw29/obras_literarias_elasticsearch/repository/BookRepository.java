package com.bootcampw29.obras_literarias_elasticsearch.repository;

import com.bootcampw29.obras_literarias_elasticsearch.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends ElasticsearchRepository<Book, String> {
    List<Book> findBooksByAuthor(String author);
}

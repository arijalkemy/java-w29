package com.bootcampw29.obras_literarias_elasticsearch.service;

import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import com.bootcampw29.obras_literarias_elasticsearch.dto.BookDTO;
import com.bootcampw29.obras_literarias_elasticsearch.model.Book;
import com.bootcampw29.obras_literarias_elasticsearch.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ElasticsearchOperations elasticsearchOperations;
    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, ElasticsearchOperations elasticsearchOperations) {
        this.bookRepository = bookRepository;
        this.elasticsearchOperations = elasticsearchOperations;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<BookDTO> searchBooksByAuthor(String author) {
        List<Book> books = this.bookRepository.findBooksByAuthor(author);
        return books.stream()
                .map(b -> modelMapper.map(b, BookDTO.class))
                .toList();
    }

    @Override
    public List<BookDTO> searchBooksByKeywordTitle(String keyword) {

        NativeQuery query = NativeQuery.builder()
                .withQuery(q -> q
                        .match(m -> m
                                .field("title")
                                .query(keyword)
                        )
                )
                .build();

        SearchHits<Book> bookSearchHits = elasticsearchOperations.search(query, Book.class);
        return bookSearchHits.stream()
                .map(searchHit -> modelMapper.map(searchHit.getContent(), BookDTO.class))
                .toList();
    }

    @Override
    public List<BookDTO> searchTop5BooksByPages() {
        NativeQuery query = NativeQuery
                .builder()
                .withSort(s -> s.
                        field(f -> f
                                .field("numberOfPages")
                                .order(SortOrder.Desc)))
                .withMaxResults(5)
                .build();
        SearchHits<Book> bookSearchHits = elasticsearchOperations.search(query, Book.class);
        return bookSearchHits.stream()
                .map(searchHit -> modelMapper.map(searchHit.getContent(), BookDTO.class))
                .toList();
    }
}

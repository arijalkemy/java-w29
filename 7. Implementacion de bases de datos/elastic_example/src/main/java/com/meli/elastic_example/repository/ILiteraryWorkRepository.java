package com.meli.elastic_example.repository;

import com.meli.elastic_example.entity.LiteraryWork;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ILiteraryWorkRepository extends ElasticsearchRepository<LiteraryWork, String> {
    List<LiteraryWork> findLiteraryWorksByAuthor(String author);
    List<LiteraryWork> findLiteraryWorksByName(String name);
    List<LiteraryWork> findTop5LiteraryWorksByOrderByNumberOfPagesDesc();
    List<LiteraryWork> findLiteraryWorksByPublicationYearBefore(String year);
    List<LiteraryWork> findLiteraryWorksByEditorial(String editorial);
}

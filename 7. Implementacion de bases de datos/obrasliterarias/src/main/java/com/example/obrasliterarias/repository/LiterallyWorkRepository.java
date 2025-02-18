package com.example.obrasliterarias.repository;

import com.example.obrasliterarias.model.LiterallyWork;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface LiterallyWorkRepository extends ElasticsearchRepository<LiterallyWork, String> {
    List<LiterallyWork>  findLiterallyWorkByAuthorNameContaining(String name);
    List<LiterallyWork> findLiterallyWorkByNameContaining(String name);
    List<LiterallyWork> findAllByOrderByQuantityPagesDesc();

    // Alternative
    //@Query("{ \"size\": 5, \"sort\": [{ \"quantityPages\": \"desc\" }] }")
    //List<LiterallyWork> findTop5ByQuantityPages();

    List<LiterallyWork> findLiterallyWorkByYearBefore(Integer year);
    List<LiterallyWork> findLiterallyWorkByEditorial_NameContaining(String editorialName);
}

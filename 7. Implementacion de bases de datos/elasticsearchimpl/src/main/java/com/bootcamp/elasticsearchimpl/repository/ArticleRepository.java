package com.bootcamp.elasticsearchimpl.repository;

import com.bootcamp.elasticsearchimpl.model.Article;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {
//
//    @Query ("{\n" +
//            "  \"query\": {\n" +
//            "    \"match_all\": {}\n" +
//            "  }")
    List<Article> findAll();

}

package com.bootcamp.elasticsearchimpl.service;

import com.bootcamp.elasticsearchimpl.dto.ArticleDTO;
import com.bootcamp.elasticsearchimpl.model.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    public ArticleDTO save (ArticleDTO artic);

    public List<Article> findAll();

    public Optional<Article> findById(int id);

    public String deleteArticle (int id);

    public String editArticle (Article article);
}

package com.bootcamp.elasticsearchimpl.service;

import com.bootcamp.elasticsearchimpl.dto.ArticleDTO;
import com.bootcamp.elasticsearchimpl.model.Article;
import com.bootcamp.elasticsearchimpl.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImpArticleService implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public ArticleDTO save(ArticleDTO artic) {
        // Se agregó DTO para que funcione
        Article article = new Article(artic.getId(), artic.getTitle(), List.of());
        Article savedArticle = articleRepository.save(article);
        return new ArticleDTO(savedArticle.getId(), savedArticle.getTitle());
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    //va optional porque puede que devuelva como puede que no
    public Optional<Article> findById (int id) {
        return articleRepository.findById(id);

    }

    @Override
    public String deleteArticle(int id) {
        articleRepository.deleteById(id);
        return "Artículo eliminado correctamente";
    }

    @Override
    public String editArticle (Article art) {
        articleRepository.save(art);
        return "Articulo modificado correctamente";
    }
}

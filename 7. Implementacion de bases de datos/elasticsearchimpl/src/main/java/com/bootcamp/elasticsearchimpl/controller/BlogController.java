package com.bootcamp.elasticsearchimpl.controller;

import com.bootcamp.elasticsearchimpl.dto.ArticleDTO;
import com.bootcamp.elasticsearchimpl.model.Article;
import com.bootcamp.elasticsearchimpl.service.ArticleService;
import org.apache.coyote.Response;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/article/new")
    public ResponseEntity<?> save (@RequestBody ArticleDTO artic) {
        return new ResponseEntity<>(articleService.save(artic), HttpStatus.OK);

    }

    @GetMapping("/article")
    public ResponseEntity<?> findAll () {

        return new ResponseEntity<>(articleService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/article/{id}")
    //va optional porque puede que devuelva como puede que no
    public Optional<Article> findById(@PathVariable int id) {

        return articleService.findById(id);
    }

    @DeleteMapping ("article/delete/{id}")
    public String deleteArticle (@PathVariable int id) {

        return articleService.deleteArticle(id);
    }

    @PutMapping ("article/edit")
    public String editArticle (@RequestBody Article artic) {

        return articleService.editArticle(artic);
    }

}

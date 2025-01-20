package com.example.blog_exercise.service;


import com.example.blog_exercise.entity.EntradaBlog;
import com.example.blog_exercise.exception.BlogAlreadyExistsException;
import com.example.blog_exercise.exception.BlogNotFoundException;
import com.example.blog_exercise.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {

    private IBlogRepository repository;

    public BlogServiceImpl(IBlogRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<EntradaBlog> getAllBlogs() {
        return repository.getAllBlogs();
    }

    @Override
    public Optional<EntradaBlog> getBlogById(Long id) {
        Optional<EntradaBlog> blog = repository.getBlogById(id);

        if(blog.isEmpty()) {
            throw new BlogNotFoundException("El blog con el id " + id + " no existe.");
        }

        return blog;
    }

    @Override
    public Long saveBlog(EntradaBlog blog) {
        if(blogExists(blog.getId())) {
            throw new BlogAlreadyExistsException("El blog con el id " + blog.getId() + " ya existe.");
        }

        return repository.saveBlog(blog);
    }

    public boolean blogExists(Long id){
        return repository.getBlogById(id).isPresent();
    }
}

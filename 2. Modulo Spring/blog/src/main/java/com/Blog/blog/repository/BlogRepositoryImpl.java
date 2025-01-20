package com.Blog.blog.repository;

import com.Blog.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {
    private List<EntradaBlog> blogs = new ArrayList<>();

    @Override
    public EntradaBlog addBlog(EntradaBlog entradaBlog) {
        blogs.add(entradaBlog);
        return entradaBlog;
    }

    @Override
    public Optional<EntradaBlog> findById(Integer id) {
        return blogs.stream().filter(b->b.getId().equals(id)).findFirst();
    }

    @Override
    public List<EntradaBlog> findAll() {
        return blogs;
    }


}

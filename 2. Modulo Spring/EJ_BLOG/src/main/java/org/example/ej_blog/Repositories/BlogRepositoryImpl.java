package org.example.ej_blog.Repositories;

import org.example.ej_blog.Entities.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    private final List<EntradaBlog> blogs;

    public BlogRepositoryImpl() {
        this.blogs = new ArrayList<>();
    }

    @Override
    public EntradaBlog addBlog(EntradaBlog blog) {
        blogs.add(blog);
        return blog;
    }

    @Override
    public Optional<EntradaBlog> getBlogById(Integer id) {
        return blogs
                .stream()
                .filter(e -> e.getIdBlog().equals(id))
                .findFirst();
    }

    @Override
    public List<EntradaBlog> getAllBlogs() {
        return blogs
                .stream().toList();
    }
}

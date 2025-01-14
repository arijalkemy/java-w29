package com.bootcamp.manejo_excepciones_blog.repository;

import com.bootcamp.manejo_excepciones_blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepository {

    private Map<Integer, EntradaBlog> blogs;

    public BlogRepository() {
        this.blogs = new HashMap<>();
    }

    public Integer saveBlog(EntradaBlog entradaBlog) {
        blogs.put(entradaBlog.getBlogId(), entradaBlog);
        return entradaBlog.getBlogId();
    }

    public EntradaBlog getBlogById(Integer id) {
        return blogs.get(id);
    }

    public List<EntradaBlog> getAllBlogs() {
        return new ArrayList<>(blogs.values());
    }
}

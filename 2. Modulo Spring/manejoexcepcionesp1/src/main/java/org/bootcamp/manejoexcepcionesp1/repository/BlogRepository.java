package org.bootcamp.manejoexcepcionesp1.repository;

import org.bootcamp.manejoexcepcionesp1.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepository implements IBlogRepository {
    private List<EntradaBlog> blogs = new ArrayList<>();

    @Override
    public EntradaBlog crearEntradaBlog(EntradaBlog blog) {
        blogs.add(blog);
        return blog;
    }

    @Override
    public Optional<EntradaBlog> getById(Long id) {
        return blogs.stream().filter(blog -> blog.getId().equals(id)).findFirst();
    }

    @Override
    public List<EntradaBlog> getAll() {
        return blogs;
    }
}
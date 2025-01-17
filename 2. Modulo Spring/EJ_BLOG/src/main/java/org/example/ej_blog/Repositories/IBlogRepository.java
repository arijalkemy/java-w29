package org.example.ej_blog.Repositories;

import org.example.ej_blog.Entities.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {

    EntradaBlog addBlog(EntradaBlog blog);

    Optional<EntradaBlog> getBlogById(Integer id);

    List<EntradaBlog> getAllBlogs();
}

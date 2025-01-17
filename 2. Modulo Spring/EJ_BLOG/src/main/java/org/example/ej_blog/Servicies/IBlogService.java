package org.example.ej_blog.Servicies;

import org.example.ej_blog.Dtos.BlogDto;
import org.example.ej_blog.Entities.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    EntradaBlog addBlog(BlogDto blog);

    Optional<BlogDto> findBlogById(Integer id);

    List<BlogDto> getAllBlogs();

}

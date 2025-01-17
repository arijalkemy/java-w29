package org.example.ej_blog.Servicies;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ej_blog.Dtos.BlogDto;
import org.example.ej_blog.Entities.EntradaBlog;
import org.example.ej_blog.Exceptions.ConflictException;
import org.example.ej_blog.Exceptions.NoFoundBlog;
import org.example.ej_blog.Repositories.BlogRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {


    private final BlogRepositoryImpl repository;
    ObjectMapper mapper = new ObjectMapper();


    public BlogServiceImpl(BlogRepositoryImpl repository) {

        this.repository = repository;
    }

    @Override
    public EntradaBlog addBlog(BlogDto blogDto) {
        Optional<EntradaBlog> blog = repository.getBlogById(blogDto.getIdBlog());

        if (blog.isPresent()) {
            throw new ConflictException("Entrada con id " + blogDto.getIdBlog() + " ya existe");
        }

        return repository.addBlog(mapper.convertValue(blogDto, EntradaBlog.class));
    }

    @Override
    public Optional<BlogDto> findBlogById(Integer id) {
        Optional<EntradaBlog> blog = repository.getBlogById(id);
        if (blog.isEmpty()) {
            throw new NoFoundBlog("No existe el blog con el id: " + id);
        }
        return blog.map(b -> mapper.convertValue(b, BlogDto.class));
    }

    @Override
    public List<BlogDto> getAllBlogs() {
        List<EntradaBlog> blog = repository.getAllBlogs();

        return  blog.stream().map( blog1 -> mapper.convertValue(blog1, BlogDto.class))
                .toList();
    }
}

package com.meli.scaffolding.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.scaffolding.dto.BlogDto;
import com.meli.scaffolding.entity.Blog;
import com.meli.scaffolding.exception.AlreadyExistsException;
import com.meli.scaffolding.exception.NotFoundException;
import com.meli.scaffolding.repositories.IBlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements IBlogService{

    private final IBlogRepository blogRepository;

    @Override
    public BlogDto save(BlogDto blog) {
        ObjectMapper om = new ObjectMapper();
        Blog blogEntity = om.convertValue(blog, Blog.class);
        Optional<Blog> blogResponse = this.blogRepository.save(blogEntity);
        System.out.println(blogResponse);
        if (blogResponse.isEmpty()) {
            System.out.println("Llega aca");
            throw new AlreadyExistsException("Este Blog ya esta registrado");
        }
        BlogDto blogDto = om.convertValue(blogResponse.get(), BlogDto.class);
        return blogDto;
    }

    @Override
    public BlogDto getById(Integer id) {
        ObjectMapper om = new ObjectMapper();
        Optional<Blog> blog = this.blogRepository.getById(id);

        if (blog.isEmpty()) {
            throw new NotFoundException("No se ha encontrado un blog con el id " + id);
        }

        BlogDto blogDto = om.convertValue(blog.get(), BlogDto.class);
        return blogDto;
    }

    @Override
    public List<BlogDto> getAll() {
        ObjectMapper om = new ObjectMapper();
        List<Blog> blogs = this.blogRepository.findAll();
        return blogs.stream().map(b -> om.convertValue(b, BlogDto.class)).toList();
    }
}

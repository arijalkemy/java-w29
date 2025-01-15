package com.Blog.blog.service;

import com.Blog.blog.dto.AddBlogDto;
import com.Blog.blog.dto.ResponseBlogDto;
import com.Blog.blog.entity.EntradaBlog;
import com.Blog.blog.exception.ConflictException;
import com.Blog.blog.exception.NotFound;
import com.Blog.blog.repository.IBlogRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BlogService implements IBlogService{
    private IBlogRepository repostory;
    private ObjectMapper objMapper;

    public BlogService(IBlogRepository repository, ObjectMapper objMapper) {
        this.repostory= repository;
        this.objMapper = objMapper;
    }

    @Override
    public ResponseBlogDto addBlog(AddBlogDto blogDto) {
        Optional<EntradaBlog> op = repostory.findById(blogDto.getId());
        if (op.isPresent()){
            throw new ConflictException("El Blog ya Existe");
        }
        EntradaBlog entrada = objMapper.convertValue(blogDto,EntradaBlog.class);
        ResponseBlogDto response = objMapper.convertValue(repostory.addBlog(entrada),ResponseBlogDto.class);
        response.setMensaje("Se creo el Blog correctamente.");
        return response;
    }

    @Override
    public AddBlogDto getBlogById(Integer id) {
        Optional<EntradaBlog> op = repostory.findById(id);
        if (op.isEmpty()){
            throw new NotFound("No existe el blog.");
        }
        return objMapper.convertValue(op.get(),AddBlogDto.class);
    }

    @Override
    public List<AddBlogDto> getAllBlogs() {

        List<EntradaBlog> blogs = repostory.getAllBlogs();
        if (blogs.isEmpty()){
            throw new NotFound("No hay Blogs.");
        }
        return objMapper.convertValue(blogs, new TypeReference<List<AddBlogDto>>() {});
    }
}

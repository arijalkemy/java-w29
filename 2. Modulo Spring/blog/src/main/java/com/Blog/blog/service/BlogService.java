package com.Blog.blog.service;

import com.Blog.blog.dto.AddBlogDto;
import com.Blog.blog.dto.ResponseBlogDto;
import com.Blog.blog.entity.EntradaBlog;
import com.Blog.blog.exception.ConflictException;
import com.Blog.blog.exception.NotFoundException;
import com.Blog.blog.repository.IBlogRepository;
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
    public AddBlogDto getBlog(Integer id) {
        Optional<EntradaBlog> entradaBlog = repostory.findById(id);
        if (entradaBlog.isEmpty()){
            throw new NotFoundException("No se encontro ningun blog");
        }
        return objMapper.convertValue(entradaBlog,AddBlogDto.class);
    }

    @Override
    public List<AddBlogDto> getAllBlogs() {
        if (repostory.findAll().isEmpty()){
            throw new NotFoundException("No Hay Ningun blog creado");
        }
        return  repostory.findAll().stream().map(r-> objMapper.convertValue(r,AddBlogDto.class)).toList();
    }


}

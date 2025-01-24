package com.meliBootcamp.Exceptions.service;

import Utils.MyMapper;
import com.meliBootcamp.Exceptions.dto.BlogDTO;
import com.meliBootcamp.Exceptions.entity.Blog;
import com.meliBootcamp.Exceptions.repository.IRepositoryBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    IRepositoryBlog repository;
    @Override
    public String crearPost(Blog blog) {
        repository.guardarBlog(blog);
        return "El blog fue creado correctamente el id es: /blog/"+ blog.getId();
    }

    @Override
    public BlogDTO devolverBLog(String id) {
        return MyMapper.blogADto(repository.buscarBlog(id));
    }

    @Override
    public List<BlogDTO> listarBLogs() {

        return repository.buscarBlogs().stream().map(MyMapper::blogADto).toList();
    }
}

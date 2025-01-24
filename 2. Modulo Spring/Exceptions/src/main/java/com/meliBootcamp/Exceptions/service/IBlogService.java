package com.meliBootcamp.Exceptions.service;

import com.meliBootcamp.Exceptions.dto.BlogDTO;
import com.meliBootcamp.Exceptions.entity.Blog;

import java.util.List;

public interface IBlogService {
    public String crearPost(Blog blog);
    public BlogDTO devolverBLog(String id);
    public List<BlogDTO> listarBLogs();

}

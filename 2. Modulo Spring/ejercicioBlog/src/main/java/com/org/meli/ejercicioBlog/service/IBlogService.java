package com.org.meli.ejercicioBlog.service;

import com.org.meli.ejercicioBlog.dto.EntradaBlogDto;
import com.org.meli.ejercicioBlog.dto.response.NuevaEntradaBlogDto;

import java.util.List;

public interface IBlogService {
    EntradaBlogDto getBlogById(Integer id);
    List<EntradaBlogDto> getAll();
    NuevaEntradaBlogDto createBlog(EntradaBlogDto entradaBlogDto);
}

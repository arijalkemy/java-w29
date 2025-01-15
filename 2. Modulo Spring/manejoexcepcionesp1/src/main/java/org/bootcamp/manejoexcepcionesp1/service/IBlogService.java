package org.bootcamp.manejoexcepcionesp1.service;

import org.bootcamp.manejoexcepcionesp1.dto.EntradaBlogDto;

import java.util.List;

public interface IBlogService {
    String crearEntradaBlog(EntradaBlogDto blog);
    EntradaBlogDto getEntradaBlog(Long id);
    List<EntradaBlogDto> getAllEntradasBlog();
}
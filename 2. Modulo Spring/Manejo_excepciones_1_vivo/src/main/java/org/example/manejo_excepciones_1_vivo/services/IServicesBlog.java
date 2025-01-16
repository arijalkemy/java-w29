package org.example.manejo_excepciones_1_vivo.services;

import org.example.manejo_excepciones_1_vivo.dto.request.EntradaBlogRequestDto;
import org.example.manejo_excepciones_1_vivo.dto.response.EntradaBlogResponseDto;
import org.example.manejo_excepciones_1_vivo.entity.EntradaBlog;

import java.util.List;

public interface IServicesBlog {
    EntradaBlogResponseDto createBlog(EntradaBlogRequestDto entradaBlog);
    List<EntradaBlogResponseDto> getBlogs();
    EntradaBlogResponseDto getBlogById(Integer id);
}

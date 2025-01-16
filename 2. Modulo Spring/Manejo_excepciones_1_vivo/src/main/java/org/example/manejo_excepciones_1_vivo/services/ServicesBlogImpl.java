package org.example.manejo_excepciones_1_vivo.services;

import lombok.AllArgsConstructor;
import org.example.manejo_excepciones_1_vivo.dto.request.EntradaBlogRequestDto;
import org.example.manejo_excepciones_1_vivo.dto.response.EntradaBlogResponseDto;
import org.example.manejo_excepciones_1_vivo.entity.EntradaBlog;
import org.example.manejo_excepciones_1_vivo.exeption.BlogNotFoundException;
import org.example.manejo_excepciones_1_vivo.repository.RepositoryBlogImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ServicesBlogImpl implements IServicesBlog {

    private final RepositoryBlogImpl repositoryBlog;

    @Override
    public EntradaBlogResponseDto createBlog(EntradaBlogRequestDto entradaBlog) {

        if (repositoryBlog.getBlogById(entradaBlog.getId()) != null) {
            throw new BlogNotFoundException("Blog ya existe");
        }

        return EntradaBlogResponseDto.builder()
                .message("Blog creado")
                .entradaBlog(repositoryBlog.createBlog(EntradaBlog.builder()
                        .id(entradaBlog.getId())
                        .tituloBlog(entradaBlog.getTituloBlog())
                        .nombreAutor(entradaBlog.getNombreAutor())
                        .fechaPublicacion(entradaBlog.getFechaPublicacion())
                        .build()))
                .build();
    }

    @Override
    public List<EntradaBlogResponseDto> getBlogs() {
        return repositoryBlog.getBlogs().stream().map(entradaBlog -> EntradaBlogResponseDto.builder()
                .message("Lista de blogs")
                .entradaBlog(entradaBlog)
                .build()).collect(Collectors.toList());
    }

    @Override
    public EntradaBlogResponseDto getBlogById(Integer id) {
        EntradaBlog entradaBlog = repositoryBlog.getBlogById(id);
        return EntradaBlogResponseDto.builder()
                .message("Blog encontrado")
                .entradaBlog(entradaBlog)
                .build();
    }
}

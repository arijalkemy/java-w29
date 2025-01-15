package com.example.ejercicio_blog.service;

import com.example.ejercicio_blog.dto.EntradaBlogDto;
import com.example.ejercicio_blog.dto.response.NuevaEntradaBlogDto;
import com.example.ejercicio_blog.entity.EntradaBlog;
import com.example.ejercicio_blog.exception.EntradaBlogAlreadyExistsException;
import com.example.ejercicio_blog.exception.EntradaBlogNotFoundException;
import com.example.ejercicio_blog.repository.IBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BlogServiceImpl implements IBlogService {

    private final IBlogRepository blogRepository;

    @Override
    public EntradaBlogDto getBlogById(Integer id) {
        Optional<EntradaBlog> oEntrada = blogRepository.getBlogById(id);
        if(oEntrada.isEmpty()){
            throw new EntradaBlogNotFoundException(id);
        }
        return EntradaBlogDto.convertToDto(oEntrada.get());
    }

    @Override
    public List<EntradaBlogDto> getAll() {
        List<EntradaBlog> entradas = blogRepository.getAll();
        if(entradas.isEmpty()){
            throw new EntradaBlogNotFoundException();
        }
        return entradas.stream().map(EntradaBlogDto::convertToDto).toList();
    }

    @Override
    public NuevaEntradaBlogDto createBlog(EntradaBlogDto entradaBlogDto) {
        Optional<EntradaBlog> oEntrada = blogRepository.getBlogById(entradaBlogDto.id());
        if(oEntrada.isPresent()) {
            throw new EntradaBlogAlreadyExistsException(entradaBlogDto.id());
        }
        ObjectMapper om = new ObjectMapper();
        EntradaBlog nuevaEntrada = om.convertValue(entradaBlogDto, EntradaBlog.class);
        blogRepository.addEntrada(nuevaEntrada);
        return new NuevaEntradaBlogDto("Se creó la entrada de blog con id: " + entradaBlogDto.id());
    }
}

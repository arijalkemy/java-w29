package com.meli.blog.service;

import com.meli.blog.dto.EntradaBlogDTO;
import com.meli.blog.entity.EntradaBlog;
import com.meli.blog.exceptions.AlreadyExistsException;
import com.meli.blog.exceptions.NotFoundException;
import com.meli.blog.repository.EntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntradaBlogServiceImpl implements EntradaBlogService {
    @Autowired
    private EntradaBlogRepository entradaBlogRepository;

    @Override
    public Long create(EntradaBlog entradaBlog) {
        EntradaBlog entrada = entradaBlogRepository.entradaBlogList.stream().filter(blog -> blog.id.equals(entradaBlog.id)).findFirst().orElse(null);
        System.out.println(entrada);
        if (entrada == null) {
            entradaBlogRepository.entradaBlogList.add(entradaBlog);
            return entradaBlog.id;
        }
        else {
            throw new AlreadyExistsException("Este registro ya existe");
        }
    }

    @Override
    public EntradaBlogDTO findById(Long id) {
        try{
            EntradaBlog entrada = entradaBlogRepository.entradaBlogList.stream().filter(entradaBlog -> entradaBlog.id.equals(id)).findFirst().orElse(null);

            if (entrada == null) {
                throw new NotFoundException("No existe este blog");
            }

            EntradaBlogDTO entradaBlogDTO = new EntradaBlogDTO(entrada.author, entrada.date, entrada.title);
            return entradaBlogDTO;
        } catch (NotFoundException e) {
            throw new NotFoundException("No existe este blog");
        }
    }

    @Override
    public List<EntradaBlogDTO> findAll() {
        List<EntradaBlogDTO> entradaBlogDTOS = new ArrayList<>();
        entradaBlogRepository.entradaBlogList.stream().forEach(entradaBlog -> entradaBlogDTOS.add(new EntradaBlogDTO(entradaBlog.title, entradaBlog.author, entradaBlog.date)));
        if (entradaBlogDTOS.isEmpty()) {
            throw new NotFoundException("No hay blogs");
        }
        return entradaBlogDTOS;
    }
}

package com.bootcamp.elastic.service;

import com.bootcamp.elastic.model.ObraLiteraria;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IObraLiterariaService {
    List<ObraLiteraria> findAll();
    ObraLiteraria save(ObraLiteraria obraLiteraria);
    List<ObraLiteraria> findByAutor(String autor);
    List<ObraLiteraria> findByTitulo(String titulo);
}

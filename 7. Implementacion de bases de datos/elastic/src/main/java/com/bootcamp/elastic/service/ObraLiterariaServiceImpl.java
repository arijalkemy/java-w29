package com.bootcamp.elastic.service;

import com.bootcamp.elastic.model.ObraLiteraria;
import com.bootcamp.elastic.repository.ObraLiterariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ObraLiterariaServiceImpl implements IObraLiterariaService{
    private final ObraLiterariaRepository obraLiterariaRepository;

    @Override
    public List<ObraLiteraria> findAll() {
        Iterable<ObraLiteraria> obras = obraLiterariaRepository.findAll();
        return StreamSupport.stream(obras.spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public ObraLiteraria save(ObraLiteraria obraLiteraria) {
        return obraLiterariaRepository.save(obraLiteraria);
    }

    @Override
    public List<ObraLiteraria> findByAutor(String autor) {
        return obraLiterariaRepository.findByAutor(autor);
    }

    @Override
    public List<ObraLiteraria> findByTitulo(String titulo) {
        return obraLiterariaRepository.findByTitulo(titulo);
    }
}

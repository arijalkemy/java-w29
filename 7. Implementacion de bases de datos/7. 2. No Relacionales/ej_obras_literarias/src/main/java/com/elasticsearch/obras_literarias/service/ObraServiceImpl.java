package com.elasticsearch.obras_literarias.service;

import com.elasticsearch.obras_literarias.exception.NotFoundException;
import com.elasticsearch.obras_literarias.model.Obra;
import com.elasticsearch.obras_literarias.repository.ObraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObraServiceImpl implements ObraService {

    private final ObraRepository obraRepository;

    @Override
    public Obra save(Obra obra) {
        return obraRepository.save(obra);
    }

    @Override
    public Iterable<Obra> getAll() {
        return obraRepository.findAll();
    }

    @Override
    public Obra getById(String id) {
        return obraRepository.findById(id).orElseThrow(() -> new NotFoundException("Obra no encontrada"));
    }

    @Override
    public Iterable<Obra> getByAutor(String nombre) {
        return obraRepository.findByAutor(nombre);
    }

    @Override
    public Iterable<Obra> getByEditorial(String palabra) {
        return obraRepository.findByEditorial(palabra);
    }

    @Override
    public Iterable<Obra> getAllByTitulo(String palabra) {
        return obraRepository.findByNombreContaining(palabra);
    }

    @Override
    public Iterable<Obra> getTopPages() {
        return obraRepository.findTop5ByOrderByCantidadPaginasDesc();
    }

    @Override
    public Iterable<Obra> getObrasAntesDe(Integer anio) {
        return obraRepository.findObraByAnioBefore(anio);
    }
}

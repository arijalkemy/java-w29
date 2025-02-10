package com.elasticsearch.obras_literarias.service;

import com.elasticsearch.obras_literarias.model.Obra;

public interface ObraService {
    Obra save(Obra obra);

    Iterable<Obra> getAll();

    Obra getById(String id);

    Iterable<Obra> getByAutor(String nombre);

    Iterable<Obra> getByEditorial(String palabra);

    Iterable<Obra> getAllByTitulo(String palabra);

    Iterable<Obra> getTopPages();

    Iterable<Obra> getObrasAntesDe(Integer anio);
}

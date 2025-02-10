package com.elasticsearch.obras_literarias.repository;

import com.elasticsearch.obras_literarias.model.Obra;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraRepository extends ElasticsearchRepository<Obra, String> {
    //@Query("{\"match\": {\"autor\": \"?0\"}}")
    Iterable<Obra> findByAutor(String autor);

    //@Query("{\"query_string\": {\"default_field\": \"nombre\",\"query\": \"*?0*\"}}")
    Iterable<Obra> findByNombreContaining(String nombre);

    //@Query("{\"match\": {\"editorial\": \"?0\"}}")
    Iterable<Obra> findByEditorial(String editorial);

    //@Query("{\"range\": {\"anio\": {\"lt\": \"?0\"}}}")
    Iterable<Obra> findObraByAnioBefore(Integer anio);

    //@Query("{\"sort\": [{\"cantidad_paginas\": {\"order\": \"desc\"}}],\"size\": 5}")
    Iterable<Obra> findTop5ByOrderByCantidadPaginasDesc();
}

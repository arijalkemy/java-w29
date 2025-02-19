package com.example.obras_literarias.repository;

import com.example.obras_literarias.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    List<ObraLiteraria> findByAutor(String autor);
    List<ObraLiteraria> findByNombreContainingIgnoreCase(String titulo);
    List<ObraLiteraria> findByCantidadDePaginasGreaterThan(Integer cantidadDePaginas);
    List<ObraLiteraria> findByYearBefore(Integer year);
    List<ObraLiteraria> findByEditorial(String editorial);
}

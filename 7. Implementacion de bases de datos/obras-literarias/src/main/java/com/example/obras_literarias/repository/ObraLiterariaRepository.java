package com.example.obras_literarias.repository;

import com.example.obras_literarias.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    // Consulta 1: Obras por autor
    List<ObraLiteraria> findByAutor(String autor);

    // Consulta 2: Obras por palabra clave en el título
    List<ObraLiteraria> findByNombreContaining(String keyword);

    // Consulta 3: Top 5 obras con más cantidad de páginas (ordenado de mayor a menor)
    List<ObraLiteraria> findTop5ByOrderByCantidadDePaginasDesc();

    // Consulta 4: Obras antes de un determinado año
    List<ObraLiteraria> findByYearLessThan(int year);

    // Consulta 5: Obras de una determinada editorial
    List<ObraLiteraria> findByEditorial(String editorial);
}

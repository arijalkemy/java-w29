package com.example.literaryWorks.repository;

import com.example.literaryWorks.model.Work;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWorkRepository extends ElasticsearchRepository<Work, String> {
    // Retornar las obras de un determinado autor. Por ejemplo, todas las obras de “Garcia Marquez”
    @Query("{\"bool\": {\"must\": [{\"match\": {\"author\": \"?0\"}}]}}")
    List<Work> findWorksByName(String name);

    // Retornar las obras que contengan palabras claves en sus títulos. Por ejemplo: que contengan la palabra “quijote”
    @Query("{\"match\": {\"name\": \"?0\"}}")
    List<Work> findWorksByWordInName(String word);

    // Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.
    @Query("{\"sort\": {\"pages\": \"desc\"}, \"size\": 5}")
    List<Work> findWorksByPagesOrderByPagesDesc();

    // Retornar las obras que fueron publicadas antes de un determinado año. Por ejemplo: Antes de 1998.
    @Query("{\"bool\": {\"must\": [{\"range\": {\"publishedYear\": {\"lt\": \"?0\"}}}]}}")
    List<Work> findWorksByPublishedYear(Integer year);

    // Retornar todas las obras de una determinada editorial. Por ejemplo: Todas las obras de la editorial “Santillana”
    @Query("{\"bool\": {\"must\": [{\"match\": {\"publisher\": \"?0\"}}]}}")
    List<Work> findWorksByPublisher(String publisher);
}

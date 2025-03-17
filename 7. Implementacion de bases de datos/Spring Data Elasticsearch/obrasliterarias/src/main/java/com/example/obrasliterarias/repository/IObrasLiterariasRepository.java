package com.example.obrasliterarias.repository;

import com.example.obrasliterarias.model.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IObrasLiterariasRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    //@Query("{\"match\": {\"autor\": \"?0\"}}")
    Iterable<ObraLiteraria> findByAutor(String autor);

    //@Query("{\"query_string\": {\"default_field\": \"name\",\"query\": \"*?0*\"}}")
    Iterable<ObraLiteraria> findByTitleContaining(String name);

    //@Query("{\"match\": {\"editorial\": \"?0\"}}")
    Iterable<ObraLiteraria> findByEditorial(String editorial);

    //@Query("{\"range\": {\"year\": {\"lt\": \"?0\"}}}")
    Iterable<ObraLiteraria> findByYearLessThan(Integer year);

    //@Query("{\"sort\": [{\"pages\": {\"order\": \"desc\"}}],\"size\": 5}")
    Iterable<ObraLiteraria> findTop5ByOrderByPagesDesc();
}

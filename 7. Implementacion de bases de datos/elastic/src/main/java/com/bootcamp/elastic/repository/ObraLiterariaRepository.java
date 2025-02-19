package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.model.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    @Query("{\"match\":{\"autor\":\"?0\"}}")
    public List<ObraLiteraria> findByAutor(String autor);

    @Query("{\"match\":{\"nombre\":\"?0\"}}")
    public List<ObraLiteraria> findByTitulo(String titulo);
}

package com.pruebaa.pruebademo.repository;

import com.pruebaa.pruebademo.model.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IObrasRepository  extends ElasticsearchRepository<ObraLiteraria, String> {

    @Query("{\"match_all\": {}}")
    List<ObraLiteraria> findAll();

    @Query("{\"term\": {\"id\": \"?0\"}}")
    Optional<ObraLiteraria> findById(String id);

    @Query("{\"bool\": {\"must\": [{\"term\": {\"id\": \"?0\"}}, {\"term\": {\"autor\": \"?1\"}}]}}")
    Optional<ObraLiteraria> findByIdAndAuthor(String id, String autor);

}
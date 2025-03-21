package com.bootcamp.obrasliterarias.repository;

import com.bootcamp.obrasliterarias.model.Obra;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ObraRepository extends ElasticsearchRepository<Obra, String> {
    List<Obra> findByAutor(String autor);
    List<Obra> findObraByTituloContaining(String titulo);
    @Query("{\"query\": {\"match_all\": {}}, \"size\": 5, \"sort\": [{\"cantidadPaginas\": {\"order\": \"desc\"}}]}")
    List<Obra> findTop5();
}

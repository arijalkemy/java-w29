package com.meli.obrasliterarias.repository;

import com.meli.obrasliterarias.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, Long> {
    @Query("{\"match\": {\"autor\": \"?0\"}}")
    List<ObraLiteraria> findByAutor(String nombre);

    @Query("{\"match\": {\"nombre\": \"?0\"}}")
    List<ObraLiteraria> findByNombre(String nombre);

    @Query("{\"match_all\": {}}, {\"sort\": [{\"cantidadPaginas\": {\"order\": \"desc\"}}], \"size\": 5}")
    List<ObraLiteraria> findTop5ByOrderByCantidadPaginasDesc();

    List<ObraLiteraria> findByAnioPublicacion(int anioPublicacion);

    @Query("{\"match\": {\"editorial\": \"?0\"}}")
    List<ObraLiteraria> findByEditorial(String editorial);
}

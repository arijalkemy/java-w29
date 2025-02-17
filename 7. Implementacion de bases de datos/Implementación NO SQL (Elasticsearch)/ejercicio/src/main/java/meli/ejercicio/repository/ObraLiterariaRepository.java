package meli.ejercicio.repository;

import meli.ejercicio.domain.ObraLiteraria;

import java.util.Optional;

public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, Long> {
    Optional<ObraLiteraria> findById(String id);
}

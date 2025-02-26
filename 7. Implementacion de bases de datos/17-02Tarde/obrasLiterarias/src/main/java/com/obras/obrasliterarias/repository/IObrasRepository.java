package com.obras.obrasliterarias.repository;

import com.obras.obrasliterarias.domain.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IObrasRepository extends ElasticsearchRepository<ObraLiteraria, Long> {
}

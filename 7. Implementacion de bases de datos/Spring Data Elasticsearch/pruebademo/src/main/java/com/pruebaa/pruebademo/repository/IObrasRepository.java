package com.pruebaa.pruebademo.repository;

import com.pruebaa.pruebademo.domain.ObrasLiterarias;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IObrasRepository  extends ElasticsearchRepository<ObrasLiterarias, Long> {
}

package com.example.obrasliterarias.repository;

import com.example.obrasliterarias.model.LiteralyWork;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiteralyPlayRepository extends ElasticsearchRepository<LiteralyWork, String> {
}

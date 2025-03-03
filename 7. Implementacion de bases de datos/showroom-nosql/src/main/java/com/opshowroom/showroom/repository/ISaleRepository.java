package com.opshowroom.showroom.repository;

import com.opshowroom.showroom.domain.Sale;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISaleRepository extends ElasticsearchRepository<Sale, Long> {
    List<Sale> findByDate(LocalDate date);
}

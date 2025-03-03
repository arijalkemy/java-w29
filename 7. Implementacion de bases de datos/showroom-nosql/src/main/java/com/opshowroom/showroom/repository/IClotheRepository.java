package com.opshowroom.showroom.repository;

import com.opshowroom.showroom.domain.Clothe;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClotheRepository extends ElasticsearchRepository<Clothe,Long> {

//    @Query("FROM Clothe c where c.size = :param")
    List<Clothe> findBySize(String param);

//    @Query("FROM Clothe c WHERE c.name LIKE '%' || :word || '%'")
    List<Clothe> findByName(String word);
}

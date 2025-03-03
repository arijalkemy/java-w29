package com.opshowroom.showroom.repository;

import com.opshowroom.showroom.domain.Clothe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClotheRepository extends JpaRepository<Clothe,Long> {

    @Query("FROM Clothe c where c.size = :param")
    List<Clothe> findBySize(String param);

    @Query("FROM Clothe c WHERE c.name LIKE '%' || :word || '%'")
    List<Clothe> findByName(String word);
}

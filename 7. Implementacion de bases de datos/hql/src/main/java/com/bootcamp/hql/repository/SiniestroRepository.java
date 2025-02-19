package com.bootcamp.hql.repository;

import com.bootcamp.hql.enity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiniestroRepository extends JpaRepository<Siniestro, Long> {
    @Query("SELECT s FROM Siniestro s WHERE s.economicLoss > :loses")
    public List<Siniestro> findByLosesGraterThan(@Param("loses") int loses);

    @Query("SELECT sum(s.economicLoss) FROM Siniestro s WHERE s.economicLoss > :loses")
    public Long findTotalLosesGraterThan(@Param("loses") int loses);
}

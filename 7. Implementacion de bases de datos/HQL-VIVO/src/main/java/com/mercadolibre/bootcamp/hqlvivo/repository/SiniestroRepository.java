package com.mercadolibre.bootcamp.hqlvivo.repository;

import com.mercadolibre.bootcamp.hqlvivo.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SiniestroRepository extends JpaRepository<Siniestro, Long> {

    @Query("SELECT SUM(s.perdidaEconomica) FROM Siniestro s WHERE s.perdidaEconomica > 10000")
    Double findTotalLossOver10000();

}

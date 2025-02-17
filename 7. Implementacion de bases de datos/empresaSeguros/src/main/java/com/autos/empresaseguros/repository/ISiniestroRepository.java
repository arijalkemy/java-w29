package com.autos.empresaseguros.repository;

import com.autos.empresaseguros.dto.PerdidaEconomicaInfoProjection;
import com.autos.empresaseguros.dto.PerdidaEconomicaProjection;
import com.autos.empresaseguros.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro,Long> {
    @Query("SELECT v.patente AS patente, v.marca as marca, v.modelo as modelo, SUM(s.perdidaEconomica) AS perdidaTotal " +
            "FROM Siniestro s " +
            "JOIN s.vehiculo v " +
            "GROUP BY v.patente, v.marca, v.modelo " +
            "HAVING SUM(s.perdidaEconomica) > 10000")
    List<PerdidaEconomicaProjection> findVehiculosConPerdidaEconomicaAlta();

    @Query("SELECT v.patente AS patente, v.marca as marca, v.modelo as modelo, SUM(s.perdidaEconomica) AS perdidaTotal " +
            "FROM Siniestro s " +
            "JOIN s.vehiculo v " +
            "GROUP BY v.patente, v.marca, v.modelo " +
            "HAVING SUM(s.perdidaEconomica) > 10000")
    List<PerdidaEconomicaInfoProjection> findInfoVehiculosConPerdidaEconomicaAlta();

}

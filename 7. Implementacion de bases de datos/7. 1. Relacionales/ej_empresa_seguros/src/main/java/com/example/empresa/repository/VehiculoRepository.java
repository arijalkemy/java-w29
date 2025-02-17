package com.example.empresa.repository;

import com.example.empresa.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
    @Query("SELECT v FROM Vehiculo v ORDER BY v.anio")
    List<Vehiculo> findAllPatentesAndMarcas();

    @Query("SELECT v FROM Vehiculo v WHERE v.cantidadRuedas = :cantidadRuedas AND v.anio = :anio")
    List<Vehiculo> findAllByRuedasAndYear(Integer cantidadRuedas, Integer anio);

    @Query("SELECT v FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica >= :monto")
    List<Vehiculo> findAllByPerdidaEconomica(Double monto);

    @Query("SELECT v, SUM(s.perdidaEconomica) FROM Vehiculo v " +
            "JOIN v.siniestros s " +
            "WHERE s.perdidaEconomica >= :monto " +
            "GROUP BY v.id")
    List<Object[]> findTotalPerdidaEconomicaOfSiniestrosGreaterThan(Double monto);
}

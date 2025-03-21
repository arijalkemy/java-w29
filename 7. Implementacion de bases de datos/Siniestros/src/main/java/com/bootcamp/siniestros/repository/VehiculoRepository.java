package com.bootcamp.siniestros.repository;

import com.bootcamp.siniestros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    @Query("SELECT v FROM Vehiculo v ORDER BY v.anio")
    List<Vehiculo> findPatentesByFechaAndMarca();

    @Query("SELECT v.patente " +
            "FROM Vehiculo v " +
            "WHERE v.cantidadRuedas >= :cantidadRuedas AND v.anio = :anio")
    List<String> findPatentesByCantidadRuedasYAnio(Integer cantidadRuedas, Integer anio);

    @Query("SELECT v FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica >= :perdida")
    List<Vehiculo> findBySiestroPerdida(double perdida);
}

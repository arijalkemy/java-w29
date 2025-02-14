package com.example.empresa.repository;

import com.example.empresa.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.anio")
    List<String[]> findAllPatentesAndMarcas();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas = :cantidadRuedas AND v.anio = :anio")
    List<String> findAllByRuedasAndYear(Integer cantidadRuedas, Integer anio);

    @Query("SELECT v.patente, v.marca, v.modelo FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica >= :monto")
    List<String[]> findAllByPerdidaEconomica(Integer monto);
}

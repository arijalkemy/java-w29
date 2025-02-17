package com.mercadolibre.bootcamp.hqlvivo.repository;

import com.mercadolibre.bootcamp.hqlvivo.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v FROM Vehiculo v")
    List<Vehiculo> findAll();

    @Query("SELECT v FROM Vehiculo v WHERE v.ruedas > 4 AND YEAR(v.fechaFabricacion) = YEAR(NOW()) ORDER BY v.fechaFabricacion")
    List<Vehiculo> findAllByWheelCountAndCurrentYear();

    @Query("SELECT v FROM Vehiculo v INNER JOIN v.siniestros s  WHERE s.perdidaEconomica > 10000 ORDER BY v.fechaFabricacion")
    List<Vehiculo> findAllByLossOver10000();

}
